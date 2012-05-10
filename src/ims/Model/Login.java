/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.Model;

/**
 *
 * @author Jean
 */
public class Login {
    private int id;
    private String username;
    private String password;
    private String accessType;

    public Login(){
        this.username = "";
        this.password = "";
        this.accessType = "";
    }
    
    public Login(int id, String username, String password, String accessType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accessType = accessType;
    }
    
    public Login(String username, String password, String accessType) {
        this.username = username;
        this.password = password;
        this.accessType = accessType;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

}
