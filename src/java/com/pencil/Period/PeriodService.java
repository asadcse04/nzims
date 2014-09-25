/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Period;

import java.util.List;

/**
 *
 * @author Mamun
 */
public interface PeriodService 
{
    public boolean createPeriod(Period prd);
    
    public boolean updatePeriod(Period prdObj);
    
    List<String> shiftNameList();
    
    List<Period> periodList();
}
