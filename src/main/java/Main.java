
package src.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/interface.fxml"));
            primaryStage.setTitle("2048");
            primaryStage.setScene(new Scene(root, 731, 431));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public static void main(String[] args) {
    // 启动JavaFX应用程序
    launch(args);
}
}
