/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Seller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnect;

/**
 *
 * @author Demirr
 */
public class SellerDAO extends DBConnect implements BaseDAO<Seller> {

    public Seller login(Seller entity) {

        Seller seller = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from seller where email='" + entity.getEmail() + "'");
            if (rs.next()) {
                seller = new Seller(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("created_date"),
                        rs.getTimestamp("last_modified_date")
                );
            }

            return seller;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<Seller> readList() {
        List<Seller> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from seller");

            while (rs.next()) {
                list.add(new Seller(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
                        rs.getString("password"), rs.getTimestamp("created_date"), rs.getTimestamp("last_modified_date")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(Seller seller) {
        try {

            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into seller(first_name,last_name,email,password) values ('" 
                    + seller.getFirstName() + "','" + seller.getLastName() + "',"
                    + "'" + seller.getEmail() + "','" + seller.getPassword() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Seller entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Seller entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Seller getEntityById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
