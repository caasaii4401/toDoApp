package com.rjgx.todoapp.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;



/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 袁欢
 * @Date: 2022/10/29/23:01
 * @website: https:g-7.net
 * @Description:
 * @version: 1.0
 */
public class Shaker {
    private TranslateTransition translateTransition;

    public Shaker(Node node) {
        translateTransition=new TranslateTransition(Duration.millis(50), (javafx.scene.Node) node);
        translateTransition.setFromX(0f);
        translateTransition.setByX(10f);
        translateTransition.setByY(23f);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);

    }
    public void shake(){
        translateTransition.playFromStart();

    }
}
