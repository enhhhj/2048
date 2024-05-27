package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.java.model.Information;

public class LoginSceneController {

    @FXML
    private Button Button_login;

    @FXML
    private TextField Imput_password2;

    @FXML
    private TextField Input_password;

    @FXML
    private TextField Input_username;

    @FXML
    private Label Label_password;

    @FXML
    private Label Label_password2;

    @FXML
    private Label Label_username;

    @FXML
    private void handleLogin() {
        String username = Input_username.getText();
        String password = Input_password.getText();
        String password2 = Imput_password2.getText();

        if (username.isEmpty() || password.isEmpty() || password2.isEmpty()) {
            showFXMLDialog("/Allfieldsarerequired.fxml", "Error");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Allfieldsarerequired.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) Button_login.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        if (!password.equals(password2)) {
            showFXMLDialog("/passworddontmatch.fxml", "Error");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/passworddontmatch.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) Button_login.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        if (Information.userExists(username)) {
            showFXMLDialog("/nameexists.fxml", "Error");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/nameexists.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) Button_login.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        // Create new user and add to the list
        Information newUser = new Information(username, password);
        Information.addUser(newUser);
        showFXMLDialog("/Usersuccessfullyregister.fxml", "Success");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Usersuccessfullyregister.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) Button_login.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
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



}
