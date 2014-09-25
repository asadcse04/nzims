
package com.pencil.Section;

import java.io.Serializable;

/**
 *
 * @author user
 */

public class Section implements Serializable {
 
   
    private int sectionID;

    private String sectionName;
  
    private String note;

    public Section()
    {
        
    }

    public Section(int sectionID, String sectionName, String note) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.note = note;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

   
   
}
