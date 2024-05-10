/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ProductDAO;
import entity.Product;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Demirr
 */

@FacesConverter("productConverter")
public class ProductConverter  implements Converter{
    
    private ProductDAO productDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        Long id=Long.valueOf(string);
        Product product=this.getProductDAO().getEntityById(id);
        return product;
    
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Product product=(Product)t;
        return String.valueOf(product.getId());
    }

    public ProductDAO getProductDAO() {
        if(this.productDAO==null){
            this.productDAO=new ProductDAO();
        }
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    
    
}
