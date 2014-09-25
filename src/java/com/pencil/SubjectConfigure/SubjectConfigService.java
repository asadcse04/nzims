/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SubjectConfigure;

import java.util.List;

/**
 *
 * @author Mahfuj
 */
public interface SubjectConfigService
{
    public boolean saveSubjectConfig(SubjectConfig sbjCnf);
    
    public List<SubjectConfig> sbjconfigurationList();
    
    public List<String> bookList(SubjectConfig sbj_cnf);
    
}
