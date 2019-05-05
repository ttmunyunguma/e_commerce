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
import javax.inject.Inject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author terrence
 */
public class EditDao{

    
    // ======================================
    // =             Attributes             =
    // ======================================
    static SessionFactory factory = HibernateUtil.getSessionFactory();
    Product product = new Product();

    
    // ======================================
    // =        Business Methods            =
    // ======================================
    
    public boolean deleteProduct(int productId) {
        
        try {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                product = session.get(Product.class, productId);
                
                session.delete(product);
                session.getTransaction().commit();
            }
            
            return true;
        } catch (HibernateException e) {
        }

        return false;
    }
}
