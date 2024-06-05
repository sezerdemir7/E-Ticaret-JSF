/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.StoreDAO;
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
@FacesConverter(value="storeConverter",managed = true)
public class StoreConverter implements Converter,Serializable{
    
    @EJB
    private StoreDAO storeDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

       if(!string.isBlank()){
            Long id = Long.valueOf(string);
            return storeDAO.getEntityById(id);
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
