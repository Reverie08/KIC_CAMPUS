<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/createpage/cp_header.css">
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="<%=request.getContextPath() %>/common/gmMain.jsp"><img src="../imgs/glogo.png"></a>
		</div>
		<div class="search">
			<input type="text" placeholder="통합검색"> <img
				src="../imgs/search.png">
		</div>
		<div>
			<table class="min_menu1">
				<tr>
					<td>카테고리
						<div id="triangle" class="triangle1"></div>
					</td>
					<td>서비스
						<div id="triangle" class="triangle2"></div>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<table class="min_menu2">
				<tr>
				<% if(session.getAttribute("id")==null) { %>
					<td><a href="<%=request.getContextPath()%>/gmarket_project/gmLogin.jsp">로그인</a></td>
					<td><a href="<%=request.getContextPath()%>/gmarket_project/gmJoin.jsp">회원가입</a></td>
					<% } else { %>
					<td><a href="<%=request.getContextPath()%>/gmarket_project/gmJoinInfo.jsp">나의 회원정보[<%=session.getAttribute("id") %>]</a></td>
					<td><a href="<%=request.getContextPath()%>/gmarket_project/gmLogout.jsp">로그아웃</a></td>
					<% } %>
					<td><a href="#">나의 쇼핑정보</a>
						<div id="triangle" class="triangle3"></div></td>
					<td><a href="#">최근본상품</a></td>
					<td><a href="#">장바구니</a></td>
					<td><a href="#">고객센터</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>