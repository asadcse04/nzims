/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff.SMS;

import com.pencil.Stuff.Stuff_Reg;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author salim
 */
public class StuffDataModel  extends ListDataModel<Stuff_Reg> implements SelectableDataModel<Stuff_Reg> 
{

    public StuffDataModel()
    {
        
    }

    public StuffDataModel(List<Stuff_Reg> list) {
        super(list);
    }
    
    

    @Override
    public Object getRowKey(Stuff_Reg stuff_rg)
    {
        return stuff_rg.getContactNo();
    }

    @Override
    public Stuff_Reg getRowData(String mobile)
    {
        List<Stuff_Reg> stuffData = (List<Stuff_Reg>) getWrappedData();

        for (Stuff_Reg stuff : stuffData) {
            if (stuff.getContactNo().equals(mobile)) {
                return stuff;
            }
        }
        return null;
    }
    
}
