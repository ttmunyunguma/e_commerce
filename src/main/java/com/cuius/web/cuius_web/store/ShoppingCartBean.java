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
import com.cuius.web.cuius_web.handler.SearchProduct;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author terrence
 */
@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {
 
    // ======================================
    // =             Attributes             =
    // ======================================

    
    private List<ShoppingCartItem> cartItems = new ArrayList<>();
    private String country = new String();
    private int cartSize;
    
    /**
     * Creates a new instance of ShoppingCartBean
     */
    public ShoppingCartBean() {
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    public String addToCart(Product item) {

        boolean itemFound = false;
        for (ShoppingCartItem cartItem : cartItems) {
            // If item already exists in the shopping cart we just change the quantity
            if (cartItem.getItem().equals(item)) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                itemFound = true;
            }
        }
        if (!itemFound) // Otherwise it's added to the shopping cart
        {
            cartItems.add(new ShoppingCartItem(item, 1));
        }

        cartSize = cartItems.size();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", item.getProName() + " added to cart"));

        return null;
    }
    
    public String removeItemFromCart(Product item) {

        for (ShoppingCartItem cartItem : cartItems) {
            if (cartItem.getItem().equals(item)) {
                cartItems.remove(cartItem);
                cartSize = cartItems.size();
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
    
    public void checkOut(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("checkout.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearShoppingCart(){
        
        // Clear the shopping cart
        cartItems = new ArrayList<>();
    }
    
/*    public String confirmation() {

        // Creating the invoice
        User user = accountBean.getUser();
        Invoice invoice = new Invoice(user.getFirstName(), user.getLastName(), user.getEmail(), address.getStreet1(), address.getCity(), address.getZipcode(), country);
        invoice.setTelephone(user.getTelephone());
        invoice.setStreet2(address.getStreet2());
        for (ShoppingCartItem cartItem : cartItems) {
            invoice.addInvoiceLine(new InvoiceLine(cartItem.getQuantity(), cartItem.getItem().getTitle(), cartItem.getItem().getUnitCost()));
        }

        // Sending the invoice
        jmsContext.createProducer().send(queue, invoice);
        logger.info("An invoice has been sent to the queue");


        // Displaying the invoice creation
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Order created",
                "You will receive a confirmation email"));

        return "/main";
    }*/
    
    public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public boolean shoppingCartIsEmpty() {
        return getCartItems() == null || getCartItems().isEmpty();
    }
    
    public Double getTotal() {
        if (cartItems == null || cartItems.isEmpty())
            return 0.0;

        Double total = 0.0;

        // Sum up the quantities
        for (ShoppingCartItem cartItem : cartItems) {
            total += (cartItem.getSubTotal());
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public int getCartSize() {
        return cartSize;
    }

    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }
    
/*    public String[] getCountries() {
        TypedQuery<Country> query = em.createNamedQuery(Country.FIND_ALL, Country.class);
        List<Country> countries = query.getResultList();
        String[] result = new String[countries.size()];
        for (int i = 0; i < countries.size(); i++) {
            result[i] = countries.get(i).getName();
        }
        return result;
    }*/

}
