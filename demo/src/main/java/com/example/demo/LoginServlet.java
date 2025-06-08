package com.example.demo;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "loginServlet", value = {"/user-servlet"})
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        out.println("<DOCTYPE html>");
        out.println("<html><head><title>用户登录</title>");
        out.println("</head><body>");
        if("admin".equals(username)&&"123456".equals(password)){
            out.println("登录成功！欢迎您，"+username);
        }else {
            out.println("对不起，您的用户名或密码不正确。");
        }

        out.println("</body></html>");
    }


}


