/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.Controller;

import ims.DataLayer.*;
import ims.Model.Login;
import ims.UI.FrontPage;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jdesulme
 */
public class LoginHandler {
    private String dbUser; 
    private String dbPass;
    private String dbAccessType;
    
    public LoginHandler(String inUsername, char[] inPassword) {
        DataAccess dataAccess  = new DataAccess();
        
        ArrayList<Login> loginList = dataAccess.GetLogin(inUsername);
        
        for (Login login : loginList) {
            dbUser = login.getUsername();
            dbPass = login.getPassword();
            dbAccessType = login.getAccessType();
        }
      
        if( isPasswordCorrect(inPassword) ){
            FrontPage main = new FrontPage(dbAccessType);
            main.setVisible(true);
            System.out.println("all good");
           
        } else {
            JOptionPane.showMessageDialog(null, 
                "The password is incorrect please try again",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private boolean isPasswordCorrect(char[] input ) {
        boolean isCorrect;
        
        char[] correctPass = this.dbPass.toCharArray();
        
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
