<%@page import="gmarket.gmMember"%>
<%@page import="gmarket.gmMemberDAO"%> 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");

	//Connection 객체
	gmMemberDAO dao = new gmMemberDAO();
	/* Connection conn = dao.getConnection(); */

	String msg = id + "님이 로그인 하셨습니다";
	String url = "../common/gmMain.jsp";
	gmMember mem = dao.getMember(id); 
	if (mem != null) {
		if (pass.equals(mem.getPass())) {
			//session
			session.setAttribute("id", id);
		} else {
			msg = "비밀번호가 맞지 않습니다";
			url = "gmLogin.jsp";
		}
	} else {
		msg = "id를 확인 하세요";
		url = "gmLogin.jsp";
	}
	%>
	<script>
alert("<%=msg%>");
location.href="<%=url%>";
	</script>
	<%=id%>
	<%=pass%>
</body>
</html>