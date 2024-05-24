package src.main.java.view;

import src.main.java.controller.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.ColorMap;

public class GameFrame extends Application {

    private GameController controller;
    private Button restartBtn;
    private Button loadBtn;
    private Label stepLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加载FXML文件
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interface.fxml"));
        AnchorPane root = loader.load();

        // 获取控制器
        GameController controller = loader.getController();

        // 初始化颜色映射
        ColorMap.InitialColorMap();

        // 设置界面元素
        stepLabel = new Label("Start");
        stepLabel.setFont(new javafx.scene.text.Font("Serif", 22));
        stepLabel.setLayoutX(480);
        stepLabel.setLayoutY(50);
        root.getChildren().add(stepLabel);

        restartBtn = new Button("Restart");
        restartBtn.setLayoutX(500);
        restartBtn.setLayoutY(150);
        restartBtn.setPrefSize(110, 50);
        root.getChildren().add(restartBtn);

        loadBtn = new Button("Load");
        loadBtn.setLayoutX(500);
        loadBtn.setLayoutY(220);
        loadBtn.setPrefSize(110, 50);
        root.getChildren().add(loadBtn);

        // 添加按钮事件
        restartBtn.setOnAction(e -> {
            controller.restartGame();
        });

        loadBtn.setOnAction(e -> {
            // 添加加载游戏逻辑
        });

        // 创建场景并显示
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2024 CS109 Project Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
