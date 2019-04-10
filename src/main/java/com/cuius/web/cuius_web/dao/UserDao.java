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
package com.cuius.web.cuius_web.dao;

import com.cuius.web.cuius_web.entity.Users;
import com.cuius.web.cuius_web.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author terrence
 */
public class UserDao {
    
    // ======================================
    // =             Attributes             =
    // ======================================
    
    static SessionFactory factory = HibernateUtil.getSessionFactory();
    public static boolean isProceessSuccessful;
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    public static List<Users> getAllUsers(){
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM USERS");
        List<Users> result = query.list();
        
        return result;
    }
    
    public static Users getUserByUserName(String userName){
        Users user;
        try (Session session = factory.openSession()) {
            user = session.get(Users.class, userName);
        }
        return user;
    }
    
    public static Users getUserByEmail(String email){
        Users user;
        try (Session session = factory.openSession()) {
            user = session.get(Users.class, email);
        }
        return user;
    }
    
    public boolean createUser(Users user){
         
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
        }
        return false;
    }
    
    public static Users doSignIn(String email, String password){
        
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Users WHERE email=:email AND password=:password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            
            Users result = (Users) query.getSingleResult();
            if(result!= null)
                isProceessSuccessful = true;
            
            return result;
        } catch (HibernateException e) {
        }
        return null;
    }
    
    public static void mergeContext(Users user){
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
        }
    }
}
