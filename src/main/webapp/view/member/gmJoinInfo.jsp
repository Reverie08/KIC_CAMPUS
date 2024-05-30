<%@page import="model.GmMember"%>
<%@page import="dao.GmMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/member/mem_infopage/mi_main.css">
<style>
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="main">
		<div class="title">내 정보</div>

		<table class="info_table">
			<tbody>
				<tr class="name">
					<td>이름</td>
					<td>${mem.name}<%-- <span><a
						href="${pageContext.request.contextPath}/member/gmMemberPassForm">이름변경</a></span></td> --%>
				</tr>
				<tr>
					<td>사용자ID</td>
					<td>${mem.id}</td>
				</tr>
				<tr class="pass">
					<td>비밀번호</td>
					<td><a
						href="${pageContext.request.contextPath}/member/gmMemberPassForm">비밀번호
							수정</a></td>
				</tr>
				<tr><td>활동</td><td>${mem.trader==1?"소비":"판매"}</td><tr>
				<tr>
					<td>E-mail</td>
					<td>${mem.email}</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${mem.tel}</td>
				</tr>
			</tbody>
		</table>
		<div class="quit">
			<a href="${pageContext.request.contextPath}/member/gmMemberDelForm">회원탈퇴</a>
		</div>
		<div class="modify">
			<a href="${pageContext.request.contextPath}/member/gmMemberUpdForm">회원정보수정</a>
		</div>
	</div>
</body>
</html>