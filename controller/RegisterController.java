package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.GameFrame;

import javax.swing.*;
import java.awt.*;

public class RegisterController {

    @FXML
    private JButton Button_register;

    @FXML
    private JLabel Label_password;

    @FXML
    private JLabel Label_username;

    @FXML
    private JPasswordField PasswordField_password;

    @FXML
    private JTextField TextField_username;





    public void RegisterController(JButton Button_register,JLabel Label_password,JLabel Label_username,JPasswordField PasswordField_password,JTextField TextField_username){

        this.Button_register=Button_register;
        this.Label_password=Label_password;
        this.Label_username=Label_username;
        this.PasswordField_password=PasswordField_password;
        this.TextField_username=TextField_username;

    }

}












