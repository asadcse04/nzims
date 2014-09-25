/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBookCategory;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Riad
 */

@ManagedBean
@ViewScoped
public class PhoneBookCategoryController {
    
    private PhoneBookCategory phoneBookCategory;
    
    private List<PhoneBookCategory> phoneBookCategoryList;
    
    
    PhoneBookCategoryService servicedao=new PhoneBookCategoryServiceImpl();
    
    
    public void addPhoneBookCategory(){
        
        FacesContext context=FacesContext.getCurrentInstance();
        
        if(servicedao.addPhoneBookCategory(this.phoneBookCategory)){
        
        context.addMessage(null, new FacesMessage("Successful", "PhoneBook  Category Added"));
        }
        
        else{
         
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed", "PhoneBook  Category Not Added"));   
        
        }
      
        
    }

    /**
     * @return the phoneBookCategory
     */
    public PhoneBookCategory getPhoneBookCategory() {
        
        if(this.phoneBookCategory==null){
            
            this.phoneBookCategory=new PhoneBookCategory();
        }
        return this.phoneBookCategory;
    }

    /**
     * @param phoneBookCategory the phoneBookCategory to set
     */
    public void setPhoneBookCategory(PhoneBookCategory phoneBookCategory) {
        
        this.phoneBookCategory = phoneBookCategory;
    }

    /**
     * @return the phoneBookCategoryList
     */
    public List<PhoneBookCategory> getPhoneBookCategoryList() {
        
        this.phoneBookCategoryList=this.servicedao.getAllPhoneCategoryList();
        
        return this.phoneBookCategoryList;
    }

    /**
     * @param phoneBookCategoryList the phoneBookCategoryList to set
     */
    public void setPhoneBookCategoryList(List<PhoneBookCategory> phoneBookCategoryList) {
        
        this.phoneBookCategoryList = phoneBookCategoryList;
    }
    
}
