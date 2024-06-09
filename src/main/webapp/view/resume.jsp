<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="https://framerusercontent.com/images/2JM2En4ZikryoxRiHtpLKZJIQo.png"/><title>그리팅 | 그리팅 가이드</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
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
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            border-radius: 0.5rem;
            width: 200px;
            z-index: 1000;
        }
        .dropdown-menu.show {
            display: block;
        }
    </style>
</head>
<body class="bg-gray-100">
    <div class="flex h-screen">
        <!-- Sidebar -->
        <div class="w-1/5 bg-white shadow-lg p-4">
            <div class="flex items-center mb-4">
                <img src="https://framerusercontent.com/images/2JM2En4ZikryoxRiHtpLKZJIQo.png" alt="Logo" class="mr-2">
                <span class="text-lg font-bold">Greeting Guide</span>
            </div>
            <ul>
                <li class="mb-2 text-gray-700">공고리스트</li>
                <li class="mb-2 text-gray-700 pl-4">CX Manager</li>
                <li class="mb-2 text-red-500 pl-4">Front-end Developer</li>
            </ul>
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
                        <img src="https://via.placeholder.com/20" alt="Filter Icon" class="mr-2">
                        <span>필터</span>
                    </button>
                    <select class="border border-gray-300 rounded p-2">
                        <option>평가 대상</option>
                    </select>
                    <input type="text" placeholder="이름, 이메일, 전화번호로 검색" class="border border-gray-300 rounded p-2 flex-grow">
                    <button class="flex items-center text-gray-700" id="dropdownButton" onclick="toggleDropdown()">
                        <img src="https://via.placeholder.com/20" alt="Options Icon" class="mr-2">
                        <span>다중 선택</span>
                    </button>
                </div>
                <div class="flex items-center space-x-4">
                    <button class="flex items-center text-gray-700">
                        <img src="https://via.placeholder.com/20" alt="Applicants Icon" class="mr-2">
                        <span>지원자</span>
                    </button>
                    <button class="flex items-center text-gray-700">
                        <img src="https://via.placeholder.com/20" alt="Mail Icon" class="mr-2">
                        <span>메일함</span>
                    </button>
                    <button class="flex items-center text-gray-700">
                        <img src="https://via.placeholder.com/20" alt="Schedule Icon" class="mr-2">
                        <span>면접일정</span>
                    </button>
                    <button class="flex items-center text-gray-700">
                        <img src="https://via.placeholder.com/20" alt="Dashboard Icon" class="mr-2">
                        <span>대시보드</span>
                    </button>
                </div>
                <div class="relative">
                    <button class="flex items-center text-gray-700" id="dropdownButton" onclick="toggleDropdown()">
                        <img src="https://via.placeholder.com/20" alt="Options Icon" class="mr-2">
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

            <!-- Columns -->
            <div class="flex space-x-4">
                <!-- 지원 접수 Column -->
                <div class="w-1/4 bg-white shadow-lg rounded p-4">
                    <div class="flex items-center justify-between mb-4">
                        <h2 class="text-lg font-semibold">지원 접수</h2>
                        <button class="text-gray-500" onclick="addTemplate('apply-intake')">+</button>
                    </div>
                    <div id="apply-intake">
                        <div class="p-4 border border-gray-200 rounded mb-2">
                            <div class="text-gray-700">채지인</div>
                            <div class="text-sm text-gray-500">직접등록</div>
                            <div class="text-sm text-gray-500">2023.06.19</div>
                            <div class="text-sm text-gray-500">평가 완료 (1/1)</div>
                            <div class="text-green-500 mt-2">👍 100</div>
                        </div>
                    </div>
                </div>

                <!-- 실무자 면접 Column -->
                <div class="w-1/4 bg-white shadow-lg rounded p-4">
                    <div class="flex items-center justify-between mb-4">
                        <h2 class="text-lg font-semibold">실무자 면접</h2>
                        <button class="text-gray-500" onclick="addTemplate('practical-interview')">+</button>
                    </div>
                    <div id="practical-interview">
                        <div class="p-4 border border-gray-200 rounded mb-2">
                            <div class="text-gray-700">이지은</div>
                            <div class="text-sm text-gray-500">직접등록</div>
                            <div class="text-sm text-gray-500">2023.06.19</div>
                            <div class="text-sm text-gray-500">평가 중 (1/3)</div>
                            <div class="text-red-500 mt-2">👎 25</div>
                        </div>
                        <div class="p-4 border border-gray-200 rounded mb-2">
                            <div class="text-gray-700">한재현</div>
                            <div class="text-sm text-gray-500">직접등록</div>
                            <div class="text-sm text-gray-500">2023.06.19</div>
                            <div class="text-sm text-gray-500">평가 중 (0/3)</div>
                        </div>
                    </div>
                </div>

                <!-- 임원 면접 Column -->
                <div class="w-1/4 bg-white shadow-lg rounded p-4">
                    <div class="flex items-center justify-between mb-4">
                        <h2 class="text-lg font-semibold">임원 면접</h2>
                        <button class="text-gray-500" onclick="addTemplate('executive-interview')">+</button>
                    </div>
                    <div id="executive-interview" class="text-center text-gray-500">지원자 없음</div>
                </div>

                <!-- 입사 제안 Column -->
                <div class="w-1/4 bg-white shadow-lg rounded p-4">
                    <div class="flex items-center justify-between mb-4">
                        <h2 class="text-lg font-semibold">입사 제안</h2>
                        <button class="text-gray-500" onclick="addTemplate('job-offer')">+</button>
                    </div>
                    <div id="job-offer" class="text-center text-gray-500">지원자 없음</div>
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
            if (!button.contains(event.target) && !dropdownMenu.contains(event.target)) {
                dropdownMenu.classList.remove('show');
            }
        });
    </script>
</body>
</html>