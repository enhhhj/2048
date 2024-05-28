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
import src.main.java.model.Storage;

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

    private Storage storage = Storage.getInstance(); // 使用单例模式的Storage实例

    @FXML
    private void handleLogin() {
        String username = Input_username.getText();
        String password = Input_password.getText();
        String password2 = Imput_password2.getText();

        if (username.isEmpty() || password.isEmpty() || password2.isEmpty()) {
            showFXMLDialog("/Allfieldsarerequired.fxml", "Error");
            return;
        }

        if (!password.equals(password2)) {
            showFXMLDialog("/passworddontmatch.fxml", "Error");
            return;
        }

        if (storage.userExists(username)) {
            showFXMLDialog("/nameexists.fxml", "Error");
            return;
        }

        Information newUser = new Information(username, password);
        storage.addUser(newUser);
        showFXMLDialog("/Usersuccessfullyregister.fxml", "Success");
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
