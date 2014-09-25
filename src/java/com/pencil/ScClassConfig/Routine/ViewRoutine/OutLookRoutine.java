/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig.Routine.ViewRoutine;

import java.io.Serializable;

/**
 *
 * @author Mahfuj
 */
public class OutLookRoutine implements Serializable
{
    private String DayName;
    
    private String period_1;
    
    private String period_2;
    
    private String period_3;
    
    private String period_4;
    
    private String period_5;
    
    private String period_6;
    
    private String period_7;
    
    private String period_8;

    public OutLookRoutine() {
    }

    public OutLookRoutine(String DayName, String period_1, String period_2, String period_3, String period_4, String period_5, String period_6, String period_7, String period_8) {
        this.DayName = DayName;
        this.period_1 = period_1;
        this.period_2 = period_2;
        this.period_3 = period_3;
        this.period_4 = period_4;
        this.period_5 = period_5;
        this.period_6 = period_6;
        this.period_7 = period_7;
        this.period_8 = period_8;
    }

    /**
     * @return the DayName
     */
    public String getDayName() {
        return DayName;
    }

    /**
     * @param DayName the DayName to set
     */
    public void setDayName(String DayName) {
        this.DayName = DayName;
    }

    /**
     * @return the period_1
     */
    public String getPeriod_1() {
        return period_1;
    }

    /**
     * @param period_1 the period_1 to set
     */
    public void setPeriod_1(String period_1) {
        this.period_1 = period_1;
    }

    /**
     * @return the period_2
     */
    public String getPeriod_2() {
        return period_2;
    }

    /**
     * @param period_2 the period_2 to set
     */
    public void setPeriod_2(String period_2) {
        this.period_2 = period_2;
    }

    /**
     * @return the period_3
     */
    public String getPeriod_3() {
        return period_3;
    }

    /**
     * @param period_3 the period_3 to set
     */
    public void setPeriod_3(String period_3) {
        this.period_3 = period_3;
    }

    /**
     * @return the period_4
     */
    public String getPeriod_4() {
        return period_4;
    }

    /**
     * @param period_4 the period_4 to set
     */
    public void setPeriod_4(String period_4) {
        this.period_4 = period_4;
    }

    /**
     * @return the period_5
     */
    public String getPeriod_5() {
        return period_5;
    }

    /**
     * @param period_5 the period_5 to set
     */
    public void setPeriod_5(String period_5) {
        this.period_5 = period_5;
    }

    /**
     * @return the period_6
     */
    public String getPeriod_6() {
        return period_6;
    }

    /**
     * @param period_6 the period_6 to set
     */
    public void setPeriod_6(String period_6) {
        this.period_6 = period_6;
    }

    /**
     * @return the period_7
     */
    public String getPeriod_7() {
        return period_7;
    }

    /**
     * @param period_7 the period_7 to set
     */
    public void setPeriod_7(String period_7) {
        this.period_7 = period_7;
    }

    /**
     * @return the period_8
     */
    public String getPeriod_8() {
        return period_8;
    }

    /**
     * @param period_8 the period_8 to set
     */
    public void setPeriod_8(String period_8) {
        this.period_8 = period_8;
    }
       
}
