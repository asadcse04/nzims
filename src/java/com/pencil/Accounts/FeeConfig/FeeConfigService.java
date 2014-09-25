/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeConfig;

import com.pencil.Accounts.SubFeeHead.SubFeeHead;
import java.util.List;

/**
 *
 * @author jahangiralamdiu
 */
public interface FeeConfigService {
    
    public boolean saveFeeConfig(FeeConfig feeConfigObj, List <SubFeeHeadDetail> subFeeHeadDetList, List<ClassDeptObj> classDeptList);
    
    public List<SubFeeHeadDetail> getSubHeadDetail(FeeConfig feeConfig,ClassDeptDataList classDeptDataList);
    
     public List<ClassDeptObj> getClassDeptList();   
        
}
