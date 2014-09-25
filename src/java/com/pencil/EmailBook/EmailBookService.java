/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.EmailBook;

import java.util.List;

/**
 *
 * @author sis
 */
public interface EmailBookService {
    
    
      
    public boolean addEmailBook(EmailBook emailBook);

    public boolean updateEmailBook(EmailBook emailBook);

    public List<EmailBook> getAllEmailBook();

    
    
}
