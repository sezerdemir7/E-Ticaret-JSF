/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ImageDAO;
import entity.Image;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped
public class ImageBean implements Serializable {

    private Image image;
    @EJB
    private ImageDAO imageDAO;
    private List<Image> list;
    private Part doc;

    private String uploadTo = "C:\\Users\\Demirr\\Desktop\\files\\";

    /*public Long upload() {
        Long imageId ;
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

            Image newImage = new Image();
            newImage.setPath(f.getParent());
            newImage.setName(f.getName());
            newImage.setType(doc.getContentType());

         return imageId=  getImageDAO().createImage(newImage);
          

        } catch (IOException e) {
            System.out.println("Dosya yükleme hatası: " + e.getMessage());
        }
        return 2L;
    }*/
    public Image upload() {
       
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

            Image newImage = new Image();
            newImage.setPath(f.getParent());
            newImage.setName(f.getName());
            newImage.setType(doc.getContentType());

         return   getImageDAO().createImage(newImage);
          

        } catch (IOException e) {
            System.out.println("Dosya yükleme hatası: " + e.getMessage());
        }
        return null;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageDAO getImageDAO() {
        
        return imageDAO;
    }

    public void setImageDAO(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    public List<Image> getList() {
        List<Image> list=getImageDAO().readList();
        return list;
    }

    public void setList(List<Image> list) {
        this.list = list;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public void setUploadTo(String uploadTo) {
        this.uploadTo = uploadTo;
    }

}
