package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameSuccessController {

    @FXML
    private Button Button_Onemoregame;
    private InterfaceController mainController;

    public void setMainController(InterfaceController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleButtonOnemoregame() {
        mainController.resetGame();
        Stage stage = (Stage) Button_Onemoregame.getScene().getWindow();
        stage.close();
    }

}
