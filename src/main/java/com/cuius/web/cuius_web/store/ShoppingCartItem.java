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

import com.cuius.web.cuius_web.entity.Product;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author terrence
 */
public class ShoppingCartItem {
    
    // ======================================
    // =             Attributes             =
    // ======================================

    @NotNull
    private Product item;
    @NotNull
    @Min(1)
    private Integer quantity;
    
    // ======================================
    // =            Constructors            =
    // ======================================

    public ShoppingCartItem(Product item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================

    public Double getSubTotal() {
        return item.getProPrice()* quantity;
    }
    
    // ======================================
    // =         Getters & setters          =
    // ======================================

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCartItem cartItem = (ShoppingCartItem) o;

        if (!item.equals(cartItem.item)) return false;
        if (!quantity.equals(cartItem.quantity)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
