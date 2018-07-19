<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<h1>用户登录</h1>
	<c:if test="${loginError}">
		<h2 style="color: red;">用户名或密码错误</h2>
	</c:if>
	  <!-- 当退出后来到登录页面时，显示该消息 -->
	<c:if test="${param.logout != null}">
		<h2>已退出，请重新登录</h2>
	</c:if>
	<div>
		<form action="" method="post">
		<security:csrfInput/>
			<div>
				<label for="username">用户名:</label>
				<input type="text" name="username" id="username">
			</div>
			<div>
				<label for="password">密　码:</label>
				<input type="text" name="password" id="password">
			</div>
			<div>
				<button type="submit">登录</button>
			</div>
		</form>
	</div>
</body>
</html>