<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<t:layout title="首页">
			<div style="color:red;height:100px;padding:10px;">
			<security:authentication property="principal.username" var="username"/>
					${username}--
				<!-- springsecurity默认的退出路径是：POST /logout，注意：springsecurity自带处理 -->

				
			</div>	
	todo>>
</t:layout>