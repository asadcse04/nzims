/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig;

import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.Period.Period;
import java.util.List;

/**
 *
 * @author Mahfuj
 */
public interface Sc_ClassConfigService
{
    public boolean saveScClassConfig(ScClassConfig cnf);
    
    public boolean updateScClassConfig(ScClassConfig cnf);
    
    public List<String> listScClass(int acyrID);
    
    public List<String> listScClassGlobal();
    
    public List<String> listScDept(int acyrID,String className);
    
    public List<String> listScDeptGlobal();
    
    public List<String> listScShift(int acyrID,String deptName,String className);
    
    public List<String> listScSection(int acyrID,String deptName,String className,String shift);
    
    public List<ScClassConfig> listScClassConfig();
    
    public int getScCnfID(int acyr,String deptName,String className,String shiftName,String sectionName);
    
    
    List<ScClassConfig> scClassConfiguration_List_ed();
    
    StringBuilder scClassConfig_ID_List(ScClassConfig scCnf);
    
    List<Student_Registration> studentList(StringBuilder scCnfID);
    
    
    public List<Period> viewPeriodList(String shiftName);
    
    public List<String> viewSubjectList(int sclassCnfID);
    
    public ScClassConfig scClassConfig(String studentid);
    
}
