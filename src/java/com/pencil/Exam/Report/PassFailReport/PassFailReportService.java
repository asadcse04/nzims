/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.PassFailReport;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface PassFailReportService {
    
  
    
    public List<String> ExamNameList();
    
    public List<PassFailReport> totalPassFail(PassFailReport passFailReport);
    
}
