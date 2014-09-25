/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.BasicView;

import java.util.List;

/**
 *
 * @author SHOHUG.SQ
 */
public interface BasicReportService {

    public int getScCnfID(BasicReport sq);
    
    public int getExCnfID(BasicReport sq);
    
    public List<String> subjectName(BasicReport className);

    public List<BasicReport> yearClassDepartShiftSection();

    public List<BasicReport> DetailsMarkReport(int exCnfID, int scCnfID, String subjectName);

    public List<BasicReport> subjectMarkReport(int exCnfID, int scCnfID, String subjectName);

    public List<BasicReport> ExamPassFailReport(int exCnfID, int scCnfID);

    public List<BasicReport> GradingReport(int exCnfID, int scCnfID);

    public List<BasicReport> SectionWise_meritList(int exCnfID, int scCnfID);

}
