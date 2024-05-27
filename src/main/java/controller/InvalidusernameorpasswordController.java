package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InvalidusernameorpasswordController {

    @FXML
    private Button Button_return;

    @FXML
    private void handleButtonReturn() {
        // 关闭当前窗口
        Stage stage = (Stage) Button_return.getScene().getWindow();
        stage.close();
    }
}
