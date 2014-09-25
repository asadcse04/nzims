/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass;

import java.util.List;

/**
 *
 * @author Mahfuj
 */
public interface SchoolClass_Service
{
    public boolean createSchoolClass(SchoolClass sclass);
    
    public boolean updateSchoolClass(SchoolClass sclassObj);
    
    List<SchoolClass> schoolclassList();
}
