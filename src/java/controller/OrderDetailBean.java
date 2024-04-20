/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDetailDAO;
import entity.OrderDetail;

/**
 *
 * @author serki
 */
public class OrderDetailBean extends  BaseBean<OrderDetail, OrderDetailDAO>{

    public OrderDetailBean(OrderDetail entity, OrderDetailDAO dao) {
        super(entity, dao);
    }

    @Override
    protected OrderDetail createEntityInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected OrderDetailDAO createDAOInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
