package com.example.demo1.boda.dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "addProductServlet", value = "/add-product")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao dao = new ProductDaoImpl();
        Product product=null;
        String message=null;
        try {
            product  = new Product(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name"),
                    request.getParameter("brand"),
                    Double.parseDouble(request.getParameter("price"))
            );

            int success = dao.addProduct(product);
            if(success==1){
                message="<li>成功插入一条记录!</li>";
            }else {
                message="<li>插入记录错误!</li>";

            }
        } catch (Exception e) {
            System.out.println(e);
            message="<li>插入记录错误!</li>"+e;
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/add-product.jsp");
        rd.forward(request, response);
    }
}
