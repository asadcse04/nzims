/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SubjectWiseReport;

import java.util.List;

/**
 *
 * @author salim
 */
public interface SubjectReportService 
{
  public List<SubjectReport> DetailsMarkReport(int exCnfID,int scCnfID,String subjectName);
  
  public List<SubjectReport> subjectMarkReport(int exCnfID,int scCnfID,String subjectName);
  
}
