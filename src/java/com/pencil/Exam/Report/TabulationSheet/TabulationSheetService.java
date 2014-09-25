/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.TabulationSheet;

import java.util.List;

/**
 *
 * @author SHOHUG.SQ
 */
public interface TabulationSheetService {
    
    public List<String> listScClass(int acyrID);
    
    public List<String> listScDept(int acyrID,String className);
    
    public List<String> listScShift(int acyrID,String deptName,String className);
    
    public List<String> listScSection(int acyrID,String deptName,String className,String shift);
    
    public int getScCnfID(int acyr,String deptName,String className,String shiftName,String sectionName);
    
    public int getExCnfID(int acyr,String className,String ExamName);
    
    public List<TabulationSheetSQ> AllList(TabulationSheetController controller);
    
}
