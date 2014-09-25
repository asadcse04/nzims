/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass.ClassRoom;

import java.util.List;

/**
 *
 * @author user
 */
public interface ClassRoomService 
{
 
    public boolean createClassRoom(ClassRoom classRm);
    
    public boolean updateClassRoom(ClassRoom classRm);
    
    List<ClassRoom> classRoomList();
}
