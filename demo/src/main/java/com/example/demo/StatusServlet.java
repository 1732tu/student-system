package com.example.demo;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StatusServlet", value = "/status-ervlet")
public class StatusServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String qq = request.getParameter("q");
        if (qq == null) {
            out.println("没有提供请求参数");

        } else if(qq.equals("0")) {
            out.println(response.getStatus() + "<br>");
            out.println("Hello,Guys!");
        }else if(qq.equals("1")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        }else if(qq.equals("2")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        }else {
            response.sendError(404,"resource cannot founddd!");
        }
    }

}
