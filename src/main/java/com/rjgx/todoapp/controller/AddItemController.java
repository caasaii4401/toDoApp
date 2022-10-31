package com.rjgx.todoapp.controller;

import com.rjgx.todoapp.animations.Shaker;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 袁欢
 * @Date: 2022/10/20/17:59
 * @website: https:g-7.net
 * @Description:
 * @version: 1.0
 */
public class AddItemController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addButton;
    @FXML
    private Label notTaskLabel;
    @FXML
    private AnchorPane rootPane;
    @FXML
    void f5f0f0(ActionEvent event) {

    }

    @FXML
    void initialize() {

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            Shaker buttonShaker=new Shaker(addButton);
            buttonShaker.shake();
            FadeTransition fadeTransition=new FadeTransition(Duration.millis(2000),addButton);
            FadeTransition labelTransition =new FadeTransition(Duration.millis(2000),notTaskLabel);
            //remove
            System.out.println("added clicked");
            addButton.relocate(0,20);
            notTaskLabel.relocate(0,45);
            addButton.setOpacity(0);
            notTaskLabel.setOpacity(0);
            fadeTransition.setFromValue(1F);
            fadeTransition.setToValue(0F);
            fadeTransition.setCycleCount(4);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();
            labelTransition.setFromValue(1f);
            labelTransition.setToValue(0f);
            labelTransition.setCycleCount(2);
            labelTransition.setAutoReverse(false);
            labelTransition.play();
            try {
                AnchorPane formPane= FXMLLoader.load(getClass().getResource("/com/rjgx/todoapp/addItemForm.fxml"));
                rootPane.getChildren().setAll(formPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
