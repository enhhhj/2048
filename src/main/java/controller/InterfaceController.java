package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import src.main.java.model.GridNumber;

public class InterfaceController {

    @FXML
    private AnchorPane AnchorPane_score;

    @FXML
    private AnchorPane AnchorPane_stepnum;

    @FXML
    private Button Button_Down;

    @FXML
    private Button Button_End;

    @FXML
    private Button Button_Left;

    @FXML
    private Button Button_Right;

    @FXML
    private Button Button_Up;

    @FXML
    private Button Button_withdraw;

    @FXML
    private GridPane GridPane_numbers;

    @FXML
    private Label Label_num00;

    @FXML
    private Label Label_num01;

    @FXML
    private Label Label_num02;

    @FXML
    private Label Label_num03;

    @FXML
    private Label Label_num10;

    @FXML
    private Label Label_num11;

    @FXML
    private Label Label_num12;

    @FXML
    private Label Label_num13;

    @FXML
    private Label Label_num20;

    @FXML
    private Label Label_num21;

    @FXML
    private Label Label_num22;

    @FXML
    private Label Label_num23;

    @FXML
    private Label Label_num30;

    @FXML
    private Label Label_num31;

    @FXML
    private Label Label_num32;

    @FXML
    private Label Label_num33;

    @FXML
    private Label Label_score;

    @FXML
    private Label Label_score1;

    @FXML
    private Label Label_scorenum1;

    @FXML
    private Label Label_stepnum;

    private GridNumber grid;
    private Label[][] labels;
    private int steps;
    private int score;

    @FXML
    public void initialize() {
        labels = new Label[][] {
                { Label_num00, Label_num01, Label_num02, Label_num03 },
                { Label_num10, Label_num11, Label_num12, Label_num13 },
                { Label_num20, Label_num21, Label_num22, Label_num23 },
                { Label_num30, Label_num31, Label_num32, Label_num33 }
        };
        steps = 0;
        score = 0;

        // 初始化 grid 变量
        grid = new GridNumber(4, 4);
        updateGrid();
    }

    public void setGrid(GridNumber grid) {
        this.grid = grid;
        updateGrid();
    }

    public void setSizes(){

    }
    public void updateGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = grid.getNumber(i, j);
                labels[i][j].setText(number == 0 ? "" : String.valueOf(number));
            }
        }
        Label_stepnum.setText(String.valueOf(steps));
        Label_score.setText(String.valueOf(score));
    }

    @FXML
    private void handleButtonUp() {
        grid.moveUp();

        updateGrid();
    }

    @FXML
    private void handleButtonDown() {
        grid.moveDown();

        updateGrid();
    }

    @FXML
    private void handleButtonLeft() {
        grid.moveLeft();

        updateGrid();
    }

    @FXML
    private void handleButtonRight() {
        grid.moveRight();

        updateGrid();
    }

    @FXML
    private void handleButtonWithdraw() {
        // 撤回上一步的逻辑
        // 需要你根据你的实际逻辑来实现
    }

    @FXML
    private void handleButtonEnd() {
        // 结束游戏的逻辑
        // 需要你根据你的实际逻辑来实现
    }
}
