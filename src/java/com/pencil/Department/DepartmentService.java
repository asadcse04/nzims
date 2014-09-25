/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Department;

import java.util.List;

/**
 *
 * @author user
 */
public interface DepartmentService 
{

    public boolean createDepartment(Department dept); 
    
    public boolean updateDepartment(Department deptObj); 
    
    List<Department> departmentList();
}
