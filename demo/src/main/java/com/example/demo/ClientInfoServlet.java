package com.example.demo;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "/clientInfoServlet", value = "/client-info")
public class ClientInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html><head>");
        out.println("<title>客户端信息</title></head>");
        out.println("<body>");
        out.println("<table border=1 align='center'>");
        out.println("<tr><td>"+"请求方法"+"</td>");
        out.println("<td>"+request.getMethod()+"</td></tr>");
        out.println("<tr><td>"+"请求URI"+"</td>");
        out.println("<td>"+request.getRequestURI()+"</td></tr>");
        out.println("<tr><td>"+"协议"+"</td>");
        out.println("<td>"+request.getProtocol()+"</td></tr>");
        out.println("<tr><td>上下文路径</td>");
        out.println("<td>"+request.getContextPath()+"</td></tr>");
        out.println("<tr><td>客户主机名</td>");
        out.println("<td>"+request.getRemoteHost()+"</td></tr>");
        out.println("<tr><td>客户IP地址</td>");
        out.println("<td>"+request.getRemoteAddr()+"</td></tr>");
        out.println("<tr><td>端口号：");
        out.println("<td>"+request.getRemotePort()+"</td></tr>");
        out.println("</table>");
        out.println("<body></html>");

    }


}



