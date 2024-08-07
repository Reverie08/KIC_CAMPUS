<%@page import="gmarket.gmMemberDAO"%>
<%@page import="gmarket.gmMember"%>
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
String name = request.getParameter("name");
String tel = request.getParameter("tel");
String email = request.getParameter("email");

gmMemberDAO dao = new gmMemberDAO();
gmMember gm = new gmMember();

gm.setId(id);
gm.setPass(pass);
gm.setName(name);
gm.setTel(tel);
gm.setEmail(email);

int num = dao.insertMember(gm);

String msg = "";
String url = "";

if(num>0) {
	msg=name+"님이 회원가입이 완료 되었습니다";
	url="gmLogin.jsp";
} else {
	msg="회원가입이 실패 하였습니다";
	url="gmJoin.jsp";
}

%>
<script>
alert("<%=msg %>");
location.href="<%=url %>"
</script>

<%=id %>
<%=pass %>
<%=name %>
<%=tel %>
<%=email %>
</body>
</html>