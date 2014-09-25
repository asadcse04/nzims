/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Gallery.Committee;

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
public class CommitteeController 
{

    private Committee committee;

    private UploadedFile photoFile;

    private List<Committee> committeeList;

    CommitteeService servicedao = new CommitteeServiceImpl();

    ImgUpLoad uploadService = new ImgUpload_Impl();

    public void saveCommittee() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (this.photoFile != null) {

            this.committee.setImgpath(this.photoFile.getFileName());

            if (servicedao.saveCommittee(this.committee)) {

                uploadService.uploadImg("committeeImage", committee.getId()+"_"+photoFile.getFileName(), photoFile);

                context.addMessage(null, new FacesMessage("Successfully.. Committee Registration complete", "..."));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Committee registration failed...!", ""));

            }

        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select committee image...!", ""));

        }

    }

    public void updateCommittee()
    {

        if (this.photoFile.getFileName().equals("")) 
        {
            if (servicedao.updateCommittee(this.committee))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully.. Committee Information Update complete...", "..."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed.. Committee Information Update Failed...", "..."));
            }
        } 
        else 
        {
            this.committee.setImgpath(committee.getId()+"_"+photoFile.getFileName());

            if (servicedao.updateCommittee(this.committee)) 
            {
                uploadService.uploadImg("committeeImage",committee.getId()+"_"+photoFile.getFileName(),photoFile);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully.. Committee Update complete...", "..."));
            } 
            else 
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Committee Information Update failed...!", ""));
            }
        }

        this.committee = null;
    }

//    public void updateCommittee() {
//
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        if (this.photoFile != null) {
//
//            this.committee.setImgpath(this.photoFile.getFileName());
//
//            if (servicedao.updateCommittee(this.committee)) {
//
//                uploadService.uploadImg("committeeImage", committee.getId() + "_" + photoFile.getFileName(), photoFile);
//
//                context.addMessage(null, new FacesMessage("Successful Committee Update complete...", "..."));
//
//                this.committee = null;
//
//            } else {
//                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Committee Information Update failed...!", ""));
//            }
//
//        } else {
//            if (this.servicedao.updateCommittee(this.committee)) {
//
//                context.addMessage(null, new FacesMessage("Successful... Committee Information Update complete...", "..."));
//
//                this.committee = null;
//            } else {
//                context.addMessage(null, new FacesMessage("Failed... Committee Information Update Failed...", "..."));
//            }
//
//        }
//
//    }

    /**
     * @return the committee
     */
    public Committee getCommittee() {

        if (this.committee == null) {

            this.committee = new Committee();
        }

        return this.committee;
    }

    /**
     * @param committee the committee to set
     */
    public void setCommittee(Committee committee) {
        this.committee = committee;
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

    /**
     * @return the committeeList
     */
    public List<Committee> getCommitteeList() {

        this.committeeList = servicedao.committeeList();

        return this.committeeList;
    }

    /**
     * @param committeeList the committeeList to set
     */
    public void setCommitteeList(List<Committee> committeeList) {
        this.committeeList = committeeList;
    }

}
