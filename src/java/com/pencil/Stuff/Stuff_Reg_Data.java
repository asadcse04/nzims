/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author SHOHUG-SQ
 */
public class Stuff_Reg_Data extends ListDataModel<Stuff_Reg> implements SelectableDataModel<Stuff_Reg>
{   
    public Stuff_Reg_Data()
    {
        
    }

    public Stuff_Reg_Data(List<Stuff_Reg> list)
    {
        super(list);
    }

    @Override
    public Object getRowKey(Stuff_Reg stuff) 
    {
       return stuff.getContactNo();
    }

    @Override
    public Stuff_Reg getRowData(String mobile)
    {     
        List<Stuff_Reg> stuffData = (List<Stuff_Reg>) getWrappedData();  
          
        for(Stuff_Reg teacher : stuffData) {  
            if(teacher.getContactNo().equals(mobile))  
                return teacher;  
        }  
          
        return null; 
    }
    
}
