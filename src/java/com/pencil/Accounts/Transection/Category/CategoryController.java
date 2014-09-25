/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Category;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mastermind
 */
@ManagedBean
@ViewScoped
public class CategoryController implements Serializable
{

    private Category category;
    
    private List<Category> category_List;
    
    CategoryService categoryDao = new CategoryServiceImpl();
    
    public CategoryController() 
    {
        this.category_List = categoryDao.categoryList();
    }
    
    public void insertCategory()
    {
       FacesContext context = FacesContext.getCurrentInstance();
      
       if(categoryDao.createCategory(this.category))
       {
          this.category_List = categoryDao.categoryList();
 
          context.addMessage(null, new FacesMessage("Successful insert transection category info.")); 
       }
       else
       {
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert transection category!",""));
       }
    }
    
    public void updateCategory()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(categoryDao.updateCategory(this.category))
        {
            this.category_List = categoryDao.categoryList();
            
            this.category=null;
            
            context.addMessage(null, new FacesMessage("Successful update transection category info.")); 
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update transection category!",""));
        }
    }

    public Category getCategory() 
    {
        if(this.category==null)
        {
          this.category= new Category();
        }
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategory_List() {
        return category_List;
    }

    public void setCategory_List(List<Category> category_List) {
        this.category_List = category_List;
    }
    
}
