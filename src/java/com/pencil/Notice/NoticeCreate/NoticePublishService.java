/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Notice.NoticeCreate;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface NoticePublishService {
    
    public boolean addNoticePublish(NoticePublish noticePublish);
    
    public boolean updateNoticePublish(NoticePublish noticePublish);
    
    public List<NoticePublish> noticePublishList();
}
