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
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
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
    private String price;
    private String quantity;
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
    public void changeProductInfo() {

        try {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                product = session.get(Product.class, displayProductMB.getSelectedProduct().getProId());

                if (!StringUtils.isBlank(productName)) {
                    product.setProName(productName);
                }
                if (!StringUtils.isBlank(productDescription)) {
                    product.setProDesc(productDescription);
                }
                if (!StringUtils.isBlank(price)) {
                    product.setProPrice(Double.parseDouble(price));
                }
                if (!StringUtils.isBlank(String.valueOf(quantity))) {
                    product.setProQty(Integer.parseInt(quantity));
                }

                session.update(product);
                session.getTransaction().commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
                FacesContext.getCurrentInstance().getExternalContext().redirect("viewproducts.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (HibernateException e) {
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data Save Failed", ""));
        }

    }

    public void deleteProduct() {

        boolean status = new EditDao().deleteProduct(displayProductMB.getSelectedProduct().getProId());
        if (status) {
            try {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Successfull", ""));
                FacesContext.getCurrentInstance().getExternalContext().redirect("viewproducts.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Could Not Delete", "There was an error"));
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

}
