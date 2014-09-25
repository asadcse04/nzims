/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.SubHead;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface SubHeadService 
{
    public boolean createSubHead(SubHead sh);
    
    public boolean updateSubHead(SubHead shobj);
    
    List<SubHead> subHeadList();
    
    List<String> mainHead_List(String trCategoryName);
    
}
