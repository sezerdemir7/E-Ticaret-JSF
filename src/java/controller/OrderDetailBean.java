/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDetailDAO;
import entity.OrderDetail;
import entity.Orders;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class OrderDetailBean extends BaseBean<OrderDetail> implements Serializable {

    @EJB
    private OrderDetailDAO dao;

    public OrderDetailBean() {
        super(OrderDetail.class);
    }

    @Override
    public void create() {
        this.dao.create(entity);
        this.clearForm();
    }

    @Override
    public void update() {
        this.dao.update(entity);
        this.clearForm();
    }

    @Override
    public void delete() {
        this.dao.delete(entity);
        this.clearForm();
    }

    @Override
    public List<OrderDetail> getList() {
        return this.dao.readList();
    }

    @Override
    public OrderDetail getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }
    
    // bundan sonrası eklendi
    public String goToOrderDetailPage(Orders order) {
        getEntity().setOrder(order);
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("order id=====" + getEntity().getOrder().getId());
        System.out.println("*");

        return "/panel/order/order_detay.xhtml?faces-redirect=true";
    }

      public List<OrderDetail> listOrderDetailByOrder() {
        List<OrderDetail> details = new ArrayList<>();
        details = dao.listOrderDetailByOrder(getEntity().getOrder());
        for (OrderDetail detail : details) {
            System.out.println("*");
            System.out.println("*");
            System.out.println("*");
            System.out.println("detail id=====" + detail.getProduct().getName());
            System.out.println("*");
        }
        return details;

    }

    
}

/*
    public List<OrderDetail> listOrderDetailByOrder() {
        List<OrderDetail> details = new ArrayList<>();
        details = getDao().listOrderDetailByOrder(getEntity().getOrder());
        for (OrderDetail detail : details) {
            System.out.println("*");
            System.out.println("*");
            System.out.println("*");
            System.out.println("detail id=====" + detail.getProduct().getName());
            System.out.println("*");
        }
        return details;

    }

    public String goToOrderDetailPage(Order order) {
        getEntity().setOrder(order);
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("order id=====" + getEntity().getOrder().getId());
        System.out.println("*");

        return "/panel/order/order_detay.xhtml?faces-redirect=true";
    }

}
*/
