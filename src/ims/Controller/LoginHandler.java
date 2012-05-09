/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.Controller;

import java.util.Arrays;

/**
 *
 * @author jdesulme
 */
public class LoginHandler {

    private String username;
    private String password;
    private String status;
    
    public LoginHandler(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private boolean isPasswordCorrect(char[] input ) {
        boolean isCorrect = true;
        
        char[] correctPass = this.password.toCharArray();
        
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
