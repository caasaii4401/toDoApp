package com.rjgx.todoapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 袁欢
 * @Date: 2022/10/20/18:04
 * @website: https:g-7.net
 * @Description:
 * @version: 1.0
 */
public class SignupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signupUserName;

    @FXML
    private PasswordField signUpUsername;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {


    }
}
