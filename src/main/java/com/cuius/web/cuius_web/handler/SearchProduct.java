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
package com.cuius.web.cuius_web.handler;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author terrence
 */
@Named(value = "searchProduct")
@SessionScoped
public class SearchProduct implements Serializable{

    // ======================================
    // =          Injection Points          =
    // ======================================
    
    @Inject
    DisplayProductMB mb;
    
    // ======================================
    // =             Attributes             =
    // ======================================
    
    private String keyword;
    
    /**
     * Creates a new instance of SearchProduct
     */
    public SearchProduct() {
    }

    // ======================================
    // =          Getters and Setters       =
    // ======================================
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    public void searchedResults(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("searchresults.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clickedProduct(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("products.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void continueShopping(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("allproducts.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void merchantProducts(){

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("stores.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//
//            switch (String.valueOf(mb.getSelectedProduct().getMerchant().getCompanyName())) {
//
//                case "Fate Enterprises":
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("./stores/fate.xhtml");
//                case "TelOne":
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("./stores/telone.xhtml");
//                default:
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("allproducts.xhtml");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
