<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 화면 샘플 - Bootstrap</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/board/bUpd_main.css">
<style>

</style>
<script>
function chkpass(f) {
	let chk = f.pass.value == f.pass2.value
	if (!chk) {
		alert("비밀번호 확인이 틀렸습니다")
		f.pass2.focus()
		return false
	} 
	return true
}
</script>
</head>

<body>
	<div class="container">
		<div>
			<div>
				<h4>게시판 수정</h4>
				<form action="gmBoardUpdPro" method="post"
					onsubmit="return chkpass(this)" novalidate enctype="multipart/form-data">
					<input type="hidden" name="num" value="${board.num }">
					<input type="hidden" name="originfile" value="${board.file1 }">
					<div class="form-group">
						<label for="name">작성자</label> <input type="text" name="name"
							id="name" class="form-control" placeholder="이름" value="${board.name }" required>
					</div>

					<div class="form-group">
						<div>
							<label for="name">비밀번호</label> <input type="password" name="pass"
								id="pass" class="form-control" placeholder="비밀번호" required>
						</div>
					</div>

					<div class="form-group">
						<label for="name">제목</label> <input type="text" name="subject"
							id="subject" class="form-control" placeholder="제목" value="${board.subject }" required>
					</div>
					<div class="form-group">
						<label for="name">내용</label>
						<textarea name="content" id="content" class="form-control" style="overflow-y: scroll"
							required>${board.content }</textarea>
					</div>
					<div class="form-group">
						<label for="name">파일 업로드:${board.file1 }</label> <input type="file" name="file1"
							id="file1"> 
					</div>
					
					<input type="submit" value="저장">
				</form>
			</div>
		</div>
	</div>
	<script> window.addEventListener('load', () => { const forms = document.getElementsByClassName('validation-form'); Array.prototype.filter.call(forms, (form) => { form.addEventListener('submit', function (event) { if (form.checkValidity() === false) { event.preventDefault(); event.stopPropagation(); } form.classList.add('was-validated'); }, false); }); }, false); </script>
</body>
</html>
