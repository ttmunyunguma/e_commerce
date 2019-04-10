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

import com.cuius.web.cuius_web.dao.AddDao;
import com.cuius.web.cuius_web.dao.ListDao;
import com.cuius.web.cuius_web.entity.Merchant;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author terrence
 */
@Named(value = "merchantMB")
@RequestScoped
public class MerchantMB {

    // ======================================
    // =             Attributes             =
    // ======================================
    
    Merchant merchant = new Merchant();
    List<Merchant> listMerchants;
    private int merchantsSize;
    
    /**
     * Creates a new instance of MerchantMB
     */
    public MerchantMB() {
    }
    
    // ======================================
    // =        Getters and Setters         =
    // ======================================
    
    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public List<SelectItem> getListMerchants() {
        
        List<SelectItem> merchantname = new ListDao().merchantList();
        return merchantname;
    }

    public void setListMerchants(List<Merchant> listMerchants) {
        this.listMerchants = listMerchants;
    }

    public int getMerchantsSize() {
        return merchantsSize;
    }

    public void setMerchantsSize(int merchantsSize) {
        this.merchantsSize = merchantsSize;
    }
    
    // ======================================
    // =        Business Methods            =
    // ======================================
    
    public String addMerchant(){
        
        merchant.setCompanyName(merchant.getCompanyName());
        merchant.setContactName(merchant.getContactName());
        merchant.setCompanyAddress(merchant.getCompanyAddress());
        merchant.setCompanyPhone(merchant.getCompanyPhone());
        merchant.setCompanyEmail(merchant.getCompanyEmail());
        merchant.setCompanyLogo(merchant.getCompanyLogo());
        boolean status = new AddDao().addMerchant(merchant);
        if (status)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Save Failed", ""));
        
        return null;
    }
    
    public List<Merchant> getAllMerchants(){
        List<Merchant> mList = new ListDao().allMerchantsList();
        merchantsSize = mList.size();
        return mList;
    }
}
