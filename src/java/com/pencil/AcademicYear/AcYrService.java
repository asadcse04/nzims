/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.AcademicYear;

import java.util.List;

/**
 *
 * @author Mahfuj
 * 
 */
public interface AcYrService
{
    public boolean createAcYr(AcademicYear acyr);
    
    public boolean updateAcYr(AcademicYear acyrObj);
    
    List<AcademicYear> academicYrList();   
}
