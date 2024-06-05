/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author serki
 */
@Entity
public class Orders extends BaseEntity {

    private String teslimatAdresi;
    private boolean status;
    private int toplamTutar;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;
    //@CurrentTimestamp()
    private Timestamp orderDate;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Orders() {
    }

    public Orders(String teslimatAdresi, boolean status, int toplamTutar, Customer customer, Store store, Payment payment, Timestamp orderDate, List<OrderDetail> orderDetails, List<Product> products, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.teslimatAdresi = teslimatAdresi;
        this.status = status;
        this.toplamTutar = toplamTutar;
        this.customer = customer;
        this.store = store;
        this.payment = payment;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
        this.products = products;
    }

    public Orders(String teslimatAdresi, boolean status, int toplamTutar, Customer customer, Store store, Payment payment, Timestamp orderDate, List<OrderDetail> orderDetails, List<Product> products, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.teslimatAdresi = teslimatAdresi;
        this.status = status;
        this.toplamTutar = toplamTutar;
        this.customer = customer;
        this.store = store;
        this.payment = payment;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
        this.products = products;
    }

    

    public String getTeslimatAdresi() {
        return teslimatAdresi;
    }

    public void setTeslimatAdresi(String teslimatAdresi) {
        this.teslimatAdresi = teslimatAdresi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(int toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}












/*    //@OneToOne
  //  @JoinColumn(name = "customerid")
    private Customer customer;
    private Timestamp orderDate;
    private boolean status;
    private String teslimatAdresi;
    
   // @OneToMany(mappedBy = "order")
    private List<Store> store;
    
  //  @OneToOne
  //  @JoinColumn(name = "paymentid")
    private Payment payment;
    private int toplamTutar;
    
    private List<Product> products;

    public Orders() {
    }

    public Orders(Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
    }

    public Orders(Customer customer, Timestamp orderDate, boolean status, String teslimatAdresi, Payment payment, int toplamTutar, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.teslimatAdresi = teslimatAdresi;
        this.payment = payment;
        this.toplamTutar = toplamTutar;
    }

    public Orders(Customer customer, Timestamp orderDate, boolean status, String teslimatAdresi, Payment payment, int toplamTutar, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.teslimatAdresi = teslimatAdresi;
        this.payment = payment;
        this.toplamTutar = toplamTutar;
    }

    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTeslimatAdresi() {
        return teslimatAdresi;
    }

    public void setTeslimatAdresi(String teslimatAdresi) {
        this.teslimatAdresi = teslimatAdresi;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(int toplamTutar) {
        this.toplamTutar = toplamTutar;
    }
    
    
 */
