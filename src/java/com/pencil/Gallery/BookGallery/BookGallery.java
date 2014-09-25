/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.gallery.BookGallery;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class BookGallery implements Serializable{
    
    private int bookGalleryID;
    
    private int acYear;
    
    private String className;
    
    private String departmentName;
    
    private String subjectName;
    
    private String code;
    
    private String bookName;
    
    private String topic;
    
    private String author;
    
    private String publication;
    
    private String edition;
    
    private double price;
    
    private String note;
    
    private String imagePath;

    public BookGallery() {
    }

    public BookGallery(int bookGalleryID, int acYear, String className, String departmentName, String subjectName, String code, String bookName, String topic, String author, String publication, String edition, double price, String note, String imagePath) {
        this.bookGalleryID = bookGalleryID;
        this.acYear = acYear;
        this.className = className;
        this.departmentName = departmentName;
        this.subjectName = subjectName;
        this.code = code;
        this.bookName = bookName;
        this.topic = topic;
        this.author = author;
        this.publication = publication;
        this.edition = edition;
        this.price = price;
        this.note = note;
        this.imagePath = imagePath;
    }

    
    
    

    public int getBookGalleryID() {
        return bookGalleryID;
    }

    public void setBookGalleryID(int bookGalleryID) {
        this.bookGalleryID = bookGalleryID;
    }

    public int getAcYear() {
        return acYear;
    }

    public void setAcYear(int acYear) {
        this.acYear = acYear;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
    
}
