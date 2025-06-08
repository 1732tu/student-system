package com.example.demo;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "loginServlet", value = "/user-login")
public class LoginServlet_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
//用户名和密码正确，登录成功
        RequestDispatcher rd=null;
        if(username.equals("admin")&&password.equals("12356")){
            request.setAttribute("username",username);
            rd=request.getRequestDispatcher("/welcome.jsp");
        }else {
            rd=request.getRequestDispatcher("/error.jsp");

        }
        rd.forward(request,response);

    }


}

