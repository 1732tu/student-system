package com.example.demo1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formServlet", value = {"/user-register"})
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID=54L;
    private static final String TITLE="用户信息";
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>"+TITLE+"</title></head>");
        out.println("<body><h4>"+TITLE+"</h4>");
        out.println("<table>");
        out.println("<tr><td>用户名：</td>");
        String username=request.getParameter("username");
        out.println("<td>"+username+"</td></tr>");
        out.println("<tr><td>密码：</td>");
        out.println("<td>"+request.getParameter("password")+"</td></tr>");
        out.println("<tr><td>性别：</td>");
        out.println("<td>"+request.getParameter("sex")+"</td></tr>");
        out.println("<tr><td>年龄：</td>");
        out.println("<td>"+request.getParameter("age")+"</td></tr>");
        out.println("<tr><td>爱好：</td>");
        out.println("<td>"+request.getParameter("sex")+"</td></tr>");
        out.println("<td>");
        String[] hobbys=request.getParameterValues("hobby");
        if(hobbys!=null){
            for(String hobby:hobbys){
                out.println(hobby+"<br/>");
            }
        }
        out.println("</td></tr>");
        out.println("<tr><td>学历:</td>");
        out.println("<td>"+request.getParameter("education")+"</td></tr>");
        out.println("<tr><td>邮件地址：</td>");
        out.println("<td>"+request.getParameter("email")+"</td></tr>");
        out.println("<tr><td>简历：</td>");
        out.println("<td>"+request.getParameter("resume")+"</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

}



