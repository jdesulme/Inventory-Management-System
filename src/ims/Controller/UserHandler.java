/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.Controller;

import ims.DataLayer.DataAccess;
import ims.Model.Login;
import java.util.ArrayList;

/**
 *
 * @author Jean
 */
public class UserHandler {
    DataAccess dataAccess  = new DataAccess();
    
    public UserHandler() {
        dataAccess.CreateProcedure();
    }
    
    public ArrayList<Login> getData() {
        
        
        ArrayList<Login> userList = dataAccess.GetLogin();
    
        return userList;
        
    }
}
