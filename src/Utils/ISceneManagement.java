package Utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public interface ISceneManagement {

    public static void switchScene(String fxmlFileName, Node node) throws IOException {
        Parent root = FXMLLoader.load(Class.class.getClassLoader().getResource(fxmlFileName));
        Scene scene = new Scene(root);
        Stage stage = (Stage) (node.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    public static void switchScene(String fxmlFileName) throws IOException {
        Parent root = FXMLLoader.load(Class.class.getClassLoader().getResource(fxmlFileName));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
