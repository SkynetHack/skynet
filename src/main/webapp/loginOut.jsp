<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
       session.removeAttribute("loginName");
//重定向：生成新的请求和响应。
       response.sendRedirect("login.html");
%>

<body>

</body>
</html>