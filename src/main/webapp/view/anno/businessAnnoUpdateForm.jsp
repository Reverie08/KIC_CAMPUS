<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Anno</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
<style>
    .container {
        max-width: 800px;
        margin: 0 auto;
        padding: 2rem;
    }
    .header {
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    .fixed-sidebar {
        position: fixed;
        top: 0;
        left: 0;
        height: 100%;
        width: 16.66%;
    }
    .main-content {
        margin-left: 16.66%;
    }
    .form-group {
        margin-bottom: 1rem;
    }
    .form-label {
        display: block;
        font-weight: bold;
        margin-bottom: 0.5rem;
    }
    .form-input {
        width: 100%;
        padding: 0.5rem;
        border: 1px solid #ddd;
        border-radius: 0.375rem;
    }
    .form-textarea {
        width: 100%;
        padding: 0.5rem;
        border: 1px solid #ddd;
        border-radius: 0.375rem;
        resize: vertical;
    }
</style>
</head>
<body class="bg-gray-100">
<div class="flex flex-col h-screen">
    <header class="header bg-white p-4 shadow-md">
        <div class="container mx-auto flex justify-between items-center">
            <h1 class="text-2xl font-bold">Update Anno</h1>
        </div>
    </header>
    <div class="flex flex-grow">
    
        <!-- Sidebar -->
      <aside class="bg-white rounded-lg shadow p-4 fixed-sidebar">
        <h2 class="text-lg font-bold mb-4">Sidebar</h2>
        <ul>
          <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/BusinessAnnoInfo?annoid=${anno.annoid}" class="text-blue-500"><b>공고내용</b></a></li>
          <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/BusinessAnnoManagement?annoid=${anno.annoid}" class="text-blue-500">이력서 관리</a></li>
          <li class="mb-2"><a href="#" class="text-blue-500">미정</a></li>
        </ul>
      </aside>

        <!-- Main Content -->
        <div class="main-content w-5/6 p-4 overflow-x-auto">
            <div class="container bg-white p-6 rounded-lg shadow-md">
                <h2 class="text-2xl font-bold mb-4">Update Anno</h2>
                <form action="AnnoUpdatePro" method="post">
                    <input type="hidden" name="annoid" value="${anno.annoid}">

                    <div class="form-group">
                        <label for="bname" class="form-label">기업명:</label>
                        <input type="text" id="bname" name="bname" value="${anno.bname}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="welfare" class="form-label">복지:</label>
                        <input type="text" id="welfare" name="welfare" value="${anno.welfare}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annotitle" class="form-label">공고 제목:</label>
                        <input type="text" id="annotitle" name="annotitle" value="${anno.annoTitle}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annocareer" class="form-label">경력:</label>
                        <input type="text" id="annocareer" name="annocareer" value="${anno.annoCareer}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annosalary" class="form-label">연봉:</label>
                        <input type="text" id="annosalary" name="annosalary" value="${anno.annoSalary}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annoedu" class="form-label">학력:</label>
                        <input type="text" id="annoedu" name="annoedu" value="${anno.annoEdu}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annograde" class="form-label">직급:</label>
                        <input type="text" id="annograde" name="annograde" value="${anno.annoGrade}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annoworktype" class="form-label">근무 형태:</label>
                        <input type="text" id="annoworktype" name="annoworktype" value="${anno.annoWorkType}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annoworkday" class="form-label">근무 요일:</label>
                        <input type="text" id="annoworkday" name="annoworkday" value="${anno.annoWorkDay}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annoworkplace" class="form-label">근무지:</label>
                        <input type="text" id="annoworkplace" name="annoworkplace" value="${anno.annoWorkPlace}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annocommon" class="form-label">공통 자격:</label>
                        <input type="text" id="annocommon" name="annocommon" value="${anno.annoCommon}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annoqualification" class="form-label">지원 자격:</label>
                        <input type="text" id="annoqualification" name="annoqualification" value="${anno.annoQualification}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annopicknum" class="form-label">채용 인원:</label>
                        <input type="text" id="annopicknum" name="annopicknum" value="${anno.annoPickNum}" class="form-input">
                    </div>

                    <div class="form-group">
                        <label for="annocontent" class="form-label">공고 내용:</label>
                        <textarea id="annocontent" name="annocontent" class="form-textarea">${anno.annoContent}</textarea>
                    </div>

                    <div class="form-group">
                        <label for="bid" class="form-label">기업 ID:</label>
                        <input type="text" id="bid" name="bid" value="${anno.bid}" class="form-input">
                    </div>
                    
                    <div class="form-group">
                        <label for="skillid" class="form-label">스킬 ID:</label>
                        <input type="text" id="skillid" name="skillid" value="${anno.skillid}" class="form-input">
                    </div>
                    
                    <div class="form-group">
                        <input type="submit" value="Submit" class="bg-blue-500 text-white px-4 py-2 rounded cursor-pointer">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
