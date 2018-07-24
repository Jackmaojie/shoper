<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机搜索</title>
</head>
<body>
	<h1>手机搜索</h1>
	<c:if test="${cellphones != null}">
		<c:forEach items="${cellphones}" var="cellphone">
				<a href="${contextPath}/users/${cellphone.id}">${cellphone.model}</a>
		</c:forEach>
	</c:if>
	<c:if test="${cellphones == null}">
	<form:form action="" method="post" commandName="cellphone">
		<div>
			<label for="brand">品　　牌:</label>
<%-- 			<form:select path="brand">
				<form:option value="">--请选择品牌--</form:option>
				<form:option value="苹果">苹果</form:option>
				<form:option value="华为">华为</form:option>
				<form:option value="小米">小米</form:option>
				<form:option value="vivo">vivo</form:option>
				<form:option value="魅族">魅族</form:option>	
			</form:select> --%>
				<form:input type="text" path="brand" id="brand" />
			<form:errors path="brand" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="os">操作系统:</label>
			<form:input type="text" path="os" id="name" />
			<form:errors path="os" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="cpubrand">CPU型号:</label>
			<form:input type="text" path="cpubrand" id="cpubrand" />
			<form:errors path="cpubrand" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="ram">运行内存:</label>
			<form:input type="text" path="ram" id="ram" />MB
			<form:errors path="ram" cssClass="field-error"></form:errors>
		</div>
		<div>
			<label for="storage">内　　存:</label>
			<form:input type="text" path="storage" id="storage" />GB
			<form:errors path="storage" cssClass="field-error"></form:errors>
		</div>
		<div>
			<button type="submit">提交</button>
		</div>
	</form:form>
	</c:if>
</body>
</html>