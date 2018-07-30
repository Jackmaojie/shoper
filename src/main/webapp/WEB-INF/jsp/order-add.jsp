<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%-- <c:set var="title" value="${receivingAddressForm.id ==null ? '添加' : '修改'}"></c:set>  --%>
<t:layout title="创建订单">
	<h1>添加订单</h1>
	<table>
		<tr>
			<th>商品名称</th>
			<th>单价</th>
			<th>数量</th>
		</tr>
		<c:forEach items="${shoppingCart.cartItems}" var="item">
			<tr>
				<td>${item.cellphone.brand}${item.cellphone.model}</td>
				<td>￥:${item.cellphone.price/100}</td>
				<td>${item.amount}</td>
			</tr>		
		</c:forEach>
	</table>

	<form:form action="" method="post" commandName="orderForm">
		<security:csrfInput/>
		<form:select path="receivingAddressId">
			<form:option value="">--请选择收货地址--</form:option>
			<form:options items="${receivingAddresses}" itemLabel="detailedaddress" itemValue="id" />
		</form:select><br>
		  <form:errors path="receivingAddressId" cssClass="field-error" />
		<button type="submit">确定购买</button>

	</form:form>	
</t:layout>