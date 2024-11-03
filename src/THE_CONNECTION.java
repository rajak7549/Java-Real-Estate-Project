
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
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
public class THE_CONNECTION {
    
    private static String servername="localhost";
    private static String dbname="java_rst_db";
    private static String username="root";
    private static Integer portnumber=3306;
    private static String password="Raja@7549";
    
    
    //create a function to get the connection
    public static Connection getTheConnection(){
        
        Connection connection =null;
        
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setServerName(servername);
        dataSource.setUser(username);
        dataSource.setDatabaseName(dbname);
        dataSource.setPortNumber(portnumber);
        dataSource.setPassword(password);
        
        try {
            connection =dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(THE_CONNECTION.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
     
}
