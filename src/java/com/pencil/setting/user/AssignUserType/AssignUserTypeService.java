/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.setting.user.AssignUserType;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface AssignUserTypeService {
    
    public boolean addUserType(AssignUserType assignUserType);
    
    public List<AssignUserType> userList();
    
    public List<AssignUserType> mobileList(AssignUserType mobileList);
}
