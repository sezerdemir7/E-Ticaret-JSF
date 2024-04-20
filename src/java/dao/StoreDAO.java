/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Store;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author serki
 */
public class StoreDAO extends DBConnect implements BaseDAO<Store> {

    @Override
    public void create(Store entity) {

        try {
            // PreparedStatement oluştur
            PreparedStatement pst = this.getConnect().prepareStatement(
                    "INSERT INTO store (name,seller_id) "
                    + "VALUES (?, ?)");

            // Parametreleri ayarla
            pst.setString(1, entity.getName());
            pst.setLong(2, entity.getSeller().getId());

            pst.executeUpdate();

            // PreparedStatement'ı kapat
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error while creating product: " + e.getMessage());
        }

    }

    @Override
    public void update(Store entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Store entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Store> readList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Store getEntityById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
