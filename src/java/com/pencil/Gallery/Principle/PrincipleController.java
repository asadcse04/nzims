/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Gallery.Principle;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class PrincipleController {

    private Principle principle;

    private UploadedFile photoFile;

    private List<Principle> principleList;

    PrincipleService servicedao = new PrincipleServiceImpl();

    ImgUpLoad uploadService = new ImgUpload_Impl();
    

    public void savePrinciple() 
    {

        FacesContext context = FacesContext.getCurrentInstance();

        if (this.photoFile != null) {

            this.principle.setImgpath(this.photoFile.getFileName());

            if (servicedao.savePrinciple(this.principle)) {

                uploadService.uploadImg("principleImage", principle.getId()+"_"+photoFile.getFileName(), photoFile);

                context.addMessage(null, new FacesMessage("Successfully.. Principle registration complete.", "..."));

            } else {

                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Principle registration failed.!", "..."));

            }

        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select Principle image.!", "..."));

        }

    }
    
    
   public void updatePrinciple() 
   {
        if(this.photoFile.getFileName().equals(""))
        {
            if(servicedao.updatePrinciple(this.principle))               
            {        
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successfully.. Principle Update complete...", "..."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Principle Photo Update failed...!", ""));
            }
        }
        else
        {
            this.principle.setImgpath(principle.getId()+"_"+photoFile.getFileName());
            
            if(servicedao.updatePrinciple(this.principle))
            {        
                uploadService.uploadImg("principleImage",principle.getId()+"_"+photoFile.getFileName(),photoFile);
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully.. Principle Update complete...", "..."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Principle Photo Update failed...!", ""));
            }
        }
       
       this.principle=null;
   }



    public Principle getPrinciple() {

        if (this.principle == null) {

            this.principle = new Principle();
        }
        return principle;
    }

    public void setPrinciple(Principle principle) {
        this.principle = principle;
    }

    public UploadedFile getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }

    /**
     * @return the principleList
     */
    public List<Principle> getPrincipleList() {

        this.principleList = servicedao.principleList();

        return this.principleList;
    }

    /**
     * @param principleList the principleList to set
     */
    public void setPrincipleList(List<Principle> principleList) {
        this.principleList = principleList;
    }

}
