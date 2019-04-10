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
package com.cuius.web.cuius_web.handler;

import com.cuius.web.cuius_web.dao.ListDao;
import com.cuius.web.cuius_web.entity.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author terrence
 */
@Named(value = "displayProductMB")
@SessionScoped
public class DisplayProductMB implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    
    Product product = new Product();
    private Product selectedProduct;
    private String subcatname;
    private int searchResultsSize;
    private int allProductsSize;
    
    // ======================================
    // =          Injection Points          =
    // ======================================
    
    @Inject
    SearchProduct queryProduct;
    
    /**
     * Creates a new instance of displayProductMB
     */
    public DisplayProductMB() {
    }

    // ======================================
    // =        Getters and Setters         =
    // ======================================
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public int getSearchResultsSize() {
        return searchResultsSize;
    }

    public void setSearchResultsSize(int searchResultsSize) {
        this.searchResultsSize = searchResultsSize;
    }

    public int getAllProductsSize() {
        return allProductsSize;
    }

    public void setAllProductsSize(int allProductsSize) {
        this.allProductsSize = allProductsSize;
    }
    

    // ======================================
    // =        Business Methods            =
    // ======================================
    
    public List<Product> getAllProducts(){
        List<Product> pList = new ListDao().allProductsList();
        allProductsSize = pList.size();
        return pList;
    }
    
    public List<Product> listProductsByMerchant(String merchantName){
        List<Product> pList = new ListDao().productListByMerchant(merchantName);
        return pList;
    }
    
    public List<Product> productsBySubCat(){
    
        List<Product> pList = new ListDao().productListBySubCat(subcatname);
        return pList;    
    }
    
    public List<Product> getSearchedProducts(){
        List<Product> pList = new ListDao().searchProductList(queryProduct.getKeyword());
        searchResultsSize = pList.size();
        return pList;
    }
    
    public List<Product> getRandomProducts(){
        return new ListDao().findRandomSix();
    }
    
    public List<Product> getRandomFourProducts(){
        return new ListDao().findRandomFour();
    }
}
