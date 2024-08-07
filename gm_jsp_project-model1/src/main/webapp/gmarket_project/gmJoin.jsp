<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/createpage/cp_header.css">
<link rel="stylesheet" href="../css/createpage/cp_main.css">
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

<body>
	<div id="container">

		<!-- main -->
		<div class="main">
			<form action="gmJoinPro.jsp" novalidate method="post">
				<div class="head">
					<span>회원정보</span>를 입력해주세요
				</div>
				<input type="text" placeholder="ID" required name="id"> 
				<input type="password" placeholder="비밀번호" name="pass"> 
				<input type="password" placeholder="비밀번호 재입력" name="pass2"> 
				<input type="text" placeholder="이름" name="name"> 
				<input type="tel" placeholder="휴대폰 번호" name="tel"> 
				<input type="email" placeholder="이메일" name="email"> 
				<input type="reset" class="restart" value="처음으로"> 
				<input type="submit" class="finish" value="완료">
			</form>
		</div>

	</div>
	
</body>

</html>