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
package com.cuius.web.cuius_web.store;

import com.cuius.web.cuius_web.entity.Category;
import com.cuius.web.cuius_web.entity.Merchant;
import com.cuius.web.cuius_web.entity.SubCategory;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author terrence
 */
@Named(value = "catalogBean")
@SessionScoped
public class CatalogBean implements Serializable {

    /**
     * Creates a new instance of CatalogBean
     */
    public CatalogBean() {
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    public void doViewItemByCategory(Category category){
        
    }
    
    public void doViewItemBySubCategory(SubCategory subcat){
        
    }
    
    public void doViewItemByMerchant(Merchant mechant){
        
    }
    
    public void doViewItemByRating(){
        
    }
}
