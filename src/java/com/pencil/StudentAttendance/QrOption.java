/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.StudentAttendance;

import java.io.Serializable;
import java.util.Date;

/** 
 *
 * @author Mahfuj
 */
public class QrOption implements Serializable
{
    private Date from;
    
    private Date to;

    public QrOption() {
    }

    /**
     * @return the from
     */
    public Date getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public Date getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Date to) {
        this.to = to;
    }
    
    
}
