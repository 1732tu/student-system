<%--
  Created by IntelliJ IDEA.
  User: 李冰玲
  Date: 2025/5/7
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
   <table border="0">
       <tr><td>学号：</td><td>${student.studId}</td></tr>
       <tr><td>姓名：</td><td>${student.name}</td></tr>
       <tr><td>性别：</td><td>${student.gender}</td></tr>
       <tr><td>出生日期：</td><td>${student.birthday}</td></tr>
       <tr><td>电话：</td><td>${student.phone}</td></tr>
   </table>
</body>
</html>
