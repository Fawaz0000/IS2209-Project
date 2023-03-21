/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

/**
 *
 * @author mdalla
 */
import BusinessLogic.User;
import java.util.ArrayList;

public class DataAccess {
    //String variable Referencing the textfile for I/O
    String dataPersistenceLayer;
    ArrayList<User> storedUsers;

    //CONSTRUCTOR MEHTOD FOR DATAACCESS CLASS
    public DataAccess(){
        this.dataPersistenceLayer = "output.txt";
        this.storedUsers = new ArrayList<User>();
        this.loadUsersFromFile(this.dataPersistenceLayer);}
   

    //Create User method
    public void create(User input){
        this.storedUsers.add(input);
        //helper method to save changes from memory to file
        //this.saveUsersToFile(this.dataPersistenceLayer);

    }

    public void write(){
        this.saveUsersToFile(this.dataPersistenceLayer);
    }

    // Login User Method
    public boolean dologin(User input) {
        this.loadUsersFromFile(this.dataPersistenceLayer);
        boolean userP = false;
        for (int i = 0; i < this.storedUsers.size(); i++) {
            if (this.storedUsers.get(i).getEmail().equals(input.getEmail())) {
                if (this.storedUsers.get(i).getPassword().equals(input.getPassword())) {
                    userP = true;
                    break;
                }
            }
        }
        return userP;
    }

    private void loadUsersFromFile(String filename) {

        //create system nuetral reference to the I/O file
        java.io.File inFile = new java.io.File(filename);
        //domain object from bus logic layer
        User user= null;

        //try block to catch i/o exceptions
        try {
            //create new scanner
            java.util.Scanner input = new java.util.Scanner(inFile);

            while (input.hasNext()) {
                user = new User();
                String[] lineOfCsv = input.nextLine().split(","); //split contents of line
                //first element/ column = ID
                user.setName(lineOfCsv[0]);
                user.setEmail(lineOfCsv[1]);
                user.setPassword(lineOfCsv[2]);

                this.create(user);
            }
            input.close();
            //basic handlign exception
        } catch (java.io.IOException ex){
            System.out.println("Error reading file " + ex.toString());
        }
    }




    private void saveUsersToFile(String filename){
        java.io.File out = new java.io.File(filename);

        try{
            //create file to output text to using Printwriter
            java.io.PrintWriter output = new java.io.PrintWriter(out);
            for (int i=0; i < this.storedUsers.size(); i++){
                output.println(this.storedUsers.get(i).convertToCsv());
            }
            output.close();
        } catch (java.io.IOException ex){
            System.out.println("error writing to the file " + ex.toString());
        }
    }

}
