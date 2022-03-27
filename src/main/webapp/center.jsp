<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.math.entity.Prac"%>
<%@page import="java.util.List"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="centerstyle.css"/>
    
    <title>个人中心</title>
    
   
</head>



<body>
    <%
    String name = (String)session.getAttribute("loginName");
    %>
    <div class="welcome">
        <div class="center_title">
            <img src="./images/center.png" alt="个人中心">
        </div>
    </div>
    <div class="middle">
        <div class="mycenter">
            <img src="./images/my.png" alt="我的">
            <div class="mycenter-name"><%=name%>,你好!</div>
            <div class="choose">
                <div class="prac">
                    <button class="pracBtn">
                        开始练习
                    </button>
                </div>
                <form action="FindHistory">
                    <div class="findhistory"> 
                         <input class="HistoryBtn" type="submit" value="查看历史记录">
                    </div>
                </form>
                <div class="prac">
                    <button id="quit" class="pracBtn">
                        退出登录
                    </button>
                </div>
            </div>
           
        </div>
        <div class="rule">
        	<p class="rule-title">
                练习规则
            </p>
            <p class="rule-con">
                1.每次练习共20题,题目类型为三个数的四则运算,每道题分值5分,满分100分。
            </p>
            <p class="rule-con">
                2.提交答案后将立即显示正确答案及判断你的分数,并记录当次练习,提交后不可重复提交。
            </p>
            <p class="rule-con">
                3.练习过程中任何时候都可以选择重做或退出,但未提交答案的练习将不会记录。
            </p>
            <p class="rule-con">
                4.当出现除法运算时,无论结果有无小数,均保留两位小数,不进行四舍五入。
            </p>
            <p class="rule-con">
                5.练习提交后可以选择立即再做一次,规则同上。
            </p>
        </div>
    </div>

   

    
</body>


<script>
    let pracBtn = document.getElementsByClassName("pracBtn")[0];
    
    pracBtn.onclick=function(){
        location.href="GotoPrac.jsp";
    }
    let quitBtn = document.getElementById("quit");
    quitBtn.onclick=function(){
        alert("已退出");
        location.href="loginOut.jsp";
    }
</script>

</html>
