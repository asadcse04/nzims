/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ClassTeacherAssign;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class ClassTeacherAssign implements Serializable{
   
    private String teacherid;
    private String teachername;
    private int classid;
    private String classname;
    
    private String ImgPath;

    public ClassTeacherAssign() {
    }

    public ClassTeacherAssign(String teacherid, String teachername, int classid) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.classid = classid;
    }

    public ClassTeacherAssign(int classid, String classname) {
        this.classid = classid;
        this.classname = classname;
    }

    public ClassTeacherAssign(String teacherid, String teachername, String ImgPath) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.ImgPath = ImgPath;
    }
    
    
    
    

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }
    
    
    
    
}
