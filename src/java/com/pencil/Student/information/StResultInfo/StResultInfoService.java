/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Student.information.StResultInfo;

import java.util.List;

/**
 *
 * @author SHOHUG.SQ
 */
public interface StResultInfoService {
     
    public List<StResultInfo> finalGrade(StResultInfoController resultInfo);
    
    public List<StResultInfo> resultList(StResultInfoController stResultInfo);
    
     
     
}
