<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="/SpringSecurity/assets/js/test.js"></script>
</head>
<body>
	<c:url value="/login" var="loginProcessingUrl"/>
	
   <form action="${loginProcessingUrl}" method="post">
	<!--spring security默认开启CSRF防护，所以所有POST表单都必须包含csrf.token -->
   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <fieldset>
        <legend>Please Login</legend>
        <c:if test="${param.error != null}">
            <div>
                                 
                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                	用户名或者密码错误
                </c:if>
            </div>
        </c:if>
        <!-- the configured LogoutConfigurer#logoutSuccessUrl is /login?logout and contains the query param logout -->
        <c:if test="${param.logout != null}">
            <div>
                	退出成功,请<a href="${loginProcessingUrl }">登录</a>
            </div>
        </c:if>
        <p>
        <label for="username">用户名</label>
        <input type="text" id="username" name="username"/>
        </p>
        <p>
        <label for="password">密码</label>
        <input type="password" id="password" name="password"/>
        </p>
        <!-- if using RememberMeConfigurer make sure remember-me matches RememberMeConfigurer#rememberMeParameter -->
        <p>
        <label for="remember-me">请记住我?</label>
        <input type="checkbox" id="remember-me" name="remember-me"/>
        </p>
        <div>
            <button type="submit" class="btn">登录</button>
        </div>
    </fieldset>
 </form>
</body>
</html>