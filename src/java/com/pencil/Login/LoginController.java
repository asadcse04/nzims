/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login;

import com.pencil.InstituteSetup.InstituteSetup;
import com.pencil.InstituteSetup.InstituteSetupService;
import com.pencil.InstituteSetup.InstituteSetupServiceImpl;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped

/**
 *
 * @author salim
 */
public class LoginController implements Serializable {

    String username, password;

    String user;

    String roleName;

    String instituteId, instituteName, imageBackground, usrName;

    InstituteSetup institute = new InstituteSetup();

    InstituteSetupService instituteService = new InstituteSetupServiceImpl();

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public InstituteSetup getInstitute() {
        return institute;
    }

    public void setInstitute(InstituteSetup institute) {
        this.institute = institute;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String requestedURI;

    @PostConstruct
    public void init() {
        requestedURI = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);

        if (requestedURI == null) {
            requestedURI = "ErrorPage.xhtml";
        }

    }

    public void login() {

        String[] temp;
        temp = username.split("-");
        usrName = temp[0];
        instituteId = temp[1];

        FacesContext context = FacesContext.getCurrentInstance();

        context.getExternalContext().getSessionMap().put("InstituteId", instituteId);
        
        context.getExternalContext().getSessionMap().put("SchoolID", instituteId);
        
        context.getExternalContext().getSessionMap().put("UserID", username);

        institute = instituteService.getInstituteById(instituteId);

       if(institute.getInstituteFullName()!="")
        context.getExternalContext().getSessionMap().put("SchoolFullName", institute.getInstituteFullName());

       if(institute.getBackgroundImgPath()!="")
        context.getExternalContext().getSessionMap().put("SchoolImage", institute.getBackgroundImgPath());
       
       if(institute.getImgPath()!="")
        context.getExternalContext().getSessionMap().put("SchoolLogo", institute.getImgPath());
       
          if(institute.getAddress()!="")
        context.getExternalContext().getSessionMap().put("SchoolAddress", institute.getAddress());
          
         if(institute.getAcdemicyear()!="")
         context.getExternalContext().getSessionMap().put("AcademicYear", institute.getAcdemicyear());
         
        
           
         

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        HttpSession session = request.getSession();

       // System.out.println("School Name " + context.getExternalContext().getSessionMap().get("SchoolName").toString());

        try {
            request.login(this.username, this.password);
            this.user = request.getUserPrincipal().getName();
            HttpSession s = request.getSession();
            s.setAttribute("userName", this.user);

        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Login failed."));

        }

        try {

            if (this.roleName.equals("admin")) {

                requestedURI = "admin/index.xhtml";

            } else if (this.roleName.equals("teacher")) {

                requestedURI = "teacher/index.xhtml";

            } else {
                requestedURI = "ErrorPage.xhtml";
            }

            context.getExternalContext().redirect(requestedURI);

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();

            return "/Login?faces-redirect=true";

        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
        return "/Login?faces-redirect=true";
    }

}
