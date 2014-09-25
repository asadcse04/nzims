/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SmsStatus;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SHOHUG.SQ
 */

@ManagedBean
@ViewScoped

public class SmsStatusController implements Serializable{
   
   
    private SmsStutas statusList;
    
    SmsStatusService dao = new SmsStatusServiceImpl();

    public SmsStatusController() {
        this.statusList = dao.statusList();
    }

    
    public SmsStutas getStatusList() {
        if(this.statusList==null){
            this.statusList=new SmsStutas();
        }
        return statusList;
    }

    public void setStatusList(SmsStutas statusList) {
        this.statusList = statusList;
    }

   
    
}
