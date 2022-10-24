package com.rjgx.todoapp.controller;

import com.rjgx.todoapp.Database.DatabaseHandler;
import com.rjgx.todoapp.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
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
    private PasswordField signUpPassword;

    @FXML
    private CheckBox signUpCheckBoxFemale;
    @FXML
    private TextField signUpLocation;

    @FXML
    void initialize() {



        signUpButton.setOnAction(actionEvent -> {
            try {
                createUser();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });

    }
    private void createUser() throws SQLException, ClassNotFoundException {
        DatabaseHandler databaseHandler=new DatabaseHandler();
        String name=signupUserName.getText();
        String lastName=signUpLastName.getText();
        String userName=signupUserName.getText();
        String password=signUpPassword.getText();
        String location=signUpLocation.getText();
        String gender="";
        if(signUpCheckBoxFemale.isSelected()){
            gender="Female";
        }
        else{
            gender="Male";
        }
        User user=new User(name,lastName,userName,password,location,gender);

        databaseHandler.signUpUser(user);
    }
}
