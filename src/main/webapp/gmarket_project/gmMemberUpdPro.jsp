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
request.setCharacterEncoding("utf-8");
String id = (String) session.getAttribute("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String tel = request.getParameter("tel");
String email = request.getParameter("email");
gmMemberDAO dao = new gmMemberDAO();
gmMember memdb = dao.getMember(id);
gmMember gm = new gmMember();  //DTO bean
gm.setId(id);
gm.setPass(pass);
gm.setName(name);
gm.setTel(tel);
gm.setEmail(email); 
String msg = "";
String url = "gmMemberUpdForm.jsp";

if (memdb!=null){
	if (memdb.getPass().equals(pass)) {
		msg="수정 하였습니다";
		dao.updateMember(gm);
		url="gmJoinInfo.jsp";
	} else {
		msg="비밀번호가 틀렸습니다";
	}
	
	
} else {
	msg="수정 할 수 없습니다";
}
%>
<script>
alert("<%=msg%>");
location.href="<%=url%>"
</script>
</body>
</html>