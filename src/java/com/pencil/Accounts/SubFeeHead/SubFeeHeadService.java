/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SubFeeHead;

import java.util.List;

/**
 *
 * @author Mamun
 */
public interface SubFeeHeadService {
    
    public boolean addSubFeeHead(SubFeeHead subFeeHead);
    
    public List<SubFeeHead> getAllSubFeeHead();
}
