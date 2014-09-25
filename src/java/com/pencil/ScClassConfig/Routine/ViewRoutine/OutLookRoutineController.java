/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig.Routine.ViewRoutine;

import com.pencil.ScClassConfig.Routine.ClassRoutineService;
import com.pencil.ScClassConfig.Routine.ClassRoutineServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class OutLookRoutineController implements Serializable
{
    private OutLookRoutine viewRoutine;
    
    private List<OutLookRoutine> routineList;
    
    ClassRoutineService serviceDao=new ClassRoutineServiceImpl();

    /**
     * Creates a new instance of OutLookRoutineController
     */
    public OutLookRoutineController()
    {
        
    }
    
    /**
     *
     * @param classCnfID
     */
    public void viewCompleteRoutine(int classCnfID)
    {
        setRoutineList(serviceDao.OutLookCompleteRoutine(classCnfID));
    }

    /**
     * @return the viewRoutine
     */
    public OutLookRoutine getViewRoutine()
    {
        if(this.viewRoutine==null)
        {
            this.viewRoutine=new OutLookRoutine();
        }
        return this.viewRoutine;
    }

    /**
     * @param viewRoutine the viewRoutine to set
     */
    public void setViewRoutine(OutLookRoutine viewRoutine) {
        this.viewRoutine = viewRoutine;
    }

    /**
     * @return the routineList
     */
    public List<OutLookRoutine> getRoutineList() {
        return routineList;
    }

    /**
     * @param routineList the routineList to set
     */
    public void setRoutineList(List<OutLookRoutine> routineList) {
        this.routineList = routineList;
    }
}
