<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set> 
<c:set var="title" value="${receivingAddressForm.id ==null ? '添加' : '修改'}"></c:set>
<t:layout title="${title}">
	<jsp:attribute name="css">
   	 <link href="${contextPath}/assets/css/form.css" rel="stylesheet">
  	</jsp:attribute>
  	
	<jsp:attribute name="js">
   	 	<script>
     		 console.log('手机列表');
    	</script>
  	</jsp:attribute>
	<jsp:body>
	<h1>${title}</h1>
	<form:form action="" method="post" commandName="receivingAddressForm">
		<div>
			<label for="receivingname">收货人姓名:</label>
			<form:input type="text" path="receivingname" />
			<form:errors path="receivingname" cssClass="field-error"></form:errors>
		</div>

		<div>
			<label for="phonenumber">手　机　号:</label>
			<form:input type="text" path="phonenumber" />
			<form:errors path="phonenumber" cssClass="field-error"></form:errors>
		</div>
		
		
		<div>
			<label for="detailedaddress">现居住地址:</label>
			<form:input type="text" path="detailedaddress" />
			<form:errors path="detailedaddress" cssClass="field-error"></form:errors>
		</div>
		
		<div>
			<button type="submit">${title}</button>
		</div>
	</form:form>
	</jsp:body>
</t:layout>