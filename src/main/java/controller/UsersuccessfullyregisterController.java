package src.main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UsersuccessfullyregisterController {

    @FXML
    private Button Button_return;

    @FXML
    void handleButtonReturn(ActionEvent event) {
        // 关闭当前窗口
        Stage stage = (Stage) Button_return.getScene().getWindow();
        stage.close();
    }

}
