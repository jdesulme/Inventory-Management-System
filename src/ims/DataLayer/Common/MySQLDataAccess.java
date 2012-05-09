/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.DataLayer.Common;
import java.sql.*;
/**
 *
 * @author student
 */
public class MySQLDataAccess implements IDataAccess{
     
    @Override
    public Connection GetConnection(){
       
        // Load the driver before creating connection
        LoadDriver();
        
        //Intialize connection object to null
        Connection conn = null;
      
        try{
            //Create the connection object from driver
            conn = DriverManager.getConnection(DataBaseConstants.MYSQL_URL, 
                                               DataBaseConstants.MYSQL_USERNAME,
                                               DataBaseConstants.MYSQL_PASSWORD);
            
        }
        catch(SQLException e) {
            
            System.err.println("SQL Error(s) as follows:");
            while (e != null) {
                    System.err.println("SQL Return Code: " + e.getSQLState());
                    System.err.println("  Error Message: " + e.getMessage());
                    System.err.println(" Vendor Message: " + e.getErrorCode());
                    e = e.getNextException();
            }	
            
        } 
        catch(Exception e) {
            System.err.println(e);
        }  
        return conn;
    }
    
    private void LoadDriver(){
        
     try {
            // LOAD Driver
            Class.forName(DataBaseConstants.MYSQL_DRIVER);
            System.out.println("You have loaded a driver!\n");
	} 
        catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException = " + DataBaseConstants.MYSQL_DRIVER);
            System.err.println(e.getMessage());
        }
    
    }
}
