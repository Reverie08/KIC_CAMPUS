<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    .btn {
     cursor: pointer;
    }
  </style>
  <script>
    function removeCheck() {
      return confirm("정말 삭제하시겠습니까?");
    }
  </script>
</head>
<body class="bg-gray-100">
  <div class="flex flex-col h-screen">
    <header class="header bg-white p-4 shadow-md">
      <div class="container mx-auto flex justify-between items-center">
        <h1 class="text-2xl font-bold">Anno Info</h1>
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
          <h2 class="text-2xl font-bold mb-4">Anno Info</h2>
          
          <div class="info">
            <div>annoId:</div>
            <div>${anno.annoId}</div>
            
            <div>annoDate:</div>
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
          </div>

          <!-- Skill Selection -->
          <div class="form-group">
            <label for="skills" class="form-label">스킬:</label>
            <div id="skills">
              <c:forEach var="skill" items="${skills}">
                <c:if test="${skill.java != null && !skill.java.isEmpty()}">
                  <div class="skill-button" data-skillname="java">${skill.java}</div>
                </c:if>
                <c:if test="${skill.jsp != null && !skill.jsp.isEmpty()}">
                  <div class="skill-button" data-skillname="jsp">${skill.jsp}</div>
                </c:if>
                <c:if test="${skill.html != null && !skill.html.isEmpty()}">
                  <div class="skill-button" data-skillname="html">${skill.html}</div>
                </c:if>
                <c:if test="${skill.css != null && !skill.css.isEmpty()}">
                  <div class="skill-button" data-skillname="css">${skill.css}</div>
                </c:if>
                <c:if test="${skill.javascript != null && !skill.javascript.isEmpty()}">
                  <div class="skill-button" data-skillname="javascript">${skill.javascript}</div>
                </c:if>
                <c:if test="${skill.react != null && !skill.react.isEmpty()}">
                  <div class="skill-button" data-skillname="react">${skill.react}</div>
                </c:if>
                <c:if test="${skill.springframework != null && !skill.springframework.isEmpty()}">
                  <div class="skill-button" data-skillname="springframework">${skill.springframework}</div>
                </c:if>
                <c:if test="${skill.springboot != null && !skill.springboot.isEmpty()}">
                  <div class="skill-button" data-skillname="springboot">${skill.springboot}</div>
                </c:if>
                <c:if test="${skill.python != null && !skill.python.isEmpty()}">
                  <div class="skill-button" data-skillname="python">${skill.python}</div>
                </c:if>
                <c:if test="${skill.typescript != null && !skill.typescript.isEmpty()}">
                  <div class="skill-button" data-skillname="typescript">${skill.typescript}</div>
                </c:if>
                <c:if test="${skill.express != null && !skill.express.isEmpty()}">
                  <div class="skill-button" data-skillname="express">${skill.express}</div>
                </c:if>
                <c:if test="${skill.oracle != null && !skill.oracle.isEmpty()}">
                  <div class="skill-button" data-skillname="oracle">${skill.oracle}</div>
                </c:if>
                <c:if test="${skill.mysql != null && !skill.mysql.isEmpty()}">
                  <div class="skill-button" data-skillname="mysql">${skill.mysql}</div>
                </c:if>
                <c:if test="${skill.mongodb != null && !skill.mongodb.isEmpty()}">
                  <div class="skill-button" data-skillname="mongodb">${skill.mongodb}</div>
                </c:if>
              </c:forEach>
            </div>
          </div>
          
          <div class="actions">
            <a href="${pageContext.request.contextPath}/anno/business-anno-update-form?annoid=${anno.annoId}" class="bg-blue-500 text-white px-4 py-2 rounded">공고수정</a>
            <form action="anno-delete-pro" method="post" onsubmit="return removeCheck();" class="btn">
              <input type="hidden" name="annoId" value="${anno.annoId}">
              <input type="submit" value="공고삭제" class="bg-red-500 text-white px-4 py-2 rounded btn">
            </form>
            <a href="${pageContext.request.contextPath}/anno/business-anno-list" class="bg-gray-500 text-white px-4 py-2 rounded">목록보기</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
