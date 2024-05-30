<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/product/pl_main.css">
<title>Insert title here</title>
<style>

</style>
</head>
<script>
function backToTop() {
  const position =
    document.documentElement.scrollTop || document.body.scrollTop;
  if (position) {
    window.requestAnimationFrame(() => {
      window.scrollTo(0, position - position / 10);
      backToTop();
    });
  }
} 
</script>
<body>
	<div class="main">
		<div class="title">등록된 상품 리스트</div>
		
		<div class="product-container">
			<c:forEach var="prod" items="${li}">
				<a
					href="${pageContext.request.contextPath}/product/gmProdInfo?prodid=${prod.prodid}">
					<ul class="prodlist">
						<li><img
							src="${pageContext.request.contextPath}/storage/product/${prod.file2}"
							width="100px" height="120px"></li>
						<li>${prod.prodname }</li>
						<li>${prod.price }원</li>
					</ul>
				</a>
			</c:forEach>
		</div>
		
		<div class="prodform">
			<a href="${pageContext.request.contextPath }/product/gmProdForm">상품
				등록</a>
		</div>
		<button class="gotop" onclick="backToTop()">Top</button>


		



	</div>
</body>
</html>