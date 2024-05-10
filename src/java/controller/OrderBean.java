/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import dao.CartItemDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Order;
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
public class OrderBean  extends  BaseBean<Order, OrderDAO> {
    private CartDAO cartDAO;
    private CartItemDAO cartItemDAO;
    private OrderDetailDAO orderDetailDAO;
    
    public OrderBean(){
        super(Order.class,OrderDAO.class);
    }

    public boolean saveOrder(Customer customer){
        Cart cart=null;
        OrderDetail orderDetail = new OrderDetail();
        Order order=new Order();
        
        cart = getCartDAO().getCartByCustomerId(customer.getId());
        
        
        
        order.setCustomer(customer);
        order.setStatus(false);
        order.setToplamTutar(cart.getToplamFiyat());
        order.setTeslimatAdresi(customer.getAddres());
        Long orderId = getDao().createOrder(order);
        order.setId(orderId);
        
        List<CartItem> cartItems=getCartItemDAO().getCartItemsListByCartId(cart.getId());
        
        for (CartItem cartItem : cartItems) {
            orderDetail.setAdet(cartItem.getAdet());
            orderDetail.setOrder(order);
            orderDetail.setProduct(cartItem.getProduct());
            getOrderDetailDAO().create(orderDetail);
            getCartItemDAO().delete(cartItem);
        }
        
        cart.setCartItems(null);
        cart.setToplamFiyat(0);
        cart.setCustomer(customer);        
        getCartDAO().update(cart);
        
        //getDao().saveOrder(order,cartItems);
        
        return true;
    }

    
    public List<Order> getListByCustomerId(Long cutomerId) {
        return getDao().readListByCustumerId(cutomerId);
    }

    public CartDAO getCartDAO() {
        if(this.cartDAO==null){
            cartDAO=new CartDAO();
        }
        return cartDAO;
    }

    public void setCartDAO(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public CartItemDAO getCartItemDAO() {
        if(this.cartItemDAO==null){
            cartItemDAO=new CartItemDAO();
        }
        return cartItemDAO;
    }

    public void setCartItemDAO(CartItemDAO cartItemDAO) {
        this.cartItemDAO = cartItemDAO;
    }

    public OrderDetailDAO getOrderDetailDAO() {
        if(this.orderDetailDAO==null){
            orderDetailDAO=new OrderDetailDAO();
        }
        return orderDetailDAO;
    }

    public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
        this.orderDetailDAO = orderDetailDAO;
    }
    
    
    
     

    
}
