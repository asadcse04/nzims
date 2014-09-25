/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Gallery.Photo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class ImageViewController {
    
    
    private List<Photo> photolist;
    
    private List<String> imageList;
    
    PhotoService servicedao=new PhotoServiceImpl();
    
    public ImageViewController(){
        
        this.photolist=servicedao.photoList();
        
    }

    /**
     * @return the photolist
     */
    public List<Photo> getPhotolist() {
        return photolist;
    }

    /**
     * @param photolist the photolist to set
     */
    public void setPhotolist(List<Photo> photolist) {
        this.photolist = photolist;
    }
    
        /**
     * @return the imageList
     */
    public List<String> getImageList() {
        
        this.imageList=new ArrayList<String>();
        
        for(Photo p:photolist){
            
            this.imageList.add(p.getImgpath());
        }
        
        return this.imageList;
    }

    /**
     * @param imageList the imageList to set
     */
    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
    
}
