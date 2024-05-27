package src.main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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
    private ImageView Label_num00;

    @FXML
    private ImageView Label_num01;

    @FXML
    private ImageView Label_num02;

    @FXML
    private ImageView Label_num03;

    @FXML
    private ImageView Label_num10;

    @FXML
    private ImageView Label_num11;

    @FXML
    private ImageView Label_num12;

    @FXML
    private ImageView Label_num13;

    @FXML
    private ImageView Label_num20;

    @FXML
    private ImageView Label_num21;

    @FXML
    private ImageView Label_num22;

    @FXML
    private ImageView Label_num23;

    @FXML
    private ImageView Label_num30;

    @FXML
    private ImageView Label_num31;

    @FXML
    private ImageView Label_num32;

    @FXML
    private ImageView Label_num33;

    @FXML
    private Label Label_score;

    @FXML
    private Label Label_score1;

    @FXML
    private Label Label_scorenum1;

    @FXML
    private Label Label_stepnum;

    private GridNumber grid;
    private ImageView[][] labels;
    private int steps;
    private int score;

    @FXML
    public void initialize() {
        labels = new ImageView[][] {
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
    public static double logBase2(int x) {
        return Math.log(x) / Math.log(2);
    }

    public void updateGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = (int) grid.getNumber(i, j);
                double logBase2 = logBase2(number);
                if (number == 0) {
                    labels[i][j].setImage(null);
                } else {
                    labels[i][j].setImage(new Image(getClass().getResourceAsStream("/images/" + number + ".png")));
                }
            }
        }
        Label_stepnum.setText(String.valueOf(grid.getSteps()));
        Label_score.setText(String.valueOf(grid.getScores()));
    }

    @FXML
    private void handleButtonUp() {
        grid.moveUp();

        updateGrid();

        if(grid.iffailure()){
            showGameOverDialog();}
            if(grid.ifMove())
            {
                showReturnDialog();
            }
        if(grid.ifsuccess()){
            showGameSuccessDialog();
        }
    }

    @FXML
    private void handleButtonDown() {
        grid.moveDown();

        updateGrid();

        if(grid.iffailure()){
            showGameOverDialog();
        }
        if(grid.ifMove())
        {
            showReturnDialog();
        }
        if(grid.ifsuccess()){
            showGameSuccessDialog();
        }
    }

    @FXML
    private void handleButtonLeft() {
        grid.moveLeft();
        updateGrid();
        if(grid.iffailure()){
            showGameOverDialog();
        }
        if(grid.ifMove())
        {
            showReturnDialog();
        }
        if(grid.ifsuccess()){
            showGameSuccessDialog();
        }}

    @FXML
    private void handleButtonRight() {
        grid.moveRight();
        updateGrid();
        if(grid.iffailure()){
            showGameOverDialog();
        }
       if(grid.ifMove())
        {
            showReturnDialog();
        }
        if(grid.ifsuccess()){
            showGameSuccessDialog();
        }
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

    public void resetGame() {
        System.out.println("Resetting game...");
        grid = new GridNumber(4, 4);
        steps = 0;
        score = 0;
        updateGrid();

    }

    private void showGameOverDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Gamefail.fxml"));
            Parent root = fxmlLoader.load();
            GamefailController controller = fxmlLoader.getController();
            controller.setMainController(this); // 确保设置 mainController
            Stage stage = new Stage();
            stage.setTitle("游戏失败");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   private void showReturnDialog() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Return.fxml"));
            Parent root = fxmlLoader.load();
            ReturnController controller = fxmlLoader.getController();
            controller.setMainController(this);
            Stage stage = new Stage();
            stage.setTitle("方向错啦");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showGameSuccessDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GameSuccess.fxml"));
            Parent root = fxmlLoader.load();
            GamefailController controller = fxmlLoader.getController();
            controller.setMainController(this); // 确保设置 mainController
            Stage stage = new Stage();
            stage.setTitle("游戏成功");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}