/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CustomerDAO;
import entity.Customer;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Demirr
 */
@FacesConverter("customerConverter")
public class CustomerConverter implements Converter {

    private CustomerDAO CustomerDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Long id = Long.valueOf(string);
        Customer customer = this.getCustomerDAO().getEntityById(id);
        return customer;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Customer customer = (Customer) t;
        return String.valueOf(customer.getId());
    }

    public CustomerDAO getCustomerDAO() {
        if(this.CustomerDAO==null){
            this.CustomerDAO=new CustomerDAO();
        }
        return CustomerDAO;
    }

    public void setCustomerDAO(CustomerDAO CustomerDAO) {
        this.CustomerDAO = CustomerDAO;
    }
    

}
