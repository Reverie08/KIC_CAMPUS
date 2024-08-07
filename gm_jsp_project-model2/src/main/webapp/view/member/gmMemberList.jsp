<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

</style>
</head>
<body>
<div class ="container">
  		<table class ="table">
  			<thead>
  				<tr>
  					<th>이름</th>
  					<th>사용자ID</th>
  					<th>비밀번호</th>
  					<th>E-mail</th>
  					<th>전화번호</th>
  				</tr>
  			</thead>
  			<tbody>
  				<c:forEach var="m" items="${li}">
  					<tr>
  						<td>${m.name }</td>
  						<td>${m.id}</td>
  						<td>${m.pass}</td>
  						<td>${m.email }</td>
  						<td>${m.tel }</td>
  					</tr>
  				</c:forEach>
  			</tbody>
  		</table>
  </div>

</body>
</html>