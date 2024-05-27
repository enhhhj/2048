package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ReturnController {

    @FXML
    private Button Button_Return;

    private InterfaceController mainController;

    public void setMainController(InterfaceController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleButtonReturn() {
        Stage stage = (Stage) Button_Return.getScene().getWindow();
        stage.close();
    }
}
