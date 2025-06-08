package com.example.demo2.service;


import com.example.demo2.dao.AdminDao;
import com.example.demo2.entity.Admin;

public class AdminService {

    AdminDao adminDao = new AdminDao();

    public Admin getByUsername(String username){
        return adminDao.getByUsername(username);
    }

}
