package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class GamefailController {

    @FXML
    private Button Button_onemore;

    private InterfaceController mainController;

    public void setMainController(InterfaceController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleButtonOnemore() {
        mainController.resetGame();
        Stage stage = (Stage) Button_onemore.getScene().getWindow();
        stage.close();
    }
}
