/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Designation.Designation;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface DesignationService 
{
 
    public boolean addDesignation(Designation designation);
    
    public List<Designation> getAllDesignation(); 


}
