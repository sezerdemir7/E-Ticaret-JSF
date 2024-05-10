/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDetailDAO;
import entity.Order;
import entity.OrderDetail;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class OrderDetailBean extends BaseBean<OrderDetail, OrderDetailDAO> {

    public OrderDetailBean() {
        super(OrderDetail.class, OrderDetailDAO.class);
    }

    public List<OrderDetail> listOrderDetailByOrder() {
        List<OrderDetail> details = new ArrayList<>();
        details = getDao().listOrderDetailByOrder(getEntity().getOrder());
        for (OrderDetail detail : details) {
            System.out.println("*********");
            System.out.println("*********");
            System.out.println("*********");
            System.out.println("detail id=====" + detail.getProduct().getName());
            System.out.println("*********");
        }
        return details;

    }

    public String goToOrderDetailPage(Order order) {
        getEntity().setOrder(order);
        System.out.println("*********");
        System.out.println("*********");
        System.out.println("*********");
        System.out.println("order id=====" + getEntity().getOrder().getId());
        System.out.println("*********");

        return "/panel/order/order_detay.xhtml?faces-redirect=true";
    }

}
