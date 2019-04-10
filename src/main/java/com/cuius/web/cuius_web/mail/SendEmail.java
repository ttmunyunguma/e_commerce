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
package com.cuius.web.cuius_web.mail;

import com.cuius.web.cuius_web.checkout.CheckOut;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author terrence
 */
public class SendEmail {
    
    @Inject
    CheckOut bean;
    
    String to = "terrycorp@live.com";
    private static final String from = "cuiuszw@gmail.com";
    String host = "localhost";
    
    public void send() {

        try {
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            
            Session session = Session.getDefaultInstance(properties);
            
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Purchase Approval");
            
            message.setText("Hello " + bean.getCardHolderName() +". Your $"+ bean.getTotal() +" purchase has been approved" );

            Transport.send(message);
            System.out.println("Sent message successfully....");
            
        } catch (AddressException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
