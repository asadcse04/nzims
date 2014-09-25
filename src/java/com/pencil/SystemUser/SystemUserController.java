/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SystemUser;

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
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class SystemUserController implements Serializable
{
    private SystemUser system_user;
    
    private List<SystemUser> user_List;
    
    private List<SystemUser> user_filter_List;
    
    private UploadedFile photoFile;
    
    ImgUpLoad uploadService=new ImgUpload_Impl();
    
    SystemUserService serviceDao=new SystemUserService_Impl();
    

    /**
     * Creates a new instance of SystemUserController
     */
    public SystemUserController()
    {
        this.user_List=serviceDao.userList();
    }
    
    /**
     *
     * @return
     */
    public String insertSystemUser()
    {
        this.system_user.setImgPath(this.photoFile.getFileName());
        
        if(serviceDao.createUser(system_user))       
        {          
            uploadService.uploadImg("userImages",photoFile.getFileName(),photoFile);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully insert system user info."));
        }          
        else        
        {           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to insert system user info."));       
        }
        
        this.system_user=null;
        
        return "index.xhtml";
    }

    /**
     *
     * @return
     */
    public String editSystemUser()
    {
        if(this.photoFile.getFileName().equals(""))
        {
            if(serviceDao.updateUser(system_user))               
            {        
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update system user info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update system user info."));
            }
        }
        else
        {
            this.system_user.setImgPath(this.photoFile.getFileName());
            
            if(serviceDao.updateUser(system_user))
            {        
                uploadService.uploadImg("userImages",photoFile.getFileName(),photoFile);
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully update system user info."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update system user info."));
            }
        }
        
        this.system_user=null;
        
        return "/UserPanel/SystemUser.xhtml";
    }
    

    /**
     * @return the system_user
     */
    public SystemUser getSystem_user()
    {
        if(this.system_user==null)
        {
            this.system_user=new SystemUser();
        }
        
        return this.system_user;
    }

    /**
     * @param system_user the system_user to set
     */
    public void setSystem_user(SystemUser system_user) {
        this.system_user = system_user;
    }

    /**
     * @return the user_List
     */
    public List<SystemUser> getUser_List() {
        return user_List;
    }

    /**
     * @param user_List the user_List to set
     */
    public void setUser_List(List<SystemUser> user_List) {
        this.user_List = user_List;
    }

    /**
     * @return the user_filter_List
     */
    public List<SystemUser> getUser_filter_List() {
        return user_filter_List;
    }

    /**
     * @param user_filter_List the user_filter_List to set
     */
    public void setUser_filter_List(List<SystemUser> user_filter_List) {
        this.user_filter_List = user_filter_List;
    }

    /**
     * @return the photoFile
     */
    public UploadedFile getPhotoFile() {
        return photoFile;
    }

    /**
     * @param photoFile the photoFile to set
     */
    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }
}
