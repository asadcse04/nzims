/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SystemUser;

import java.util.List;

/**
 *
 * @author Mahfuj
 */
public interface SystemUserService 
{
    public boolean createUser(SystemUser usr);
    
    public boolean updateUser(SystemUser usr);
    
    public List<SystemUser> userList();
}
