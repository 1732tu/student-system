package com.example.demo2.dao;

import com.example.demo2.entity.Admin;
import com.example.demo2.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

    public Admin getByUsername(String username){
        JdbcHelper helper = new JdbcHelper();
        ResultSet resultSet = helper.executeQuery("select * from tb_admin where username = ?", username);
        try {
            if(resultSet.next()){
                Admin admin = new Admin();
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
                return admin;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            helper.closeDB();
        }
        return null;
    }

}
