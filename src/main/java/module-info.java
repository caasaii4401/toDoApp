module com.rjgx.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.rjgx.todoapp to javafx.fxml;
    exports com.rjgx.todoapp;
    exports com.rjgx.todoapp.controller;
    opens com.rjgx.todoapp.controller to javafx.fxml;
}