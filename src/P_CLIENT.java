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


public class P_CLIENT{
    
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
    
    public P_CLIENT(){}
    public P_CLIENT( int ID,String FNAME,String LNAME,String PHONE,String EMAIL,String ADDRESS){
        this.id=ID;
        this.FirstName=FNAME;
        this.LastName=LNAME;
        this.phone=PHONE;
        this.email=EMAIL;
        this.address=ADDRESS;
    } 
    
    
    
    // create a function to add a nrw client 
    public boolean addNewClient(P_CLIENT client){
        
        PreparedStatement ps;
        
        String addQuery="Insert into property_client(fname ,lname ,phone ,email ,address ) values (?,?,?,?,?)";
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
            ps.setString(1, client.getFName());
            ps.setString(2, client.getLname());
            ps.setString(3, client.getPhone());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getAddress());
            
            
            
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_OWNER.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    // create a function for edit the client details .
    public boolean editClientData(P_CLIENT client){
        
        PreparedStatement ps;
        
        String editquery="update property_client set fname=?,lname=?,phone=?,email=?,address=? where id=?" ;
        
               
        try {
            
            ps=THE_CONNECTION.getTheConnection().prepareStatement(editquery);
            
            ps.setString(1, client.getFName());
            ps.setString(2, client.getLname());
            ps.setString(3, client.getPhone());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getAddress());
            ps.setInt(6, client.getId());
    
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
     // create  a function to delete the selected owner detaisl from the database;
    public boolean deleteClient(int clientId){
        
        PreparedStatement ps;
        
        String deletequery="delete from property_client where id=?";
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(deletequery);
            
            ps.setInt(1, clientId);
            
            
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    // crete a function  to return an arraylist of client
    public ArrayList<P_CLIENT> clientList(){
        ArrayList<P_CLIENT> list=new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String selectQuery="select * from property_client";
        
        try {
            st=THE_CONNECTION.getTheConnection().createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_CLIENT client;
            while (rs.next()) {
                client = new P_CLIENT(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                list.add(client);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    
    // crete a function  to return an arraylist of client
    public ArrayList<P_SALE> saleList(){
        ArrayList<P_SALE> list=new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String selectQuery="select * from sales";
        
        try {
            st=THE_CONNECTION.getTheConnection().createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_SALE sale;
            while (rs.next()) {
                sale = new P_SALE(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
                list.add(sale);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(P_SALE.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
}
