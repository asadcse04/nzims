

package com.pencil.Gallery.Photo;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;



@ManagedBean
@ViewScoped
public class PhotoController {
    
     private Photo photo;
    
     private UploadedFile photoFile;
     
     private List<Photo> photoList;
     
     PhotoService servicedao=new PhotoServiceImpl();
     
     ImgUpLoad uploadService = new ImgUpload_Impl();
     
     
     public void saveImage()
     
     {
      
     FacesContext context = FacesContext.getCurrentInstance();
    
     if( this.photoFile != null)
    
    {
    
     this.photo.setImgpath(this.photoFile.getFileName());
    
    
     if(servicedao.savePhoto(this.photo))
     
     {
     
     uploadService.uploadImg("galleryPhoto", photo.getId()+"_"+photoFile.getFileName(), photoFile);
     
     context.addMessage(null, new FacesMessage("Successful.....Photo Save Complete", "Photo Save Complete..."));
     
     }
     
     else
     
     {
      context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Photo Save Failed...!", ""));    
     
     }
  
    }
         
 
    
    else
    {
     
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select Photo image...!", ""));   
    
    }    
         
    }
     
     

     
     

    public void updatePhoto()
    
    {
         
   if (this.photoFile.getFileName().equals("")) 
        {
            if (servicedao.updatePhoto(this.photo))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully.. Photo Information Update complete...", "..."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed.. Photo Information Update Failed...", "..."));
            }
        } 
        else 
        {
            this.photo.setImgpath(photo.getId()+"_"+photoFile.getFileName());

            if (servicedao.updatePhoto(this.photo)) 
            {
                uploadService.uploadImg("galleryPhoto",photo.getId()+"_"+photoFile.getFileName(),photoFile);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully.. Photo Update complete...", "..."));
            } 
            else 
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Photo Information Update failed...!", ""));
            }
        }

        this.photo = null;
         
    }
     
     

    
    public Photo getPhoto() {
        
        if(this.photo==null){
            
            this.photo=new Photo();
        }
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

   
    public UploadedFile getPhotoFile() {
        return photoFile;
    }

   
    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }

    /**
     * @return the photoList
     */
    public List<Photo> getPhotoList() {
        
        this.photoList=servicedao.photoList();
        
        return this.photoList;
    
    }

    /**
     * @param photoList the photoList to set
     */
    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
     
     
    
}
