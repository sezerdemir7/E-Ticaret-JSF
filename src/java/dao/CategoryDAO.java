/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Statement;
import entity.Category;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author serki
 */
public class CategoryDAO extends DBConnect implements BaseDAO<Category> {

    @Override
    public void create(Category entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into category( name) values ('"
                    +  entity.getName() + "')";

            st.executeUpdate(query);
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Category entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update category set "
                    + "name = '" + entity.getName() + "' "
                    + "createdate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "";

            st.executeUpdate(query);
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Category entity) {

        try {
            Statement st = this.getConnect().createStatement();

            String query = "delete from Category where id = " + entity.getId();
            st.executeUpdate(query);
            
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Category> readList() {
        List<Category> categoryList = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Category");

            while (rs.next()) {
                categoryList.add(new Category(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")));
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return categoryList;
    }

    @Override
    public Category getEntityById(Long id) {
        Category category = null;
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Category where id = " + id);

            rs.next();

            category = new Category(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return category;
    }

}
