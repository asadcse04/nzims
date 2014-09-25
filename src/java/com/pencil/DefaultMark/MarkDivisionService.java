/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.DefaultMark;

import java.util.List;

/**
 *
 * @author Mahfuj
 */
public interface MarkDivisionService
{
    public boolean create_d_MarkDivision(DefaultMarkDivision dmd);
    
    public boolean update_d_MarkDivision(DefaultMarkDivision dmdObj);
    
    public List<DefaultMarkDivision> d_MarkDivisionList();
}
