package src.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.main.java.controller.InterfaceController;
import src.main.java.controller.RegisterController;
import src.main.java.model.Storage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Game1.fxml"));
            Parent root = loader.load();

          //  RegisterController controller = loader.getController();
         //  controller.setStorage(new Storage());

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Register");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
