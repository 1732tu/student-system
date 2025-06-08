package com.example.demo3.service;


import com.example.demo3.dao.AdminDao;
import com.example.demo3.entity.Admin;

public class AdminService {

    AdminDao adminDao = new AdminDao();

    public Admin getByUsername(String username){
        return adminDao.getByUsername(username);
    }

}
