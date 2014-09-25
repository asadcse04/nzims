/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook;

import java.io.Serializable;
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
public class PhoneBookController implements Serializable{
    
    private PhoneBook phoneBook;
    
    private List<String> phnCatList;
    
    private List<PhoneBook> phbooklist;
    
    private String phncategory;
    
    private PhoneBookData phoneBookData;
    
    private List<PhoneBook> selectedPhoneBook;
    
    
    public PhoneBookService servicedao=new PhoneBookServiceImpl();
    
    
    
    
    public PhoneBookController(){
    
        this.phoneBookData=new PhoneBookData(servicedao.phBookList());   
    
    }
    
    public void addPhoneBook(){
        
        this.phoneBook.setCategoryid(Integer.parseInt(this.phncategory.split("-")[0]));
        
        FacesContext context=FacesContext.getCurrentInstance();
        
        if(servicedao.addPhoneBook(this.phoneBook)){
        
        context.addMessage(null, new FacesMessage("Successful", "PhoneBook  Added"));
        }
        
        else{
         
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed", "PhoneBook Not Added"));   
        
        }
        
    
}
    
    

    /**
     * @return the phoneBook
     */
    public PhoneBook getPhoneBook() {
        
        if(this.phoneBook==null){
            
          this.phoneBook=new PhoneBook();
        }
           return phoneBook;
    }

    /**
     * @param phoneBook the phoneBook to set
     */
    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    /**
     * @return the phnCatList
     */
    public List<String> getPhnCatList() {
        
        this.phnCatList=servicedao.phnCatList();
        
        return this.phnCatList;
    }

    /**
     * @param phnCatList the phnCatList to set
     */
    public void setPhnCatList(List<String> phnCatList) {
        this.phnCatList = phnCatList;
    }

    /**
     * @return the phncategory
     */
    public String getPhncategory() {
        return phncategory;
    }

    /**
     * @param phncategory the phncategory to set
     */
    public void setPhncategory(String phncategory) {
        this.phncategory = phncategory;
    }

    /**
     * @return the phbooklist
     */
    public List<PhoneBook> getPhbooklist() {
        
        this.phbooklist=servicedao.phBookList();
        
        return this.phbooklist;
    }

    /**
     * @param phbooklist the phbooklist to set
     */
    public void setPhbooklist(List<PhoneBook> phbooklist) {
        this.phbooklist = phbooklist;
    }

   
    /**
     * @return the phoneBookData
     */
    public PhoneBookData getPhoneBookData() {
        return phoneBookData;
    }

    /**
     * @param phoneBookData the phoneBookData to set
     */
    public void setPhoneBookData(PhoneBookData phoneBookData) {
        this.phoneBookData = phoneBookData;
    }

    /**
     * @return the selectedPhoneBook
     */
    public List<PhoneBook> getSelectedPhoneBook() {
        return selectedPhoneBook;
    }

    /**
     * @param selectedPhoneBook the selectedPhoneBook to set
     */
    public void setSelectedPhoneBook(List<PhoneBook> selectedPhoneBook) {
        this.selectedPhoneBook = selectedPhoneBook;
    }

}