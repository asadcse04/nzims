/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.InstitutePassFail;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface InstituteReportService {

    public List<InstituteReport> totalPassFail(InstituteReport instituteWiseReport);

    public List<String> ExamNameList();
}
