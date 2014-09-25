/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.EmailBookCategory;

import java.util.List;

/**
 *
 * @author sis
 */
public interface EmailBookCategoryService {
    
    
    public boolean addEmailBookCategory(EmailBookCategory emailBookCategory);

    public boolean updateEmailBookCategory(EmailBookCategory emailBookCategory);

    public List<EmailBookCategory> getAllEmailBookCategory();

    
}
