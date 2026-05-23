package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Game1Controller {

    @FXML
    private AnchorPane AnchorPane_intro;

    @FXML
    private Button Button_best;

    @FXML
    private Button Button_fast;

    @FXML
    private Button Button_hell;

    @FXML
    private Button Button_normal;

    @FXML
    private Button Button_simple;
    @FXML
    private void handleButtonsimple() throws IOException {
        showFXMLDialog("/interface.fxml", "Simple");
    }

    private void showFXMLDialog(String fxmlFile, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleButtonnormal() throws IOException {
        showFXMLDialog("/inter2.fxml", "Normal");
    }

    @FXML
    private void handleButtonhell() throws IOException {
        showFXMLDialog("/inter3.fxml", "Hell");
    }

}
