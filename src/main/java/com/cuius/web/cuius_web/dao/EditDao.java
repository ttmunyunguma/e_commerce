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
package com.cuius.web.cuius_web.dao;

import com.cuius.web.cuius_web.entity.Product;
import com.cuius.web.cuius_web.handler.EditProduct;
import com.cuius.web.cuius_web.util.HibernateUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author terrence
 */
@Named(value = "editDao")
@SessionScoped
public class EditDao implements Serializable{

    // ======================================
    // =             Attributes             =
    // ======================================
    static SessionFactory factory = HibernateUtil.getSessionFactory();
    Product product = new Product();

    @Inject
    EditProduct productValue;

    // ======================================
    // =        Business Methods            =
    // ======================================
    public boolean editProduct(int productId) {
        System.out.println("********************ID:" + productId);
        
        try {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                System.out.println("*******************Begin Transc");
                product = session.get(Product.class, productId);
                System.out.println("*******************Got Product");
                if (productValue.getProductName().trim() != null) {
                    product.setProName(productValue.getProductName());
                } else if (productValue.getProductDescription().trim() != null) {
                    product.setProDesc(productValue.getProductDescription());
                } else if (String.valueOf(productValue.getPrice()).trim() != null) {
                    product.setProPrice(productValue.getPrice());
                } else if (String.valueOf(productValue.getQuantity()).trim() != null) {
                    product.setProQty(productValue.getQuantity());
                }
                System.out.println("*******************Aftre ifs");
                session.update(product);
                session.getTransaction().commit();
            }
            
            return true;
        } catch (HibernateException e) {
        }

        return false;
    }
}
