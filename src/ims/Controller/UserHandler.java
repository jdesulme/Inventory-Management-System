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

    public UserHandler() {
        
    }
    
    public ArrayList<Login> getData() {
        DataAccess dataAccess  = new DataAccess();
        
        ArrayList<Login> userList = dataAccess.GetLogin();
    
        return userList;
        
    }
}
