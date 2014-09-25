/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.StudentSubjectMark;

import com.pencil.Dummy.Student.ExamResult.*;
import java.io.Serializable;

/**
 *
 * @author apple
 */
public class ShortCodeMarkAcceptance implements Serializable
{
    private double sc1;
    
    private double sc2;
    
    private double sc3;
    
    private double sc4;

    public ShortCodeMarkAcceptance() {
    }

    /**
     * @return the sc1
     */
    public double getSc1() {
        return sc1;
    }

    /**
     * @param sc1 the sc1 to set
     */
    public void setSc1(double sc1) {
        this.sc1 = sc1;
    }

    /**
     * @return the sc2
     */
    public double getSc2() {
        return sc2;
    }

    /**
     * @param sc2 the sc2 to set
     */
    public void setSc2(double sc2) {
        this.sc2 = sc2;
    }

    /**
     * @return the sc3
     */
    public double getSc3() {
        return sc3;
    }

    /**
     * @param sc3 the sc3 to set
     */
    public void setSc3(double sc3) {
        this.sc3 = sc3;
    }

    /**
     * @return the sc4
     */
    public double getSc4() {
        return sc4;
    }

    /**
     * @param sc4 the sc4 to set
     */
    public void setSc4(double sc4) {
        this.sc4 = sc4;
    }    
}
