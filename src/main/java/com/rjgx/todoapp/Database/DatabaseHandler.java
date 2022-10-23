package com.rjgx.todoapp.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 袁欢
 * @Date: 2022/10/23/18:12
 * @website: https:g-7.net
 * @Description:
 * @version: 1.0
 */
public class DatabaseHandler extends Confligs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString="jdbc:mysql//"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection= DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
}
