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
package com.cuius.web.cuius_web.checkout;

import com.cuius.web.cuius_web.mail.SendEmail;
import com.cuius.web.cuius_web.store.ShoppingCartBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.jpos.iso.ISOMsg;

/**
 *
 * @author terrence
 */
@Named(value = "sendPaymentControl")
@SessionScoped
public class SendPaymentControl implements Serializable {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    CheckOut checkOut;
    
    // ======================================
    // =             Attributes             =
    // ======================================
    
    //        TransactionLogs log = new TransactionLogs();
        SendPayment pay = new SendPayment();
        ShoppingCartBean cart = new ShoppingCartBean();
        SendEmail email = new SendEmail();
    
    /**
     * Creates a new instance of SendPaymentControl
     */
    public SendPaymentControl() {
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    public void send() throws Exception{
        
        try {
            
            pay.sendIt(checkOut);
        } 
        catch (Exception ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
//            log.createLog();
        }
        
        ISOMsg incoming = pay.getResp();
        
        if(incoming != null){
            if(incoming.hasField(39)==true){
                if(null == String.valueOf(incoming.getValue(39)))
                    FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error.xhtml");
                
                    else switch (String.valueOf(incoming.getValue(39))) {
                        case "00":
                        {
                            //Send Email Nofification
                            //email.send();
                            // Clear the shopping cart
                            cart.clearShoppingCart();
                            FacesContext.getCurrentInstance().getExternalContext().redirect("response/success.xhtml");
                        }
                        case "13":
                            FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error_amount.xhtml");
                        case "54":
                            FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error_expired.xhtml");
                        case "78":
                            FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error_suspicious.xhtml");
                        case "12":
                            FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error_reqInvalid.xhtml");
                        case "51":
                            FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error_insuficientFunds.xhtml");    
                        default:
                            FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error.xhtml");
                    }
            }
            else
                FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error.xhtml");  
        }
        else
            FacesContext.getCurrentInstance().getExternalContext().redirect("responce/error_noresponce.xhtml");  
    }
}
