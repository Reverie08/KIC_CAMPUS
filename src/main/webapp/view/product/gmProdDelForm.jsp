<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원탈퇴</title>
<style>

</style>
</head>
<body>


	<div class="container">
		<div>
			<div>
				<h4>상품 삭제</h4>
				<form novalidate      
				action="gmProdDel" method="post">
				<input type="hidden" name="prodid" value="${prodid}">
				
				<!-- 	<div>
						<div>
							<label for="pass">비밀번호</label> <input type="password"
								class="form-control" id="pass" placeholder="" value="" name="pass" 
								required>
							<div>비밀번호을 입력해주세요.</div>
						</div>
					</div> -->
					
					
					<div></div>
					<button type="submit">상품 삭제</button>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>