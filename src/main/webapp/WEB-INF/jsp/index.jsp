<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>  
<t:layout title="首页">
		<form action="" method="get" >
		<div>
			<label for="brand">品　　牌:</label>
<%-- 			<select name="brand">
				<option value="">--请选择品牌--</option>
				<option value="苹果">苹果</option>
				<option value="华为">华为</option>
				<option value="小米">小米</option>
				<option value="vivo">vivo</option>
				<option value="魅族">魅族</option>	
			</select> --%>
				<input type="text" name="brand" id="brand" />
		</div>
		<div>
			<label for="os">操作系统:</label>
			<input type="text" name="os" id="os" />
		</div>
		<div>
			<label for="cpubrand">CPU型号:</label>
			<input type="text" name="cpubrand" id="cpubrand" />
		</div>
		<div>
			<label for="ram">运行内存:</label>
			<input type="text" name="ram" id="ram" />MB
		</div>
		<div>
			<label for="storage">内　　存:</label>
			<input type="text" name="storage" id="storage" />GB
		</div>
		<div>
			<button type="submit">搜索</button>
		</div>
	</form>
	<c:if test="${cellphones != null}">
		<c:forEach items="${cellphones}" var="cellphone">
			<a href="${contextPath}/users/${cellphone.id}">${cellphone.model}</a>
		</c:forEach>
	</c:if>
	todo>>
</t:layout>