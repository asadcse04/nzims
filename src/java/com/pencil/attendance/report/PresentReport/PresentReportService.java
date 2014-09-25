/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.attendance.report.PresentReport;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface PresentReportService {
    
    public List<PresentReport> searchPresent(PresentReport presentReport);
    
}
