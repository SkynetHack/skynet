<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
    String loginName = (String)session.getAttribute("loginName");
    if(loginName == null){
    	out.print("<script>alert('用户名为空');location.href='index.html'</script>");
    }
%>

<body>

</body>
</html>