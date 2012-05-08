/*
 *  Create ODBC connection using ODBC specifc connection details
 */
package ims.DataLayer.Common;
import java.sql.*;
/**
 *
 * @author student
 */
public class ODBCDataAccess implements IDataAccess {
    
    @Override
    public Connection GetConnection(){
       
        // Load the driver before creating connection
        LoadDriver();
        
        //Intialize connection object to null
        Connection conn = null;
      
        try{
            //Create the connection object from driver
            conn = DriverManager.getConnection(DataBaseConstants.ODBC_DATASOURCE, 
                                               DataBaseConstants.ODBC_USERNAME,
                                               DataBaseConstants.ODBC_PASSWORD);
            
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
        
     try{
            // LOAD Driver
            Class.forName(DataBaseConstants.ODBC_DATASOURCE);
            System.out.println("You have loaded a driver!\n");
	} 
        catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException = " + DataBaseConstants.ODBC_DRIVER);
            System.err.println(e.getMessage());
        }
    
    }
    
}
