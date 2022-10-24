package com.rjgx.todoapp.Database;

import com.rjgx.todoapp.model.User;

import java.sql.*;

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
        String connectionString="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        //String connectionString="jdbc:mysql://150.136.110.124:3306/todo";
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection= DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    //write
    public void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insert="Insert into "+Const.USERS_TABLE+"("+Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME+","+Const.USERS_USERNAME+","
                +Const.USERS_PASSWORD+","+Const.USERS_LOCATION+","+Const.USERS_GENDER+")"+"values(?,?,?,?,?,?)";
        /*String insert="insert into users(firsname,lastname,username,password,location,gender)" +
                "values (,,,,,,)";*/
        PreparedStatement preparedStatement= getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1,user.getFirstName());
        preparedStatement.setString(2,user.getLastName());
        preparedStatement.setString(3,user.getUserName());
        preparedStatement.setString(4,user.getPassword());
        preparedStatement.setString(5,user.getLocation());
        preparedStatement.setString(6,user.getGender());
        preparedStatement.executeUpdate();
    }
    public ResultSet getUser(User user) {
        ResultSet resultSet=null;
        if (!user.getUserName().equals("") || !user.getPassword().equals("")) {
            String query = "SELECT * FROM" + Const.USERS_TABLE + "WHERE" + Const.USERS_USERNAME + "=?"
                    + "AND" + Const.USERS_PASSWORD + "=?";
            //select all from users where username="paulo" and password="password";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());
                resultSet=preparedStatement.executeQuery();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("please enter your credentials");

        }

        return resultSet;
    }}
