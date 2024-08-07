<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<style>
body {
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	background-color: #f5f5f5;
}

.container {
	text-align: center;
	background-color: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.logo {
	width: 200px;
	height: 100%;
}

.title {
	font-size: 24px;
	margin-top: 10px;
}

.subtitle {
	color: gray;
	margin-top: 5px;
	margin-bottom: 20px;
}

.input-group {
	margin-bottom: 20px;
}

.input-group input {
	width: 90%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	text-align: center;
}

.button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
}

.signup {
	margin-top: 20px;
	color: gray;
}

.signup a {
	color: #007bff;
	text-decoration: none;
}

.header {
	display: flex;
	justify-content: space-between;
	width: 100%;
	margin-bottom: 20px;
}

.header a, .header span {
	color: #000;
	text-decoration: none;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="container">
	<form action="businessloginpro" novalidate name="loginform" method="post">
		<div class="header">
			<a href="#">홈으로</a> <span>KO</span>
		</div>
		<img src="https://ifh.cc/g/hqvWJG.png" alt="Logo" class="logo">
		<div class="title">로그인</div>
		<div class="subtitle">사업자번호</div>
		<div class="input-group">
			<input type="text" name="bid" placeholder="ex)0123456789">
		</div>
		<div class="subtitle">비밀번호</div>
		<div class="input-group">
			<input type="password" name="bpw" placeholder="비밀번호">
		</div>
		<button type="submit" class="button">계속</button>
		<div class="signup">
			계정이 없으신가요? <a href="${pageContext.request.contextPath}/business/businessjoin">가입하기</a>
		</div>
	</form>
	</div>
</body>
</html>