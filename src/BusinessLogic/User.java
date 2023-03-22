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

    private String name;
    private String email;
    private String password;
    private Size shoeSize;
    private Size shirtSize;
    private Size pantSize;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;

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
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public Size getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(String size) {
        this.shoeSize = new Size(size);
    }

    public void setShoeSize(Size shoeSize) {
        this.shoeSize = shoeSize;
    }

    public Size getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(String size) {
        this.shirtSize = new Size(size);
    }

    public void setShirtSize(Size shirtSize) {
        this.shirtSize = shirtSize;
    }

    public Size getPantSize() {
        return pantSize;
    }
    
    public void setPantSize(String size) {
        this.pantSize = new Size(size); 
    }

    public void setPantSize(Size pantSize) {
        this.pantSize = pantSize;
    }

 }