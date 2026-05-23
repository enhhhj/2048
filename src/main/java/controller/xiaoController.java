package src.main.java.controller;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import src.main.java.model.GridNumber;
import src.main.java.model.Information;
import src.main.java.model.Storage;


import javafx.animation.TranslateTransition;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class xiaoController {

    @FXML
    private Button Button_Contince;

    @FXML
    private Label Label_X;

    @FXML
    private Label Label_Y;

    @FXML
    private TextField TextField_X;

    @FXML
    private TextField TextField_Y;
    private GridNumber grid;
    Stage primaryStage;

public void intui(){
    this.primaryStage=primaryStage;
    }

    private void handleButtonContince() {
        if(!grid.iftoolchangenumber()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/changenum.fxml"));
            try {
                Parent root = loader.load();
                Scene scene = new Scene(root);

                primaryStage.setScene(scene);
                primaryStage.setTitle("Register");
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

            else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/dis2.fxml"));
            try {
                Parent root = loader.load();
                Scene scene = new Scene(root);

                primaryStage.setScene(scene);
                primaryStage.setTitle("wrong");
                primaryStage.show();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void setMainController(InterfaceController interfaceController) {
    }
}
