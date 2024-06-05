/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ProductDAO;
import entity.Product;
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
@FacesConverter("productConverter")
public class ProductConverter  implements Converter,Serializable{
    
    @EJB
    private ProductDAO productDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        if(!string.isBlank()){
            Long id = Long.valueOf(string);
            return productDAO.getEntityById(id);
        }
        else{
            return null;
        }
    
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t != null){
            Product C =(Product) t;
            return C.getId().toString();
        }else{
            return "";
        }
    }

    
    
}
