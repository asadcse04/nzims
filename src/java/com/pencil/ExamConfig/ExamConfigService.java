/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamConfig;

import com.pencil.DefaultMark.DefaultMarkDivision;
import java.util.List;

/**
 *
 * @author apple
 */
public interface ExamConfigService
{
    //public List<String> subjectList(int acyr,String deptName,String className);
    
    List<String> examSubjectConfig(int acyr,String className);
    
    public List<ExamConfig> examConfigList();
    
    public boolean insertExamConfig(ExamConfig esc);
    
    public boolean exam_Subject_Mark_distribution(List<String> subject,List<DefaultMarkDivision> sbjmarkList,int excnf_id);
}
