<%@page import="gmarket.gmMember"%>
<%@page import="gmarket.gmMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = (String) session.getAttribute("id");
	gmMemberDAO dao = new gmMemberDAO();
	gmMember mem = dao.getMember(id);
	%>
	<div class="container">
		<div>
			<div>
				<h4>회원정보</h4>
				<table>
					<tr>
						<th>name</th>
						<th>value</th>
					</tr>
					<tr>
						<td>id</td>
						<td><%=mem.getId()%></td>
					<tr>
					<tr>
						<td>name</td>
						<td><%=mem.getName()%></td>
					<tr>
					<tr>
						<td>tel</td>
						<td><%=mem.getTel()%></td>
					<tr>
					<tr>
						<td>email</td>
						<td><%=mem.getEmail()%></td>
					<tr>
					<tr>
						<td colspan="2">
						<a href="<%=request.getContextPath()%>/gmarket_project/gmMemberUpdForm.jsp">회원정보수정</a> 
						<a href="<%=request.getContextPath()%>/gmarket_project/gmMemberDelForm.jsp">회원탈퇴</a> 
						<a href="<%=request.getContextPath()%>/gmarket_project/gmMemberPassForm.jsp">비밀번호수정</a></td>
					</tr>
				</table>
			</div>
		</div>




	</div>
</body>
</html>