/*
 * Terrence Takunda Munyunguma [https://github.com/TerrenceTakunda]
 *  Copyright (C) 2018 ttmunyunguma@gmail.com
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

import com.cuius.web.cuius_web.entity.Category;
import com.cuius.web.cuius_web.entity.Country;
import com.cuius.web.cuius_web.entity.Merchant;
import com.cuius.web.cuius_web.entity.Product;
import com.cuius.web.cuius_web.entity.Store;
import com.cuius.web.cuius_web.entity.SubCategory;
import com.cuius.web.cuius_web.util.HibernateUtil;
import java.util.List;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author terrence
 */
public class ListDao {
    
    // ======================================
    // =             Attributes             =
    // ======================================
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Random random = new Random();
    
    // ======================================
    // =        Business Methods            =
    // ======================================
    
    //returns a list of category names
    public List catList(){
        
        List<Category> cList;
        try (Session session = factory.openSession()) {
            cList = session.createQuery("SELECT a1.catName FROM Category a1").setCacheable(true).list();
            cList.toString();
        }
        return cList;
    }
    
    //returns everything from the category table
    public List categoryList(){
        
        List<Category> cList;
        try (Session session = factory.openSession()) {
            cList = session.createQuery("FROM Category").setCacheable(true).list();
            cList.toString();
        }
        return cList;
    }
    
    public List<Category> catListByName(String name){
        
        List<Category> cList;
        try (Session session = factory.openSession()) {
            cList = session.createQuery("SELECT a1 FROM Category a1 WHERE lower(catName) = '"+name.toLowerCase()+"'").setCacheable(true).list();

            cList.toString();
        }
        return cList;
    }
    
    public List<SubCategory> subcatListByName(String name){
        
        List<SubCategory> cList;
        try (Session session = factory.openSession()) {
            cList = session.createQuery("SELECT a1 FROM SubCategory a1 WHERE lower(subCatName) = '"+name.toLowerCase()+"'").setCacheable(true).list();

            cList.toString();
        }
        return cList;
    }
    
    //returns a list of subcategory names
    public List subcatList(String name){
        
        List<Category> scList;
        Session session = factory.openSession();
        scList = session.createQuery("SELECT a1.subCatName FROM SubCategory a1 WHERE a1.category.catId IN (SELECT a.catId FROM Category a WHERE lower(a.catName)= '" + name.toLowerCase() + "')").setCacheable(true).list();

        scList.toString();
        return scList;
    }
    
    //returns everything in the subcategories table
    public List allSubCats(){
        
        List<SubCategory> scList;
        Session session = factory.openSession();
        scList = session.createQuery("FROM SubCategory ").setCacheable(true).list();
        scList.toString();

        return scList;
    }
    
    //returns printable names in the country table
    public List<Country> allCountries(){
        
        List<Country> countryList;
        Session session = factory.openSession();
        countryList = session.createQuery("SELECT a1.printableName FROM Country a1").setCacheable(true).list();
        countryList.toString();

        return countryList;
    }
    
    //returns merchant list company names only
    public List merchantList(){
        
        List<Merchant> mList;
        try (Session session = factory.openSession()) {
            mList = session.createQuery("SELECT a1.companyName FROM Merchant a1").setCacheable(true).list();
          
            mList.toString();
        }
        return mList;
    }
    
    //returns everything in the Merchants table
    public List allMerchantsList(){
        
        List<Merchant> mList;
        try (Session session = factory.openSession()) {
            mList = session.createQuery("FROM Merchant ").setCacheable(true).list();
            mList.toString();
        }
        return mList;
    }
    
    public List<Merchant> merchantListByName(String name){
        
        List<Merchant> mList;
        try (Session session = factory.openSession()) {
            mList = session.createQuery("SELECT a1 FROM Merchant a1 WHERE lower(companyName) = '"+name.toLowerCase()+"'").setCacheable(true).list();
           
            mList.toString();
        }
        return mList;
    }
    
    //returns everything from the Products Table
    public List allProductsList(){
        
        Session session = factory.openSession();
        List<Product> pList = session.createQuery("SELECT a1 FROM Product a1").setCacheable(true).list();
        pList.toString();
        return pList;
    }
    
    public List<Product> productListBySubCat(String subcat){
        
        List<Product> pList;
        try (Session session = factory.openSession()) {
            pList = session.createQuery("SELECT a1 FROM Product a1 WHERE subCategory = '"+("SELECT a1 FROM SubCategory a1 WHERE subCatName = '"+subcat+"'")+"'").setCacheable(true).list();
            pList.toString();
        }
        return pList;
    }
    
    public List<Product> productListByMerchant(String merchant){
        
        List<Product> pList;
        Session session = factory.openSession();
        pList = session.createQuery("FROM Product WHERE merchant IN (FROM Merchant WHERE companyName = '" + merchant + "')").setCacheable(true).list();

        pList.toString();

        return pList;
    }
    
    public List<Product> searchProductList(String keyword){
        Session session = factory.openSession();
        List<Product> result = session.createQuery("SELECT i FROM Product i WHERE LOWER(i.proName) LIKE :name OR LOWER(i.proDesc) LIKE :description ORDER BY i.proName")
                                      .setParameter("name", "%"+keyword.toLowerCase()+"%")
                                      .setParameter("description", "%"+keyword.toLowerCase()+"%")
                                      .setCacheable(true)
                                      .list();
        
        return result;
    }
    
    public List<Product> findRandomFour(){
        
        Session session = factory.openSession();
        
        Query query = session.createQuery("from Product p").setCacheable(true);
        query.setFirstResult(random.nextInt(10));
        query.setMaxResults(4);
        List<Product> result = query.list();
        result.toString();
        return result;
    }
    
    public List<Product> findRandomSix(){
        
        Session session = factory.openSession();
        
        Query query = session.createQuery("from Product p").setCacheable(true);
        query.setFirstResult(random.nextInt(10));
        query.setMaxResults(6);
        List<Product> result = query.list();
        result.toString();
        return result;
    }
    
    //returns everything from the Stores Table
    public List allStoresList(){
        
        Session session = factory.openSession();
        List<Store> store = session.createQuery("SELECT a1 FROM Store a1").setCacheable(true).getResultList();
        store.toString();
        return store;
    }
    
}
