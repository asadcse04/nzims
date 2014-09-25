/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface PhoneBookService {
    
    public boolean addPhoneBook(PhoneBook phoneBook);
    
    public List<String> phnCatList();
    
    public List<PhoneBook> phBookList();
    
}
