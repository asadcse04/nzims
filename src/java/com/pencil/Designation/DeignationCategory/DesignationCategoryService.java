/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Designation.DeignationCategory;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface DesignationCategoryService {
    
    public boolean addDesignationCategory(DesignationCategory designationCategory);
    
    public List<DesignationCategory> getAllDesignationCategory();
}
