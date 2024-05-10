/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.StoreDAO;
import entity.Store;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Demirr
 */

@FacesConverter("storeConverter")
public class StoreConverter implements Converter{
    
    private StoreDAO storeDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Long id = Long.valueOf(string);
        Store store = this.getStoreDAO().getEntityById(id);
        return store;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Store store = (Store) t;
        return String.valueOf(store.getId());
    }

    public StoreDAO getStoreDAO() {
        if(this.storeDAO==null){
            this.storeDAO=new StoreDAO();
        }
        return storeDAO;
    }

    public void setStoreDAO(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }
}
