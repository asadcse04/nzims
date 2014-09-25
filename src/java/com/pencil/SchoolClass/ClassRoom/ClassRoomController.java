/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass.ClassRoom;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class ClassRoomController 
{
    private ClassRoom class_room;
    
    private List<ClassRoom> cl_room_list;
    
    ClassRoomService cl_rm_ServiceDao = new ClassRoomServiceImpl();

    /**
     * Creates a new instance of ClassRoomController
     */
    public ClassRoomController()
    {
        this.cl_room_list=cl_rm_ServiceDao.classRoomList();
    }
    
    public void insert_Class_Room()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(cl_rm_ServiceDao.createClassRoom(this.class_room))
        {
            this.cl_room_list=cl_rm_ServiceDao.classRoomList();
            
            this.class_room=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert class room info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert class room info!",""));
        }
    }
    
    
    public void editClassRoom()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(cl_rm_ServiceDao.updateClassRoom(this.class_room))
        {
            this.cl_room_list=cl_rm_ServiceDao.classRoomList();
            
            this.class_room=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update class room info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update class room!",""));
        } 
    }

    /**
     * @return the class_room
     */
    public ClassRoom getClass_room() 
    {
        if(this.class_room==null)
        {
            this.class_room=new ClassRoom();
        }
        return this.class_room;
    }

    /**
     * @param class_room the class_room to set
     */
    public void setClass_room(ClassRoom class_room) {
        this.class_room = class_room;
    }

    /**
     * @return the cl_room_list
     */
    public List<ClassRoom> getCl_room_list() {
        return cl_room_list;
    }

    /**
     * @param cl_room_list the cl_room_list to set
     */
    public void setCl_room_list(List<ClassRoom> cl_room_list) {
        this.cl_room_list = cl_room_list;
    }
}
