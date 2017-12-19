<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有员工</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css">
<style type="text/css">
	tr{
		cursor: pointer;
	}
</style>
</head>
<body>
	<h2>所有员工</h2>
	<div class="container">
		<table class="table table-hover table-condensed table-responsive">
		<tr class="success">
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
		</tr>
		<c:forEach var="employee" items="${employees}" varStatus="e">
			<tr class="">
				<td>${e.count}</td>
				<td>${employee.name}</td>
				<td>${employee.gender}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
<script type="text/javascript">
	var trArr = document.getElementsByTagName("tr");
	for(var i = 0;i<trArr.length;i++){
		if (i != 0) {
			if((i+1) % 2 == 0){
				trArr[i].className = "info";
			}else{
				trArr[i].className = "";
			}
		}
	}
</script>
</html>