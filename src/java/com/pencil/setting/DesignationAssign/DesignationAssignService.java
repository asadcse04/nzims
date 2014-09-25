/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.DesignationAssign;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface DesignationAssignService {

    public boolean AddDesignation(DesignationAssign designationAssign);

    public boolean UpdateDesignation(DesignationAssign designationAssign);

    public List<DesignationAssign> teacherList();

    public List<String> categoryList();

    public List<String> designationList(String categoryName);

}
