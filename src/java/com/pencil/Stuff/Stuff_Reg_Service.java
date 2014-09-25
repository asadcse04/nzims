/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface Stuff_Reg_Service
{   
    public boolean saveStuff(Stuff_Reg stuff);
    
    public boolean updateStuff(Stuff_Reg stuffup);
    
    public List<Stuff_Reg> stuffList();   
}
