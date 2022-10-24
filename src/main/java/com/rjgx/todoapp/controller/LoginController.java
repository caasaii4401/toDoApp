package com.rjgx.todoapp.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.rjgx.todoapp.Database.DatabaseHandler;
import com.rjgx.todoapp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginUsername;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginSignupButton;
@FXML
   private DatabaseHandler databaseHandler;

    @FXML
    void initialize() {
        String loginText=loginUsername.getText().trim();
        String loginPwd=loginPassword.getText().trim();
        User user=new User();
        user.setUserName(loginText);
        user.setPassword(loginPwd);
        loginButton.setOnAction(actionEvent -> {
            ResultSet userRow=databaseHandler.getUser(user);
            int counter=0;
            try {
                while(userRow.next()){
                    counter++;
                }
                if(counter==1){
                    System.out.println("Login Successful");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        loginSignupButton.setOnAction(actionEvent -> {
            //take users to signup screen
           loginSignupButton.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/rjgx/todoapp/signup.fxml"));
            try{
                loader.load();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Parent root =loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });


    }

    private void loginUser(String userName,String userPassword) {
       //Check in the database if the user exits,if true
       //we take them to addItem
        if(!userName.equals("")||!userPassword.equals("")){

        }
        else{
            //they need to en
        }
    }
}
