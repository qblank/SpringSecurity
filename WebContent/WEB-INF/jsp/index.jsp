<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="ss" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h2>登录成功,欢迎${user.username}</h2>
	<c:url value="/logout" var="logoutProcessingUrl"></c:url>
	<form action="${logoutProcessingUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="退出">
	</form>
	<ss:authorize access="hasRole('HR')">
		<a href="${pageContext.request.contextPath }/admin/employees">员工表</a>
	</ss:authorize>
</body>
</html>