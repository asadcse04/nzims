/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookPublication;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class Publication implements Serializable {

    private int publicationId;

    private String publicationName;

    private String publicationAddress;

    private String contactno;

    private String aboutPublication;

    private String Publicationnote;

    public Publication() {

    }

    public Publication(int publicationId, String publicationName, String publicationAddress, String contactno, String aboutPublication, String Publicationnote) {
        this.publicationId = publicationId;
        this.publicationName = publicationName;
        this.publicationAddress = publicationAddress;
        this.contactno = contactno;
        this.aboutPublication = aboutPublication;
        this.Publicationnote = Publicationnote;
    }

    /**
     * @return the publicationId
     */
    public int getPublicationId() {
        return publicationId;
    }

    /**
     * @param publicationId the publicationId to set
     */
    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    /**
     * @return the publicationName
     */
    public String getPublicationName() {
        return publicationName;
    }

    /**
     * @param publicationName the publicationName to set
     */
    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    /**
     * @return the publicationAddress
     */
    public String getPublicationAddress() {
        return publicationAddress;
    }

    /**
     * @param publicationAddress the publicationAddress to set
     */
    public void setPublicationAddress(String publicationAddress) {
        this.publicationAddress = publicationAddress;
    }

    /**
     * @return the contactno
     */
    public String getContactno() {
        return contactno;
    }

    /**
     * @param contactno the contactno to set
     */
    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    /**
     * @return the aboutPublication
     */
    public String getAboutPublication() {
        return aboutPublication;
    }

    /**
     * @param aboutPublication the aboutPublication to set
     */
    public void setAboutPublication(String aboutPublication) {
        this.aboutPublication = aboutPublication;
    }

    /**
     * @return the Publicationnote
     */
    public String getPublicationnote() {
        return Publicationnote;
    }

    /**
     * @param Publicationnote the Publicationnote to set
     */
    public void setPublicationnote(String Publicationnote) {
        this.Publicationnote = Publicationnote;
    }

}
