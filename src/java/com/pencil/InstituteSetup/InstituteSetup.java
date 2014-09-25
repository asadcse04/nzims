/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.InstituteSetup;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author Mastermind
 */
public class InstituteSetup  implements Serializable
{
    private String instituteID;
    
    private String  instituteName;
    
    private String instituteFullName;
    
    private String address;
    
    private String estb;
    
    private String contactNo;
    
    private String email;
    
    private String webSite;
    
    private String einNo;
    
    private String code;
    
    private String slogan;
    
    private String note;

    private String imgPath;
        
    private String backgroundImgPath;
    
  
    
   

    public InstituteSetup() 
    {
        
    }

    public InstituteSetup(String instituteID, String instituteName, String instituteFullName, String address, String estb, String contactNo, String email, String webSite, String einNo, String code, String slogan, String note, String imgPath, String backgroundImgPath) {
        this.instituteID = instituteID;
        this.instituteName = instituteName;
        this.instituteFullName = instituteFullName;
        this.address = address;
        this.estb = estb;
        this.contactNo = contactNo;
        this.email = email;
        this.webSite = webSite;
        this.einNo = einNo;
        this.code = code;
        this.slogan = slogan;
        this.note = note;
        this.imgPath = imgPath;
        this.backgroundImgPath = backgroundImgPath;
    }
  
    

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteFullName() {
        return instituteFullName;
    }

    public void setInstituteFullName(String instituteFullName) {
        this.instituteFullName = instituteFullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEstb() {
        return estb;
    }

    public void setEstb(String estb) {
        this.estb = estb;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEinNo() {
        return einNo;
    }

    public void setEinNo(String einNo) {
        this.einNo = einNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   
    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

 
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }  

    public String getBackgroundImgPath() {
        return backgroundImgPath;
    }

    public void setBackgroundImgPath(String backgroundImgPath) {
        this.backgroundImgPath = backgroundImgPath;
    }
    
    
}
