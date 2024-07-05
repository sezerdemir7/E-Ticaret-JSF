/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author EXCALIBUR
 */
@Named(value="NavigationBean")
@ViewScoped
public class NavigationBean implements Serializable{

	private Map<String, String> pages;
	
	public NavigationBean() {
		pages = new HashMap<>();
	}
	
	public String module(String page) {
		this.pages.put(page, "active");
		return "/panel/"+page+"/?faces-redirect=true";
	}

	public Map<String, String> getPages() {
		return pages;
	}
}
