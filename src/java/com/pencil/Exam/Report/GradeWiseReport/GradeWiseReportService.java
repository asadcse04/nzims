/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.GradeWiseReport;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface GradeWiseReportService {
 
 
    
    public List<GradeWiseReport> totalGradeList(GradeWiseReport gradeWiseReport);
    
    public List<String> ExamNameList();
    
}
