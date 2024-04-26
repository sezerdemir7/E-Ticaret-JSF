/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDetailDAO;
import entity.OrderDetail;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class OrderDetailBean extends  BaseBean<OrderDetail, OrderDetailDAO>{
    
    public OrderDetailBean(){
        super(null,null);
    }

    public OrderDetailBean(OrderDetail entity, OrderDetailDAO dao) {
        super(entity, dao);
    }
    // readList() metodu DAO üzerinden çağrılır ve sipariş detaylarını döndürür.
    public List<OrderDetail> readList() {
        return getDao().readList();
    }

    @Override
    protected OrderDetail createEntityInstance() {
        return new OrderDetail();
    }

    @Override
    protected OrderDetailDAO createDAOInstance() {
        return new OrderDetailDAO ();
    }
    
}
