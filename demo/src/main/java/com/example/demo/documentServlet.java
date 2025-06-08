
package com.example.demo;
import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "documentServlet", value = "/generate-document")
public class documentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        String doctype=request.getParameter("doctype");

        if(doctype.equals("word")){
            doctype="application/msword;charset=gb2312";
            response.setContentType(doctype);
            response.setHeader("Content-Disposition","attachment;filename=student.doc");
        }else {
            doctype="application/vnd.ms-excel;charset=gb2312";
            response.setContentType(doctype);
            response.setHeader("Content-Disposition","attachment;filename=student.xls");

        }
        //设置完响应内容类型，再返回输出流对象
        PrintWriter out=response.getWriter();
        out.println("学号\t姓名\t性别\t年龄\t所在系");
        out.println("95001\t李勇\t男\t20\t信息");
        out.println("95002\t刘晨\t女\t19\t数学");

    }

}




