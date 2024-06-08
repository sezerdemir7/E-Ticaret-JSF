/*
 * Click nbimages://nbhost/SystemFileSystem/Templates/Licenses/license-deimageault.txt to change this license
 * Click nbimages://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Image;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;



/**
 *
 * @author Demirr
 */
@Local
@Stateless
public class ImageDAO extends BaseDAO<Image> {
    public Long createImage12(Image image) {
        try {
            em.persist(image);
           
            em.flush(); 
            return image.getId(); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1L;
        }
    }
    
    public Image createImage(Image image) {
       
            em.persist(image);
            em.flush(); 
           return image;
    }
   

/*
    public Long create(Image image) {
        long generatedId = -1;
        try {
            PreparedStatement pst = getConnect().prepareStatement(
                    "insert into image (name, path, type) values (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, image.getName());
            pst.setString(2, image.getPath());
            pst.setString(3, image.getType());

            int affectedRows = pst.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
                rs.close();
            }
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return generatedId;
    }

    public List<Image> readList() {

        List<Image> imageleList = new ArrayList<>();
        try {

            PreparedStatement pst = getConnect().prepareStatement("SELECT * FROM image");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getLong("id"));
                image.setName(rs.getString("name"));
                image.setPath(rs.getString("path"));
                image.setType(rs.getString("type"));
                imageleList.add(image);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return imageleList;
    }

    public Image getById(Long id) {
        Image imageile = null;
        try {
            PreparedStatement pst = getConnect().prepareStatement("SELECT * FROM image WHERE id = " + id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                imageile = new Image();
                imageile.setId(rs.getLong("id"));
                imageile.setName(rs.getString("name"));
                imageile.setPath(rs.getString("path"));
                imageile.setType(rs.getString("type"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return imageile;
    }
*/
}
