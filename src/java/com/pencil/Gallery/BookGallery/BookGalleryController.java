/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.gallery.BookGallery;

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
 * @author SHOHUG-SQ
 *
 *
 */
@ManagedBean
@ViewScoped

public class BookGalleryController {

    private BookGallery bookGallery;
    
    private UploadedFile photoFile;

    private List<BookGallery> bookData;

    BookGalleryService dao = new BookGalleryServiceImpl();
    
    ImgUpLoad uploadService = new ImgUpload_Impl();

    BookInfo bookInfo = new BookInfo();

    private List<String> academicYearList;

    private List<String> classList;

    private List<String> departmentList;

    private List<String> sbjectList;
    
    

    public BookGalleryController() {
        this.bookData = dao.bookGalleryList();
        
        this.academicYearList = bookInfo.BookInfoList("acyr");

        this.classList = bookInfo.BookInfoList("Scl_class");

        this.departmentList = bookInfo.BookInfoList("dept");

        this.sbjectList = bookInfo.BookInfoList("subject");
    }

    public void insertBookGallery() {
        
        FacesContext context = FacesContext.getCurrentInstance();

        if (this.photoFile != null) {

            this.bookGallery.setImagePath(this.photoFile.getFileName());
            
            

            if (dao.addBookGallery(this.bookGallery)) {

                uploadService.uploadImg("BookImage", bookGallery.getBookGalleryID()+"_"+photoFile.getFileName(), photoFile);

                context.addMessage(null, new FacesMessage("Successfully.. Book Gallery Data Added.", "..."));

            } else {

                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Book Gallery Data Not Added.!", "..."));

            }

        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select Book image.!", "..."));

        }
        
    }
    
    public void updateBookGallery(){
        
                if(this.photoFile.getFileName().equals(""))
        {
            if(dao.updBookGellery(bookGallery))               
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
            this.bookGallery.setImagePath(bookGallery.getBookGalleryID()+"_"+photoFile.getFileName());
            
            if(dao.updBookGellery(bookGallery))
            {        
                uploadService.uploadImg("BookImage",bookGallery.getBookGalleryID()+"_"+photoFile.getFileName(),photoFile);
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully.. Book Update complete...", "..."));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Photo Update failed...!", ""));
            }
        }
       
       this.bookGallery=null;
        
        
        //////////
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.updBookGellery(bookGallery)) {

            context.addMessage(null, new FacesMessage("Successful", "Book Gallery Data Update"));
            
           // this.bookData = dao.bookGalleryList();

            this.bookGallery = null;
        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Book gallery data is not update"));
        }
        
    }

    public BookGallery getBookGallery() {
        if (this.bookGallery == null) {
            this.bookGallery = new BookGallery();
        }
        return bookGallery;
    }

    public void setBookGallery(BookGallery bookGallery) {
        this.bookGallery = bookGallery;
    }

    public List<BookGallery> getBookData() {
        return bookData;
    }

    public void setBookData(List<BookGallery> bookData) {
        this.bookData = bookData;
    }

    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    public List<String> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<String> departmentList) {
        this.departmentList = departmentList;
    }

    public List<String> getSbjectList() {
        return sbjectList;
    }

    public void setSbjectList(List<String> sbjectList) {
        this.sbjectList = sbjectList;
    }

    public UploadedFile getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }

}
