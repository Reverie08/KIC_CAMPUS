<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Anno Info</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
<style>
  .container {
    max-width: 800px;
    margin: 0 auto;
    padding: 2rem;
  }
  .info {
    display: grid;
    grid-template-columns: 1fr 2fr;
    gap: 0.5rem;
    margin-bottom: 1rem;
  }
  .info div:nth-child(odd) {
    font-weight: bold;
  }
  .actions {
    display: flex;
    gap: 1rem;
    margin-top: 1rem;
  }
  .header {
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
</style>
</head>
<body class="bg-gray-100">
  <div class="container bg-white p-6 rounded-lg shadow-md">
    <h2 class="text-2xl font-bold mb-4">Anno Info</h2>
    
    <div class="info">
      <div>annoId:</div>
      <div>${anno.annoId}</div>
      
      <div>annodate:</div>
      <div>${anno.annoDate}</div>
      
      <div>기업명:</div>
      <div>${anno.businessName}</div>
      
      <div>복지:</div>
      <div>${anno.welfare}</div>
      
      <div>공고 제목:</div>
      <div>${anno.annoTitle}</div>
      
      <div>경력:</div>
      <div>${anno.annoCareer}</div>
      
      <div>연봉:</div>
      <div>${anno.annoSalary}</div>
      
      <div>학력:</div>
      <div>${anno.annoEdu}</div>
      
      <div>직급:</div>
      <div>${anno.annoGrade}</div>
      
      <div>근무 형태:</div>
      <div>${anno.annoWorkType}</div>
      
      <div>근무 요일:</div>
      <div>${anno.annoWorkDay}</div>
      
      <div>근무지:</div>
      <div>${anno.annoWorkPlace}</div>
      
      <div>공통 자격:</div>
      <div>${anno.annoCommon}</div>
      
      <div>지원 자격:</div>
      <div>${anno.annoQualification}</div>
      
      <div>채용 인원:</div>
      <div>${anno.annoPickNum}</div>
      
      <div>공고 내용:</div>
      <div>${anno.annoContent}</div>
      
      <div>기업 ID:</div>
      <div>${anno.businessId}</div>
      
      <div>스킬 ID:</div>
      <div>${anno.skillId}</div>
    </div>
    
    <div class="actions">
      <a href="${pageContext.request.contextPath}/member/member-main?annoid=${anno.annoId}" class="bg-blue-500 text-white px-4 py-2 rounded">지원하기</a>
      <a href="${pageContext.request.contextPath}/anno/user-anno-list" class="bg-gray-500 text-white px-4 py-2 rounded">목록보기</a>
    </div>
  </div>
</body>
</html>
