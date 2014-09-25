/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamConfig;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author INSPIRON 5421
 */
public class ExamSubject_Config implements Serializable
{
    private List<String> subject_list;

    public ExamSubject_Config() {
    }
   

    /**
     * @return the subject_list
     */
    public List<String> getSubject_list() {
        return subject_list;
    }

    /**
     * @param subject_list the subject_list to set
     */
    public void setSubject_list(List<String> subject_list) {
        this.subject_list = subject_list;
    }
}
