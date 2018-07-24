<%@ tag language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ attribute name="title" required="true" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机</title>

	<style type="text/css">
		
	</style>
	<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<div style="color: red;">
			<security:authorize access="isAuthenticated()"><!-- 检测用户登录 -->
				<security:authentication property="principal.username"
					var="username" />
					${username}--
				<!-- springsecurity默认的退出路径是：POST /logout，注意：springsecurity自带处理 -->
				<form action="${contextPath}/logout" method="post"
					style="display: inline;">
					<security:csrfInput />
					<button type="submit">退出</button>
				</form>
				<a href="${contextPath}/uc/shop-cart"><button>购物车</button></a>
				<a href="${contextPath}/">首页</a>
			</security:authorize>
		</div>
		<div >
			<security:authorize access="isAnonymous()">
				<a href="${contextPath}/login"><button>用户登录</button></a>
				<a href="${contextPath}/users/add"><button>用户注册</button></a>	
			</security:authorize>
		</div>

	</div>
	

	<div class="content">
   	 <!-- 取tag参数值 -->
   	 	
   	 <!-- 把t:layout标签的内容插入此处 -->
   		 <jsp:doBody />
  	</div>
  
  <div class="footer">copyright 2018</div>
		
</body>
</html>
