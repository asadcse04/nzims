/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Notice.NoticeCategory;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface NoticeCategoryService {
    
    public boolean addNoticeCategory(NoticeCategory noticeCategory);
    
    public List<NoticeCategory> NoticeCategoryList();
    
}
