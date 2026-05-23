package src.main.java.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
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
import javafx.util.Duration;
import src.main.java.model.GridNumber;
import src.main.java.model.Information;
import src.main.java.model.Storage;

import java.io.IOException;

public class inter3Controller extends InterfaceController {

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
    private Button Button_dis;

    @FXML
    private Button Button_withdraw;

    @FXML
    private Button Button_xiao;

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
    private ImageView Label_num04;

    @FXML
    private ImageView Label_num05;

    @FXML
    private ImageView Label_num10;

    @FXML
    private ImageView Label_num11;

    @FXML
    private ImageView Label_num12;

    @FXML
    private ImageView Label_num13;

    @FXML
    private ImageView Label_num14;

    @FXML
    private ImageView Label_num15;

    @FXML
    private ImageView Label_num20;

    @FXML
    private ImageView Label_num21;

    @FXML
    private ImageView Label_num22;

    @FXML
    private ImageView Label_num23;

    @FXML
    private ImageView Label_num24;

    @FXML
    private ImageView Label_num25;

    @FXML
    private ImageView Label_num30;

    @FXML
    private ImageView Label_num31;

    @FXML
    private ImageView Label_num32;

    @FXML
    private ImageView Label_num33;

    @FXML
    private ImageView Label_num34;

    @FXML
    private ImageView Label_num35;

    @FXML
    private ImageView Label_num40;

    @FXML
    private ImageView Label_num41;

    @FXML
    private ImageView Label_num42;

    @FXML
    private ImageView Label_num43;

    @FXML
    private ImageView Label_num44;

    @FXML
    private ImageView Label_num45;

    @FXML
    private ImageView Label_num50;

    @FXML
    private ImageView Label_num51;

    @FXML
    private ImageView Label_num52;

    @FXML
    private ImageView Label_num53;

    @FXML
    private ImageView Label_num54;

    @FXML
    private ImageView Label_num55;

    @FXML
    private Label Label_score;

    @FXML
    private Label Label_stepnum;
    private GridNumber grid;
    private ImageView[][] labels;
    private int steps;
    private int score;
    private Information user;

    public void setUser(Information user) {
        this.user = user;
        // 从用户数据中加载游戏状态
        loadGameState(user);
    }

    private void loadGameState(Information user) {
        // 从用户的游戏状态字符串中解析出游戏状态，并初始化 grid 对象
        String gameState = user.getGameState();
        if (gameState != null && !gameState.isEmpty()) {
            this.grid = GridNumber.fromString3(gameState);
        } else {
            this.grid = new GridNumber(6, 6);
        }
        updateGrid();
    }
    @FXML
    public void initialize() {
        labels = new ImageView[][]{
                {Label_num00, Label_num01, Label_num02, Label_num03, Label_num04, Label_num05},
                {Label_num10, Label_num11, Label_num12, Label_num13, Label_num14, Label_num15},
                {Label_num20, Label_num21, Label_num22, Label_num23, Label_num24, Label_num25},
                {Label_num30, Label_num31, Label_num32, Label_num33, Label_num34, Label_num35},
                {Label_num40, Label_num41, Label_num42, Label_num43, Label_num44, Label_num45},
                {Label_num50, Label_num51, Label_num52, Label_num53, Label_num54, Label_num55}
        };
        steps = 0;
        score = 0;

        // 初始化 grid 变量
        grid = new GridNumber(6, 6);
        updateGrid();
    }



    public void setGrid(GridNumber grid) {
        this.grid = grid;
        updateGrid();
    }



    public void updateGrid() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int number = (int) grid.getNumber(i, j);

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
        grid.moveLeft();
        updateGrid();

        if (grid.iffailure()) {
            showGameOverDialog();
        }
        if (grid.ifMove()) {
            showReturnDialog();
        }
        if (grid.ifsuccess()) {
            showGameSuccessDialog();
        }
    }

    @FXML
    private void handleButtonDown() {
        grid.moveRight();
        updateGrid();

        if (grid.iffailure()) {
            showGameOverDialog();
        }
        if (grid.ifMove()) {
            showReturnDialog();
        }
        if (grid.ifsuccess()) {
            showGameSuccessDialog();
        }
    }

    @FXML
    private void handleButtonLeft() {
        grid.moveUp();
        updateGrid();

        if (grid.iffailure()) {
            showGameOverDialog();
        }
        if (grid.ifMove()) {
            showReturnDialog();
        }
        if (grid.ifsuccess()) {
            showGameSuccessDialog();
        }
    }

    @FXML
    private void handleButtonRight() {
        grid.moveDown();
        updateGrid();

        if (grid.iffailure()) {
            showGameOverDialog();
        }
        if (grid.ifMove()) {
            showReturnDialog();
        }
        if (grid.ifsuccess()) {
            showGameSuccessDialog();
        }
    }
    @FXML
    private void handleButtonWithdraw() {
        grid.Withdraw();
        updateGrid();

    }
    @FXML
    private void handleButtonEnd() {
        // 更新用户的游戏状态
        user.updateGameState(grid);
        // 保存用户信息
        Storage.getInstance().updateUser(user);

        // 关闭游戏窗口
        Stage stage = (Stage) Button_End.getScene().getWindow();
        stage.close();
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
    private void addTranslateAnimation(ImageView cell, int row, int col) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(200), cell);
        transition.setToX( 4);
        transition.setToY(4);
        transition.play();
    }


    @FXML
    private void handleButtondis() throws IOException {
        if(grid.iftoolestimate2())
        {  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dis2.fxml"));
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("2048 Game");
            stage.setScene(new Scene(root));
            stage.show();

        }
        else {
            grid.dis2();
            updateGrid();

        }
    }

    public  void handleButtonxiao()  {
        if (grid.iftoolchangenumber()) {

            try {   FXMLLoader loader = new FXMLLoader(getClass().getResource("/dis2.fxml"));
                Parent root = loader.load();
                src.main.java.controller.dis2Controller controller = loader.getController();
                controller.setMainController(this); // 确保设置 mainController
                Stage stage = new Stage();
                stage.setTitle("游戏成功");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/xiao.fxml"));
                Parent root = loader.load();
                src.main.java.controller.xiaoController controller = loader.getController();
                controller.setMainController(this); // 确保设置 mainController
                Stage stage = new Stage();
                stage.setTitle("pick");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
