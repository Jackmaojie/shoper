<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:layout title="订单列表">
	<h1>我的订单</h1>
	<table>
		<tr>
			<th>订单编号</th>
			<th>订单创建时间</th>
			<th>订单状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${cellphoneOrders}" var="cellphoneOrder">
			<tr>
				<td>${cellphoneOrder.id}</td>
				<td>${cellphoneOrder.createtime}</td>
				<td>${cellphoneOrder.stateText()}</td>
				<td><a href="${contextPath}/uc/shop-order/${cellphoneOrder.id}">订单详情</a>
					<a href="${contextPath}/uc/shop-order/${cellphoneOrder.id}/delete">取消订单</a>
				</td>
			</tr>	
		</c:forEach>
	</table>
</t:layout>