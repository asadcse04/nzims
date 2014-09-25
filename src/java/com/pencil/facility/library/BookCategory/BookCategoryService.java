/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookCategory;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface BookCategoryService {

    public boolean addBookCategory(BookCategory bookCategory);

    public boolean updateBookCategory(BookCategory bookCategory);

    public List<BookCategory> getAllBookCategory();

}
