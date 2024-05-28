package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import src.main.java.model.Information;

public class GameController {

    @FXML
    private Label Label_username;

    @FXML
    private Label Label_highestscore;

    private Information user;

    public void setUser(Information user) {
        this.user = user;
        displayUserData();
    }

    private void displayUserData() {
        Label_username.setText(user.getName());
        Label_highestscore.setText(String.valueOf(user.getHighestscore()));
    }
}
