//package BusinessLogic;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
////create all the necessary boilerplate code for an ecommerce website.
//// The group project provides students with the opportunity to apply their knowledge of Java and object-oriented programming to an application/domain problem of interest. The following sections outline the project and technical requirements that students must incorporate within their applications, and the grades being awarded for each component of the project.
//// BRIEF:
//// One of Ireland’s leading shop chains has selected your group to design and develop a platform for ordering clothes online.
//// Your group is tasked with designing and developing a Java-based information system to order clothes online. The application will consist of:
//// Portal for users
//// ●	Users can register and store all the relevant information (name, address, credit card information, phone number, shoe size,...).
//// ●	Users can browse and order clothes through a self-service portal that they can access from the application.
//// ●	Users can customise their clothes, selecting size and colours.
//// ●	Users can specify with what method they prefer to pay.
//// ●	Users can view previous and upcoming orders and cancel unwanted orders.
//// ●	Users can contact help in case of a problem with the order. 
//// Portal for management
//// ●	Retrieve, update, delete info about registered users.
//// ●	Add, retrieve, update, delete info about  clothes currently sold.
//// PROJECT REQUIREMENTS
//// ●	Trello must be used to document/manage the project lifecycle.
//// ●	ONE user story must be identified and implemented for the proposed application.
//// ●	Java and object-oriented programming must be used to develop the application.
//// ●	JavaFX must be used to deliver the application GUI.
//// ●	Each application must incorporate the following:
//// 1.Design a user-friendly GUI for the application.
//// 2.Bind application data to GUI controls.
//// 3.Create and save new USER records to a file.
//// 4.Identify and implement business logic (e.g., IF statements) that is needed to maintain the integrity of the application.
//// ●	Short technical report/summary accompanying submission:
//// 1.	Brief description of how requirements 1 to 7 (above) were met, including screenshots of the application GUI .
//// 2.	Brief description of how you used your Trello boards with screen shots of the boards.
//// 3.	Brief reflection on what might be done differently.
//// For this assignment, your focus should be on the design of the Application’s overall GUI and the development of the business logic and I/O operations. Data persistence should be limited to a USER only.
//// strat here
//// https://www.youtube.com/watch?v=QX4mJg6Yg9A
////HERE IS THE CODE FOR THe business logic layer
//// Path: src\BusinessLogic\Shared Logic File.java
//// crteate a user class
//// Path: src\BusinessLogic\User.java
//// package BusinessLogic;
//class User {
//
//    private String name;
//    private String email;
//    private String password;
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//
//    }
//
//    public String getEmail() {
//        return this.email;
//
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//
//    }
//
//    public User(String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
//
//    public User() {
//    }
//
//    // instance method that returns CSV OF THE ObJECT
//    public String convertToCsv() {
//        //allow for exceptions where the fields contain a comma or a speech mark
//        String retVAl;
//        retVAl = this.getName() + "," + this.getEmail() + "," + this.getPassword();
//        return retVAl;
//    }
//
//    //to string
//    @Override
//    public String toString() {
//        return "User{" + "name=" + name + ", email=" + email + ", password=" + password + '}';
//    }
//
//    //to sql
//    public String toSql() {
//        return "INSERT INTO users (name, email, password) VALUES ('" + this.getName() + "', '" + this.getEmail() + "', '" + this.getPassword() + "');";
//    }
//
//}
//
//// Path: src\BusinessLogic\Shared Logic File.java
//// create a user manager class
//// Path: src\BusinessLogic\UserManager.java
//// package BusinessLogic;
//// import java.io.BufferedReader;
//// import java.io.BufferedWriter;
//// import java.io.File;
//// import java.io.FileNotFoundException;
//// import java.io.FileReader;
//// import java.io.FileWriter;
//// import java.io.IOException;
//// import java.util.ArrayList;
//// import java.util.List;
//// import java.util.logging.Level;
//// import java.util.logging.Logger;
//class UserManager {
//
//    //create a list of users
//    private List<User> users;
//
//    //create an instance of usermanager
//    private static UserManager instance;
//
//    //create a constructor
//    public UserManager() {
//        this.users = new ArrayList<>();
//    }
//
//    //create a static method to get the instance of user manager
//    public static UserManager getInstance() {
//        if (instance == null) {
//            instance = new UserManager();
//        }
//
//        return instance;
//    }
//
//    //create a method to get the users
//    public List<User> getUsers() {
//        return this.users;
//
//    }
//
//    //create a method to set the users
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    //create a method to add a user
//    public void addUser(User user) {
//        this.users.add(user);
//    }
//
//    //create a method to remove a user
//    public void removeUser(User user) {
//        this.users.remove(user);
//    }
//
//}
//
////create a method to save the users to a file
////the file is in csv format
////Path: src\BusinessLogic\FileUtils.java
////package BusinessLogic;
////import java.io.BufferedWriter;
////import java.io.File;
////import java.io.FileWriter;
////import java.io.IOException;
////import java.util.List;
////import java.util.logging.Level;
////import java.util.logging.Logger;
//class InputOutput<T> {
//
//    // Declare a private field to store the file path
//    private String filePath;
//
//    // Define a constructor that takes the file path as an argument
//    public InputOutput(String filePath) {
//        this.filePath = filePath;
//    }
//
//    // Define a method that takes a data object as an argument and saves it to the file
//    public void save(T data) throws IOException {
//        // Extract data from fields and write to CSV file
//        FileWriter writer = new FileWriter(filePath, true);
//
//        writer.append(data.convertToCsv());
//        writer.append("\n");
//
//        writer.flush();
//        writer.close();
//    }
//}
//// UtilFunctions.java
//// package BusinessLogic;
//// import java.io.BufferedReader;
//// interface UtilFunctions {
////     // Define a method that takes a string as input and returns a csv string
////     public static String stringToCsv(String string) {
////         // Initialize an empty StringBuilder to store the csv values
////         StringBuilder csvValues = new StringBuilder();
////         // Split the string by whitespace and loop through each word
////         for (String word : string.split(" ")) {
////             // Check if the word contains a comma or a speech mark
////             if (word.contains(",") || word.contains("\"")) {
////                 // If so, enclose the word in double quotes and escape any existing double quotes with another double quote
////                 word = "\"" + word.replace("\"", "\"\"") + "\"";
////             }
////             // Append the word to the csv values with a comma separator
////             csvValues.append(word).append(",");
////         }
////         // Remove the last comma and return the result
////         return csvValues.substring(0, csvValues.length() - 1);
////     }
//
//// }
