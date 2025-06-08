<%--
  Created by IntelliJ IDEA.
  User: 李冰玲
  Date: 2025/5/23
  Time: 下午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<font color=red>${result}</font>
<p>请输入一条商品记录</p>
<form action="add-product" method="post">
    <table>
        <tr><td>商品号：</td><td><input type="text" name="id"></td></tr>
        <tr><td>商品名：</td><td><input type="text" name="name"></td></tr>
        <tr><td>品牌：</td><td><input type="text" name="brand"></td></tr>
        <tr><td>价格：</td><td><input type="text" name="price"></td></tr>
        <tr><td><input type="submit" value="确定"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
