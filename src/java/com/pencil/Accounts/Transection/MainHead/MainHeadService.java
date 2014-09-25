/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.MainHead;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface MainHeadService 
{
    public boolean createMainHead(MainHead mh);
    
    public boolean updateMainHead(MainHead mhobj);
    
    List<MainHead> mainHeadList();
    
    List<String>category_List(String trType);
}
