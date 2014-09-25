/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookPublication;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG-SQ
 */
@ManagedBean
@ViewScoped
public class PublicationController {

    private Publication publication;

    private List< Publication> publicationAllList;

    PublicationService serviceDao = new PublicationServiceImpl();

    public void addPublication() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addPublication(this.publication)) {
            context.addMessage(null, new FacesMessage("Successful", "Publication is Added"));

            this.publication = null;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Publication is not added"));
        }

    }

    public void updatePublication() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updatePublication(this.publication)) {
            context.addMessage(null, new FacesMessage("Successful", "Publication is Updated"));

            this.publication = null;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Publication is not updated"));
        }
    }

    /**
     * @return the publication
     */
    public Publication getPublication() {

        if (this.publication == null) {
            this.publication = new Publication();
        }
        return this.publication;
    }

    /**
     * @param publication the publication to set
     */
    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    /**
     * @return the publicationAllList
     */
    public List< Publication> getPublicationAllList() {

        this.publicationAllList = serviceDao.getAllPublication();

        return this.publicationAllList;
    }

    /**
     * @param publicationAllList the publicationAllList to set
     */
    public void setPublicationAllList(List< Publication> publicationAllList) {
        this.publicationAllList = publicationAllList;
    }

}
