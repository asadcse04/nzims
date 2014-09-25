/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBookCategory;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface PhoneBookCategoryService {
    
    public boolean addPhoneBookCategory(PhoneBookCategory phoneBookCategory);
    
    public List<PhoneBookCategory> getAllPhoneCategoryList();
    
}
