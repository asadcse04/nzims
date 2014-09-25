/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Gallery.Principle;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface PrincipleService 
{
    
    public boolean savePrinciple(Principle principle);
    
    public boolean updatePrinciple(Principle principle_update);
    
    public List<Principle> principleList();
    

}
