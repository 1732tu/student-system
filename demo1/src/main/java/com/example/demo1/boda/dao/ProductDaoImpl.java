package com.example.demo1.boda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    //插入一条商品记录
    public int addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products VALUES(?,?,?,?)";
        int n = 0;
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setString(3, product.getBrand());
            pstmt.setDouble(4, product.getPrice());
            n = pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return n;
    }
    //按ID查询商品记录
    @Override
    public Product findProductById(int id) throws SQLException {
        String sql = "SELECT id,pname,brand,price" + "FROM products WHERE id=?";
        Product product = null;
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            try (
                    ResultSet rst = pstmt.executeQuery()
            ) {
                if (rst.next()) {
                    product = new Product(rst.getInt("id"), rst.getString("pname"),
                            rst.getString("brand"), rst.getDouble("price"));
                }
            }
        } catch (SQLException se) {
            return null;
        }
        return product;
    }

    //查询所有商品信息
    public List<Product> findAllProduct() throws SQLException {
        Product product = null;
        ArrayList<Product> productList = new ArrayList<Product>();
        String sql = "SELECT *FROM products";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ) {
            while (rst.next()) {
                product = new Product(rst.getInt("id"),
                        rst.getString("name"),
                        rst.getString("brand"),
                        rst.getDouble("price"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
