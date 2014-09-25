/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.gallery.BookGallery;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface BookGalleryService {
    
    public boolean addBookGallery(BookGallery bookGallery);
    
    public boolean updBookGellery(BookGallery bookGallery);
    
    public List<BookGallery> bookGalleryList();
    
    public List<String> departmentName(String className);
    
    public List<String> subjectName(String deptName);
    
}
