package com.rjgx.todoapp.utilsTest;

import com.rjgx.todoapp.utils.DbUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 袁欢
 * @Date: 2022/10/21/22:07
 * @website: https:g-7.net
 * @Description:
 * @version: 1.0
 */
public class DbUtilTest {
    public DbUtilTest() {
    }

    public static void main(String[] args) throws SQLException {
        Connection con = DbUtil.getConnection();
        System.out.println(con);
    }
}

