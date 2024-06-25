<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="https://framerusercontent.com/images/2JM2En4ZikryoxRiHtpLKZJIQo.png" />
<title>그리팅 | 그리팅 가이드</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css"
	rel="stylesheet">
<style>
body {
	font-family: 'Roboto', sans-serif;
}

.dropdown-menu {
	display: none;
	position: absolute;
	right: 2rem;
	top: 4rem;
	background-color: white;
	border: 1px solid #ddd;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	border-radius: 0.5rem;
	width: 200px;
	z-index: 1000;
}

.dropdown-menu.show {
	display: block;
}

.login-inquiry {
	height: 100%;
	width: 100%;
	display: flex;
	flex-direction: row;
	gap: 10px;
	align-items: flex-end;
	flex-wrap: nowrap;
}

.inquiry-button {
	background-color: #007bff;
	color: white;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s;
}

.inquiry-button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body class="bg-gray-100">
	<div class="flex h-screen">
		<!-- Sidebar -->
		<div class="w-1/5 bg-white shadow-lg p-4 flex flex-col">
			<div>
				<div class="flex items-center mb-4">
					<img
						src="${pageContext.request.contextPath}/view/img/resume/${profileImage}"
						alt="Logo" class="mr-2"> <span class="text-lg font-bold">Greeting
						Guide</span>
				</div>
				<c:if test="${sessionScope.memberId != null }">
				<ul>
					<li class="mb-2"><a href="${pageContext.request.contextPath}/anno/user-anno-list" class="text-blue-500"><b>공고목록</b></a></li>
<%-- 				   <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/business-anno-insert-form" class="text-blue-500">공고작성</a></li> --%>
				</ul>
				</c:if>
				<c:if test="${sessionScope.businessId != null }">
				<ul>
					<li class="mb-2"><a href="${pageContext.request.contextPath}/anno/business-anno-list" class="text-blue-500"><b>공고목록</b></a></li>
				   <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/business-anno-insert-form" class="text-blue-500">공고작성</a></li>
				</ul>
				</c:if>
				<ul>
					<li class="mb-2"><a href="${pageContext.request.contextPath}/member/member-main" class="text-blue-500"><b>회원정보</b></a></li>
					<li class="mb-2"><a href="${pageContext.request.contextPath}/business/business-list" class="text-blue-500"><b>기업리스트</b></a></li>
				</ul>
			</div>
			<c:if test="${sessionScope.memberId != null || sessionScope.businessId != null}">
				<div class="login-inquiry mt-auto">
					<a href="${pageContext.request.contextPath}/member/member-logout"
						method="post">
						<button type="submit" class="inquiry-button">로그아웃</button>
					</a> <a href="${pageContext.request.contextPath}/member/member-info"
						method="post">
						<button type="submit" class="inquiry-button">내 정보</button>
					</a> <a
						href="${pageContext.request.contextPath}/resume/resume-register-form"
						method="post">
						<button type="submit" class="inquiry-button">이력서 작성하러 가기</button>
					</a>
				</div>
			</c:if>
		</div>
		<!-- Main Content -->
		<div class="flex-1 p-6">
			<!-- Header -->
			<div class="flex items-center justify-between mb-4">
				<div class="flex items-center space-x-4">
					<h1 class="text-2xl font-semibold">CX Manager</h1>
					<span class="text-gray-500">채용사이트 게시팀</span>
				</div>
				<div class="flex items-center space-x-4">
					<button class="flex items-center text-gray-700">
						<img src="https://via.placeholder.com/20" alt="Filter Icon"
							class="mr-2"> <span>필터</span>
					</button>
					<select class="border border-gray-300 rounded p-2">
						<option>평가 대상</option>
					</select> <input type="text" placeholder="이름, 이메일, 전화번호로 검색"
						class="border border-gray-300 rounded p-2 flex-grow">
					<button class="flex items-center text-gray-700" id="dropdownButton"
						onclick="toggleDropdown()">
						<img src="https://via.placeholder.com/20" alt="Options Icon"
							class="mr-2"> <span>다중 선택</span>
					</button>
				</div>
				<div class="flex items-center space-x-4">
					<button class="flex items-center text-gray-700">
						<img src="https://via.placeholder.com/20" alt="Applicants Icon"
							class="mr-2"> <span>지원자</span>
					</button>
					<button class="flex items-center text-gray-700">
						<img src="https://via.placeholder.com/20" alt="Mail Icon"
							class="mr-2"> <span>메일함</span>
					</button>
					<button class="flex items-center text-gray-700">
						<img src="https://via.placeholder.com/20" alt="Schedule Icon"
							class="mr-2"> <span>면접일정</span>
					</button>
					<button class="flex items-center text-gray-700">
						<img src="https://via.placeholder.com/20" alt="Dashboard Icon"
							class="mr-2"> <span>대시보드</span>
					</button>
				</div>
				<div class="relative">
					<button class="flex items-center text-gray-700" id="dropdownButton"
						onclick="toggleDropdown()">
						<img src="" alt="Options Icon" class="mr-2">
					</button>
					<div id="dropdownMenu" class="dropdown-menu">
						<ul class="space-y-2">
							<li class="text-gray-700">경력</li>
							<li class="text-gray-700">나이</li>
							<li class="text-gray-700">등록일</li>
							<li class="text-gray-700">병역사항</li>
							<li class="text-gray-700">본인여부</li>
							<li class="text-gray-700">상펄</li>
							<li class="text-gray-700">장애사항</li>
							<li class="text-gray-700 border-t pt-2 text-red-500">지원 경로</li>
							<li class="text-gray-700">채용 단계</li>
						</ul>
					</div>
				</div>
			</div>
			<form action="update-profileImage" method="post"
				enctype="multipart/form-data">
				<div class="flex bg-white shadow-lg rounded p-4 mb-4">
					<!-- 왼쪽에 프로필 사진 -->
					<div class="w-1/3 mr-8">
						<h2 class="text-lg font-semibold mb-4">프로필 사진</h2>
						<input type="hidden" name="num" value="${member.memberId}" /> <input
							type="hidden" name="originfile" value="${member.profileImage}" />
						<div class="w-48 h-48 bg-gray-200 rounded-full overflow-hidden">
							<img
								src="${pageContext.request.contextPath}/img/member/${member.profileImage}"
								alt="프로필 사진" class="w-full h-full object-cover">
						</div>
						<input type="file" name="profileImageFile" id="profile-pic"
							class="mt-4">
						<button type="submit" class="inquiry-button">변경하기</button>
					</div>
					<!-- 오른쪽에 개인 정보 -->
					<div class="w-2/3">
						<h2 class="text-lg font-semibold mb-4">개인 정보</h2>
						<form action="member-update-pro" method="post"
							enctype="multipart/form-data">
							<div class="mb-4">
								<label for="name"
									class="block text-sm font-medium text-gray-700">이름</label> <input
									type="text" name="name" id="name"
									class="mt-1 p-2 border border-gray-300 rounded w-full"
									value="${member.name}" readonly>
							</div>
							<div class="mb-4">
								<label for="email"
									class="block text-sm font-medium text-gray-700">이메일</label> <input
									type="email" name="email" id="email"
									class="mt-1 p-2 border border-gray-300 rounded w-full"
									value="${member.email}" readonly>
							</div>
							<div class="mb-4">
								<label for="phone"
									class="block text-sm font-medium text-gray-700">전화번호</label> <input
									type="tel" name="phone" id="phone"
									class="mt-1 p-2 border border-gray-300 rounded w-full"
									value="${member.phone}" readonly>
							</div>
							<div class="mb-4">
								<label for="birth"
									class="block text-sm font-medium text-gray-700">생년월일</label> <input
									type="text" name="birth" id="birth"
									class="mt-1 p-2 border border-gray-300 rounded w-full"
									value="${member.birth}" readonly>
							</div>
						</form>
					</div>
				</div>
			</form>

			<!-- 이력서 관리 -->
			<div class="flex flex-col bg-white shadow-lg rounded p-4 mb-4">
				<div class="flex justify-between mb-2">
					<h2 class="text-lg font-semibold">이력서 관리</h2>
				</div>
				<div class="border-t border-gray-200 pt-4">
					<table class="w-full">
						<thead class="text-left text-gray-500">
							<tr>
								<th>포지션 제안</th>
								<th>이력서 제목</th>
								<th>이력서 관리</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="resume" items="${memberResumeList}">
								<tr>
									<td class="py-2">
										<div class="flex items-center">
											<span
												class="bg-blue-100 text-blue-700 text-xs font-semibold px-2 py-1 rounded">기본이력서</span>
											<span class="ml-2 text-gray-700">${resume.selfInfo}</span>
										</div>
									</td>
									<td class="text-sm text-gray-500">${resume.registerDate}</td>
									<td>
										<div class="flex space-x-2">
							       <a href="${pageContext.request.contextPath}/resume/update-resume?resumeId=${resume.resumeId}" class="inquiry-button">수정</a>
                               <button onclick="deleteResume('${resume.resumeId}')" class="inquiry-button">삭제</button>
                              <a href="${pageContext.request.contextPath}/resume/resume-info?resumeId=${resume.resumeId}" class="inquiry-button">이력서 보기</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script>
	  
	   function deleteResume(resumeId){
	   	const ok = confirm("이력서를 지우시겠습니까??");
	   	if(ok == true){
	   		location.href= "${pageContext.request.contextPath}/resume/delete-resume?resumeId="+resumeId;
	   	}else{
	   			
	   	}
	   }

	
    </script>
</body>
</html>
