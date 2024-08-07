<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product/product_register.css">
<title>상품 등록 폼</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<h2>상품 등록</h2>
		<form action="gmProdRegist" method="post"
			enctype="multipart/form-data" novalidate>
			<div class="form-group">
				<label for="prodname">상품명</label> <input type="text" id="prodname"
					name="prodname" placeholder="상품명을 입력하세요" required>
			</div>
			<div class="form-group">
				<label for="price">가격</label> <input type="number" id="price"
					name="price" placeholder="가격을 입력하세요" required>
			</div>
			<div class="form-group">
				<label for="prodcontent">설명</label>
				<textarea id="prodcontent" name="prodcontent"
					placeholder="상품 설명을 입력하세요" required></textarea>
			</div>
			<div class="form-group">
				<label for="category">카테고리</label> <select id="category"
					name="category" required>
					<option value="">카테고리를 선택하세요</option>
					<option value="전자제품">전자제품</option>
					<option value="패션">패션</option>
					<option value="도서">도서</option>
					<option value="스포츠">스포츠</option>
					<option value="음식">음식</option>
				</select>
			</div>
			<div class="form-group">
				<label for="file2">이미지 업로드</label> <input type="file" id="file2"
					name="file2" required>
			</div>
			<div class="form-group button-group">
				<button type="submit">등록</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</body>
</html>
