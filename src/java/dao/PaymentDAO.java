/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Payment;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

/**
 *
 * @author serki
 */

@Local
@Stateless
public class PaymentDAO extends BaseDAO<Payment> implements Serializable{

    public PaymentDAO() {
        super(Payment.class);
    }

   
    
    
    
}
/*
    private CustomerDAO customerDAO;

    @Override
    public void create(Payment entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into Payment (customer_id, odenentutar, createddate, lastmodifieddate) "
                    + "values ('" + entity.getCustomer().getId() + "',"
                    + "'" + entity.getOdenenTutar() + "',"
                    + "'" + entity.getCreatedDate() + "',"
                    + "'" + entity.getLastModifiedDate() + "')");
             st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Payment entity) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update Payment set "
                    + "customerid ='" + entity.getCustomer().getId() + "'  "
                    + "odenentutar = '" + entity.getOdenenTutar() + "'"
                    + "createdate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");
             st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Payment entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from Payment where id = " + entity.getId());
             st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Payment> readList() {
        List<Payment> paymentList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Payment");

            while (rs.next()) {
                Customer customer = this.customerDAO.getEntityById(rs.getLong("customerid"));
                paymentList.add(new Payment(
                        customer,
                        rs.getInt("odenentutar"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
            }
             st.close();
             rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return paymentList;

    }

    @Override
    public Payment getEntityById(Long id) {

        Payment payment = null;

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Payment where id = " + id);

            rs.next();

            Customer customer = this.getCustomerDAO().getEntityById(rs.getLong("id"));
            payment = new Payment(
                    customer,
                    rs.getInt("odenentutar"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
             st.close();
             rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return payment;

    }

    public CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            this.customerDAO = new CustomerDAO();
        }
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

}
*/
