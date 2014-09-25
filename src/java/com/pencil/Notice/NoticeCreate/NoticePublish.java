/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Notice.NoticeCreate;

import java.util.Date;

/**
 *
 * @author Riad
 */
public class NoticePublish {
    
    private int acdNoticeId;
    
    private String noticeFrom;
    
    private String noticeFor;
    
    private Date startDisplay;
    
    private Date validTill;
    
    private String noticeHead;
    
    private String noticeDetails;
    
    private int rating;
    
    private int acdNoticeCategoryId;
    
    public NoticePublish(){
        
    }

    public NoticePublish(int acdNoticeId, String noticeFrom, String noticeFor, Date startDisplay, Date validTill, String noticeHead, String noticeDetails, int rating, int acdNoticeCategoryId) {
        this.acdNoticeId = acdNoticeId;
        this.noticeFrom = noticeFrom;
        this.noticeFor = noticeFor;
        this.startDisplay = startDisplay;
        this.validTill = validTill;
        this.noticeHead = noticeHead;
        this.noticeDetails = noticeDetails;
        this.rating = rating;
        this.acdNoticeCategoryId = acdNoticeCategoryId;
    }

    
    
    /**
     * @return the acdNoticeId
     */
    public int getAcdNoticeId() {
        return acdNoticeId;
    }

    /**
     * @param acdNoticeId the acdNoticeId to set
     */
    public void setAcdNoticeId(int acdNoticeId) {
        this.acdNoticeId = acdNoticeId;
    }

    /**
     * @return the noticeFrom
     */
    public String getNoticeFrom() {
        return noticeFrom;
    }

    /**
     * @param noticeFrom the noticeFrom to set
     */
    public void setNoticeFrom(String noticeFrom) {
        this.noticeFrom = noticeFrom;
    }

    /**
     * @return the noticeFor
     */
    public String getNoticeFor() {
        return noticeFor;
    }

    /**
     * @param noticeFor the noticeFor to set
     */
    public void setNoticeFor(String noticeFor) {
        this.noticeFor = noticeFor;
    }

    /**
     * @return the startDisplay
     */
    public Date getStartDisplay() {
        return startDisplay;
    }

    /**
     * @param startDisplay the startDisplay to set
     */
    public void setStartDisplay(Date startDisplay) {
        this.startDisplay = startDisplay;
    }

    /**
     * @return the validTill
     */
    public Date getValidTill() {
        return validTill;
    }

    /**
     * @param validTill the validTill to set
     */
    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    /**
     * @return the noticeHead
     */
    public String getNoticeHead() {
        return noticeHead;
    }

    /**
     * @param noticeHead the noticeHead to set
     */
    public void setNoticeHead(String noticeHead) {
        this.noticeHead = noticeHead;
    }

    /**
     * @return the noticeDetails
     */
    public String getNoticeDetails() {
        return noticeDetails;
    }

    /**
     * @param noticeDetails the noticeDetails to set
     */
    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the acdNoticeCategoryId
     */
    public int getAcdNoticeCategoryId() {
        return acdNoticeCategoryId;
    }

    /**
     * @param acdNoticeCategoryId the acdNoticeCategoryId to set
     */
    public void setAcdNoticeCategoryId(int acdNoticeCategoryId) {
        this.acdNoticeCategoryId = acdNoticeCategoryId;
    }
    
    
    
}
