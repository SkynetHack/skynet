<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; "
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<%
    // session.removeAttribute("loginName");
    
//重定向：生成新的请求和响应。
     
		out.write("<script>alert('正在退出');location.href='center.jsp';</script>");
       //response.sendRedirect("center.jsp");
%>
<body>
    
</body>
</html>