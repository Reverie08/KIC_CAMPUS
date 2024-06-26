<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Application Page</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 2rem;
        }
        .resume-container {
            max-height: 300px;
            overflow-y: auto;
        }
        .support-button {
            background-color: #4CAF50; /* Green */
            color: white;
            text-align: center;
            padding: 12px 0;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            width: 100%;
        }
    </style>
</head>
<body class="bg-gray-100">
    <div class="container bg-white p-6 rounded-lg shadow-md">
        <h1 class="text-blue-600 font-bold text-lg mb-2">지오다노</h1>
        <h2 class="text-xl font-bold mb-4">지오다노 신입 및 경력직 사원 모집</h2>
        
        <label for="applicationField" class="block mb-2">지원분야를 선택해 주세요.</label>
        <select id="applicationField" class="block w-full mb-4 p-2 border border-gray-300 rounded-md">
            <!-- Options go here -->
        </select>
        
        
        <c:forEach var="r" items="${memberResumeList}">
	        <div class="border p-4 mb-4">
	            <h3 class="text-lg font-bold mb-2">지원이력서</h3>
	            <p>${r.selfInfo }</p>
	            <div class="mt-2">
	                <span class="block text-gray-700">이메일: ${r.email}</span>
	                <span class="block text-gray-700">휴대폰번호: ${r.phone }</span>
	            </div>
	        </div>
        </c:forEach>
        
        
        <div class="border p-4 mb-4 resume-container">
            <h3 class="text-lg font-bold mb-2">선택항목</h3>
            <ul>
                <c:forEach var="resume" items="${memberResumeList}">
                    <li class="mb-2">
                        <span class="block text-gray-700">[포트폴리오] ${resume.portfolio.portfolioName}</span>
                        <a href="#" class="text-blue-500">""</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        
        <p class="text-sm text-gray-500 mb-4">* 개인정보보호를 위해 개인정보가 포함된 파일은 사전에 동의 없이 삭제될 수 있습니다.</p>
        <p class="text-sm text-gray-500 mb-4">* 채용시스템에 따른 마감 90일까지 지원기기에서 삭제 가능합니다.</p>
        <form method="get"  
        	action="${pageContext.request.contextPath}/resume/resume-anno-register" 
        	>
        <input type="hidden" name="resumeId" value="${resumeId }" >
        <input type="hidden" name="annoId" value="${annoId}" >
        <button class="bg-orange-500 text-white w-full py-2 rounded mb-4">지원하기</button>
        <button type="submit" class="support-button">지원하기</button>
        </form>
    </div>
    
    <script>
    // onsubmit="return windowClose()"
      function windowClose(){
    	  window.close();
      }
    </script>
</body>
</html>
