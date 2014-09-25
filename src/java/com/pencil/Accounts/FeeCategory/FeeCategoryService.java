/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCategory;

import java.util.List;

/**
 *
 * @author Mamun
 */
public interface FeeCategoryService {
    
    public boolean addFeeCategory(FeeCategory feeCategory);
    
    public boolean updateFeeCategory(FeeCategory feeCategory);
    
    public List<FeeCategory> getAllFeeCategory();
    
}
