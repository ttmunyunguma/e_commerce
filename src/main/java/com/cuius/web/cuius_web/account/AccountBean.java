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
import com.cuius.web.cuius_web.store.ShoppingCartBean;
import com.cuius.web.cuius_web.util.PasswordUtils;
import com.thedeanda.lorem.LoremIpsum;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.spi.AlterableContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.primefaces.PrimeFaces;

/**
 *
 * @author terrence
 */
@Named(value = "accountBean")
@SessionScoped
public class AccountBean implements Serializable {

    // ======================================
    // =          Injection Points          =
    // ======================================
    
    @Inject
    private BeanManager beanManager;

    @Inject
    private HttpServletRequest request;
    
    // ======================================
    // =             Constants              =
    // ======================================

    private static final String COOKIE_NAME = "cuiusCookie";
    private static final int COOKIE_AGE = 60; // Expires after 60 seconds
    
    // ======================================
    // =             Attributes             =
    // ======================================
    
    Users user = new Users();
    private boolean loggedIn;
    private boolean admin;
    private String passwordConfirm;
    private boolean rememberMe;
    private HttpServletResponse response;
    
    /**
     * Creates a new instance of AccountBean
     */
    public AccountBean() {
    }
    
    // ======================================
    // =         Lifecycle methods          =
    // ======================================
    
/*    @PostConstruct
    private void checkIfUserHasRememberMeCookie() {
        String coockieValue = getCookieValue();
        if (coockieValue == null)
            return;

        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_UUID, User.class);
        query.setParameter("uuid", coockieValue);
        try {
            user = query.getSingleResult();
            // If the user is an administrator
            if (user.getRole().equals(UserRole.ADMIN))
                admin = true;
            // The user is now logged in
            loggedIn = true;
        } catch (NoResultException e) {
            // The user maybe has an old coockie, let's get rid of it
            removeCookie();
        }
    }*/
    
    
    // ======================================
    // =          Business methods          =
    // ======================================
    
    @Transactional(dontRollbackOn = IllegalArgumentException.class)
    public String signUp() {
        
        // check if user_name already exist?
//        if (UserDao.getUserByUserName(user.getUserName()) != null) {
//            facesContext.addMessage(null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN, "User Name "+user.getUserName()+" already exists ",
//                            "You must choose a different login"));
//            return null;
//        }

        // If everything is ok, create the user
        
        user.setUserName(user.getUserName());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setContactNo(user.getContactNo());
        user.setRegDate(new Date());
        user.setRoleId(1);
        user.setPassword(PasswordUtils.digestPassword(user.getPassword()));
        boolean status = new UserDao().createUser(user);
        if (status) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Success!", "You are now a registered user"));
        }
        else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Failed!!!", "Sorry, something went wrong, please try again"));
        }
        resetPasswords();
        
        
//        if (user.getRoleId()== 1)
//            admin = true;
                
        return "login.xhtml?faces-redirect=true";
    }
    
    public String signIn() throws IOException {
        
        user = UserDao.doSignIn(user.getEmail(), PasswordUtils.digestPassword(user.getPassword()));
        boolean status = UserDao.isProceessSuccessful;
        
/*        try {
           //  If the user is an administrator
            if (user.getRoleId() == 1){
                admin = true;
            
              //If the user has clicked on remember me
//            if (rememberMe) {
//                String uuid = UUID.randomUUID().toString();
//                user.setUuid(uuid);
//                addCookie(uuid);

            } else {
                user.setUuid(null);
                removeCookie();
            }*/
            if (status) {

            // The user is now logged in
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Welcome" + user.getFirstName(), "Good to have you back"));
            loggedIn = true;
            PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
            return "index.xhtml?faces-redirect=true";
        }
          else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Wrong user/password", "Check your inputs or ask for a new password"));

            return "login.xhtml?faces-redirect=true";
        }
            
    }
    
    public String logout() {
        AlterableContext ctx = (AlterableContext) beanManager.getContext(SessionScoped.class);
        Bean<?> myBean = beanManager.getBeans(AccountBean.class).iterator().next();
        ctx.destroy(myBean);
        myBean = beanManager.getBeans(ShoppingCartBean.class).iterator().next();
        ctx.destroy(myBean);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("GoodBye", "You are now logged out"));
        
        return "index.xhtml?faces-redirect=true";
    }
    
/*    public String logoutAndRemoveCookie() {
        removeCookie();
        user.setUuid(null);
        em.merge(user);
        AlterableContext ctx = (AlterableContext) beanManager.getContext(SessionScoped.class);
        Bean<?> myBean = beanManager.getBeans(AccountBean.class).iterator().next();
        ctx.destroy(myBean);
        myBean = beanManager.getBeans(ShoppingCartBean.class).iterator().next();
        ctx.destroy(myBean);
        return "index";
    }*/
    
    public String forgotPassword() {
       
        try {
            user = UserDao.getUserByEmail(user.getEmail());
            String temporaryPassword = LoremIpsum.getInstance().getWords(1);
            user.setPassword(PasswordUtils.digestPassword(temporaryPassword));
            UserDao.mergeContext(user);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Email sent", "An email has been sent to " + user.getEmail() + " with a temporary password"));
            
            // send an email with the password "dummyPassword"
            
            return logout();
        } catch (NoResultException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Unknown email!!", "This email has not been used, please sign up!"));
            
            return null;
        }
    }
    
    public String updateProfile() {
        
        if (user.getPassword() != null && !user.getPassword().isEmpty())
            user.setPassword(PasswordUtils.digestPassword(user.getPassword()));
        UserDao.mergeContext(user);
        resetPasswords();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Done!!", "Profile has been updated for " + user.getFirstName()));
            
        return null;
    }
    
    private void resetPasswords() {
    }
    
    // ======================================
    // =          Cookies                   =
    // ======================================
    
    private String getCookieValue() {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private void addCookie(String value) {
        Cookie cookie = new Cookie(COOKIE_NAME, value);
        cookie.setPath("/sampleJSFLogin");
        cookie.setMaxAge(COOKIE_AGE);
        response.addCookie(cookie);
    }

    private void removeCookie() {
        Cookie cookie = new Cookie(COOKIE_NAME, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
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

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    
}
