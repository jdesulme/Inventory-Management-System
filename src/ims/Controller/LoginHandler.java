/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.Controller;

import ims.DataLayer.*;
import ims.Model.Login;
import java.util.*;

/**
 *
 * @author jdesulme
 */
public class LoginHandler {
    private String user; 
    private String pass;
    private String accessType;
    
    public LoginHandler(String inUsername, char[] inPassword) {
        DataAccess dataAccess  = new DataAccess();
        
        ArrayList<Login> loginList = new ArrayList<Login>();
        loginList = dataAccess.GetLogin(inUsername);
        
        for (Login login : loginList) {
            user = login.getUsername();
            pass = login.getPassword();
            accessType = login.getAccessType();
        }
         
        if( isPasswordCorrect(inPassword) ){
            //redirect the to the correct correct screen
        }
         
    }

    //process login information and redirect to the correct screen
    
    
    private boolean isPasswordCorrect(char[] input ) {
        boolean isCorrect = true;
        
        char[] correctPass = this.pass.toCharArray();
        
        if( input.length != correctPass.length ) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals(input, correctPass);
        }
        
        //clears the array
        Arrays.fill(correctPass,'0');
        
        return isCorrect;
    }
    
    
}
