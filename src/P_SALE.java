
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Raja
 */
public class P_SALE {
    
    private int id;
    private int propertyId;
    private int clientId;
    private String finalPrice;
    private String sellingDate;
    
    public P_SALE(){}
    
    public P_SALE(int ID, int PROPERTY_ID,int CLIENT_ID,String FINAL_PRICE,String  SELLING_DATE){
        
        this.id=ID;
        this.propertyId=PROPERTY_ID;
        this.clientId=CLIENT_ID;
        this.finalPrice=FINAL_PRICE;
        this.sellingDate=SELLING_DATE;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(String sellingDate) {
        this.sellingDate = sellingDate;
    }
    
    // create a function to add a new Sale 
    public boolean addNewSale(P_SALE sale){
        
        PreparedStatement ps;
        
        String addQuery="Insert into sales(property_id, client_id, final_price, sale_date) values (?,?,?,?)";
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
            ps.setInt(1, sale.getPropertyId());
            ps.setInt(2, sale.getClientId());
            ps.setString(3, sale.getFinalPrice());
            ps.setString(4, sale.getSellingDate());

            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_SALE.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    // create a function for edit the client details .
    public boolean editsaleData(P_SALE sale){
        
        PreparedStatement ps;
        
        String editquery="update sales set property_id=?,client_id=?,final_price=?,sale_date=? where id=?" ;
  
        try {
            
            ps=THE_CONNECTION.getTheConnection().prepareStatement(editquery);
            
            ps.setInt(1, sale.getPropertyId());
            ps.setInt(2, sale.getClientId());
            ps.setString(3, sale.getFinalPrice());
            ps.setString(4, sale.getSellingDate());
            ps.setInt(5, sale.getId());
    
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_SALE.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    // create  a function to delete the selected sale detaisl from the database;
    public boolean deleteSale(int saleId){
        
        PreparedStatement ps;
        
        String deletequery="delete from sales where id=?";
        
               
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement(deletequery);
            
            ps.setInt(1, saleId);
            
            
            return (ps.executeUpdate()>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_SALE.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

   
    // crete a function  to return an arraylist of sale
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
