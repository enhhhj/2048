package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.java.model.Information;
import src.main.java.model.Storage;

import java.net.URL;

public class RegisterController {

    @FXML
    private Button Button_register;

    @FXML
    private Button Button_login;

    @FXML
    private Label Label_password;

    @FXML
    private Label Label_username;

    @FXML
    private PasswordField PasswordField_password;

    @FXML
    private TextField TextField_username;

    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @FXML
    private void handleButtonLogin() {
        String username = TextField_username.getText();
        String password = PasswordField_password.getText();

        Information user = storage.findUser(username);
        if (storage.ifGetIn(username,password)) {
            // 登录成功
            System.out.println("Login successful");
            // 关闭登录窗口并打开主游戏界面
            user = storage.findUser(username);
            showGameScene(user);
            Stage stage = (Stage) Button_login.getScene().getWindow();
            stage.close();

        } else {
            // 显示错误消息窗口
            showInvalidUsernameOrPasswordDialog();
        }
    }
    private void showGameScene(Information user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interface.fxml"));
            Parent root = fxmlLoader.load();

            // 获取控制器实例
            InterfaceController gameController = fxmlLoader.getController();
            gameController.setUser(user);

            Stage stage = new Stage();
            stage.setTitle("2048 Game");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleButtonRegister() {

        // 打开注册界面
        openLoginScene();
    }

    private void openGameScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interface.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("2048 Game");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openLoginScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/LoginScene.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showInvalidUsernameOrPasswordDialog() {
        try {
            URL resource = getClass().getResource("/Invaliusernameorpassword.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(resource);
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
