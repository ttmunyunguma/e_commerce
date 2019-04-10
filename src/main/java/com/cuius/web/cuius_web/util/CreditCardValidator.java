/*
 *  Terrence Takunda Munyunguma [https://github.com/TerrenceTakunda]
 *  Copyright (C) 2019 ttmunyunguma@gmail.com
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.cuius.web.cuius_web.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author terrence
 */

@FacesValidator(value ="com.cuius.web.cuius_web.util.CreditCardValidator")
public class CreditCardValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value != null){
            
            if(StringUtils.isNumericSpace((CharSequence) value) == false){
                context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error!", "A valid Card number is only numeric!"));
                FacesMessage message = new FacesMessage("Please enter a valid Credit Card number!");
                message.setSeverity(FacesMessage.SEVERITY_WARN);
                throw new ValidatorException(message);
            }
            else{
                if(checkLuhn((String) value) == false){
                    context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Card number Invalid", "Please Check again, you might have made an error!"));
                    FacesMessage message = new FacesMessage("Please enter a valid Credit Card number!");
                    message.setSeverity(FacesMessage.SEVERITY_WARN);
                    throw new ValidatorException(message);
                }
            }
        }
    }
    
    // checks credit card number for Luhn Algorithm
    public static boolean checkLuhn(String ccNumber){           

	int sum = 0;
	boolean alternate = false;
		
	for (int i = ccNumber.length()-1; i>=0; i--){
		
        	int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			
		if (alternate){
			
			n *= 2;
			if (n > 9)
                            n = (n % 10) + 1;
		}
		sum += n;
		alternate = !alternate;
	}
    return (sum % 10 == 0);
    }
    
}
