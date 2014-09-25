/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookSubCategory;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface BookSubCategoryService {

    public boolean addBookSubCategory(BookSubCategory bookSubCategory);

    public boolean updateBookSubCategory(BookSubCategory bookSubCategory);

    public List<BookSubCategory> getAllBookSubCategory();
}
