/*
 * Terrence Takunda Munyunguma [https://github.com/TerrenceTakunda]
 * Copyright (C) 2019 ttmunyunguma@gmail.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *  
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.cuius.web.cuius_web.handler;

import com.cuius.web.cuius_web.dao.EditDao;
import com.cuius.web.cuius_web.entity.Product;
import com.cuius.web.cuius_web.util.HibernateUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author terrence
 */
@Named(value = "editProduct")
@SessionScoped
public class EditProduct implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    
    private String productName;
    private double price;
    private int quantity;
    private String productDescription;
    static SessionFactory factory = HibernateUtil.getSessionFactory();
    Product product = new Product();
    
    
    // ======================================
    // =         Injection Points           =
    // ======================================
    
    @Inject
    DisplayProductMB displayProductMB;
    
    /**
     * Creates a new instance of EditProduct
     */
    public EditProduct() {
    }
    
    // ======================================
    // =         Business Methods           =
    // ======================================
    
    public void changeProductInfo(){
        
        try {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                product = session.get(Product.class, displayProductMB.getSelectedProduct().getProId());
                
                if (productName.trim() != null) {
                    product.setProName(productName);
                } else if (productDescription.trim() != null) {
                    product.setProDesc(productDescription);
                } else if (String.valueOf(price).trim() != null) {
                    product.setProPrice(price);
                } else if (String.valueOf(quantity).trim() != null) {
                    product.setProQty(quantity);
                }
                
                session.update(product);
                session.getTransaction().commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
            }
            
        } catch (HibernateException e) {
        }
        
//        if(status)
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
//        else
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data Save Failed", ""));
        
    }
    
    
    // ======================================
    // =       Setters and Getters          =
    // ======================================

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
}
