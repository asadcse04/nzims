/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookAuthor;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class Author implements Serializable {

    private int authorId;

    private String authorName;

    private String aboutAuthor;

    private String authornote;

    private String authorImg;

    public Author() {

    }

    public Author(int authorId, String authorName, String aboutAuthor, String authornote, String authorImg) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.aboutAuthor = aboutAuthor;
        this.authornote = authornote;
        this.authorImg = authorImg;
    }

    /**
     * @return the authorId
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the aboutAuthor
     */
    public String getAboutAuthor() {
        return aboutAuthor;
    }

    /**
     * @param aboutAuthor the aboutAuthor to set
     */
    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }

    /**
     * @return the authornote
     */
    public String getAuthornote() {
        return authornote;
    }

    /**
     * @param authornote the authornote to set
     */
    public void setAuthornote(String authornote) {
        this.authornote = authornote;
    }

    /**
     * @return the authorImg
     */
    public String getAuthorImg() {
        return authorImg;
    }

    /**
     * @param authorImg the authorImg to set
     */
    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

}
