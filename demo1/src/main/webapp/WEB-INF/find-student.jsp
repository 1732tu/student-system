<%--
  Created by IntelliJ IDEA.
  User: 李冰玲
  Date: 2025/5/7
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询</title>
</head>
<body>
<p><a href="find-student">查询所有学生</a> </p>
<form action="find-student" method="post">
    请输入学生学号：
    <input type="text" name="stud_id" size="15">
    <input type="submit" value="确定">
</form>
</body>
</html>
