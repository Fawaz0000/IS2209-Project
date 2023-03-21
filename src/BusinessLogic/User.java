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

    // instance method that returns CSV OF THE ObJECT
    public String convertToCsv() {
        return this.getName()
                + "," + this.getEmail()
                + "," + this.getPassword();
    }

    // use special chars to save commas in the csv file
    public String convertToCsvWithSpecialChars() {
        return this.getName().replace(",", "||")
                + "," + this.getEmail().replace(",", "||")
                + "," + this.getPassword().replace(",", "||");
    }

    //to string
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", password=" + password + '}';
    }

    //to sql
    public String toSql() {
        return "INSERT INTO users (name, email, password) VALUES ('" + this.getName() + "', '" + this.getEmail() + "', '" + this.getPassword() + "');";
    }

    //create an online shopping system
}// i added this comment just to see
