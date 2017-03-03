<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String extPath = request.getContextPath();
	String extBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+extPath;
	//session登录设置
	String userId = String.valueOf(session.getAttribute("userId"));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
  </head>
  <script type="text/javascript">
	//java变量->js变量
	var userId ="<%=userId%>";
	var extBasePath = "<%=extBasePath%>";
	//有不传值和传值两处页面的跳转,要区别开
	if(userId!="null"){
		alert("session值--->"+userId);
	}else{
		window.location.href="login/backToLogin.do";
	}
  	//get和post区别
  	//1.get请求需注意缓存问题,post请求不需担心这个问题
	//2.post请求必须设置Content-Type值为application/x-form-www-urlencoded,get方式的话无所谓
	  function testString(){
			$.ajax({
				type:"get",
				url:"user/findUserName.do",
				//contentType:"application/json;charset=utf-8",
				data:'userId=1111',
				success:function(data){
					alert(data);
				}
			});
		}
	  function testPojo(){
			$.ajax({
				type:"post",
				url:"user/findUser.do",
				contentType:"application/json;charset=utf-8",
				data:'{"userId":"22222"}',
				success:function(data){
					alert(data);
				}
			});
		}
	  function testMap(){
			$.ajax({
				type:"get",
				url:"user/findMap.do",
				contentType:"application/json;charset=utf-8",
				data:'userId=1',
				success:function(data){
					alert(data);
				}
			});
		}
	  function loginOut(){
			$.ajax({
				type:"post",
				url:extBasePath+"login/loginOut.do",
				contentType:"application/json;charset=utf-8",
				data:'{"userId":"1"}',
				success:function(){
					debugger
				}
			});
		}
  </script>
  
  <body>
    This is my JSP page. <br>
    <button onclick="testString()" >后台接收String类型参数</button>
    <button onclick="testPojo()" >后台接收Object类型参数</button>
    <button onclick="testMap()" >查询数据库数据</button>
	<a href="user/redirectPage.do">普通页面跳转</a>
	<a href="user/redirectPageWithParams.do?qtParam=1">页面间跳转并且传值</a>
	<button onclick="loginOut()" >退出系统</button>
  </body>
</html>
