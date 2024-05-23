<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class ="container">
<a class="btn btn-primary float-right m-2" href="${pageContext.request.contextPath}/board/boardForm">게시판 입력</a>
  		<table class ="table">
  			<thead>
  				<tr>
  					<th>ser</th>
  					<th>이름</th> 
  					<th>제목</th>
  					<th>이미지</th>
  					<th>날짜</th>
  					<th>조회</th>
  				</tr>
  			</thead>
  			<tbody>
  				<c:forEach var="b" items="${li}">
  					<tr>
  						<td>${b.num}</td>
  						<td>${b.name}</td>
  						<td><a href ="${pageContext.request.contextPath }/board/boardInfo?num=${b.num}">${b.subject}</a></td>
  						<td>${b.file1 }</td>
  						<td>${b.regdate }</td>
  						<td>${b.readcnt }</td>
  					</tr>
  				</c:forEach>
  			</tbody>
  		</table>
  </div>
</body>
</html>