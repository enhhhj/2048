
package src.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加载FXML文件
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interface.fxml"));
        // 从FXML文件中加载AnchorPane
        AnchorPane root = loader.load();
        // 创建一个新的场景，并将根节点设置为AnchorPane
        Scene scene = new Scene(root);
        // 设置主舞台的场景
        primaryStage.setScene(scene);
        // 设置窗口标题
        primaryStage.setTitle("2048 Game");
        // 显示窗口
        primaryStage.show();
    }

    public static void main(String[] args) {
        // 启动JavaFX应用程序
        launch(args);
    }
}
