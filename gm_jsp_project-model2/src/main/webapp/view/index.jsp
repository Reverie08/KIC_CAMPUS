<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
index 입니다
<c:if test="${sessionScope.id==null}">
<% response.sendRedirect(request.getContextPath() + "/member/gmMain"); %>
</c:if>
<c:if test="${sessionScope.id!=null}">
<% response.sendRedirect(request.getContextPath() + "/member/gmJoinInfo"); %>
</c:if>
</body>
</html>