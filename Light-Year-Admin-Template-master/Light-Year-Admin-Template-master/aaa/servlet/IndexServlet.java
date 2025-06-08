package com.example.demo2.servlet;

import com.example.demo2.entity.Clazz;
import com.example.demo2.service.ClazzService;
import com.example.demo2.service.StudentService;
import com.example.demo2.utils.ApiResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    ClazzService clazzService = new ClazzService();
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //返回数据
        resp.setContentType("application/json; charset=utf-8");
        int clazzC = clazzService.count();
        int stuC = studentService.count();
        List<Clazz> clazzes = clazzService.statistics();
        //封装数据
        Map<String,Object> res = new HashMap<>();
        res.put("clazzCount",clazzC);
        res.put("studentCount",stuC);
        res.put("clazzes",clazzes);
        resp.getWriter().write(ApiResult.json(true,"成功",res));
    }
}
