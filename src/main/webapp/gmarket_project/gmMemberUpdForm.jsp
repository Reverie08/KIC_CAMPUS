<%@page import="gmarket.gmMember"%>
<%@page import="gmarket.gmMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/mem_updpage/mu_header.css">
<link rel="stylesheet" href="../css/mem_updpage/mu_main.css">
<title>G마켓 - 회원가입</title>
<style>
@font-face {
	font-family: 'GmarketSansMedium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

#container {
	width: 1900px;
	height: 960px;
	overflow-x: hidden;
	overflow-y: hidden;
}
</style>
</head>
<%

String id = (String)session.getAttribute("id");
gmMemberDAO dao=new gmMemberDAO();
gmMember mem = dao.getMember(id);

%>
<body>
	<div id="container">

		<!-- main -->
		<div class="main">
			<form action="gmMemberUpdPro.jsp" novalidate method="post">
				<div class="head">
					<span>회원정보</span>를 입력해주세요 
				</div>
				<input type="text" placeholder="ID" required readonly name="id" value="<%=mem.getId()%>"> 
				<input type="password" placeholder="비밀번호" name="pass"> 
				<input type="text" placeholder="이름" name="name" value="<%=mem.getName() %>"> 
				<input type="tel" placeholder="휴대폰 번호" name="tel" value="<%=mem.getTel()%>"> 
				<input type="email" placeholder="이메일" name="email" value="<%=mem.getEmail()%>"> 
				<input type="submit" class="finish" value="수정 완료">
			</form>
		</div>

	</div>
	
</body>

</html>