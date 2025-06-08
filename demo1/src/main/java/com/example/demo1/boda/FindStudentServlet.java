/*package com.example.demo1.boda;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.*;


@WebServlet(name = "findStudentServlet",value = "/find-student")
public class FindStudentServlet extends HttpServlet {
    public void init() {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e);
            getServletContext().log("找不到驱动程序类");
        }
    }

    public Connection getConnection()throws SQLException{
        String username="root";
        String password="123456";
        String dburl="jdbc:mysql://127.0.0.1:3306/elearning"+"?userSSL=false&serverTimezone=UTC";
        Connection conn=null;
        try{
            conn= DriverManager.getConnection(dburl,username,password);
        }catch (SQLException e){
            throw e;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<Student>studentList=new ArrayList<Student>();
        String sql="SELECT * FROM students";
        try (
            Connection conn=getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet result=pstmt.executeQuery();
        )
        {
            while (result.next()){
                Student student=new Student();
                student.setStudId(result.getInt("stud_id"));
                student.setName(result.getString("name"));
                student.setGender(result.getString("gender"));
                student.setBirthday(result.getDate("birthday").toLocalDate());
                student.setPhone(result.getString("phone"));
                studentList.add(student);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(!studentList.isEmpty()){
            req.getSession().setAttribute("studentList",studentList);
            resp.sendRedirect("/demo1/show-all-student.jsp");
        }else{
            resp.sendRedirect("/demo1/error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String studentid = req.getParameter("stud_id");
        String sql = "SELECT * FROM students WHERE stud_id=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

        ) {
            pstmt.setString(1, studentid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                Student student = new Student();
                Student.setStudId(rst.getInt("stud_id"));
                student.setName(rst.getString("name"));
                student.setGender(rst.getString("gender"));
                student.setBirthday(rst.getDate("birthday").toLocalDate());
                student.setPhone(rst.getString("phone"));
                req.getSession().setAttribute("student", student);
                resp.sendRedirect("/demo1/show-student.jsp");

            } else {
                resp.sendRedirect("/demo1/error.jsp");

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


 */
