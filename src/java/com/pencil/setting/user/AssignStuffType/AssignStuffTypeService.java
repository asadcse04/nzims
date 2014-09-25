/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.setting.user.AssignStuffType;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface AssignStuffTypeService {
    
    public boolean addUserType(AssignStuffType assignUserType);
    
    public List<AssignStuffType> userList();
    
    public List<AssignStuffType> mobileList(AssignStuffType mobileList);
}
