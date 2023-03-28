/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package UserInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import DataAccess.DataAccess;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import BusinessLogic.User;
import DataAccess.DataStore;
import static DataAccess.DataStore.getInstance;
import static Utils.IAuthorize.login;
import static Utils.IAuthorize.register;

public class FXMLDocumentController {

  DataStore dataAccess =  getInstance();

    @FXML
    private PasswordField pwlogPassword;

    @FXML
    private TextArea talogMessage;

    @FXML
    private TextArea taregMessage;

    @FXML
    private TextField tflogEmailAddress;

    @FXML
    private TextField tfregEmailAddress;

    @FXML
    private TextField tfregName;

    @FXML
    private PasswordField pwregPassword;

    @FXML
    void btnlogClear(ActionEvent event) {
        tflogEmailAddress.setText("");
        pwlogPassword.setText("");
        talogMessage.setText("");
    }

    @FXML
    void btnlogLogin(ActionEvent event) throws Exception {
        User userToCheck = new User();
        userToCheck.setEmail(tflogEmailAddress.getText());
        userToCheck.setPassword(pwlogPassword.getText());

        boolean userP = login(userToCheck);
        
        if (userP == true) {
            talogMessage.setText("...Logging In...");
            Stage stage = (Stage) (Stage)((Node) event.getSource()).getScene().getWindow();
            Parent root= FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.show();
        }
        else {
            talogMessage.setText("Incorrect Email or Password");
        }
    }

    @FXML
    void btnregClear(ActionEvent event) {
        tfregName.setText("");
        tfregEmailAddress.setText("");
        pwregPassword.setText("");
        taregMessage.setText("");
       

    }

    @FXML
    void btnregRegister(ActionEvent event) {
        User userToCreate = new User();
        userToCreate.setName(tfregName.getText());
        userToCreate.setEmail(tfregEmailAddress.getText());
        userToCreate.setPassword(pwregPassword.getText());

        if(register(userToCreate) == false){
            taregMessage.setText("User Already Exists");
            return;
        }

        taregMessage.setText("User Registered");

    }

}
