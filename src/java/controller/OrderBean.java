/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDAO;
import entity.Order;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class OrderBean  extends  BaseBean<Order, OrderDAO>{
    
    public OrderBean(){
        super(null,null);
    }

    public OrderBean(Order entity, OrderDAO dao) {
        super(entity, dao);
    }

    @Override
    protected Order createEntityInstance() {
        return new Order();
    }

    @Override
    protected OrderDAO createDAOInstance() {
        return new OrderDAO();
    }
    
}
