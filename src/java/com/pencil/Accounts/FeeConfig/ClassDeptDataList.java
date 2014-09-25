/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeConfig;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author jahangiralamdiu
 */
public class ClassDeptDataList extends ListDataModel<ClassDeptObj> implements SelectableDataModel<ClassDeptObj> {

    public ClassDeptDataList() {
    }

    public ClassDeptDataList(List<ClassDeptObj> list) {
        super(list);
    } 


    @Override
    public ClassDeptObj getRowData(String className) {
       
        List<ClassDeptObj> classDeptObjList = (List<ClassDeptObj>) getWrappedData();  
          
        for(ClassDeptObj classDeptObj : classDeptObjList) { 
            
            if(classDeptObj.getClassName().equals(className)) 
                
                return classDeptObj;  
        }  
          
        return null; 
    }
    
    @Override
    public Object getRowKey(ClassDeptObj classDeptObj) {
        
        return classDeptObj.getClassName();
    }
    
}
