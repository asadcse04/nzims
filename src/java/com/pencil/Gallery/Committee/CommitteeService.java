/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Gallery.Committee;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface CommitteeService {
    
    public boolean saveCommittee(Committee committee);
    
    public boolean updateCommittee(Committee committee_update);
   
    public List<Committee> committeeList();
    
}
