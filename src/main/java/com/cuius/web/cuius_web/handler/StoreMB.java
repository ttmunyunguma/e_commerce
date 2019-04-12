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

import com.cuius.web.cuius_web.dao.AddDao;
import com.cuius.web.cuius_web.dao.ListDao;
import com.cuius.web.cuius_web.entity.Merchant;
import com.cuius.web.cuius_web.entity.Store;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author terrence
 */
@Named(value = "storeMB")
@SessionScoped
public class StoreMB implements Serializable {
    
    // ======================================
    // =             Attributes             =
    // ======================================
    
    Store store = new Store();
    Merchant merchant = new Merchant();
    String merchantname;
    List<Merchant> listmerchant;

    /**
     * Creates a new instance of StoreMB
     */
    public StoreMB() {
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    public String addStore(){
        
        listmerchant = new ListDao().merchantListByName(merchantname);
        merchant.setMerchantId(listmerchant.get(0).getMerchantId());
        
        store.setMerchant(merchant);
        store.setStoreName(store.getStoreName());
        store.setAddress(store.getAddress());
        store.setLatitude(store.getLatitude());
        store.setLongitude(store.getLongitude());
        store.setStoreType(store.getStoreType());
        store.setColorCode(store.getColorCode());
        boolean status = new AddDao().addStore(store);
        if(status)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", "Store Information recorded successfully"));
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Save Failed", "Something went wrong, Please try again later..."));

        return null;
    }
    
    public List<Store> getAllStores(){

        return new ListDao().allStoresList();
    }
    
    
    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public List<Merchant> getListmerchant() {
        return listmerchant;
    }

    public void setListmerchant(List<Merchant> listmerchant) {
        this.listmerchant = listmerchant;
    }
    
    
}
