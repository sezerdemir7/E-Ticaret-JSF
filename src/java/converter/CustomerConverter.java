/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CustomerDAO;
import entity.Customer;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Demirr
 */
@Named
@RequestScoped
@FacesConverter(  value = "customerConverter", managed = true)
public class CustomerConverter implements Converter, Serializable {

    @EJB
    private CustomerDAO CustomerDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (!string.isBlank()) {
            Long id = Long.valueOf(string);
            return CustomerDAO.getEntityById(id);
        } else {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t != null) {
            Customer C = (Customer) t;
            return C.getId().toString();
        } else {
            return "";
        }
    }

}
