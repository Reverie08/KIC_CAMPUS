<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/board/bl_main.css">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<div class="main">
		<div class="title">${boardName }</div>
		
		<div class="board-container">
			<table class="boardlist">
				<thead>
					<tr class="boardlist_head">
						<th>순번</th>
						<th>이름</th>
						<th>제목</th>
						<!-- <th>이미지</th> -->
						<th>날짜</th>
						<th>조회</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="boardNum" value="${boardNum}" />
					<c:forEach var="b" items="${li}">
						<tr>
							<th>${boardNum }</th>
							<c:set var="boardNum" value="${boardNum-1 }" />
							<th>${b.name }</th>
							<th><a
								href="${pageContext.request.contextPath }/board/gmBoardInfo?num=${b.num}">${b.subject}</a></th>
							<%-- <th>${b.file1}</th> --%>
							<th>${b.regdate }</th>
							<th>${b.readcnt }</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="boardform"><a
			href="${pageContext.request.contextPath }/board/gmBoardForm?boardid=${boardid }">게시판
			입력</a></div>
		
		<ul class="pagination">
			<c:choose>
				<c:when test="${start <= bottomLine}">
					<li class="disabled"><a href="#">이전</a></li>
				</c:when>
				<c:otherwise>
					<li class="move"><a
						href="${pageContext.request.contextPath}/board/gmBoardList?boardid=${boardid}&pageNum=${start - bottomLine}">&lt;</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:forEach var="p" begin="${start}" end="${end}">
				<li><a
					href="${pageContext.request.contextPath}/board/gmBoardList?boardid=${boardid}&pageNum=${p}">${p}</a>
				</li>
			</c:forEach>

			<c:choose>
				<c:when test="${end >= maxPage}">
					<li class="disabled"><a href="#">다음</a></li>
				</c:when>
				<c:otherwise>
					<li class="move"><a
						href="${pageContext.request.contextPath}/board/gmBoardList?pageNum=${start + bottomLine}">&gt;</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</body>
</html>