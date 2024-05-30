<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product/pd_main.css">
<title>상품 삭제</title>
<style>

</style>
</head>
<body>
    <div class="container">
        <div>
            <h4>상품 삭제</h4>
            <form novalidate action="gmProdDel" method="post">
                <input type="hidden" name="prodid" value="${prodid}">
                <button type="submit">상품 삭제</button>
            </form>
        </div>
    </div>
</body>
</html>
