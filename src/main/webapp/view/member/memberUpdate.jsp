<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원정보</title>
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
	background-color: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

.title {
	font-size: 24px;
	margin-bottom: 20px;
}

.info-group {
	margin-bottom: 15px;
	text-align: left;
}

.info-group label {
	display: block;
	font-weight: bold;
	color: #333;
}

.info-group input {
	width: 90%;
	padding: 8px;
	margin: 5px auto 15px auto;
	border: 1px solid #ccc;
	border-radius: 4px;
	background-color: #f9f9f9;
	font-size: 14px;
	text-align: center;
	color: #333;
}

.button {
	width: 100%;
	margin-bottom: 10px;
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
}

.button:hover {
	background-color: #0056b3;
}

.button-secondary {
	background-color: #6c757d;
	margin-top: 10px;
}

.button-secondary:hover {
	background-color: #5a6268;
}
</style>
</head>
<body>
	<div class="container">
		<div class="title">회원정보</div>
		<form
			action="${pageContext.request.contextPath}/member/memberupdatepro"
			method="post">
			<div class="info-group">
				<label for="id">사용자 아이디</label> <input type="text" id="memberId"
					name="memberId" value="${mem.memberId}" readonly>
			</div>
			<div class="info-group">
				<label for="username">사용자 이름</label> <input type="text" id="name"
					name="name" value="${mem.name}" readonly>
			</div>
			<div class="info-group">
				<label for="email">이메일</label> <input type="email" id="email"
					name="email" placeholder="abc@abc.com" value="${mem.email}">
			</div>
			<div class="info-group">
				<label for="phone">전화번호</label> <input type="tel" id="phone"
					name="phone" placeholder="010-XXXX-XXXX" value="${mem.phone}">
			</div>
			<div class="info-group">
				<label for="birth">생년월일</label> <input type="text" id="birth"
					name="birth" placeholder="YYYY-MM-DD" value="${mem.birth}">
			</div>
			<div class="info-group">
				<label for="birth">비밀번호</label> <input type="password" id="pw"
					name="pw" placeholder="비밀번호를 입력해주세요." value="">
			</div>

			<button type="submit" class="button">수정 확인</button>
		</form>
		<a href="${pageContext.request.contextPath}/member/memberinfo">
			<button type="button" class="button button-secondary">수정 취소</button>
		</a> <a href="${pageContext.request.contextPath}/member/memberdeleteform">
			<button type="button" class="button button-secondary">회원 탈퇴</button>
		</a>
	</div>
</body>
</html>