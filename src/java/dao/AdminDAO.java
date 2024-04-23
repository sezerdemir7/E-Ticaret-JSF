/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Statement;
import java.sql.ResultSet;

import entity.Admin;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author serki
 */
public class AdminDAO extends DBConnect implements BaseDAO<Admin> {

    @Override
    public void create(Admin entity) {
        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into Admin(firstName, lastName, password, email, createdDate, lastModifiedDate) values ('"
                    + entity.getFirstName() + "',"
                    + "'" + entity.getLastName() + "',"
                    + "'" + entity.getPassword() + "'"
                    + ",'" + entity.getEmail() + "',"
                    + "'" + entity.getCreatedDate() + "'"
                    + ",'" + entity.getLastModifiedDate() + "')";

            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Admin entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update Admin set "
                    + "firstname ='" + entity.getFirstName() + "'  "
                    + "lastName = '" + entity.getLastName() + "' "
                    + "password = '" + entity.getPassword() + "' "
                    + "email = '" + entity.getEmail() + "' "
                    + "createDate ='" + entity.getCreatedDate() + "'"
                    + "lastModifiedDate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "";

            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Admin entity) {

        try {
            Statement st = this.getConnect().createStatement();

            String query = "delete from Admin where id = " + entity.getId();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Admin> readList() {

        List<Admin> adminList = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Admin");

            while (rs.next()) {
                adminList.add(new Admin(
                        rs.getLong("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return adminList;
    }

    @Override
    public Admin getEntityById(Long id) {

        Admin admin = null;
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Admin where id = " + id);

            rs.next();

            admin = new Admin(
                    rs.getLong("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getTimestamp("createdDate"),
                    rs.getTimestamp("lastModifiedDate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return admin;

    }

}
