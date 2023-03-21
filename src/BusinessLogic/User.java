/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

/**
 *
 * @author mdalla
 */
public class User {
    private String lastname;

    private String email;
    private String password;

    public String getName() {
        return this.lastname;
    }

    public void setName(String name) {
        this.lastname = name;

    }

    public String getEmail() {
        return this.email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public User(String name, String email, String password) {
        this.lastname = name;
        this.email = email;
        this.password = password;
    }
    
    public User() {
    }

    // instance method that returns CSV OF THE ObJECT
    public String convertToCsv() {
        return this.getName()
                + "," + this.getEmail()
                + "," + this.getPassword();
    }

}// i added this comment just to see