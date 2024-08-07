<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath }/member/picturePro"
			enctype="multipart/form-data" method="post">
			<input type="file" name="picture">
			<button type="submit">이미지 등록</button>	
		</form>
	</div>
</body>
</html>