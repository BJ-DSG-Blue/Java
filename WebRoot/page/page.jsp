<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String extPath = request.getContextPath();
	String extBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+extPath;
%>

<%
	//接收从后台返回的值(request直接用就行,不用去定义,param1和2对应后台的返回参数名)
	String param1 = request.getParameter("param1");
	String param2 = request.getParameter("param2");
%>
<script type="text/javascript">
	//java变量->js变量
	var extBasePath = "<%=extBasePath%>";
	var param1 ="<%=param1%>";
	var param2 ="<%=param2%>";
	//有不传值和传值两处页面的跳转,要区别开
	if(param1!="null"&&param2!="null"){
		alert("param1->"+param1+",param2->"+param2);
	}
</script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>页面跳转</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<script type="text/javascript" src="<%=extBasePath%>/js/jquery-3.1.1.min.js"></script>
  </head>
  
  <body>
    This is my change Page.jsp</br>
    <a href="<%=extBasePath%>/user/backToIndex.do">redirect跳回到首页</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<%=extBasePath%>/user/loginToIndex.do">根据ModelAndView跳回到首页</a>
  </body>
</html>
