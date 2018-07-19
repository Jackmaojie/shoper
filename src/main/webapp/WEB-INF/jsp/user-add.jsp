<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>   
<t:layout title="用户注册">
	<h1>用户注册</h1>
	<c:if test="${param.logout != null}">
		<h2>已退出，请重新登录</h2>
	</c:if>
	<form:form action="" method="post" commandName="cellphoneUser">
		<div>
			<label for="username">用户名:</label>
			<form:input type="text" path="username" />
			<form:errors path="username" cssClass="field-error"></form:errors>
		</div>

		<div>
			<label for="gender">性　别:</label>
			<form:radiobutton path="gender" value="Male" />
			男
			<form:radiobutton path="gender" value="Female" />
			女
			<form:errors path="gender" cssClass="field-error"></form:errors>
		</div>
		
		
		<div>
			<label for="password">密　码:</label>
			<form:input type="password" path="password" />
		</div>
		
		<div>
			<button type="submit">注册</button>
		</div>
	</form:form>		
</t:layout>