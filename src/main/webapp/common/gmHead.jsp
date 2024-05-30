<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath }/css/createpage/cp_header.css"> --%>
<style>
/* .boards ul li {
	list-style-type: none;
	margin: 0;
	height:18px;
}
 */
@font-face {
	font-family: 'GmarketSansMedium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

/* header */
.header {
   width: 1900px;
   height: 30px;
   padding: 5px;
   font-family: 'GmarketSansMedium';
   border-bottom: 1px solid #E1E1E1;
}

input::placeholder {
   font-family: 'GmarketSansMedium';
}

.logo {
   float: left;
}

.search {
   position: relative;
   float: left;
   height: 30px;
   margin: 0;
}

#triangle {
   position: absolute;
   width: 0px;
   height: 0px;
   border-top: 8px solid #BEC1C7;
   border-left: 5px solid transparent;
   border-right: 5px solid transparent;
}

.triangle1 {
   top: 24px;
   left: 268px;
}

.triangle2 {
   top: 24px;
   left: 345px;
}

.triangle3 {
   top: 24px;
   left: 1618px;
}

.triangle4 {
   top: 3px;
   left: 55px;
}

.search input {
   float: left;
   width: 130px;
   height: 25px;
   border: 1px solid #067DFD;
   outline: none;
   border-radius: 20px;
   padding: 0 10px;
   margin-left: 6px;
   margin-top: 0;
}

.search img {
   position: absolute;
   width: 16px;
   height: 16px;
   top: 5px;
   left: 135px;
   cursor: pointer;
}


.min_menu1 td, .min_menu2 td {
   float: left;
   margin-top: 5px;
   padding-left: 13px;
   padding-right: 25px;
   font-size: 13px;
   color: gray;
   border-right: 1px solid #E1E1E1;
}


.min_menu1 td:last-child, .min_menu2 td:last-child {
   border-right: none;
}

.min_menu1 {
   float: left;
}

.min_menu1 td:last-child {
	margin-top: 5px;
}

.min_menu2 {
   float: right;
}

/*.min_menu2 td:first-child {
   margin-top: 1px;
}*/

.min_menu2 td:nth-child(3) {
   margin-top: 2px;
   padding-right: 19px;
}

.min_menu2 td:not(:nth-child(3)) {
   padding-right: 8px;
}

.min_menu2 td a {
   text-decoration: none;
   color: gray;
}

.min_menu2 td:last-child {
   width: 100px;
}

.boards>ul {
	padding-left: 0;
}

.boards>ul>li {
	position: relative;
	top: -13px;
	/* right: 40px; */
}

.boards ul li {
	list-style-type: none;
	margin: 0;
	height:18px;
}

.boards .boards_kind {
	display: none;
}

.boards ul li:hover .boards_kind {
	display: block;
	position: relative;
	width: 70px;
	right: 40px;
	margin: 0;
}
</style>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/member/gmMain"><img
				src="../imgs/glogo.png"></a>
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
					<c:if test="${sessionScope.id==null }">
						<td><a
							href="${pageContext.request.contextPath}/member/gmLogin">로그인</a></td>
						<td><a
							href="${pageContext.request.contextPath}/member/gmJoin">회원가입</a></td>
					</c:if>

					<c:if test="${sessionScope.id!=null }">
						<td><a
							href="${pageContext.request.contextPath}/member/gmJoinInfo">나의
								회원정보[<%=session.getAttribute("id")%>]
						</a></td>
						<td><a
							href="${pageContext.request.contextPath}/member/gmLogout">로그아웃</a></td>
					</c:if>

					<c:if test="${sessionScope.id eq 'admin' }">
						<li><a
							href="${pageContext.request.contextPath}/member/gmMemberList">회원리스트</a>
						</li>

					</c:if>
					<td><a href="#">나의 쇼핑정보</a>
						<div id="triangle" class="triangle3"></div></td>
					<td><a href="${pageContext.request.contextPath}/product/gmProdList">상품리스트</a></td>
					<td><a href="#">장바구니</a></td>
					<td>
						<nav class="boards">
							<ul>
								<li><a
									href="${pageContext.request.contextPath}/board/gmBoardList?boardid=1">고객센터</a>
									<div id="triangle" class="triangle4"></div>
									<ul class="boards_kind">
										<li><a
											href="${pageContext.request.contextPath}/board/gmBoardList?boardid=1">공지사항</a></li>
										<li><a
											href="${pageContext.request.contextPath}/board/gmBoardList?boardid=2">자유게시판</a></li>
										<li><a
											href="${pageContext.request.contextPath}/board/gmBoardList?boardid=3">Q&A</a></li>
									</ul></li>
							</ul>
						</nav>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>