package com.example.demo1.boda.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Util {
    //通过标识名来创建相应连接池
    private static DataSource dataSource = new ComboPooledDataSource("mysql");
    //创建连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败");
        }
    }
    //释放连接
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            resultSet = null;
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            statement = null;
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            connection=null;
        }

    }
}
