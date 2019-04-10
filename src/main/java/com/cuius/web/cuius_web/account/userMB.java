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
package com.cuius.web.cuius_web.account;

import com.cuius.web.cuius_web.dao.UserDao;
import com.cuius.web.cuius_web.entity.Users;
import com.cuius.web.cuius_web.util.PasswordUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

/**
 *
 * @author terrence
 * @deprecated 
 */
@Named(value = "userMB")
@SessionScoped
public class userMB implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    
    Users user = new Users();
    private boolean loggedIn;
    private boolean admin;
    private String password1;
    private String password2;
    private boolean rememberMe;
    private FacesContext facesContext;
    
    /**
     * Creates a new instance of userMB
     */
    public userMB() {
    }
    
    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword1() {
        password1 = user.getPassword();
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    @Transactional(dontRollbackOn = IllegalArgumentException.class)
    public String signUp() {
        System.out.println("********************sign up method called*************");
        // check if user_name already exist?
//        if (UserDao.getUserByUserName(user.getUserName()) != null) {
//            facesContext.addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN, "User Name "+user.getUserName()+" already exists ",
//                            "You must choose a different login"));
//            return null;
//        }

        // If everything is ok, create the user
        user.setPassword(PasswordUtils.digestPassword(password1));
        System.out.println("*********************"+PasswordUtils.digestPassword(password1));
        user.setUserName(user.getUserName());
        System.out.println("*********************"+user.getUserName());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        System.out.println("*********************"+user.getEmail());
        user.setContactNo(user.getContactNo());
        user.setRegDate(new Date());
        user.setRoleId(1);
        boolean status = new UserDao().createUser(user);
        System.out.println("*********************Status: "+status);
        if(status)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "You are now a registered user"));
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Failed!!!", "Sorry, something went wrong, please try again"));

//        resetPasswords();
        
        loggedIn = true;
        
//        if (user.getRoleId()== 1)
//            admin = true;
                
        return "index.xhtml";
    }
}
