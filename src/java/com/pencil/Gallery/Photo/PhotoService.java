/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Gallery.Photo;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface PhotoService {
    
    public boolean savePhoto(Photo photo);
    
     public boolean updatePhoto(Photo photo);
    
     public List<Photo> photoList();
    
}
