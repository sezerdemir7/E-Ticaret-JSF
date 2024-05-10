/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author Demirr
 */
public interface Controller<T> {

    public void clearForm();

    public void create();

    public void update();

    public void delete();

    public List<T> getList();

}
