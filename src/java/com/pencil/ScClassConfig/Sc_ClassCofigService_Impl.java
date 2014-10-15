/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig;

import com.pencil.Connection.DB_Connection;
import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.Period.Period;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
public class Sc_ClassCofigService_Impl implements Serializable,Sc_ClassConfigService 
{

    /*-----------------------------------------------------------Comments Start from here--------------------------------------------------------------------*/

    /**
     *
     * @param cnf
     * @return
     */
    
    @Override
    public boolean saveScClassConfig(ScClassConfig cnf)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        ResultSet rs=null;
        
        int classconfid=0;
        
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            prst=con.prepareStatement("select max(ScConfigID) from classconfig where InstituteID=?");
            prst.setString(1, instituteid);
            rs=prst.executeQuery();
            
            if(rs.next()){
               classconfid=rs.getInt(1)+1;
            }
            else{
            classconfid=1;
            }
            
            prst = con.prepareStatement("insert into classconfig values(?,?,(select departmentID from department where departmentName=?),"
                    + "(SELECT ClassID FROM class where ClassName=?),?,(SELECT ShiftID FROM shift where ShiftName=?),?,(SELECT SectionID FROM section where SectionName=? and InstituteID=?),?,?,?,?)");
        
            
            prst.setInt(1, classconfid);
            
            prst.setInt(2,cnf.getAcyrID());
            
            prst.setString(3,cnf.getDeptName());
            
            prst.setString(4,cnf.getClassName());
            
            prst.setString(5,cnf.getClassName());
            
            prst.setString(6,cnf.getShiftName());
            
            prst.setString(7,cnf.getShiftName());
            
            prst.setString(8,cnf.getSectionName());
            
            prst.setString(9,instituteid);
            
            prst.setString(10,cnf.getSectionName());

            prst.setString(11,cnf.getRoomNum());
            
            prst.setString(12, instituteid);
            
            prst.setString(13, classconfid+"-"+instituteid);
            
            prst.execute();
             
            return true; 
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
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
            
            cnf=null;
        }
        
        return false;
    }
    
    
    public boolean updateScClassConfig(ScClassConfig cnf)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;

        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
      
            prst = con.prepareStatement("update classconfig set AcYrID=?,DeptID=(select departmentID from department where departmentName=?),"
                    + "ClassID=(select ClassID from class where ClassName=?),ShiftID=(select ShiftID from shift where ShiftName=?),"
                    + "SectionID=(SELECT SectionID FROM section where SectionName=? and InstituteID=?),"
                    + "RoomNo=? where ScConfigID=? and InstituteID=?");

            
            prst.setInt(1,cnf.getAcyrID());
            
            prst.setString(2,cnf.getDeptName());
            
            prst.setString(3,cnf.getClassName());
            
            prst.setString(4,cnf.getShiftName());
            
            prst.setString(5,cnf.getSectionName());
            
            prst.setString(6,instituteid);
            
            prst.setString(7,cnf.getRoomNum());
            
            prst.setInt(8, cnf.getScConfigID());
            
            prst.setString(9, instituteid);
            
            prst.execute();
             
            return true; 
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
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
            
            cnf=null;
        }
        
        return false;
    }
    
    /*-----------------------------------------------------------Comments End--------------------------------------------------------------------*/
    
    
    
    
    /*-----------------------------------------------------------Comments Start from here--------------------------------------------------------------------*/

    /**
     *
     * @param acyrID
     * @return
     */
    
     @Override
    public List<String> listScClass(int acyrID)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<String> listClass=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct c.className from class c,classconfig cf where cf.classID=c.classID and cf.AcYrID=? and cf.instituteid=?");
            
             prst.setInt(1,acyrID);
            
            prst.setString(2, instituteid);
           
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                listClass.add(rs.getString("c.className"));
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
        
        return listClass;
    }
    

    @Override
    public List<String> listScClassGlobal()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<String> listClass=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct className from class");
            
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                listClass.add(rs.getString(1));
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
        
        return listClass;
    }
    
    /*-----------------------------------------------------------Comments End here--------------------------------------------------------------------*/
    
    
    
    
    /*-----------------------------------------------------------Comments Start from here--------------------------------------------------------------------*/

    /**
     *
     * @param acyrID
     * @param className
     * @return
     */
    

    @Override
    public List<String> listScDept(int acyrID,String className)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<String> listdept=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct d.departmentName from department d,classconfig sf where sf.DeptID=d.DepartmentID and sf.AcYrID=?"
                    + " and sf.classID=(select ClassID from class where ClassName=?)  and sf.instituteid=?");
            
            prst.setInt(1,acyrID);
            
            prst.setString(2,className);
            
            prst.setString(3, instituteid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                listdept.add(rs.getString("d.departmentName"));
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
            
            className=null;
        } 
        
        return listdept;
    }
    
    @Override
    public List<String> listScDeptGlobal()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> listdept=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct departmentName from department");

            rs = prst.executeQuery();
            
            while(rs.next())
            {
                listdept.add(rs.getString(1));
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
        
        return listdept;
    }
    
     
    /*-----------------------------------------------------------Comments Start from here--------------------------------------------------------------------*/

    /**
     *
     * @return
     */
    

    @Override
    public List<ScClassConfig> listScClassConfig()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<ScClassConfig> listClassCnf=new ArrayList<ScClassConfig>();
        
        try
        {
            prst = con.prepareStatement("SELECT scCnf.ScConfigID,scCnf.AcYrID,c.ClassName,d.DepartmentName,s.ShiftName,sctn.SectionName,scCnf.RoomNo"
                    + " FROM classconfig scCnf,department d,class c,shift s,section sctn where scCnf.DeptID=d.DepartmentID and scCnf.ClassID=c.ClassID"
                    + " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.InstituteID=sctn.InstituteID and scCnf.InstituteID=?");
            
            prst.setString(1, instituteid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                listClassCnf.add(new ScClassConfig(rs.getInt("scCnf.ScConfigID"),rs.getInt("scCnf.AcYrID"),rs.getString("c.ClassName"),rs.getString("d.DepartmentName"),rs.getString("s.ShiftName"),rs.getString("sctn.SectionName"),rs.getString("scCnf.RoomNo")));
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
        
        return listClassCnf;
    }
    
    /*-----------------------------------------------------------Comments End Here--------------------------------------------------------------------*/

    
    
    
    /*-----------------------------------------------------------Comments Start from here--------------------------------------------------------------*/

    /**
     *
     * @param shiftName
     * @return
     */
    
    @Override
    public List<Period> viewPeriodList(String shiftName)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<Period> prdList=new ArrayList<Period>();
        
        try
        {
            prst = con.prepareStatement("SELECT PeriodName, StartTime, EndTime FROM period where ShiftID=(select ShiftID from shift where ShiftName=?)");
            
            prst.setString(1,shiftName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                prdList.add(new Period(rs.getString("PeriodName"),rs.getString("StartTime"),rs.getString("EndTime")));
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
             
            shiftName=null;
        } 
        
        return prdList;
    }
    /*-----------------------------------------------------------Comments End here--------------------------------------------------------------------*/
    
    

    
    
    /*-----------------------------------------------------------Comments Start from here--------------------------------------------------------------------*/

    /**
     *
     * @param sclassCnfID
     * @return
     */
    
    @Override
    public List<String> viewSubjectList(int sclassCnfID)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<String> sbjList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct sbj.SubjectName subject FROM subjectconfig s,classconfig c,subject sbj where s.SubjectID=sbj.SubjectID and c.instituteid=s.InstituteID and"
                    + " s.DeptID=(select Deptid from classconfig where scConfigID=?) and s.ClassID=(select ClassID from classconfig where scConfigID=?) and c.InstituteID=?");
            
            prst.setInt(1,sclassCnfID);
            
            prst.setInt(2,sclassCnfID);
            
            prst.setString(3, instituteid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                sbjList.add(rs.getString("subject"));
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
        
        return sbjList;
    }
    
    /*-----------------------------------------------------------Comments End here--------------------------------------------------------------------*/

    
    
    
    
    /*-----------------------------------------------------------Comments Start from here-------------------------------------------------------------*/

    /**
     *
     * @param acyrID
     * @param deptName
     * @param className
     * @return
     */
    
    @Override
    public List<String> listScShift(int acyrID, String deptName, String className)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> list_shift=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct s.ShiftName FROM classconfig c,academic_year a,department d,class cl,shift s"
                    + " where c.ShiftID=s.ShiftID and c.AcYrID=? and c.DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and c.ClassID=(select ClassID from class where ClassName=?)");
            
            prst.setInt(1,acyrID);
            
            prst.setString(2,deptName);
            
            prst.setString(3,className);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                list_shift.add(rs.getString("s.ShiftName"));
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
            deptName=null;
                
            className=null;
        } 
        
        return list_shift;
    }
    
    /*-----------------------------------------------------------Comments End here--------------------------------------------------------------------*/

    
    
    
    /*-----------------------------------------------------------Comments Start from here-------------------------------------------------------------*/

    /**
     *
     * @param acyrID
     * @param deptName
     * @param className
     * @param shift
     * @return
     */
    
    @Override
    public List<String> listScSection(int acyrID, String deptName, String className, String shift)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<String> list_section=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("select distinct s.SectionName from classconfig c,academic_year a,department d,class cl,shift sf,section s"
                    + " where c.SectionID=s.SectionID and c.InstituteID=s.InstituteID and c.InstituteID=? and c.AcYrID=? and c.DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and c.ClassID=(select ClassID from class where ClassName=?) and c.ShiftID=(select ShiftID from shift where ShiftName=?)");
            
            
            prst.setString(1, instituteid);
           
            prst.setInt(2,acyrID);
            
            prst.setString(3,deptName);
            
            prst.setString(4,className);
            
            prst.setString(5,shift);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                list_section.add(rs.getString("s.SectionName"));
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
            
            deptName=null; 
                
            className=null;
                
            shift=null;
        }  
        
        return list_section;
    }
    
    /*-----------------------------------------------------------Comments End here--------------------------------------------------------------------*/

    
    
    
    
    
    /*-----------------------------------------------------------Comments Start from here--------------------------------------------------------------------*/

    /**
     *
     * @return
     */
    
    @Override
    public List<ScClassConfig> scClassConfiguration_List_ed()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<ScClassConfig> scCnfList=new ArrayList<ScClassConfig>();
        
        try
        {
            prst = con.prepareStatement("SELECT scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,scCnf.ClassConfigID,scCnf.ScConfigID\n" +
"FROM classconfig scCnf,class c,shift s,section sctn where scCnf.ClassID=c.ClassID and scCnf.InstituteID=sctn.InstituteID\n" +
"and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.InstituteID=? group by scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName order by scCnf.ScConfigID");
            
            prst.setString(1, instituteid);
            rs = prst.executeQuery();
             
            while(rs.next())
            {
                scCnfList.add(new ScClassConfig(rs.getInt("scCnf.AcYrID"),rs.getString("c.ClassName"),rs.getString("s.ShiftName"),rs.getString("sctn.SectionName"),rs.getString("scCnf.ClassConfigID"),rs.getInt("scCnf.ScConfigID")));
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

        return scCnfList;
    }

    /**
     *
     * @param scCnf
     * @return
     */
    @Override
    public StringBuilder scClassConfig_ID_List(ScClassConfig scCnf) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteid="";
         
        FacesContext context=FacesContext.getCurrentInstance();
        
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        StringBuilder scCnfID = new StringBuilder();
        
        try
        {    
            prst = con.prepareStatement("SELECT scCnf.ScConfigID FROM classconfig scCnf,class c,shift s,section sctn where scCnf.AcYrID=? and scCnf.ClassID=c.ClassID"
                    + " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.ClassID=(SELECT ClassID FROM class where ClassName=?)"
                    + " and scCnf.ShiftID=(SELECT ShiftID FROM shift where ShiftName=?) and scCnf.SectionID=(SELECT SectionID FROM section where SectionName=? and instituteid=?)");
       
            prst.setInt(1,scCnf.getAcyrID());
            
            prst.setString(2,scCnf.getClassName());
            
            prst.setString(3,scCnf.getShiftName());
            
            prst.setString(4,scCnf.getSectionName());
            
             prst.setString(5,instituteid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                scCnfID.append(rs.getString("scCnf.ScConfigID"));
                
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
            
            scCnf=null;
        }
        
        return scCnfID;
    }

    /**
     *
     * @param scCnfID
     * @return
     */
    @Override
    public List<Student_Registration> studentList(StringBuilder scCnfID)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        List<Student_Registration> stdList=new ArrayList<Student_Registration>();
       
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        try
        {    
          
            prst = con.prepareStatement("SELECT si.StudentID,s.StudentName,s.StudentRoll FROM student_identification si,student_basic_info s where"
                    + " si.StudentID=s.StudentID and si.instituteid=s.instituteid and s.instituteid=? and si.ClassConfigID IN("+scCnfID.toString()+") order by s.StudentRoll");
            
            prst.setString(1, instituteid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                stdList.add(new Student_Registration(rs.getString("si.StudentID"),rs.getString("s.StudentName"),rs.getInt("s.StudentRoll")));
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
            
            scCnfID.setLength(0);
        }
        
        return stdList;
    }

    /**
     *
     * @param acyr
     * @param deptName
     * @param className
     * @param shiftName
     * @param sectionName
     * @return
     */
    @Override
    public int getScCnfID(int acyr, String deptName, String className, String shiftName, String sectionName)
    {      
        int scCnfID = 0;

        DB_Connection o;

        Connection con = null;
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
         String instituteid="";
         
        FacesContext context=FacesContext.getCurrentInstance();
        
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            o=new DB_Connection();
            
            con=o.getConnection();
            
            prst=con.prepareStatement("select ScConfigID from classconfig where AcYrID=? and DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and ClassID=(select ClassID from class where ClassName=?)"
                    + " and shiftID=(select ShiftID from shift where ShiftName=?)"
                    + " and SectionID=(select SectionID from section where SectionName=? and instituteid=?)");
            
            prst.setInt(1,acyr);
            
            prst.setString(2,deptName);
            
            prst.setString(3,className);
            
            prst.setString(4,shiftName);
            
            prst.setString(5,sectionName);
            
            prst.setString(6,instituteid);
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                scCnfID=rs.getInt(1);
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
            
            deptName=null;
            
            className=null;
            
            shiftName=null;
            
            sectionName=null;          
        }
        return scCnfID;
    }
   
    
    @Override
    @SuppressWarnings("UnusedAssignment")
    public ScClassConfig scClassConfig(String studentid)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        ScClassConfig scClassConfig;
       
        try
        {    
          
            prst = con.prepareStatement("SELECT cg.scconfigid, cg.acyrid, c.classname, d.departmentname, s.shiftname, sc.sectionname, cg.roomno "
                    + " FROM classconfig cg, class c, department d, shift s, section sc   "
                    + " where cg.classid=c.classid and cg.shiftid=s.shiftid and cg.deptid=d.departmentid and cg.sectionid=sc.sectionid  "
                    + " and scconfigid=(select classconfigid from student_identification where studentid=?) ");
            prst.setString(1,studentid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                scClassConfig = new ScClassConfig(rs.getInt("cg.scconfigid"), rs.getInt("cg.acyrid"), rs.getString("c.classname"), rs.getString("d.departmentname"), rs.getString("s.shiftname"), rs.getString("sc.sectionname"),rs.getString("cg.roomno") );
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
            
            scClassConfig=null;
        }
        
        return scClassConfig;
    }
    
}
