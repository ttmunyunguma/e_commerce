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
package com.cuius.web.cuius_web.store;

import com.cuius.web.cuius_web.entity.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author terrence
 */
@Named(value = "wishlistBean")
@SessionScoped
public class WishlistBean implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    
    private List<ShoppingCartItem> wishlistItems = new ArrayList<>();
    private String country = new String();
    private int listSize;
    
    
    /**
     * Creates a new instance of WishlistBean
     */
    public WishlistBean() {
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    public String addToWishlist(Product item) {

        boolean itemFound = false;
        for (ShoppingCartItem wishlistItem : wishlistItems) {
            // If item already exists in the shopping cart we just change the quantity
            if (wishlistItem.getItem().equals(item)) {
                wishlistItem.setQuantity(wishlistItem.getQuantity() + 1);
                itemFound = true;
            }
        }
        if (!itemFound) // Otherwise it's added to the shopping cart
        {
            wishlistItems.add(new ShoppingCartItem(item, 1));
        }

        listSize = wishlistItems.size();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", item.getProName() + " added to Wishlist"));

        return null;
    }
    
    public String removeItemFromWishlist(Product item) {

        for (ShoppingCartItem cartItem : wishlistItems) {
            if (cartItem.getItem().equals(item)) {
                wishlistItems.remove(cartItem);
                listSize = wishlistItems.size();
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Removed!", item.getProName() + "Removed Succesfully"));
                return null;
            }
        }

        return null;
    }
    
    public String updateQuantity() {
        return null;
    }
    
    public void clearWishlist(){
        
        // Clear the wishlist
        wishlistItems = new ArrayList<>();
    }
    
    public boolean wishlistIsEmpty() {
        return getWishlistItems() == null || getWishlistItems().isEmpty();
    }
    
    public Double getTotal() {
        if (wishlistItems == null || wishlistItems.isEmpty())
            return 0.0;

        Double total = 0.0;

        // Sum up the quantities
        for (ShoppingCartItem wishlistItem : wishlistItems) {
            total += (wishlistItem.getSubTotal());
        }
        return total;
    }
    
    protected Long getParamId(String param) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        return Long.valueOf(map.get(param));
    }
    
    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public List<ShoppingCartItem> getWishlistItems() {
        return wishlistItems;
    }

    public void setWishlistItems(List<ShoppingCartItem> wishlistItems) {
        this.wishlistItems = wishlistItems;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
    
}
