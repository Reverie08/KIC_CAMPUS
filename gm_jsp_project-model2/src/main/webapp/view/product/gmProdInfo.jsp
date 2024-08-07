<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/board/bInfo_main.css">
</head>

<body>
    <div class="container">
        <div class="board-info">
            <h4 class="title">상품 정보</h4>
            <table class="board-table">
                <tr>
                    <td class="label">상품ID</td>
                    <td class="value">${prod.prodid}</td>
                </tr>
                <tr>
                    <td class="label">상품명</td>
                    <td class="value">${prod.prodname}</td>
                </tr>
                <tr>
                    <td class="label">가격</td>
                    <td class="value">${prod.price}</td>
                </tr>
                <tr>
                    <td class="label">상품설명</td>
                    <td class="value">${prod.prodcontent}</td>
                </tr>
                <tr>
                    <td class="label">상품등록일</td>
                    <td class="value"><fmt:formatDate value="${prod.prodregdate}" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td class="label">카테고리</td>
                    <td class="value">${prod.category}</td>
                </tr>
                <tr>
                    <td class="label">이미지</td>
                    <td class="value"><img class="board-image"
                        src="${pageContext.request.contextPath}/storage/img/${prod.file2}" /></td>
                </tr>
                <tr>
                    <td class="actions" colspan="2">
                        <a class="action-link" href="${pageContext.request.contextPath}/product/gmProdUpdForm?prodid=${prod.prodid}">상품 수정</a>
                        <a class="action-link" href="${pageContext.request.contextPath}/product/gmProdDelForm?prodid=${prod.prodid}">상품 삭제</a>
                        <a class="action-link" href="${pageContext.request.contextPath}/product/gmProdList">상품 목록</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
