<%@page import="model.GmMember"%>
<%@page import="dao.GmMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/member/mem_updpage/mu_header.css">
<link rel="stylesheet" href="../css/member/mem_updpage/mu_main.css">
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

.main label {
	position: relative;
    margin-right: 6px;
    bottom:2px;
}

.main .trader {
	width:15px;
	height:15px;
}

.main input[type="radio"] {
    margin-right: 55px; /* 라디오 버튼 사이 간격 조절 */
}
</style>
</head>

<body>
	<div id="container">

		<!-- main -->
		<div class="main">
			<form action="gmMemberUpdPro" novalidate method="post">
				<div class="head">
					<span>회원정보</span>를 입력해주세요 
				</div>
				<input type="text" placeholder="ID" required readonly name="id" value="${mem.id}"> 
				<input type="password" placeholder="비밀번호" name="pass"> 
				<input type="text" placeholder="이름" name="name" value="${mem.name}">
				<label for="trader">소비자</label><input class="trader" type="radio" name="trader" id="trader"  value="1" required 
				 ${mem.trader==1 ? "checked" : " " } disabled>
				<label for="trader">판매자</label><input class="trader" type="radio" name="trader" id="trader"  value="2" required  
				 ${mem.trader==2 ? "checked" : " " } disabled> 
				<input type="tel" placeholder="휴대폰 번호" name="tel" value="${mem.tel}"> 
				<input type="email" placeholder="이메일" name="email" value="${mem.email}"> 
				<input type="submit" class="finish" value="수정 완료">
			</form>
		</div>

	</div>
	
</body>

</html>