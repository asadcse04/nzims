/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig.Routine;

import com.pencil.ScClassConfig.Routine.ViewRoutine.OutLookRoutine;
import java.util.List;

/**
 *
 * @author Mahfuj
 */
public interface ClassRoutineService
{
    public boolean save_Assign_Subject_Tchr(ClassRoutine cr,String dayName,String prdName,String tchrid);
    
    public List<ClassRoutineUpdate> viewRoutine(int ClassCnfID,String day,String shift);
    
    public List<OutLookRoutine> OutLookCompleteRoutine(int ClassCnfID);
    
    public boolean updateRoutine(ClassRoutineUpdate crUpdate,boolean flag);
}
