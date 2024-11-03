/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Raja
 */
public class P_TYPE {
    
    private  int id;
    private String name;
    private String description;
    
    
    public  Integer getID(){
        return id;
    }
    
    public void setId(Integer ID){
        this.id=ID;
    }
    
    public String getName(){
        return name;
        
    }
    
    public void setName(String NAME){
        this.name=NAME;
        
        
    }
    public String getDescription(){
        return this.description;
        
    }
    
    public void setDescription(String DESCRIPTION){
        this.description=DESCRIPTION;
    }
    //Create the class constructor 
    public P_TYPE(){
        
    }
    public P_TYPE(Integer ID,String NAME,String DESCRIPTION){
        this.id=ID;
        this.name=NAME;
        this.description=DESCRIPTION;
    }
    
    // create a function to insert edit remove type 
    public boolean execTypeQuery(String queryType,P_TYPE type){
        PreparedStatement ps;
        
        // add a new type
        if(queryType.equals("add")){
            try {
                ps=THE_CONNECTION.getTheConnection().prepareStatement("INSERT INTO property_type(name,description) VALUES (?,?)");
                ps.setString(1, getName());
                ps.setString(2, type.getDescription());
               
              return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
            // add a new ttype 
            else if(queryType.equals("edit"))
            {
            try {
                ps=THE_CONNECTION.getTheConnection().prepareStatement("UPDATE property_type SET name=?,description=? WHERE id=?");
                ps.setString(1, getName());
                ps.setString(2, type.getDescription());
                ps.setInt(3, type.getID());
                    
                return (ps.executeUpdate()>=0);
                  
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        }   
        
        else if(queryType.equals("remove"))
            {
            try {
                //query -> DELETE FROM property_type WHERE id=?
                ps=THE_CONNECTION.getTheConnection().prepareStatement("DELETE FROM property_type WHERE id=?");
                ps.setInt(1, type.getID());
                    
                return (ps.executeUpdate()>=0);
                  
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Enter add edit remove","Valid Operation",id);
            return false;
            
        }
    
    }  
    
    // create a function to return a list of all type in a Hashmap
    //String is the key
    // integer is the key 
    public HashMap<String,Integer> getTypeMap(){
        HashMap<String , Integer> map=new HashMap<>();
        Statement st;
        ResultSet rs;
        
        try {
            st=THE_CONNECTION.getTheConnection().createStatement();
            rs=st.executeQuery("select * from property_type");
            P_TYPE type;
            
            while(rs.next()){
                type=new P_TYPE(rs.getInt(1),rs.getString(2),rs.getString(3));
                map.put(type.getName(), type.getID());
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return map;
    }
    //create  afunction to get a type data by id
    //we can use getTypeMap() function to getthe id and name
    // but we want the description to 
    public P_TYPE getTypeById(Integer id){
        
        PreparedStatement ps;
        ResultSet rs;
        
        P_TYPE type=new P_TYPE();
        
        
         try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement("SELECT * from property_type where id=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            
            
            if(rs.next()){
               type.setId(id);
            type.setName(rs.getString(2));
            type.setDescription(rs.getString(3));
            
            }
    
            
            } catch (SQLException ex) {
            Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        }
         return type;
    
    }
    
}
