/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mahfuj 
 */
public class Student_Registration implements Serializable
{
    
    //----------------------------------Student Basic(Change By Requirement)--------------------------------------
    
    
    //---------------------------------------Student Basic Info---------------------------------------------------
    
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private String CntNo;
    
    private String gender;
    
    private Date dob;
    
    private boolean status;
    
    private String imgPath;
    
    private String religion;
    
    private String bloodGroup;
    
    
     ///----------------------------------Student Address Info-------------------------------------------------------
    
    private String presentAddress;
    
    private String permanentAddress;
    
    //-------------------------------------Student GuardianInfo-----------------------------------------------------
    
    private String fatherName;
    
    private String fatherOccupation;
    
    
    private String motherName;
    
    private String motherOccupation;
    
    
    private String guardianName;
    
    private String guardianOccupation;
    
    private double guardianSalary;
    
    
    private String relation;
    
    private String guardianContactNo;
    
    private String guardianEmail;
   
    
       
    /////-----------------------------------Previous Exam Info------------------------------------------------------
    private int prev_Exam_ID;
    
    private String instituteName;
    
    private String eductn_board;
    
    private String group;
    
    private String p_examName;
    
    private String examRoll;
    
    private String examRegNo;
    
    private String grade;
    
    private String cgpa;
    
    private String passingYear;
    
    
    ///---------------------------------------Previous institute info---------------------------------------------------------
    private int prev_institute_ID;
    
    private String collegeName;
    
    private String academicYear; 
    
    private String prvs_className;
    
    private String prvs_deptName;
    
    private int prvs_classRoll;
    
    private String prvs_edu_board;
    
    
    //-------------------------------------Student Identification(fixed)-------------------------------------------------------------
    
    private int acyr;
    
    private String deptName;
    
    private String className;
    
    private String shiftName;
    
    private String sectionName;
    
    //---------------------------------------Student Attendance-------------------------------------------------
    
    private boolean absent;
    
    private String  note="";
    
    private String period="";
    
    //-----------------------------------------------4th subject wrapper(fixed)------------------------------------------------------------
    
    /*private String cmpl_1_sbjName;
    
    private String optn_1_sbjName;
    
    private String cmpl_2_sbjName;
    
    private String optn_2_sbjName;
    
    private boolean sbj_status;*/
    

    public Student_Registration()
    {
        
    }

    public Student_Registration(String studentID, String studentName, int studentRoll, String CntNo, String gender, Date dob, boolean status, String imgPath, String religion, String bloodGroup, String presentAddress, String permanentAddress, String fatherName,String fatherOccupation, String motherName,String motherOccupation, String guardianName,String guardianOccupation,double guardianSalary, String relation, String guardianContactNo,String guardianEmail,int acyr, String deptName, String className, String shiftName, String sectionName)
    {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.CntNo = CntNo;
        this.gender = gender;
        this.dob = dob;
        this.status = status;
        this.imgPath = imgPath;
        this.religion = religion;
        this.bloodGroup = bloodGroup;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.fatherName = fatherName;
        this.fatherOccupation=fatherOccupation;
        this.motherName = motherName;
        this.motherOccupation=motherOccupation;
        this.guardianName = guardianName;
        this.guardianOccupation=guardianOccupation;
        this.guardianSalary=guardianSalary;
        this.relation = relation;
        this.guardianContactNo = guardianContactNo;
        this.guardianEmail=guardianEmail;
       
        /*this.instituteName = instituteName;
        this.eductn_board = eductn_board;
        this.group = group;
        this.p_examName=p_ExamName;
        this.examRoll = examRoll;
        this.examRegNo = examRegNo;
        this.grade = grade;
        this.cgpa = cgpa;
        this.passingYear = passingYear;
        this.collegeName = collegeName;
        this.academicYear = academicYear;
        this.prvs_className = prvs_className;
        this.prvs_deptName = prvs_deptName;
        this.prvs_classRoll = prvs_classRoll;
        this.prvs_edu_board = prvs_edu_board;*/
        this.acyr = acyr;
        this.deptName = deptName;
        this.className = className;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
    }
    
    

    public Student_Registration(String studentID, String studentName, int studentRoll) { //attendance purpose
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
    }
    
     public Student_Registration(String studentID, String studentName, int studentRoll, String gender, String fatherName, String guardianContactNo) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.gender = gender;
        this.fatherName = fatherName;
        this.guardianContactNo = guardianContactNo;
       
    }
    

    //---------------------------------------------Refactoring start-----------------------------------------------------------------

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentRoll
     */
    public int getStudentRoll() {
        return studentRoll;
    }

    /**
     * @param studentRoll the studentRoll to set
     */
    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    /**
     * @return the CntNo
     */
    public String getCntNo() {
        return CntNo;
    }

    /**
     * @param CntNo the CntNo to set
     */
    public void setCntNo(String CntNo) {
        this.CntNo = CntNo;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * @return the religion
     */
    public String getReligion() {
        return religion;
    }

    /**
     * @param religion the religion to set
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the presentAddress
     */
    public String getPresentAddress() {
        return presentAddress;
    }

    /**
     * @param presentAddress the presentAddress to set
     */
    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    /**
     * @return the permanentAddress
     */
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * @param permanentAddress the permanentAddress to set
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the fatherOccupation
     */
    public String getFatherOccupation() {
        return fatherOccupation;
    }

    /**
     * @param fatherOccupation the fatherOccupation to set
     */
    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    /**
     * @return the motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName the motherName to set
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * @return the motherOccupation
     */
    public String getMotherOccupation() {
        return motherOccupation;
    }

    /**
     * @param motherOccupation the motherOccupation to set
     */
    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    /**
     * @return the guardianName
     */
    public String getGuardianName() {
        return guardianName;
    }

    /**
     * @param guardianName the guardianName to set
     */
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    /**
     * @return the guardianOccupation
     */
    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    /**
     * @param guardianOccupation the guardianOccupation to set
     */
    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    /**
     * @return the guardianSalary
     */
    public double getGuardianSalary() {
        return guardianSalary;
    }

    /**
     * @param guardianSalary the guardianSalary to set
     */
    public void setGuardianSalary(double guardianSalary) {
        this.guardianSalary = guardianSalary;
    }

    /**
     * @return the relation
     */
    public String getRelation() {
        return relation;
    }

    /**
     * @param relation the relation to set
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * @return the guardianContactNo
     */
    public String getGuardianContactNo() {
        return guardianContactNo;
    }

    /**
     * @param guardianContactNo the guardianContactNo to set
     */
    public void setGuardianContactNo(String guardianContactNo) {
        this.guardianContactNo = guardianContactNo;
    }

    /**
     * @return the guardianEmail
     */
    public String getGuardianEmail() {
        return guardianEmail;
    }

    /**
     * @param guardianEmail the guardianEmail to set
     */
    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }

    /**
     * @return the acyr
     */
    public int getAcyr() {
        return acyr;
    }

    /**
     * @param acyr the acyr to set
     */
    public void setAcyr(int acyr) {
        this.acyr = acyr;
    }

    /**
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName the deptName to set
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the shiftName
     */
    public String getShiftName() {
        return shiftName;
    }

    /**
     * @param shiftName the shiftName to set
     */
    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    /**
     * @return the sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @param sectionName the sectionName to set
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }  

    public int getPrev_Exam_ID() {
        return prev_Exam_ID;
    }

    public void setPrev_Exam_ID(int prev_Exam_ID) {
        this.prev_Exam_ID = prev_Exam_ID;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getEductn_board() {
        return eductn_board;
    }

    public void setEductn_board(String eductn_board) {
        this.eductn_board = eductn_board;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getP_examName() {
        return p_examName;
    }

    public void setP_examName(String p_examName) {
        this.p_examName = p_examName;
    }

    public String getExamRoll() {
        return examRoll;
    }

    public void setExamRoll(String examRoll) {
        this.examRoll = examRoll;
    }

    public String getExamRegNo() {
        return examRegNo;
    }

    public void setExamRegNo(String examRegNo) {
        this.examRegNo = examRegNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public int getPrev_institute_ID() {
        return prev_institute_ID;
    }

    public void setPrev_institute_ID(int prev_institute_ID) {
        this.prev_institute_ID = prev_institute_ID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getPrvs_className() {
        return prvs_className;
    }

    public void setPrvs_className(String prvs_className) {
        this.prvs_className = prvs_className;
    }

    public String getPrvs_deptName() {
        return prvs_deptName;
    }

    public void setPrvs_deptName(String prvs_deptName) {
        this.prvs_deptName = prvs_deptName;
    }

    public int getPrvs_classRoll() {
        return prvs_classRoll;
    }

    public void setPrvs_classRoll(int prvs_classRoll) {
        this.prvs_classRoll = prvs_classRoll;
    }

    public String getPrvs_edu_board() {
        return prvs_edu_board;
    }

    public void setPrvs_edu_board(String prvs_edu_board) {
        this.prvs_edu_board = prvs_edu_board;
    }

    @Transient
    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    @Transient
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Transient
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
    
    
    
    
}
