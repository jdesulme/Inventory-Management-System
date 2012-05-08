/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.DataLayer.Common;
import java.sql.Connection;
/**
 *
 * @author student
 */
public class DataBase {
    
    private Connection connection = null;
    
    public DataBase(ConnectionType connectionType){
        
        switch(connectionType){
            
            case ODBC:connection = new ODBCDataAccess().GetConnection();
            case MYSQL:connection = new MySQLDataAccess().GetConnection();        
        } 
     }
    
    public Connection getConnection(){
        return connection;
    }
    
}
