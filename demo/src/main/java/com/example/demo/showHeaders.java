package com.example.demo;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.util.Enumeration;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "/showHeaders", value = "/show-headers")
public class showHeaders extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>请求头信息</title></head>");
        out.println("<body><p>服务器收到的请求头信息</title></head>");

        Enumeration<String>headers=request.getHeaderNames();
        while (headers.hasMoreElements()){
            String header=(String) headers.nextElement();
            String value=request.getHeader(header);
            out.println(header+"="+value+"<br>");
        }
        out.println("<body></html>");

    }

}


