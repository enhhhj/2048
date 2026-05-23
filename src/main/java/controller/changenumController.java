package src.main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.java.model.GridNumber;

import java.io.IOException;

public class changenumController extends InterfaceController {

    @FXML
    private Button Button_confirm;

    @FXML
    private Label Label_changenum;

    @FXML
    private TextField TextField_change;
    private GridNumber grid;

    @FXML
    void handleButtonconfirm(ActionEvent event) {
        int a= Integer.parseInt(Label_changenum.getText());
        grid.setchangenumber(a);
       if(!grid.dotoolchangenumber())
       {

           try { FXMLLoader loader = new FXMLLoader(getClass().getResource("/changedis.fxml"));
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
       }
       else{
            grid.change();
       }
    }

}
