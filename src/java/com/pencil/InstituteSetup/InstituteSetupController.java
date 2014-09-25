/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.InstituteSetup;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Mastermind
 */
@ManagedBean
@ViewScoped
public class InstituteSetupController implements Serializable
{
    private InstituteSetup instituteSetup;
    
    private UploadedFile photoFileLogo;
    
    private UploadedFile photoFileBackGImg;
    
    private List<InstituteSetup> InstituteList;
    
    private List<String> invstituteNameData;
    
    InstituteSetupService InstituteDao = new InstituteSetupServiceImpl();
   
    ImgUpLoad imgservice=new ImgUpload_Impl();
    
    
    
    public InstituteSetupController()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        HttpSession s = request.getSession();
        
        System.out.println(s.getAttribute("user"));
        
       
//        this.InstituteList = InstituteDao.instituteSetupList();
//         
//        this.invstituteNameData = InstituteDao.instituteNameList();
         
    }
    
    
  public void insertInstituteSetup()
    {
       FacesContext context = FacesContext.getCurrentInstance();
        
       if(photoFileLogo != null)
        {
            this.instituteSetup.setImgPath(photoFileLogo.getFileName());
            
            this.instituteSetup.setBackgroundImgPath(photoFileBackGImg.getFileName());
            
            if(InstituteDao.saveInstitute(this.instituteSetup))
            {
                imgservice.uploadImg("Header",photoFileLogo.getFileName(),photoFileLogo);
                
                imgservice.uploadImg("Header", photoFileBackGImg.getFileName(), photoFileBackGImg);
                
                context.addMessage(null, new FacesMessage("Successful","Insert institute setup.")); 
            }
            else
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Institute setup failed...!",""));
            }
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please select institute logo...!",""));
        }
        
    }
  
  public void editInstituteSetup()
    {
     if(this.photoFileLogo.getFileName().equals(""))
        {
            if(InstituteDao.updateInstitute(instituteSetup))               
            {        
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update institute info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update institute info."));
            }
        }
        else
        {
            this.instituteSetup.setImgPath(photoFileLogo.getFileName());
            
            if(InstituteDao.updateInstitute(instituteSetup)) 
            {        
                imgservice.uploadImg("Header",photoFileLogo.getFileName(),photoFileLogo);
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update institute info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update institute info."));
            }
        }
    }
   
    public InstituteSetup getInstituteSetup()
    {
         if (this.instituteSetup==null) 
        {
            this.instituteSetup = new InstituteSetup();
        }

        return this.instituteSetup;
    }

    public void setInstituteSetup(InstituteSetup instituteSetup) {
        this.instituteSetup = instituteSetup;
    }

    public UploadedFile getPhotoFileLogo() {
        return photoFileLogo;
    }

    public void setPhotoFileLogo(UploadedFile photoFileLogo) {
        this.photoFileLogo = photoFileLogo;
    }

    public UploadedFile getPhotoFileBackGImg() {
        return photoFileBackGImg;
    }

    public void setPhotoFileBackGImg(UploadedFile photoFileBackGImg) {
        this.photoFileBackGImg = photoFileBackGImg;
    }


    public List<InstituteSetup> getInstituteList() {
        return InstituteList;
    }

    public void setInstituteList(List<InstituteSetup> InstituteList) {
        this.InstituteList = InstituteList;
    }

    public ImgUpLoad getImgservice() {
        return imgservice;
    }

    public void setImgservice(ImgUpLoad imgservice) {
        this.imgservice = imgservice;
    }

    public List<String> getInvstituteNameData() {
        return invstituteNameData;
    }

    public void setInvstituteNameData(List<String> invstituteNameData) {
        this.invstituteNameData = invstituteNameData;
    }

}
