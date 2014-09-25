/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook.SMS;

import com.pencil.Phone.PhoneBook.PhoneBook;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Riad
 */
public class PhoneBookData extends ListDataModel<PhoneBook> implements SelectableDataModel<PhoneBook> {

    public PhoneBookData() {
    }
    
    public PhoneBookData(List<PhoneBook> list) {
        
        super(list);
    
    }
    
       public PhoneBook getRowData(String mobile) {
       
               
        List<PhoneBook> phoneBookData = (List<PhoneBook>) getWrappedData();  
          
        for(PhoneBook phoneBook : phoneBookData) {  
            
            if(phoneBook.getMobile().equals(mobile))  
                
                return phoneBook;  
        }  
          
        return null; 
    }
       
        public Object getRowKey(PhoneBook phoneBook) {
       
        return phoneBook.getMobile();
    }
    
}
