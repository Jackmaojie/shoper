<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:layout title="购物车详情">
	<h1>购物车详情</h1>
	<table>
		<tr>
			<th>商品</th>
			<th>单价</th>
			<th>数量</th>
			<th>合计</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${shoppingCart.cartItems}" var="item">
			<tr>
				<td>${item.cellphone.brand}<br>
					${item.cellphone.model}<br>
					${item.cellphone.color}
				</td>
				<td>￥:${item.cellphone.price/100}</td>
				<td>${item.amount}</td>
				<td>￥:${item.amount * (item.cellphone.price/100)}</td>
				<td>
					<form action="${contextPath}/uc/shop-cart/removeItem" method="post">
						<security:csrfInput/>
						<input type="hidden" name="cellphoneId" value="${item.cellphone.id}">
						<button type="submit">删除</button>
					</form>
				</td>
			</tr>	
		</c:forEach>
		<tr>
			<td>总额</td>
			<td></td>
		</tr>
	</table>

	
</t:layout>


