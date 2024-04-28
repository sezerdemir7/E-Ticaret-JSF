/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDAO;
import entity.Customer;
import entity.Order;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

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
    
    public boolean saveOrder(Customer customer){
        Order order=new Order();
        order.setCustomer(customer);
        order.setStatus(false);
        order.setTeslimatAdresi(customer.getAddres());
        
        getDao().saveOrder(order);
        return true;
    }

    
    public List<Order> getListByCustomerId(Long cutomerId) {
        return getDao().readListByCustumerId(cutomerId);
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
