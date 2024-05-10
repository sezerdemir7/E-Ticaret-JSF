/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SellerDAO;
import entity.Seller;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Demirr
 */
@FacesConverter("storeConverter")
public class SellerConverter implements Converter{
    
    private SellerDAO SellerDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Long id = Long.valueOf(string);
        Seller store = this.getSellerDAO().getEntityById(id);
        return store;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Seller store = (Seller) t;
        return String.valueOf(store.getId());
    }

    public SellerDAO getSellerDAO() {
        if(this.SellerDAO==null){
            this.SellerDAO=new SellerDAO();
        }
        return SellerDAO;
    }

    public void setSellerDAO(SellerDAO SellerDAO) {
        this.SellerDAO = SellerDAO;
    }
}
