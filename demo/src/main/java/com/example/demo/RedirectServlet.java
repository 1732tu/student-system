
package com.example.demo;
import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "sendRedirect", value = "/send-redirect")
public class RedirectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        String userAgent = request.getHeader("user-agent");
//在请求对象上存储一个属性
        request.setAttribute("param1","请求作用域属性");
        //在会话对象上存储一个属性
        HttpSession session=request.getSession();
        session.setAttribute("param2","会话作用域属性");
        if((userAgent!=null)&&(userAgent.indexOf("Chrome")!=-1)){
            response.sendRedirect("weclome.jsp");
        }else {
            response.sendRedirect("https://www.baidu.com/");
        }

    }

}
