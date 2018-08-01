<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:layout title="订单地址列表">
	<style type="text/css">
		.menu{
			display: inline-block;
			color:#00AB00;
		}
	</style>
	<h1>订单地址列表</h1>
	<div >
		<table>
			<tr>
				<th>收货人</th>
				<th>手机号</th>
				<th>详细地址</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${receivingAddresses}" var="address">
				<tr>
					<td>${address.receivingname}</td>
					<td>${address.phonenumber}</td>
					<td>${address.detailedaddress}</td>
					<td>
						<a href="${contextPath}/uc/shop-address/${address.id}/edit">修改</a>
						<a href="${contextPath}/uc/shop-address/${address.id}/delete">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</t:layout>