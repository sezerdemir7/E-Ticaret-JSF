/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AdminDAO;
import entity.Admin;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class AdminBean extends BaseBean<Admin, AdminDAO> {

    public AdminBean() {
        super(Admin.class, AdminDAO.class);
    }

    public String login() {
        Admin adminTest = this.getDao().login(this.getEntity());

        if (adminTest != null && adminTest.getPassword().equals(this.getEntity().getPassword())) {
            this.setEntity(adminTest);
            return "/panel/admin/admin-home.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre Yanlış", "Şifre yanlış."));
            return null; // Başarısız giriş durumunda null döndürüyor
        }
    }

}
