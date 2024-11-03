
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.protocol.Resultset;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java .sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Raja
 */
public class P_PROPERTY {

    private int id;
    private int type;
    private int size;
    private int ownerId;
    private String price;
    private String address;
    private int bedrooms;
    private int bathrooms;
    private int age;
    private boolean balcone;
    private boolean pool;
    private boolean backyard;
    private boolean garage;
    private String description;

    public P_PROPERTY() {
    }

    public P_PROPERTY(int ID, int TYPE, int SIZE, int OWNER_ID, String PRICE,
            String ADDRESS, int BEDROOMS, int BATHROOMS, int AGE, boolean BALCONE, boolean POOL, boolean BACKYARD,
            boolean GARAGE, String DESCRIPTION) {

        this.id = ID;
        this.type = TYPE;
        this.size = SIZE;
        this.ownerId = OWNER_ID;
        this.price = PRICE;
        this.address = ADDRESS;
        this.bedrooms = BEDROOMS;
        this.bathrooms = BATHROOMS;
        this.age = AGE;
        this.balcone = BALCONE;
        this.pool = POOL;
        this.backyard = BACKYARD;
        this.garage = GARAGE;
        this.description = DESCRIPTION;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBalcone() {
        return balcone;
    }

    public void setBalcone(boolean balcone) {
        this.balcone = balcone;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isBackyard() {
        return backyard;
    }

    public void setBackyard(boolean backyard) {
        this.backyard = backyard;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // create a function to add a new   property
    public boolean addProperty(P_PROPERTY property) {

        PreparedStatement ps;

        String addQuery = "INSERT INTO the_property ("
                + " type, square_feet, ownerId, price, address, bedrooms, bathrooms, age, balcone, pool, backyard, garage, description"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
            ps.setInt(1, property.getType());
            ps.setInt(2, property.getSize());
            ps.setInt(3, property.getOwnerId());
            ps.setString(4, property.getPrice());
            ps.setString(5, property.getAddress());
            ps.setInt(6, property.getBedrooms());
            ps.setInt(7, property.getBathrooms());
            ps.setInt(8, property.getAge());
            ps.setBoolean(9, property.isBalcone());
            ps.setBoolean(10, property.isPool());
            ps.setBoolean(11, property.isBackyard());
            ps.setBoolean(12, property.isGarage());
            ps.setString(13, property.getDescription());

            return (ps.executeUpdate() > 0);

        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    // create a function to edit a new   property
    public boolean ediProperty(P_PROPERTY property) {
        
        PreparedStatement ps;

       String editQuery = "UPDATE the_property SET "
                + "type = ?, "
                + "square_feet = ?, "
                + "ownerId = ?, "
                + "price = ?, "
                + "address = ?, "
                + "bedrooms = ?, "
                + "bathrooms = ?, "
                + "age = ?, "
                + "balcone = ?, "
                + "pool = ?, "
                + "backyard = ?, "
                + "garage = ?, "
                + "description = ? "
                + "WHERE id = ?";
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(editQuery);
            ps.setInt(1, property.getType());
            ps.setInt(2, property.getSize());
            ps.setInt(3, property.getOwnerId());
            ps.setString(4, property.getPrice());
            ps.setString(5, property.getAddress());
            ps.setInt(6, property.getBedrooms());
            ps.setInt(7, property.getBathrooms());
            ps.setInt(8, property.getAge());
            ps.setBoolean(9, property.isBalcone());
            ps.setBoolean(10, property.isPool());
            ps.setBoolean(11, property.isBackyard());
            ps.setBoolean(12, property.isGarage());
            ps.setString(13, property.getDescription());
            ps.setInt(14, property.getId());

            return (ps.executeUpdate() > 0);

        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    // create a function to delete aselected  property
    public boolean removeProperty(int propertyid) {
        PreparedStatement ps;
        
        String deletequery="delete from the_property where id=?";
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(deletequery);
            
            ps.setInt(1, propertyid);
            
            
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // create a function to searfor a property by id
    
    public P_PROPERTY findProperty(int propertyId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        P_PROPERTY property = null;

        String searchQuery = "SELECT * FROM the_property WHERE id = ?";

        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(searchQuery);
            ps.setInt(1, propertyId);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Create and return the property with data from the result set
                property = new P_PROPERTY(
                        rs.getInt("id"),
                        rs.getInt("type"),
                        rs.getInt("square_feet"),
                        rs.getInt("ownerId"),
                        rs.getString("price"),
                        rs.getString("address"),
                        rs.getInt("bedrooms"),
                        rs.getInt("bathrooms"),
                        rs.getInt("age"),
                        rs.getBoolean("balcone"),
                        rs.getBoolean("pool"),
                        rs.getBoolean("backyard"),
                        rs.getBoolean("garage"),
                        rs.getString("description")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
            // Optionally, you can return null or throw a custom exception
        } finally {
            // Close resources in the finally block to prevent memory leaks
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return property; // Return the found property or null if not found
    }

// Example implementation for propertiesList
    public ArrayList<P_PROPERTY> propertiesList() {
        
        ArrayList<P_PROPERTY> list=new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        
        String selectQuery="select * from the_property";
        
        try {
            
            st=THE_CONNECTION.getTheConnection().createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_PROPERTY property;
            
            while (rs.next()) {
                
                property = new P_PROPERTY(  rs.getInt("id"),
                        rs.getInt("type"),
                        rs.getInt("square_feet"),
                        rs.getInt("ownerId"),
                        rs.getString("price"),
                        rs.getString("address"),
                        rs.getInt("bedrooms"),
                        rs.getInt("bathrooms"),
                        rs.getInt("age"),
                        rs.getBoolean("balcone"),
                        rs.getBoolean("pool"),
                        rs.getBoolean("backyard"),
                        rs.getBoolean("garage"),
                        rs.getString("description"));
                
                list.add(property);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    // create a function to return a list of the property depending on the selected type
    // Example implementation for propertiesList
    public ArrayList<P_PROPERTY> propertiesListByType(int typeid) {
        
        ArrayList<P_PROPERTY> list=new ArrayList<>();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery="select  * from the_property where type=?";
        
        try {
            
            ps=THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, typeid);
            rs=ps.executeQuery();
            
            P_PROPERTY property;
            
            while (rs.next()) {
                
                property = new P_PROPERTY(  rs.getInt("id"),
                        rs.getInt("type"),
                        rs.getInt("square_feet"),
                        rs.getInt("ownerId"),
                        rs.getString("price"),
                        rs.getString("address"),
                        rs.getInt("bedrooms"),
                        rs.getInt("bathrooms"),
                        rs.getInt("age"),
                        rs.getBoolean("balcone"),
                        rs.getBoolean("pool"),
                        rs.getBoolean("backyard"),
                        rs.getBoolean("garage"),
                        rs.getString("description"));
                
                list.add(property);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    // create a function to add image to thr property 
    public boolean addImageProperty(int propertyid, String the_image_path) {

        PreparedStatement ps;

        String addQuery = "Insert into propertyimages(property_id,the_image) values (?,?)";
        try {
            
            try {
                FileInputStream propertyImage=new FileInputStream(new File(the_image_path));
                ps = THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
                ps.setInt(1, propertyid);
                ps.setBinaryStream(2, propertyImage);
                return (ps.executeUpdate() > 0);
                
            } catch (FileNotFoundException ex) {
               // Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, ex.getMessage()+ "Invalid File ","Image ERROR",2);
                return false;
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    
    // create afunction to get the selected property  list of images by proprty
    
    public HashMap<byte[], Integer> propertiesImageList(int propertyId) {

        HashMap<byte[], Integer> list = new HashMap<>();

        PreparedStatement ps;
        ResultSet rs;

        String selectQuery = "SELECT * FROM propertyimages WHERE property_id=?";

        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, propertyId);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.put(rs.getBytes("the_image"), rs.getInt("id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
        //create a function to get Image by id 
    public byte[] getImageId(int imageId) {

        PreparedStatement ps;
        ResultSet rs;

        String selectQuery = "SELECT the_image FROM propertyimages WHERE id=?";

        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, imageId);
            rs = ps.executeQuery();

            if (rs.next()) {
                 return rs.getBytes("the_image");
            }else{
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //  cretate a function to remove Image i=by id 
    public boolean  removePropertyImage(int imageId) {

        PreparedStatement ps;
        ResultSet rs;
        byte[] imageData = null;

        String selectQuery = "SELECT the_image FROM propertyimages WHERE id=?";
        String deleteQuery = "DELETE FROM propertyimages WHERE id=?";

        try {
            // Retrieve the image data first
            ps = THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, imageId);
            rs = ps.executeQuery();

            if (rs.next()) {
                imageData = rs.getBytes("the_image");
            }

            // If image data is found, proceed with deletion
            if (imageData != null) {
                ps = THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
                ps.setInt(1, imageId);
                ps.executeUpdate(); // Perform the delete operation
            }

        } catch (SQLException ex) {
            Logger.getLogger(P_PROPERTY.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the image data if found and deleted, otherwise null
        return false;
    }

    
}
