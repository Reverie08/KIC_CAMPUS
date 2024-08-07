<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class ="container">
  		<table class ="table">
  			<thead>
  				<tr>
  					<th>id</th>
  					<th>비밀번호</th>
  					<th>이름</th>
  					<th>성벌</th>
  					<th>이메일</th>
  					<th>전화번호</th>
  					<th>사진명</th>
  				</tr>
  			</thead>
  			<tbody>
  				<c:forEach var="m" items="${li}">
  					<tr>
  						<td>${m.id}</td>
  						<td>${m.pass}</td>
  						<td>${m.name }</td>
  						<td>${m.gender==1?"남":"여" }</td>
  						<td>${m.email }</td>
  						<td>${m.tel }</td>
  						<td>${m.picture }</td>
  					</tr>
  				</c:forEach>
  			</tbody>
  		</table>
  </div>

</body>
</html>