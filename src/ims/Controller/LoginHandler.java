/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.Controller;

import ims.DataLayer.*;
import ims.Model.Login;
import ims.UI.FrontPage;
import ims.UI.PizzaOrder;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jdesulme
 */
public class LoginHandler {
    public String dbUser; 
    private String dbPass;
    private String dbAccessType;
    private boolean loginPanel = false;
    
    public LoginHandler(String inUsername, char[] inPassword) {
        DataAccess dataAccess  = new DataAccess();
        
        ArrayList<Login> loginList = dataAccess.GetLogin(inUsername);
        
        for (Login login : loginList) {
            dbUser = login.getUsername();
            dbPass = login.getPassword();
            dbAccessType = login.getAccessType();
        }
      
        if( isPasswordCorrect(inPassword) ){
              /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

            FrontPage main = new FrontPage(dbAccessType);
            main.setVisible(true);
            loginPanel = true;
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
    
    public boolean isSuccessful(){
        return loginPanel;
    }
}
