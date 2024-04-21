/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PaymentDAO;
import entity.Payment;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class PaymentBean extends BaseBean<Payment, PaymentDAO>{
    
    public PaymentBean(){
        super(null,null);
    }

    public PaymentBean(Payment entity, PaymentDAO dao) {
        super(entity, dao);
    }

    @Override
    protected Payment createEntityInstance() {
        return new Payment();
    }

    @Override
    protected PaymentDAO createDAOInstance() {
        return new PaymentDAO();
    }
    
}
