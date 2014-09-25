/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.EmailBookCategory;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sis
 */
@ManagedBean
@ViewScoped

public class EmailBookCategoryController {

    private EmailBookCategory emailBookCategory;

    private List<EmailBookCategory> emailBookCategoryAllList;

    EmailBookCategoryService serviceDao = new EmailBookCategoryServiceImpl();

    public EmailBookCategoryController() {

    }

    public void addEmailBookCategory() {
        
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addEmailBookCategory(this.getEmailBookCategory())) {
            context.addMessage(null, new FacesMessage("Successful", "EmailBookCategory List Added"));

            this.setEmailBookCategory(null);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "EmailBookCategory List is not added"));
        }

    }

    public void updateEmailBookCategory() {
        
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateEmailBookCategory(this.getEmailBookCategory())) {
            context.addMessage(null, new FacesMessage("Successful", "EmailBookCategory List Updated"));

            this.setEmailBookCategory(null);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "EmailBookCategory List is not updated"));
        }

    }

    /**
     * @return the emailBookCategory
     */
    public EmailBookCategory getEmailBookCategory() {

        if (this.emailBookCategory == null) {
            this.emailBookCategory = new EmailBookCategory();
        }

        return emailBookCategory;

    }

    /**
     * @param emailBookCategory the emailBookCategory to set
     */
    public void setEmailBookCategory(EmailBookCategory emailBookCategory) {
        this.emailBookCategory = emailBookCategory;
    }

    /**
     * @return the emailBookCategoryAllList
     */
    public List<EmailBookCategory> getEmailBookCategoryAllList() {

        this.emailBookCategoryAllList = serviceDao.getAllEmailBookCategory();
        return this.emailBookCategoryAllList;

    }

    /**
     * @param emailBookCategoryAllList the emailBookCategoryAllList to set
     */
    public void setEmailBookCategoryAllList(List<EmailBookCategory> emailBookCategoryAllList) {
        this.emailBookCategoryAllList = emailBookCategoryAllList;
    }

}
