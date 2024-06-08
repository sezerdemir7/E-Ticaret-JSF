/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import dao.CartItemDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.PaymentDAO;
import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.OrderDetail;
import entity.Orders;
import entity.Payment;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@RequestScoped
public class OrderBean extends BaseBean<Orders> implements Serializable {

    @EJB
    private OrderDAO dao;

    @EJB
    private CartDAO cartdao;

    @EJB
    private CartItemDAO cartitemdao;

    @EJB
    private OrderDetailDAO orderdetaildao;
    
    @EJB
    private PaymentDAO paymentDAO;

    public OrderBean() {
        super(Orders.class);
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
    public List<Orders> getList() {
        return this.dao.readList();
    }

    @Override
    public Orders getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

    //burdan sonrası eklendi
    public List<Orders> getListByCustomerId(Long customerId) {
        return this.dao.readListByCustomerId(customerId);
    }

    public boolean saveOrder(Customer customer) {
        System.out.println("*******************");
        System.out.println("*******************");
        System.out.println("*******************");
        System.out.println("*******************");
        System.out.println("*******deneme noktası********");
        System.out.println("*******************");
        
        
        
        try {
            Cart cart = cartdao.getCartByCustomer(customer);
            List<CartItem> cartItems = cartitemdao.getCartItemsListByCart(cart);
            if (cart==null || cartItems==null ) {
                System.out.println("cart null hatasi");
                return false;
            }
            
            Payment payment =new Payment();
            payment.setCustomer(customer);
            payment.setOdenenTutar(cart.getToplamFiyat());
            paymentDAO.create(payment);

            Orders order = new Orders();
            order.setCustomer(customer);
            order.setStatus(false);
            order.setOrderDate(new Timestamp(System.currentTimeMillis()));
            order.setToplamTutar(cart.getToplamFiyat());
            order.setTeslimatAdresi(customer.getAddres());
            order.setPayment(payment);
            dao.create(order);

            

            for (CartItem cartItem : cartItems) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setAdet(cartItem.getAdet());
                orderDetail.setOrder(order);
                orderDetail.setProduct(cartItem.getProduct());
                orderdetaildao.create(orderDetail);
                cartitemdao.delete(cartItem);
            }

            cart.setCartItems(null);
            cart.setToplamFiyat(0);
            cart.setCustomer(customer);
            cartdao.update(cart);

            this.clearOrderForm();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private void clearOrderForm() {
    this.entity = new Orders();
    this.cartdao=null;
    this.cartitemdao=null;
    this.orderdetaildao=null;
    this.paymentDAO=null;
}

    /*  public boolean saveOrder(Customer customer){
        Cart cart=null;
        OrderDetail orderDetail = new OrderDetail();
        Orders order=new Orders();
        
        cart = this.cartdao.getCartByCustomer(customer);
        
        
        
        order.setCustomer(customer);
        order.setStatus(false);
        order.setToplamTutar(cart.getToplamFiyat());
        order.setTeslimatAdresi(customer.getAddres());
        Long orderId = this.dao.createOrder(order);
        order.setId(orderId);
        
        List<CartItem> cartItems=this.cartitemdao.getCartItemsListByCart(cart);
        
        for (CartItem cartItem : cartItems) {
            orderDetail.setAdet(cartItem.getAdet());
            orderDetail.setOrder(order);
            orderDetail.setProduct(cartItem.getProduct());
            this.orderdetaildao.create(orderDetail);
            this.cartitemdao.delete(cartItem);
        }
        
        cart.setCartItems(null);
        cart.setToplamFiyat(0);
        cart.setCustomer(customer);        
        this.cartdao.update(cart);
        
        //getDao().saveOrder(order,cartItems);
        
        return true;
    }
     */
}

/*
    public boolean saveOrder(Customer customer){
        Cart cart=null;
        OrderDetail orderDetail = new OrderDetail();
        Order order=new Order();
        
        cart = getCartDAO().getCartByCustomer(customer);
        
        
        
        order.setCustomer(customer);
        order.setStatus(false);
        order.setToplamTutar(cart.getToplamFiyat());
        order.setTeslimatAdresi(customer.getAddres());
        Long orderId = getDao().createOrder(order);
        order.setId(orderId);
        
        List<CartItem> cartItems=getCartItemDAO().getCartItemsListByCart(cart);
        
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
 */
