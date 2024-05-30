<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/product/product_register.css">
<title>상품 수정 폼</title>
<style>

</style>
</head>
<body>
	<div class="container">
		<h2>상품 수정</h2>
		<form action="gmProdUpd" method="post"
			novalidate enctype="multipart/form-data"  >
			<input type="hidden" name="prodid" value="${prod.prodid}">
			<input type="hidden" name="currentfile" value="${prod.file2 }">
			<div class="form-group">
				<label for="prodname">상품명</label> <input type="text" id="prodname"
					name="prodname" value="${prod.prodname }" required>
			</div>
			<div class="form-group">
				<label for="price">가격</label> <input type="number" id="price"
					name="price" value="${prod.price }" required>
			</div>
			<div class="form-group">
				<label for="prodcontent">설명</label>
				<textarea id="prodcontent" name="prodcontent"
					 required>${prod.prodcontent }</textarea>
			</div>
			<div class="form-group">
				<label for="category">카테고리</label> 
				<select id="category" name="category" required>
					<option value="">카테고리를 선택하세요</option>
					<option value="전자제품" <c:if test="${prod.category == '전자제품'}">selected</c:if>>전자제품</option>
					<option value="패션" <c:if test="${prod.category == '패션'}">selected</c:if>>패션</option>
					<option value="도서" <c:if test="${prod.category == '도서'}">selected</c:if>>도서</option>
					<option value="스포츠" <c:if test="${prod.category == '스포츠'}">selected</c:if>>스포츠</option>
					<option value="음식" <c:if test="${prod.category == '음식'}">selected</c:if>>음식</option>
				</select>
			</div>
			<div class="form-group">
				<label for="file2">이미지 업로드:${prod.file2 }</label> <input type="file" id="file2"
					name="file2" required>
			</div>
			<div class="form-group button-group">
				<button type="submit">수정</button>
				<a class="cancel" href="${pageContext.request.contextPath}/product/gmProdInfo?prodid=${prod.prodid}"><button>이전</button></a>
			</div>
		</form>
	</div>
</body>
</html>
