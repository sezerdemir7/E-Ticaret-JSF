/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author Demirr
 */
public abstract class GenericSQL<T> extends DBConnect implements BaseDAO<T>{
    
        public void create(T object) {
        try {
            Class<?> cls = object.getClass();
            List<Field> allFields = new ArrayList<>();
            allFields.addAll(Arrays.asList(cls.getDeclaredFields()));

            // Kalıtım yoluyla aldığı alanları almak için üst sınıfları dolaşma
            Class<?> superClass = cls.getSuperclass();
            while (superClass != null) {
                allFields.addAll(Arrays.asList(superClass.getDeclaredFields()));
                superClass = superClass.getSuperclass();
            }

            String tableName = cls.getSimpleName();
            String query = "INSERT INTO " + tableName + " (";
            String values = " VALUES (";

            boolean first = true;

            for (Field field : allFields) {
                if (!field.getName().equals("id")) {
                    if (!first) {
                        query += ",";
                        values += ",";
                    }
                    field.setAccessible(true);
                    query += field.getName();
                    values += "'" + field.get(object) + "'";
                    first = false;
                }
            }

            query += ")" + values + ")";

            System.out.println("SQL query: " + query);

            Statement statement = this.getConnect().createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Veri tabanına eklendi");

        } catch (Exception  e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> list(T object) {
        List<Object> resultList = new ArrayList<>();

        try {
            Class<?> cls = object.getClass();
            List<Field> allFields = new ArrayList<>();
            allFields.addAll(Arrays.asList(cls.getDeclaredFields()));

            // Kalıtım yoluyla aldığı alanları almak için üst sınıfları dolaşma
            Class<?> superClass = cls.getSuperclass();
            while (superClass != null) {
                allFields.addAll(Arrays.asList(superClass.getDeclaredFields()));
                superClass = superClass.getSuperclass();
            }


            String query = "SELECT * FROM " + cls.getSimpleName();
            System.out.println("Query: " + query);

            Statement statement = this.getConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Object obj = cls.newInstance();
                for (Field field : allFields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    field.set(obj, value);
                }
                resultList.add(obj);
            }
            statement.close();
            resultSet.close();

            return resultList;

        } catch (Exception  e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(T object, int id) {
        try {
            Class<?> cls = object.getClass();
            String tableName = cls.getSimpleName();
            String query = "DELETE FROM " + tableName + " WHERE id = " + id;

            System.out.println("SQL query: " + query);

            Statement statement = this.getConnect().createStatement();
            statement.executeUpdate(query);
            statement.close();
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void update(T object) {
        try {
            Class<?> cls = object.getClass();
            List<Field> allFields = new ArrayList<>();
            allFields.addAll(Arrays.asList(cls.getDeclaredFields()));


            Class<?> superClass = cls.getSuperclass();
            while (superClass != null) {
                allFields.addAll(Arrays.asList(superClass.getDeclaredFields()));
                superClass = superClass.getSuperclass();
            }

            String tableName = cls.getSimpleName();
            String query = "UPDATE " + tableName + " SET ";

            boolean first = true;

            for (Field field : allFields) {
                if (!field.getName().equals("id")) {
                    if (!first) {
                        query += ", ";
                    }
                    field.setAccessible(true);
                    query += field.getName() + "='" + field.get(object) + "'";
                    first = false;
                }
            }


            Field idField = cls.getDeclaredField("id");
            idField.setAccessible(true);
            Object idValue = idField.get(object);
            query += " WHERE id=" + idValue;

            System.out.println("SQL query: " + query);

            Statement statement = this.getConnect().createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Veri tabanında güncellendi");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
