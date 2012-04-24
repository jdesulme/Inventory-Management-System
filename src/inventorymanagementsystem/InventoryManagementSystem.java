/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import ims.UI.FrontPage;
import ims.UI.Login;
/**
 *
 * @author kumar
 */
public class InventoryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login login = new Login();
        login.setVisible(true);
        login.setUI(null);
        System.out.println("hello");
        
        FrontPage frontPage = new FrontPage();
        frontPage.setVisible(true);
    }
}
