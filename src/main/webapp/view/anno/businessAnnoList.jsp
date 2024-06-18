<%@page import="model.Anno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Job Announcements</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
  <style>
    .card-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 16px;
        width: 100%;
    }
    .card {
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 60%;
        padding: 0;
        background-color: #fff; /* 카드 배경색을 흰색으로 설정 */
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s, box-shadow 0.2s;
        overflow: hidden;
        text-decoration: none;
        color: inherit;
        display: flex;
        flex-direction: column;
    }
    .card-content-wrapper {
        display: flex;
    }
    .card-content {
        padding: 16px;
        width: 66.67%;
    }
    .card-extra {
        padding: 16px;
        width: 33.33%;
        border-left: 1px solid #ddd;
    }
    .card-title {
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 8px;
    }
    .card-text {
        font-size: 14px;
        color: #555;
        margin-bottom: 4px;
    }
    .card-footer {
        font-size: 12px;
        color: #777;
        padding: 16px;
        align-self: flex-start;
    }
    .card:hover {
        transform: scale(1.05);
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
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
  </style>
</head>
<body class="bg-gray-100">
  <div class="flex flex-col h-screen">
    <header class="header bg-white p-4 shadow-md">
      <div class="container mx-auto flex justify-between items-center">
        <h1 class="text-2xl font-bold">Job Announcements</h1>
      </div>
    </header>
    <div class="flex flex-grow">
    
      <!-- Sidebar -->
      <aside class="bg-white rounded-lg shadow p-4 fixed-sidebar">
        <h2 class="text-lg font-bold mb-4">Sidebar</h2>
        <ul>
          <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/business-anno-list" class="text-blue-500"><b>공고목록</b></a></li>
          <li class="mb-2"><a href="#" class="text-blue-500">#</a></li>
          <li class="mb-2"><a href="#" class="text-blue-500">#</a></li>
          <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/business-anno-insert-form" class="text-blue-500">공고작성</a></li>
        </ul>
      </aside>

      <!-- Main Content -->
      <div class="main-content w-5/6 p-4 overflow-x-auto">
        <div class="card-container">
          <c:set var="annoId" value="${annoId}"/>
          <c:forEach var="businessAnno" items="${li}">
            <a href="${pageContext.request.contextPath}/anno/business-anno-info?annoid=${businessAnno.annoId}" class="card">
              <div class="card-content-wrapper">
                <div class="card-content">
                  <div class="card-title">${businessAnno.annoId}</div>
                  <div class="card-title">${businessAnno.businessId}</div>
                  <div class="card-title">${businessAnno.businessName}</div> 
                  <div class="card-text">Title: ${businessAnno.annoTitle}</div>
                  <div class="card-text">Grade: ${businessAnno.annoGrade}</div>
                  <div class="card-text">Type: ${businessAnno.annoWorkType}</div>
                  <div class="card-text">Place: ${businessAnno.annoWorkPlace}</div>
                </div>
                <div class="card-extra">
                  <div class="card-text">Extra Info 1: </div>
                  <div class="card-text">Extra Info 2: </div>
                  <div class="card-text">Extra Info 3: </div>
                </div>
              </div>
              <div class="card-footer">
                <fmt:formatDate value="${businessAnno.annoDate}" pattern="yyyy-MM-dd" />
              </div>
            </a>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
