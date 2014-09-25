/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Teacher;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mahfuj
 */
@FacesConverter(forClass=Teacher.class,value="tchr")
public class TeacherConverter implements Converter,Serializable 
{
    private List<Teacher> teacherList;
    
    TeacherService serviceDao=new TeacherServiceImpl();

    /**
     *
     */
    public TeacherConverter()
    {
        this.teacherList=serviceDao.teacherList();
    }
    
    /**
     *
     * @param context
     * @param component
     * @param submittedValue
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue)
    {
        if((submittedValue.trim().equals("")) )
        {
            return null;
        }
        else
        {
            try
            {
                int id = Integer.parseInt(submittedValue); 
                
                for(Teacher t:teacherList)
                {
                    if(t.getTeacherID()==id)
                    {
                        //System.out.println(t.getTeacherID());
                        
                        return t;
                    }
                }
            }
            catch(NumberFormatException exception)
            {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid teacher"));
            }
        }
        return null;
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if(value == null || value.equals(""))
        {
            return null;
        }
        else
        {  
            return String.valueOf(((Teacher)value).getTeacherID());
        }
    }
    
    /**
     * @return the teacherList
     */
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    /**
     * @param teacherList the teacherList to set
     */
    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
    
}
