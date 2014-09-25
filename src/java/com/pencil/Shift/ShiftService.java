/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Shift;

import java.util.List;

/**
 *
 * @author user
 */
public interface ShiftService
{
   public boolean createShift(Shift shft);
   
   public boolean updateShift(Shift shftObj);
    
   List<Shift> shiftList();
}
