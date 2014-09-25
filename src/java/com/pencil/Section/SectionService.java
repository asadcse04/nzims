/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Section;

import java.util.List;

/**
 *
 * @author user
 */
public interface SectionService
{
    
    public boolean createSection(Section sect);
    
    public boolean updateSection(Section sectObj);
    
    List<Section> sectionList();
}
