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
				<ul>
					<li class="mb-2 text-gray-700">공고리스트</li>
					<li class="mb-2 text-gray-700 pl-4">CX Manager</li>
					<li class="mb-2 text-red-500 pl-4">Front-end Developer</li>
				</ul>
				<ul>
					<li class="mb-2 text-gray-700">어쩌구리스트</li>
					<li class="mb-2 text-gray-700 pl-4">CX Manager</li>
					<li class="mb-2 text-red-500 pl-4">Front-end Developer</li>
				</ul>
			</div>
			<c:if test="${sessionScope.memberId != null }">
				<div class="login-inquiry mt-auto">
					<a href="${pageContext.request.contextPath}/member/member-logout"
						method="post">
						<button type="submit" class="inquiry-button">개인 로그아웃</button>
					</a> 
					
					<a href="${pageContext.request.contextPath}/member/member-info"
						method="post">
						<button type="submit" class="inquiry-button">내 정보</button>
					</a>
						<a href="${pageContext.request.contextPath}/resume/resume-register-form"
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
						<img src="https://via.placeholder.com/20" alt="Options Icon"
							class="mr-2">
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
			<div class="flex bg-white shadow-lg rounded p-4 mb-4">
				<!-- 왼쪽에 프로필 사진 -->
				<div class="w-1/3 mr-8">
					<h2 class="text-lg font-semibold mb-4">프로필 사진</h2>
					<div class="w-48 h-48 bg-gray-200 rounded-full overflow-hidden">
						<img src="https://via.placeholder.com/150" alt="프로필 사진"
							class="w-full h-full object-cover">
					</div>
					<input type="file" name="profileImage" id="profile-pic"
						class="mt-4">
				</div>

				<!-- 오른쪽에 나머지 정보 -->
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

			<!-- Column Container -->
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
						
							<c:forEach var="resume" items="${memberResumeList} ">
							<tr>
								<td class="py-2">
									<div class="flex items-center">
										<span class="bg-blue-100 text-blue-700 text-xs font-semibold px-2 py-1 rounded">기본이력서</span>
										<span class="ml-2 text-gray-700">이력서 설명</span>
									</div>
								</td>
								<td class="text-sm text-gray-500">이력서 등록날짜</td>
								<td>
									<div class="flex space-x-2">
										<button class="text-blue-500">수정</button>
										<button class="text-blue-500">삭제</button>
										<a href="${pageContext.request.contextPath}/resume/resume-info?resumeid=5">이력서 보기</a>
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
        function addTemplate(columnId) {
            const template = `
                <div class="p-4 border border-gray-200 rounded mb-2">
                    <div class="text-gray-700">New Candidate</div>
                    <div class="text-sm text-gray-500">직접등록</div>
                    <div class="text-sm text-gray-500">2023.06.19</div>
                    <div class="text-sm text-gray-500">평가 중 (0/3)</div>
                </div>
            `;
            const column = document.getElementById(columnId);
            if (column.classList.contains('text-center')) {
                column.classList.remove('text-center', 'text-gray-500');
                column.innerHTML = '';
            }
            column.insertAdjacentHTML('beforeend', template);
        }

        function toggleDropdown() {
            const dropdownMenu = document.getElementById('dropdownMenu');
            dropdownMenu.classList.toggle('show');
        }

        document.addEventListener('click', function(event) {
            const dropdownMenu = document.getElementById('dropdownMenu');
            const button = document.getElementById('dropdownButton');
            if (!button contains(event.target) && !dropdownMenu.contains(event.target)) {
                dropdownMenu.classList.remove('show');
            }
        });
    </script>
</body>
</html>
