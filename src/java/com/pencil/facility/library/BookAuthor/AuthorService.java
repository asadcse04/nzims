/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookAuthor;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface AuthorService {

    public boolean addAuthor(Author author);
    
    public boolean updateAuthor(Author author);
    

    public List<Author> getAllAuthor();
}
