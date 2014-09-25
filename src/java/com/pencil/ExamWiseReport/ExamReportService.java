/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamWiseReport;

import java.util.List;

/**
 *
 * @author salim
 */
public interface ExamReportService
{
    public List<ExamReport> ExamPassFailReport(int exCnfID,int scCnfID);
    
    public List<ExamReport> GradingReport(int exCnfID,int scCnfID);
    
    public List<ExamReport> SectionWise_meritList(int exCnfID,int scCnfID);
}
