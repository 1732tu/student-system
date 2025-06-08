package com.example.demo1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "configDemoServlet",value = {"/config-demo"},
       initParams={
        @WebInitParam(name="email",value = "hacker@163.com"),
        @WebInitParam(name = "telephone",value = "8899123")
        })
public class ConfigDemoServlet extends HttpServlet {
    String servletName = null;
    ServletConfig config = null;
    String email = null;
    String telephone = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
        servletName = config.getServletName();
        email = config.getInitParameter("email");
        telephone = config.getInitParameter("telephone");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<head><title>配置对象</title></head>");
        out.println("Servlet 名称："+servletName+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone);
        out.println("</body></html>");

    }
}

