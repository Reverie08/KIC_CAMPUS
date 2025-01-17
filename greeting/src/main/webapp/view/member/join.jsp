<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        body {
            font-family: Pretendard-Regular, Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 400px;
            padding: 20px;
        }
        .container h2 {
            margin-top: 0;
            text-align: center;
        }
        .container form {
            display: flex;
            flex-direction: column;
        }
        .container form label {
            margin-bottom: 5px;
            font-weight: bold;
        }
        .container form input {
            margin-bottom: 10px;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .container form input[type="password"] {
            position: relative;
        }
        .password-requirements {
            display: none;
            flex-wrap: wrap;
            margin-bottom: 10px;
        }
        .password-requirements span {
            display: flex;
            align-items: center;
            margin-bottom: 5px;
            margin-right: 5px;
            padding: 5px;
            border-radius: 5px;
        }
        .password-requirements span.invalid {
            color: #dc3545;
            background-color: #f8d7da;
        }
        .password-requirements span.valid {
            color: #28a745;
            background-color: #d4edda;
        }
        .password-requirements span::before {
            content: '✖';
            margin-right: 5px;
        }
        .password-requirements span.valid::before {
            content: '✔';
        }
        
        .email {
        	display: flex;
        }
        
        .email input{
        	display: inline-block;
        	align-content: center;
        }
        
        .email input:last-of-type{
        	width: 201px;
        }
        
        .email span {
        	display: inline-block;
        	padding: 0 2px;
        	padding-top: 10px;
        }
        
        .address input#postcode {
        	margin-bottom: 2px;
        }
        
        .address-detail{
        	display : flex;
        	flex-direction: column;
        }
        
        .address-detail input#address{
        	 margin-bottom: 2px;
        }
        
        .container form button {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .container form button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>회원가입</h2>
        <form action="joinPro" novalidate name="joinform" method="post">
        	<label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름">
            
	        	<label for="userid">아이디</label>
	            <input type="text" id="userid" name="userid" placeholder="아이디">
            
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" oninput="validatePassword()">
            <div class="password-requirements" id="password-requirements">
                <span id="uppercase" class="invalid">영어 대문자</span>
                <span id="lowercase" class="invalid">영어 소문자</span>
                <span id="number" class="invalid">숫자</span>
                <span id="special" class="invalid">특수문자</span>
                <span id="length" class="invalid">8자 이상</span>
                <span id="no-personal-info" class="invalid">개인정보 미포함</span>
            </div>

            <label for="confirm-password">비밀번호 확인</label>
            <input type="password" id="confirm-password" name="confirm-password" onfocus="showPasswordRequirements()">
        	
        	<label for="gender">성별</label>
        	<div class="gender">
        		<input type="radio" id="gender" name="gender" value="1">남자
        		<input type="radio" id="gender" name="gender" value="2">여자
            </div>
            
            <label for="email">이메일</label>
            <div class="email">
	            <input type="text" name="email1" size="15"> <span>@</span> 
				<input type="email" list="email2" name="email2" placeholder="직접입력">
				<datalist id="email2">
					<option value = "gmail.com">
					<option value = "naver.com">
					<option value = "daum.net">
				</datalist>
            </div>
            
            <label for="phone">전화번호</label>
            <input type="text" id="phone" name="phone" placeholder="01012345678">
            
            <label for="birth">생년월일</label>
			<input type="text" id="birth" name="birth" placeholder="YYYYMMDD">
            
            <label for="address">주소</label>
            <div class="address">
	            <input type="text" id="postcode" name="postcode" size="5" readonly>
				<input type="button" id="postcode" value="우편번호 찾기" onclick="checkPost()">
            </div>
            <div class="address-detail">
				<input type="text" id="address" name="addr1" size="50" placeholder="주소" readonly>
				<input type="text" id="detailAddress" name="addr2" size="50" placeholder="상세주소">
            </div>
            
            <button type="submit">가입하기</button>
        </form>
    </div>
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	 
    <script>
        function showPasswordRequirements() {
            document.getElementById('password-requirements').style.display = 'flex';
            validatePassword();
        }

        function validatePassword() {
            const password = document.getElementById('password').value;
            const name = document.getElementById('name').value;
            const phone = document.getElementById('phone').value;

            const uppercase = /[A-Z]/.test(password);
            const lowercase = /[a-z]/.test(password);
            const number = /[0-9]/.test(password);
            const special = /[~!@#$%^&*(),.?":{}|<>]/.test(password);
            const length = password.length >= 8;
            const noPersonalInfo = !password.includes(name) && !password.includes(phone);

            document.getElementById('uppercase').classList.toggle('invalid', !uppercase);
            document.getElementById('uppercase').classList.toggle('valid', uppercase);
            document.getElementById('lowercase').classList.toggle('invalid', !lowercase);
            document.getElementById('lowercase').classList.toggle('valid', lowercase);
            document.getElementById('number').classList.toggle('invalid', !number);
            document.getElementById('number').classList.toggle('valid', number);
            document.getElementById('special').classList.toggle('invalid', !special);
            document.getElementById('special').classList.toggle('valid', special);
            document.getElementById('length').classList.toggle('invalid', !length);
            document.getElementById('length').classList.toggle('valid', length);
            document.getElementById('no-personal-info').classList.toggle('invalid', !noPersonalInfo);
            document.getElementById('no-personal-info').classList.toggle('valid', noPersonalInfo);
        }
        
        
        /* 우편번호 */
        
        function checkPost() {
    		console.log("우편번호")
            new daum.Postcode({	
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    let addr = ''; // 주소 변수
                    let extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                   /* // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                    } */

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('postcode').value = data.zonecode;
                    document.getElementById("address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("detailAddress").focus();
                }
            }).open();
        }
        
    </script>
</body>
</html>
