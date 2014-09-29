/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Md Mahfuj Jia
 * @StudentResult Module
 */
public class ResultServiceImpl implements Serializable,StudentExamResultService
{

    /**
     *
     * @param acyr
     * @param className
     * @param ExamName
     * @return
     */
    @Override
    public int getExCnfID(int acyr, String className, String ExamName) 
    {
        int exCnfId=0;
        
        DB_Connection o; 
       
        Connection con = null;
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        String instituteid="";
        
        FacesContext context=FacesContext.getCurrentInstance();
        
        context.getExternalContext().getSessionMap().put("Examname", ExamName);
        
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            o=new DB_Connection();
            
            con=o.getConnection();
            
            prst=con.prepareStatement("select ExCnfID from exam_config where AcYr=? and ClassID=(select ClassID from class where ClassName=?) and ExamID=(select Exam_ID from exam where ExamName=? and instituteid=?) and instituteid=?");
            
            prst.setInt(1,acyr);
            
            prst.setString(2,className);
            
            prst.setString(3,ExamName);
            
            prst.setString(4,instituteid);
             
            prst.setString(5,instituteid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                exCnfId=rs.getInt(1);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("ResultServiceImpl:"+ex);
        }
        finally
        { 
            try
            { 
                if(rs!=null) 
                { 
                    rs.close(); 
                } 
                if(prst!=null) 
                { 
                    prst.close(); 
                } 
                if(con!=null) 
                { 
                    con.close(); 
                } 
            } 
            catch(SQLException e) 
            { 
                System.out.println(e); 
            }
            
            className=null;
            
            ExamName=null;
        } 
        
        return exCnfId;
    }

    /**
     *
     * @param scCnfID
     * @param subjectName
     * @return
     */
    @Override
    public List<StudentExamResult> getStudent_insertResult(int scCnfID, String subjectName)
    {
        List<StudentExamResult> studentList=new ArrayList<StudentExamResult>();
        
        int flag = 0;
        
        String qr="";
        
        DB_Connection o; 
       
        Connection con = null;
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            o=new DB_Connection();
            
            con=o.getConnection();
            
            
            
            prst=con.prepareStatement("select status from subject where SubjectName=?");
            
            prst.setString(1,subjectName);
            
            rs=prst.executeQuery();
            
            if(rs.next())
            {
                flag=rs.getInt(1);
            }
            rs.close();
            
            prst.close();
            
            
            
            if(flag==0)//for common  subject
            {
                qr="select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si"
                    + " where si.StudentID=sb.StudentID and si.instituteid=sb.instituteid "
                        + " and si.ClassConfigID IN("+getScCnf_id_List(scCnfID)+") and sb.InstituteID='"+instituteID+"' order by sb.StudentRoll";
            }
            
            else if(flag==1)//for elective subject
            {
                qr="select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si,student_4th_subject_wrap sw"
                        + " where si.StudentID=sb.StudentID and sw.StudentID=sb.StudentID and si.instituteid=sb.instituteid "
                        + " and sb.InstituteID='"+instituteID+"' and sw.SubjectID=(select SubjectID from subject where SubjectName='"+subjectName+"') and si.ClassConfigID=? order by sb.StudentRoll";
                
               // prst.setInt(1, scCnfID);
            }
            else if(flag==2)//for departmental subject
            {
                qr="select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si"
                    + " where si.StudentID=sb.StudentID and si.instituteid=sb.instituteid and sb.InstituteID='"+instituteID+"' "
                        + " and si.ClassConfigID=? order by sb.StudentRoll";
                
                //prst.setInt(1, scCnfID);
            }
            else if(flag==3)//for common elective subject both science & commerce for example computer
            {
                qr="select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si,student_4th_subject_wrap sw"
                        + " where si.StudentID=sb.StudentID and sw.StudentID=sb.StudentID and si.instituteid=sb.instituteid and sb.InstituteID='"+instituteID+"' "
                        + " and sw.SubjectID=(select SubjectID from subject where SubjectName='"+subjectName+"') and si.ClassConfigID IN("+getScCnf_id_List(scCnfID)+") order by sb.StudentRoll";
                
               // prst.setInt(1, scCnfID);
            }
            
            prst = con.prepareStatement(qr);
            
            if((flag==1)|| (flag==2))
            {
                prst.setInt(1, scCnfID);
            }
            
            rs = prst.executeQuery();

            while (rs.next())
            {
                studentList.add(new StudentExamResult(rs.getString(1), rs.getString(2), rs.getInt(3), "", "", "", ""));
            }
            
            System.out.println("Number of student to input mark:"+studentList.size());
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        { 
            try
            { 
                if(rs!=null) 
                { 
                    rs.close(); 
                } 
                if(prst!=null) 
                { 
                    prst.close(); 
                } 
                if(con!=null) 
                { 
                    con.close(); 
                } 
            } 
            catch(SQLException e) 
            { 
                System.out.println(e); 
            }
            
            subjectName=null;
        } 
        
        return studentList;
    }
    
    /**
     *
     * @param sc_cnf_id
     * @return
     */
    public StringBuilder getScCnf_id_List(int sc_cnf_id)
    {
        StringBuilder sb=new StringBuilder();
        
        String qr = "";
        
        DB_Connection db; 
       
        Connection cn = null;
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            db=new DB_Connection();
            
            cn=db.getConnection();
            
            prst=cn.prepareStatement("SELECT AcYrID, ClassID, ShiftID, SectionID FROM classconfig where ScConfigID=?  and InstituteID='"+instituteID+"'");
            
            prst.setInt(1,sc_cnf_id);
            
            rs=prst.executeQuery();
            
            if(rs.next())
            {
                qr="SELECT ScConfigID FROM classconfig where AcYrID="+rs.getInt("AcYrID")+" and  ClassID="+rs.getInt("ClassID")+" and ShiftID="+rs.getInt("ShiftID")+" and SectionID="+rs.getInt("SectionID")+"";
            }
            
            rs.close();
            
            prst.close();
            
            
            prst=cn.prepareStatement(qr);
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                sb.append(rs.getInt("ScConfigID"));
                
                sb.append(",");
            }  
            
            if(sb.length()>0)
            {
                sb.setLength(sb.length()-1);
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(rs!=null) 
                { 
                    rs.close(); 
                } 
                if(prst!=null) 
                { 
                    prst.close(); 
                } 
                if(cn!=null) 
                { 
                    cn.close(); 
                } 
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
        }
        
        return sb;
    }

    /**
     *
     * @param exCnfID
     * @param subjectName
     * @param teacherID
     * @param examRsList
     * @param exmGrdList
     * @return
     */
    @Override
    public boolean insertStudentExamScore(int exCnfID, String subjectName,String teacherID, List<StudentExamResult> examRsList,List<ExamGrade> exmGrdList) 
    {   
        String sc1;
        
        String sc2;
        
        String sc3;
        
        String sc4;
        
        
        DB_Connection db; 
       
        Connection cn = null;
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        
        double sbj_total = 0;
        
        double totalScore = 0;
        
        double avg = 0;
        
        double finalScore = 0;
        
        String letterGrd = "";
        
        double point = 0;
        
        boolean failflag=false;
        
        
        List<ExamMarkDivision> exmMark_Div_List;
        
        Iterator<StudentExamResult> itr;
        
        try
        {
            db=new DB_Connection();
            
            cn=db.getConnection();
            
            exmMark_Div_List=new ArrayList<ExamMarkDivision>();
            
            
            
            prst=cn.prepareStatement("select ExmSbj_ID, ShortCode, TotalMark, Acceptance, PassMark from exam_mark_division where ExmSbj_ID="
                    + "(select ExmSbj_ID FROM exam_subject_config where ExCnfID=? and InstituteId=?"
                    + " and SubjectID=(select SubjectID from subject where SubjectName=?)) and InstituteId=?");
           
            
            prst.setInt(1,exCnfID);
            
            prst.setString(2,instituteID);
            
            prst.setString(3,subjectName);
            
            prst.setString(4,instituteID);
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                exmMark_Div_List.add(new ExamMarkDivision(rs.getInt("ExmSbj_ID"),rs.getInt("ShortCode"),rs.getDouble("TotalMark"),rs.getDouble("Acceptance"),rs.getDouble("PassMark")));
            }
            
            System.out.println("Subject Mark division size:"+exmMark_Div_List.size());
            
            rs.close();
            
            prst.close();
            

            
            prst=cn.prepareStatement("insert into student_result values(null,?,(select SubjectID from subject where SubjectName=?),?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            itr=examRsList.iterator();
            
            while(itr.hasNext())
            {
                StudentExamResult exmResult = itr.next();
                
                if ((exmResult.getShortcode1().equals("A")) || (exmResult.getShortcode1().equals("")))
                {
                    sc1 = "0";
                } 
                else 
                {
                    sc1 = exmResult.getShortcode1();
                }

                if ((exmResult.getShortcode2().equals("A")) || (exmResult.getShortcode2().equals("")))
                {
                    sc2 = "0";
                } 
                else 
                {
                    sc2 = exmResult.getShortcode2();
                }

                if ((exmResult.getShortcode3().equals("A")) || (exmResult.getShortcode3().equals("")))
                {
                    sc3 = "0";
                } 
                else 
                {
                    sc3 = exmResult.getShortcode3();
                }

                if ((exmResult.getShortcode4().equals("A")) || (exmResult.getShortcode4().equals("")))
                {
                    sc4 = "0";
                } 
                else 
                {
                    sc4 = exmResult.getShortcode4();
                }
                
                
                
                for(int i=0;i<exmMark_Div_List.size();i++)
                {
                    sbj_total=sbj_total+(exmMark_Div_List.get(i).getTotalMark()*exmMark_Div_List.get(i).getAcceptance());
                    
                    if((exmMark_Div_List.get(i).getShortCode()==1) && (!exmResult.getShortcode1().equals("")))
                    {
                         if (Double.parseDouble(sc1) < exmMark_Div_List.get(i).getPassMark())//fail in sba
                         {
                             failflag=true;
                         }
                         
                         finalScore = finalScore + (Double.parseDouble(sc1) * exmMark_Div_List.get(i).getAcceptance()); 
                    }
                    if((exmMark_Div_List.get(i).getShortCode()==2) && (!exmResult.getShortcode2().equals("")))
                    {
                        if (Double.parseDouble(sc2) < exmMark_Div_List.get(i).getPassMark())//fail in ob
                        {                           
                            failflag=true;
                        }
                       
                        totalScore = totalScore + Double.parseDouble(sc2);

                        avg = avg + (Double.parseDouble(sc2) * exmMark_Div_List.get(i).getAcceptance());

                        finalScore = finalScore + (Double.parseDouble(sc2) * exmMark_Div_List.get(i).getAcceptance());
                    }
                    if((exmMark_Div_List.get(i).getShortCode()==3) && (!exmResult.getShortcode3().equals("")))
                    {
                        if (Double.parseDouble(sc3) < exmMark_Div_List.get(i).getPassMark()) //fail in sb
                        {
                            failflag=true; 
                        }
                        
                        totalScore = totalScore + Double.parseDouble(sc3);

                        avg = avg + (Double.parseDouble(sc3) * exmMark_Div_List.get(i).getAcceptance());

                        finalScore = finalScore + (Double.parseDouble(sc3) * exmMark_Div_List.get(i).getAcceptance());
                    }
                    if((exmMark_Div_List.get(i).getShortCode()==4) && (!exmResult.getShortcode4().equals("")))
                    {
                        if (Double.parseDouble(sc4) < exmMark_Div_List.get(i).getPassMark()) //fail in pr
                        {
                            failflag=true;
                        }
                        
                        totalScore = totalScore + Double.parseDouble(sc4);

                        avg = avg + (Double.parseDouble(sc4) * exmMark_Div_List.get(i).getAcceptance());

                        finalScore = finalScore + (Double.parseDouble(sc4) * exmMark_Div_List.get(i).getAcceptance());
                    }
                }//End for
                
                for(int i=0;i<exmGrdList.size();i++)
                {
                    if(exmGrdList.get(i).getGradeNumber()<=((finalScore/sbj_total)*100))
                    {
                        letterGrd=exmGrdList.get(i).getLetterGrade();
                        
                        point=exmGrdList.get(i).getPoint();
                        
                        break;
                    }
                }
                
                if(failflag)
                {
                    letterGrd="F";
                    
                    point=0.0;
                    
                    failflag=false;
                }
                
                prst.setString(1,exmResult.getStudentID());
                
                prst.setString(2,subjectName);
                
                prst.setString(3,exmResult.getShortcode1());
                
                prst.setString(4,exmResult.getShortcode2());
                
                prst.setString(5,exmResult.getShortcode3());
                
                prst.setString(6,exmResult.getShortcode4());
                
                prst.setDouble(7,totalScore);
                
                prst.setDouble(8,avg);
                
                prst.setDouble(9,finalScore);
                
                prst.setString(10,letterGrd);
                
                prst.setDouble(11,point);
                
                prst.setInt(12,exCnfID);
                
                prst.setString(13,teacherID);//TeacherID
                
                prst.setString(14,"note");
                
                prst.setDouble(15,sbj_total);
                
                prst.setString(16, instituteID);
                
                prst.addBatch();
                
                
                sbj_total = 0;

                totalScore = 0;

                avg = 0;

                finalScore = 0;

                letterGrd = "";

                point = 0;
                
            }//End main while
            
            int[] i=prst.executeBatch();
            
            System.out.println("Number of student has given exam mark::"+i.length);
            
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(cn!=null)
                {
                    cn.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            
            subjectName=null;
            
            examRsList.clear();
            
            exmGrdList.clear();
        }
        
        return false;
    }

    /**
     *
     * @param exCnfID
     * @param scCnfID
     * @param exmGrdList
     */
    @Override
    public void generateMeritList(int exCnfID, StringBuilder scCnfID,List<ExamGrade> exmGrdList) 
    {
        List<String> studentID = new ArrayList<String>();

        Iterator<String> id_itr;

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        PreparedStatement p = null;

        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        int subjectCount = 0;
        
        double sbj_bngl_FullMark=0;
        
        double sbj_english_FullMark=0;
        
        int tmpSbjCnt = 0;

        int tmpSbj1Cnt = 0;

        int optionalSbjID = 0;

        boolean fail_flag = false;

        double totalSumScore = 0;

        double totalSumGpa = 0;

        double temp_sbj_score = 0;

        double temp_sbj1_score = 0;

        double finalSumGpa = 0;

        double finalSumCGPA = 0;
        
        String finalGrade="";
        
        //System.out.println(scCnfID.toString());
               
/*-------------------------------------------------Get Student List where ScCnfID=Acyr,Class------------------------------------------------------------*/       
        try
        {
            prst=con.prepareStatement("select StudentID FROM student_identification  where ClassConfigID IN("+scCnfID.toString()+")  and InstituteID='"+instituteID+"' ");
            
            //prst.setString(1,scCnfID.toString());
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                studentID.add(rs.getString("StudentID"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        { 
            try
            { 
                if(rs!=null) 
                { 
                    rs.close(); 
                } 
                if(prst!=null) 
                { 
                    prst.close(); 
                } 
            } 
            catch(SQLException e) 
            { 
                System.out.println("I am not ok..Block-1");
                
                System.out.println(e); 
            } 
        }
        
        System.out.println("Total Student Found:"+studentID.size());
        
/*----------------------------------------------------------------------------End Student List-----------------------------------------------------------*/  
        
        
        
        
        
        
        
        
        try
        {
            id_itr=studentID.iterator();
            
            p = con.prepareStatement("insert into student_result_summary (ID,StudentID,ExcnfID,TotalMark,TotalGpa,CGPA,FinalGrade,InstituteID) values(null,?,?,?,?,?,?,?)");
            
            while (id_itr.hasNext())
            {
                String std_id = id_itr.next();//individual studentID
                
/*--------------------------------------------------------4th subject list and status checking-----------------------------------------------------------*/
                try
                {
                    prst = con.prepareStatement("select SubjectID,Status from student_4th_subject_wrap where StudentID=? ");

                    prst.setString(1, std_id);

                    rs = prst.executeQuery();

                    while (rs.next())
                    {
                        if (!rs.getBoolean("Status"))
                        {
                            optionalSbjID = rs.getInt("SubjectID");//get Optional subject
                        }
                    }
                } 
                catch (SQLException exp)
                {
                    System.out.println(exp);
                } 
                finally
                {
                    try
                    {
                        if (rs != null)
                        {
                            rs.close();
                        }
                        if (prst != null)
                        {
                            prst.close();
                        }
                    } 
                    catch (SQLException e)
                    {
                        System.out.println("I am not ok..(Block-2)");

                        System.out.println(e);
                    }
                }

/*----------------------------------------------------4th subject list and status checking End-----------------------------------------------------------*/
                
                
                
                              
                try 
                {
                    prst = con.prepareStatement("select SubjectID,FinalScore,GradePoint,SbjFullMark from student_result where StudentID=? and ExCnfID=? and  InstituteID='"+instituteID+"' ");

                    prst.setString(1,std_id);

                    prst.setInt(2,exCnfID);

                    rs = prst.executeQuery();

                    while(rs.next())
                    {
                        if ((rs.getDouble("GradePoint") == 0) && (rs.getInt("SubjectID") != optionalSbjID))
                        {
                            fail_flag = true;

                            System.out.println("Fail Subject ID:" + rs.getInt("SubjectID"));
                        }

                        
                        /*****************************All Subject Block(Without Bangla & English)  SubjectID=6,7,8,9 are b1,b2,E1,E2*********************************************************/
                        
                        if ((rs.getInt("SubjectID") != 7) && (rs.getInt("SubjectID") != 8) && (rs.getInt("SubjectID") != 9) && (rs.getInt("SubjectID") != 10))
                        {
                            totalSumScore = totalSumScore + rs.getDouble("FinalScore");

                            /* ******************************Regular Subject Block*******************************************/
                
                            if (rs.getInt("SubjectID") != optionalSbjID)
                            {
                                totalSumGpa = totalSumGpa + rs.getDouble("GradePoint");
                            } 
                            
                            /*******************************Regular Subject Block End*******************************************/
                      
                            
                            
                            
                           /* *****************************Optional Subject Block*******************************************/
                             
                            else 
                            {
                                
                                if (rs.getDouble("GradePoint") > 2)
                                {
                                    totalSumGpa = totalSumGpa + (rs.getDouble("GradePoint") - 2);

                                    System.out.println("Optional Subject CGPA:" + ((rs.getDouble("GradePoint") - 2)));

                                    //subjectCount--;//optional subject not counted
                                    
                                    subjectCount--;
                                }
                            }
                         
                            /*****************************Optional Subject Block End********************************************/

                            subjectCount++;//count number of subject to get cgpa=(totalSumGpa)/subjectCount
                        }
                        
                        /****************All Subject Except Bangla-1,2 & English-1,2 End***********************************************/
                        
                        
                        /****************Only Bangla-1,2 & English-1,2****************************************************************/

                        else
                        {
                            if ((rs.getInt("SubjectID") == 7) || (rs.getInt("SubjectID") == 8))
                            {
                                temp_sbj_score = temp_sbj_score + rs.getDouble("FinalScore");

                                tmpSbjCnt = 1;//count 2 subject as 1
                                
                                sbj_bngl_FullMark=sbj_bngl_FullMark+rs.getDouble("SbjFullMark");
                            } 
                            else
                            {
                                temp_sbj1_score = temp_sbj1_score + rs.getDouble("FinalScore");

                                tmpSbj1Cnt = 1;//count 2 subject as 1
                                
                                sbj_english_FullMark=sbj_english_FullMark+rs.getDouble("SbjFullMark");
                            }
                        }

                    }//End while inner
                    
                    
                    if(tmpSbjCnt==1)
                    {
                        for(int i=0;i<exmGrdList.size();i++)
                        {
                            if(exmGrdList.get(i).getGradeNumber()<=((temp_sbj_score/sbj_bngl_FullMark)*100))
                            {
                                totalSumGpa=totalSumGpa+exmGrdList.get(i).getPoint();
                                
                                break;
                            }
                        }
                    }
                    
                    if(tmpSbj1Cnt==1)
                    {
                        for(int i=0;i<exmGrdList.size();i++)
                        {
                            if(exmGrdList.get(i).getGradeNumber()<=((temp_sbj1_score/sbj_english_FullMark)*100))
                            {
                                totalSumGpa=totalSumGpa+exmGrdList.get(i).getPoint();
                                
                                break;
                            }
                        }
                    }
                   
                    
                    System.out.println("-------------------------************************************-----------------------------");

                    System.out.println("Student ID:" + std_id);

                    System.out.println("Bangla:" + temp_sbj_score);

                    System.out.println("English:" + temp_sbj1_score);

                    System.out.println("Number Of Subject:" + (subjectCount + tmpSbjCnt + tmpSbj1Cnt));

                    System.out.println("Final Total Mark:" + (totalSumScore + temp_sbj_score + temp_sbj1_score));

                    if (fail_flag)//if fails in any subject
                    {
                        //System.out.println("Total GPA:" + finalSumGpa);

                        //System.out.println("Total CGPA:" + finalSumCGPA);
                    } 
                    else
                    {
                        //finalSumGpa = (totalSumGpa + getTemp_Sbj_Gpa(temp_sbj_score / 2) + getTemp_Sbj_Gpa(temp_sbj1_score / 2));

                        //finalSumCGPA = (totalSumGpa + getTemp_Sbj_Gpa(temp_sbj_score / 2) + getTemp_Sbj_Gpa(temp_sbj1_score / 2)) / (subjectCount + tmpSbjCnt + tmpSbj1Cnt);

                        finalSumGpa= totalSumGpa;
                        
                        finalSumCGPA=(totalSumGpa/(subjectCount + tmpSbjCnt + tmpSbj1Cnt));
                        
                        System.out.println("Total GPA:" + finalSumGpa);

                        System.out.println("Total CGPA:" + finalSumCGPA);
                        
                    }
                    
                    
                    
                    for (int i = 0; i < exmGrdList.size(); i++) 
                    {
                        if (exmGrdList.get(i).getPoint() <= finalSumCGPA) 
                        {
                            finalGrade = exmGrdList.get(i).getLetterGrade();
                            
                            break;
                        }
                    }

                    

                    p.setString(1, std_id);

                    p.setInt(2,exCnfID);

                    p.setDouble(3, (totalSumScore + temp_sbj_score + temp_sbj1_score));

                    p.setDouble(4,finalSumGpa);

                    p.setDouble(5,finalSumCGPA);

                    p.setString(6,finalGrade);
                    
                    p.setString(7, instituteID);

                    p.addBatch();
                    
                    
                    

                    totalSumScore = 0.0;

                    totalSumGpa = 0.0;

                    temp_sbj_score = 0.0;

                    temp_sbj1_score = 0.0;

                    subjectCount = 0;

                    tmpSbjCnt = 0;

                    tmpSbj1Cnt = 0;

                    finalSumGpa = 0;

                    finalSumCGPA = 0;
                } 
                catch (SQLException ex)
                {
                    System.out.println("I am not ok..(BLOCK-3)");

                    System.out.println(ex);
                }
                finally
                {
                    try 
                    {  
                        if (rs != null)
                        {
                            rs.close();
                        }
                        if (prst != null)
                        {
                            prst.close();
                        }
                    } 
                    catch (SQLException e)
                    {
                        System.out.println(e);
                    }
                }

                optionalSbjID = 0;

                fail_flag = false;

            }//end main while
            
            int[] i=p.executeBatch();
            
            System.out.println("Final Result Student:"+i.length);
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if (p != null)
                {
                    p.close();
                }
                if(con!=null)
                {
                    con.close();
                } 
            } 
            catch (SQLException ex)
            {
                System.out.println(ex);
            }
            
            exmGrdList.clear();
            
            scCnfID.setLength(0);
        }
        
    }//end function
 
    /**
     *
     * @param className
     * @return
     */
    @Override
    public StringBuilder scCnfID(String className)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        StringBuilder scCnfID = new StringBuilder();
        
        try
        {    
            prst = con.prepareStatement("SELECT ScConfigID FROM classconfig where ClassID=(Select ClassID From class where ClassName=?)  and InstituteID='"+instituteID+"'");
       
            prst.setString(1,className);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                scCnfID.append(rs.getString("ScConfigID"));
                
                scCnfID.append(",");
            }
            
            if(scCnfID.length()>0)
            {
                scCnfID.setLength(scCnfID.length()-1);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
            
            System.out.println("I  am not ok here....");
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
            
            className=null;
        }
        
        return scCnfID;
    }

    /**
     *
     * @param exCnfID
     * @return
     */
    @Override
    public List<StudentMeritList> StudentMeritList(int exCnfID)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<StudentMeritList> stdMeritlist=new ArrayList<StudentMeritList>();
        
        try
        {
  
            prst = con.prepareStatement("Select sb.StudentID,sb.StudentName,srs.TotalMark, srs.TotalGpa, srs.CGPA, srs.FinalGrade"
                    + " from student_result_summary srs,student_basic_info sb where srs.StudentID=sb.StudentID and srs.InstituteID=sb.InstituteID and srs.InstituteID='"+instituteID+"' "
                    + " and srs.ExcnfID=?");
            
            prst.setInt(1, exCnfID);
            
            System.out.println("exCnfID :"+exCnfID);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                stdMeritlist.add(new StudentMeritList(rs.getString("sb.StudentID"),rs.getString("sb.StudentName"),rs.getDouble("srs.TotalMark"),rs.getDouble("srs.TotalGpa"),rs.getDouble("srs.CGPA"),rs.getString("srs.FinalGrade")));              
            }
              
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        }

        return stdMeritlist;
    }

    /**
     *
     * @return
     */
    @Override
    public List<ExamGrade> examGradeList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<ExamGrade> exmGrdList=new ArrayList<ExamGrade>();
        
        try
        {
            prst=con.prepareStatement("SELECT LetterGrade, GradeNumber, Point FROM examgrade  where InstituteID='"+instituteID+"'");
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                exmGrdList.add(new ExamGrade(rs.getString("LetterGrade"),rs.getDouble("GradeNumber"),rs.getDouble("Point")));
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        }
        
        return exmGrdList;
    }

    @Override
    public int editStudentResult(int exCnfID,String subjectName,ViewStudentResult stdExmRs,List<ExamGrade> exmGrdList)
    {
        String sc1;
        
        String sc2;
        
        String sc3;
        
        String sc4;
        
        DB_Connection db; 
       
        Connection cn = null;
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        double totalScore = 0;
        
        double avg = 0;
        
        double finalScore = 0;
        
        String letterGrd = "";
        
        double point = 0;
        
        boolean failflag=false;
        
        int rowEffect=0;
        
        List<ExamMarkDivision> exmMark_Div_List = new ArrayList<ExamMarkDivision>();
        
        try
        {
            db=new DB_Connection();
            
            cn=db.getConnection();
            
            prst=cn.prepareStatement("select ExmSbj_ID, ShortCode, TotalMark, Acceptance, PassMark from exam_mark_division where ExmSbj_ID="
                    + "(select ExmSbj_ID FROM exam_subject_config where ExCnfID=? and  InstituteID='"+instituteID+"' "
                    + " and SubjectID=(select SubjectID from subject where SubjectName=?)) and  InstituteID='"+instituteID+"' ");
           
            
            prst.setInt(1,exCnfID);
            
            prst.setString(2,subjectName);
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                exmMark_Div_List.add(new ExamMarkDivision(rs.getInt("ExmSbj_ID"),rs.getInt("ShortCode"),rs.getDouble("TotalMark"),rs.getDouble("Acceptance"),rs.getDouble("PassMark")));
            }
            
            rs.close();
            
            prst.close();
            
            
            
            if ((stdExmRs.getShortCode1().equals("A")) || (stdExmRs.getShortCode1().equals(""))) 
            {
                sc1 = "0";
            } 
            else 
            {
                sc1 = stdExmRs.getShortCode1();
            }

            if ((stdExmRs.getShortCode2().equals("A")) || (stdExmRs.getShortCode2().equals("")))
            {
                sc2 = "0";
            } 
            else 
            {
                sc2 = stdExmRs.getShortCode2();
            }

            if ((stdExmRs.getShortCode3().equals("A")) || (stdExmRs.getShortCode3().equals(""))) 
            {
                sc3 = "0";
            } 
            else 
            {
                sc3 = stdExmRs.getShortCode3();
            }

            if ((stdExmRs.getShortCode4().equals("A")) || (stdExmRs.getShortCode4().equals("")))
            {
                sc4 = "0";
            } 
            else 
            {
                sc4 = stdExmRs.getShortCode4();
            }
            
            
            
            for (int i = 0; i < exmMark_Div_List.size(); i++)
            {
                if ((exmMark_Div_List.get(i).getShortCode() == 1) && (!stdExmRs.getShortCode1().equals(""))) 
                {
                    if (Double.parseDouble(sc1) < exmMark_Div_List.get(i).getPassMark())//fail in sba
                    {
                        failflag = true;
                    }

                    finalScore = finalScore + (Double.parseDouble(sc1) * exmMark_Div_List.get(i).getAcceptance());
                }
                if ((exmMark_Div_List.get(i).getShortCode() == 2) && (!stdExmRs.getShortCode2().equals("")))
                {
                    if (Double.parseDouble(sc2) < exmMark_Div_List.get(i).getPassMark())//fail in ob
                    {
                        failflag = true;
                    }

                    totalScore = totalScore + Double.parseDouble(sc2);

                    avg = avg + (Double.parseDouble(sc2) * exmMark_Div_List.get(i).getAcceptance());

                    finalScore = finalScore + (Double.parseDouble(sc2) * exmMark_Div_List.get(i).getAcceptance());
                }
                if ((exmMark_Div_List.get(i).getShortCode() == 3) && (!stdExmRs.getShortCode3().equals("")))
                {
                    if (Double.parseDouble(sc3) < exmMark_Div_List.get(i).getPassMark()) //fail in sb
                    {
                        failflag = true;
                    }

                    totalScore = totalScore + Double.parseDouble(sc3);

                    avg = avg + (Double.parseDouble(sc3) * exmMark_Div_List.get(i).getAcceptance());

                    finalScore = finalScore + (Double.parseDouble(sc3) * exmMark_Div_List.get(i).getAcceptance());
                }
                if ((exmMark_Div_List.get(i).getShortCode() == 4) && (!stdExmRs.getShortCode4().equals("")))
                {
                    if (Double.parseDouble(sc4) < exmMark_Div_List.get(i).getPassMark()) //fail in pr
                    {
                        failflag = true;
                    }

                    totalScore = totalScore + Double.parseDouble(sc4);

                    avg = avg + (Double.parseDouble(sc4) * exmMark_Div_List.get(i).getAcceptance());

                    finalScore = finalScore + (Double.parseDouble(sc4) * exmMark_Div_List.get(i).getAcceptance());
                }
            }//End for
                
                
            for (int i = 0; i < exmGrdList.size(); i++)
            {
                if (exmGrdList.get(i).getGradeNumber() <= ((finalScore / stdExmRs.getSbjFullMark()) * 100))
                {
                    letterGrd = exmGrdList.get(i).getLetterGrade();

                    point = exmGrdList.get(i).getPoint();

                    break;
                }
            }

            if (failflag) 
            {
                letterGrd = "F";

                point = 0.0;
            }
            
            prst=cn.prepareStatement("update student_result set ShortCode1=?,ShortCode2=?,ShortCode3=?,ShortCode4=?,TotalScore=?,Average=?,"
                    + "FinalScore=?,LetterGrade=?,GradePoint=? where ResultID=?");
            
            
            prst.setString(1, stdExmRs.getShortCode1());

            prst.setString(2, stdExmRs.getShortCode2());

            prst.setString(3, stdExmRs.getShortCode3());

            prst.setString(4, stdExmRs.getShortCode4());

            prst.setDouble(5, totalScore);

            prst.setDouble(6, avg);

            prst.setDouble(7, finalScore);

            prst.setString(8, letterGrd);

            prst.setDouble(9, point);

            prst.setInt(10,stdExmRs.getResultID());

            rowEffect=prst.executeUpdate();  
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
            
            System.out.println("Student result update problem...");
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(cn!=null)
                {
                    cn.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
            
            subjectName=null;
            
            stdExmRs=null;
            
            //exmGrdList.clear();
            
            //exmMark_Div_List.clear();
        }
        
        return rowEffect;
    }

    @Override
    public List<ViewStudentResult> studentExamResult(int exCnfID,int scCnfID,String subjectName)
    {
        List<ViewStudentResult> studentResultList=new ArrayList<ViewStudentResult>();
        
        DB_Connection db; 
       
        Connection cn = null;
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        String qr="";
        
        int sbj_st = 0;
        
        try
        {
            db=new DB_Connection();
            
            cn=db.getConnection();
            
            
            
            prst=cn.prepareStatement("select status from subject where SubjectName=?");
            
            prst.setString(1,subjectName);
            
            rs=prst.executeQuery();
            
            if(rs.next())
            {
                sbj_st=rs.getInt(1);
            }
            rs.close();
            
            prst.close();
            
            
            
            if(sbj_st==0)
            {
                qr="SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.TotalScore, sr.Average, sr.FinalScore, sr.LetterGrade, sr.GradePoint, t.TeacherName, sr.Note, sr.SbjFullMark"
                    + " FROM student_result sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID "
                        + "and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='"+instituteID+"' and sr.ExCnfID=?"
                    + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID IN("+getScCnf_id_List(scCnfID)+") order by sb.StudentRoll";
            }
            else if(sbj_st==1)//for departmental elective subject..
            {
                qr="SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.TotalScore, sr.Average, sr.FinalScore, sr.LetterGrade, sr.GradePoint, t.TeacherName, sr.Note, sr.SbjFullMark"
                        + " FROM student_result sr,teacher t,student_basic_info sb,student_identification si,student_4th_subject_wrap sw where "
                        + "sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.StudentID=sw.StudentID and sr.SubjectID=sw.SubjectID and sr.teacherID=t.teacherID "
                        + " and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='"+instituteID+"' and sr.ExCnfID=?"
                        + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll";
            }
            else if(sbj_st==2)//for departmental subject
            {
                qr="SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.TotalScore, sr.Average, sr.FinalScore, sr.LetterGrade, sr.GradePoint, t.TeacherName, sr.Note, sr.SbjFullMark"
                    + " FROM student_result sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID "
                        + " and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='"+instituteID+"' and sr.ExCnfID=?"
                    + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll";
            }
            else if(sbj_st==3)
            {
                 qr="SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.TotalScore, sr.Average, sr.FinalScore, sr.LetterGrade, sr.GradePoint, t.TeacherName, sr.Note, sr.SbjFullMark"
                        + " FROM student_result sr,teacher t,student_basic_info sb,student_identification si,student_4th_subject_wrap sw where "
                        + "sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.StudentID=sw.StudentID and sr.SubjectID=sw.SubjectID and sr.teacherID=t.teacherID "
                         + " and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='"+instituteID+"' and sr.ExCnfID=?"
                        + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID IN("+getScCnf_id_List(scCnfID)+") order by sb.StudentRoll";
            }
            prst=cn.prepareStatement(qr);
            
            prst.setInt(1,exCnfID);
            
            prst.setString(2,subjectName);
            
            if((sbj_st==1)|| (sbj_st==2))
            {
                prst.setInt(3,scCnfID);
            }
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                studentResultList.add(new ViewStudentResult(rs.getInt("sr.ResultID"),rs.getString("sr.StudentID"),rs.getString("sb.StudentName"),rs.getInt("sb.StudentRoll"),rs.getString("sr.ShortCode1"), rs.getString("sr.ShortCode2"), rs.getString("sr.ShortCode3"), rs.getString("sr.ShortCode4"), rs.getDouble("sr.TotalScore"), rs.getDouble("sr.Average"), rs.getDouble("sr.FinalScore"), rs.getString("sr.LetterGrade"), rs.getDouble("sr.GradePoint"), rs.getString("t.TeacherName"), rs.getString("sr.Note"),rs.getDouble("sr.SbjFullMark")));
            }
            
            System.out.println("Total Student:"+studentResultList.size());
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(cn!=null)
                {
                    cn.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
            
            subjectName=null;
        }
        
        return studentResultList;
    }
}
