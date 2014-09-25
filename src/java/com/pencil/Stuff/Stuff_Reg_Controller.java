/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author SHOHUG-SQ
 */

@ManagedBean
@ViewScoped

public class Stuff_Reg_Controller  implements Serializable
{    
     private Stuff_Reg stuff;
     
     private List<Stuff_Reg> stuffList;
     
     private List<Stuff_Reg> stuff_Filter_List;
     
     private Stuff_Reg_Data stuffData; 
     
     private UploadedFile photoFile;
     
     Stuff_Reg_Service stuffDao = new Stuff_Reg_ServiceImpl();
     
     ImgUpLoad uploadService=new ImgUpload_Impl();

    public Stuff_Reg_Controller() 
    {      
        this.stuffList = stuffDao.stuffList();
        
        stuffData = new Stuff_Reg_Data(this.stuffList);
    }

    public Stuff_Reg getStuff() 
    {
        if(this.stuff==null)
        {
            this.stuff=new Stuff_Reg();
        }
        return stuff;
    }

    public void setStuff(Stuff_Reg stuff) {
        this.stuff = stuff;
    }

    public List<Stuff_Reg> getStuffList() {
        return stuffList;
    }

    public void setStuffList(List<Stuff_Reg> stuffList) {
        this.stuffList = stuffList;
    }

    public List<Stuff_Reg> getStuff_Filter_List() {
        return stuff_Filter_List;
    }

    public void setStuff_Filter_List(List<Stuff_Reg> stuff_Filter_List) {
        this.stuff_Filter_List = stuff_Filter_List;
    }

    public Stuff_Reg_Data getStuffData() {
        return stuffData;
    }

    public void setStuffData(Stuff_Reg_Data stuffData) {
        this.stuffData = stuffData;
    }

    public UploadedFile getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }

    public Stuff_Reg_Service getStuffDao() {
        return stuffDao;
    }

    public void setStuffDao(Stuff_Reg_Service stuffDao) {
        this.stuffDao = stuffDao;
    }

    public ImgUpLoad getUploadService() {
        return uploadService;
    }

    public void setUploadService(ImgUpLoad uploadService) {
        this.uploadService = uploadService;
    }
///////////////////////////////////////////////////////////////////////////////
    
     public String insertStuff()
     {
        if(this.photoFile!=null)
        {
            this.stuff.setImgPath(this.photoFile.getFileName());
            
            if(stuffDao.saveStuff(this.stuff))
            {
                uploadService.uploadImg("StuffImages",stuff.getStuffID()+"_"+photoFile.getFileName(),photoFile);
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully insert stuff info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to insert stuff info."));
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warnning", "Please select stuff image...!"));
        }
        
        this.stuff = null;
        
        return "index.xhtml";
    }
    
   ///////////////////////////////////////////////////////////////////////////////
     
     public String updateStuff()
     {

       if(this.photoFile.getFileName().equals(""))
        {
            if(stuffDao.updateStuff(stuff))               
            {        
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update stuff info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update stuff info."));
            }
        }
        else
        {
            this.stuff.setImgPath(stuff.getStuffID()+"_"+photoFile.getFileName());
            
            if(stuffDao.updateStuff(stuff))
            {        
                uploadService.uploadImg("StuffImages",stuff.getStuffID()+"_"+photoFile.getFileName(),photoFile);
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update stuff info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update stuff info."));
            }
        }
       
        this.stuff = null;
        
        return "index.xhtml";
    }   
     
}
