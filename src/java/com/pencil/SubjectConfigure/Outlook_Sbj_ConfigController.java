/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SubjectConfigure;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class Outlook_Sbj_ConfigController implements Serializable
{
    private SubjectConfig sbjCnf;
    
    private List<SubjectConfig> sbjCnfList;
    
    private List<String> bookList;
    
    SubjectConfigService serviceDao=new SubjectConfigService_Impl();

    /**
     * Creates a new instance of OutlookConfigController
     */
    public Outlook_Sbj_ConfigController() 
    {
        this.sbjCnfList=serviceDao.sbjconfigurationList();
    }
    
    /**
     *
     * @param sbjcnf
     */
    public void subject_bookList(SubjectConfig sbjcnf)
    { 
        this.setBookList(serviceDao.bookList(sbjcnf)); 
    }

    /**
     * @return the sbjCnf
     */
    public SubjectConfig getSbjCnf()
    {
        if(this.sbjCnf==null)
        {
            this.sbjCnf=new SubjectConfig();
        }
        return this.sbjCnf;
    }

    /**
     * @param sbjCnf the sbjCnf to set
     */
    public void setSbjCnf(SubjectConfig sbjCnf) {
        this.sbjCnf = sbjCnf;
    }

    /**
     * @return the sbjCnfList
     */
    public List<SubjectConfig> getSbjCnfList() {
        return sbjCnfList;
    }

    /**
     * @param sbjCnfList the sbjCnfList to set
     */
    public void setSbjCnfList(List<SubjectConfig> sbjCnfList) {
        this.sbjCnfList = sbjCnfList;
    }

    /**
     * @return the bookList
     */
    public List<String> getBookList() {
        return bookList;
    }

    /**
     * @param bookList the bookList to set
     */
    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }
}
