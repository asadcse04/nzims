/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeHead;

import java.util.List;

/**
 *
 * @author Mamun
 */
public interface FeeHeadService {
    
    public boolean addFeeHead(FeeHead feeHead);
    
    public List<FeeHead> getAllFeeHead();
    
}
