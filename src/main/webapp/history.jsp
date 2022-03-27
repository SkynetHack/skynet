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
    <link rel="stylesheet" href="historystyle.css"/>
    <title>Document</title>
     <script src="./echarts.js"></script>
</head>
<%
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

<body>
    <div class="head">
        <div class="head-title">历史练习记录</div>
        <div class="head-title">仅展示最近5次</div>
        
      </div>
    
    <div id="chart" >
    </div>

    <div class="quit">
        <button id="q">
            退出
        </button>
    </div>
</body>

<script>
    let quit = document.getElementById("q");
    quit.onclick=function(){
        location.href="center.jsp";
    }
    const instance = echarts.init(chart);
    const option={
        xAxis:{
            type:'category',
            data:[
            	<%for(int z=0;z<i;z++){%>
            		'<%=pracdate[z] %>(得分:<%=pracscr[z]%>)'
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
        },
        toolbox: {
          show: true, //是否显示工具栏组件
          orient: "horizontal", //工具栏icon的布局朝向
          itemSize: 18, //工具栏icon的大小
          itemGap: 20, //item之间的间距
          right: 20, //toolbox的定位位置
          feature: {
            saveAsImage: { show: true }, //导出图片
            magicType: {
              //动态类型切换
              type: ["line", "bar", "pie"]
            },
            restore: { show: true } //重置
          },
          iconStyle: {
            // color:'#04a0bb'
          }
        }
    };
    instance.setOption(option)
</script>


</html>