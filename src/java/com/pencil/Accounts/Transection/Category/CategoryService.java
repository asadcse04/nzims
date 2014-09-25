/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Category;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface CategoryService 
{
    public boolean createCategory(Category cate);
    
    public boolean updateCategory(Category cateObj);
     
    List<Category> categoryList();
    
}
