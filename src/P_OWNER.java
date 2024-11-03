/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Raja
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class P_OWNER {
    
    private int id;
    private String FirstName;
    private String LastName;
    private String phone;
    private String email;
    private String address;
    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int Id){
        this.id=Id;
        
    }
    public String getFName(){
        return this.FirstName;
    }
    public void setName(String FNAME){
        this.FirstName=FNAME;
    }
    
    public String getLname(){
        return this.LastName;
    }
    public void setLname(String LNAME){
        this.LastName=LNAME;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String PNAME){
        this.phone=PNAME;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String EMAIL){
        this.email=EMAIL;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String ADDRESS){
        this.address=ADDRESS;
        
    }
    
    public P_OWNER(){}
    public P_OWNER( int ID,String FNAME,String LNAME,String PHONE,String EMAIL,String ADDRESS){
        this.id=ID;
        this.FirstName=FNAME;
        this.LastName=LNAME;
        this.phone=PHONE;
        this.email=EMAIL;
        this.address=ADDRESS;
    }  
    // create a function to add a nrw client 
    // fo=irasr createthe ownwer table in the database
    public boolean addNewOwner(P_OWNER owner){
        
        PreparedStatement ps;
        
        String addQuery="Insert into property_owner(fname ,lname ,phone ,email ,address ) values (?,?,?,?,?)";
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
            ps.setString(1, owner.getFName());
            ps.setString(2, owner.getLname());
            ps.setString(3, owner.getPhone());
            ps.setString(4, owner.getEmail());
            ps.setString(5, owner.getAddress());
            
            
            
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_OWNER.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    
    // create  a function to delete the selected owner detaisl from the database;
    public boolean deleteOwner(int ownerId){
        
        PreparedStatement ps;
        
        String deletequery="delete from property_owner where id=?";
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(deletequery);
            
            ps.setInt(1, ownerId);
            
            
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_OWNER.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    // create a function for edit the owner details .
    public boolean editOwnerData(P_OWNER owner){
        
        PreparedStatement ps;
        
        String editquery="update property_owner set fname=?,lname=?,phone=?,email=?,address=? where id=?" ;
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(editquery);
            
            ps.setString(1, owner.getFName());
            ps.setString(2, owner.getLname());
            ps.setString(3, owner.getPhone());
            ps.setString(4, owner.getEmail());
            ps.setString(5, owner.getAddress());
            ps.setInt(6, owner.getId());
            
            
            
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_OWNER.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    // crete a function  to return an arraylist of owner
    
    public ArrayList<P_OWNER> ownerList(){
        ArrayList<P_OWNER> list=new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String selectQuery="select * from property_owner";
        
        try {
            st=THE_CONNECTION.getTheConnection().createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_OWNER owner;
            while (rs.next()) {
                owner = new P_OWNER(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                list.add(owner);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_OWNER.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
