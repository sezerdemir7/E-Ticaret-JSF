/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SellerDAO;
import entity.Seller;
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
@FacesConverter(value = "sellerConverter", managed = true)
public class SellerConverter implements Converter, Serializable{
    
    @EJB
    private SellerDAO sellerDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

         if(!string.isBlank()){
            Long id = Long.valueOf(string);
            return sellerDAO.getEntityById(id);
        }
        else{
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t != null){
            Seller C =(Seller) t;
            return C.getId().toString();
        }else{
            return "";
        }
    }

}
