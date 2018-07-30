<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:layout title="订单详情">
	<h1>订单详情</h1>
	<div>订单创建时间：${cellphoneOrder.createtime}</div>
	<table>
		<tr>
			<th>商品名称</th>
			<th>单价</th>
			<th>数量</th>
		</tr>
			<c:forEach items="${cellphoneOrder.orderItems}" var="cellphoneOrderItem">
				<tr>
					<td>${cellphoneOrderItem.cellphone.brand}${cellphoneOrderItem.cellphone.model}</td>
					<td>${cellphoneOrderItem.cellphone.price}</td>
					<td>${cellphoneOrderItem.amount}</td>
				</tr>
			</c:forEach>
	</table>
	<div>
		总金额:￥${cellphoneOrder.totalCost()/100}
	</div>
	<div>
		收货地址：${cellphoneOrder.receivingAddress.detailedaddress}<br>
		<a href="${contextPath}/uc/shop-address/${cellphoneOrder.receivingAddress.id}/edit">更换收货地址</a>

	</div>
	
</t:layout>


