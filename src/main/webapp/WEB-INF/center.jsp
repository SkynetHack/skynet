<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.math.entity.Prac"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="centerstyle.css"/>
    
    <title>个人中心</title>
    
    <script src="./echarts.js"></script>
</head>
<body>
    <%
    
    String name = (String)session.getAttribute("loginName");
    List<Prac> pracs = (List)request.getAttribute("pracs");
    int i=0,j=0;
    for(Prac p:pracs)
    {
    	i++;
    }
	int[] pracscr=new int[i];
	String[] pracdate=new String[i];
	
    for(Prac p:pracs){
    	pracscr[j]=p.getScore();
    	pracdate[j]=p.getDate();
    	j++;
    }
    
    %>
    <div class="welcome">
        <div class="center_title">个人中心</div>
        <div class="prac"><a  href="GotoPrac.jsp" style="color: black;">开始练习</a></div>
        <div class="mywelcome">欢迎,<%=name %></div>
        <div class="logout"><a href="loginOut.jsp" onclick="alert('已退出')" style="color:#999;">退出登录</a></div>
    </div>
    <div class="mycenter">
        <p>姓名： <%=name%> </p>
        <p>历史成绩(仅展示最后5次)：</p>
    </div>
    <div id="chart">
    </div>
   

    
</body>
</html>
<script>
    const instance = echarts.init(chart);
    const option={
        xAxis:{
            type:'category',
            data:[
            	<%for(int z=0;z<i;z++){%>
            		'<%=pracdate[z] %>'
            		<%if(z!=i-1){%>
            		,
            		<% }%>
            	<%}%>
            ]
         
        },
        yAxis:{
            type:'value'
        },
        series:{
            data:[
            	<%for(int z=0;z<i;z++){%>
        		<%=pracscr[z]%>
        		<%if(z!=i-1){%>
        		,
        		<% }%>
        	<%}%>
            ],
            type:'line',
            barWidth:'20px',
            color:'#3b69f5'
        }
    };
    instance.setOption(option)
</script>