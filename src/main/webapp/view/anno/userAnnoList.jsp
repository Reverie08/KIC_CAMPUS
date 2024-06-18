<%@page import="model.Anno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Announcements</title>
<style>
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 16px;
        justify-content: center; /* Center the cards */
    }
    .card {
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 300px; /* Adjust the width back to previous size */
        padding: 0; /* Reset padding */
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s, box-shadow 0.2s; /* Smooth transition */
        overflow: hidden; /* Ensure rounded corners */
        text-decoration: none; /* Remove underline from links */
        color: inherit; /* Inherit text color */
    }
    .card-content {
        padding: 16px;
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
    }
    .card:hover {
        transform: scale(1.05); /* Slightly enlarge the card */
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* Deeper shadow */
    }
</style>
</head>
<body>
    <div class="card-container">
        <c:set var="annoId" value="${annoId}"/>
        <c:forEach var="userAnno" items="${li}">
            <a href="${pageContext.request.contextPath}/anno/user-anno-info?annoid=${userAnno.annoId}" class="card"> <!-- Replace "yourLinkHere" with your actual link -->
                <div class="card-content">
                    <div class="card-title">${userAnno.annoId}</div>
                    <div class="card-title">${userAnno.businessId}</div>
                    <div class="card-title">${userAnno.businessName}</div>
                    <div class="card-text">Title: ${userAnno.annoTitle}</div>
                    <div class="card-text">Grade: ${userAnno.annoGrade}</div>
                    <div class="card-text">Type: ${userAnno.annoWorkType}</div>
                    <div class="card-text">Place: ${userAnno.annoWorkPlace}</div>
                </div>
                <div class="card-footer">
                    <fmt:formatDate value="${userAnno.annoDate}" pattern="yyyy-MM-dd" />
                </div>
            </a>
        </c:forEach>
    </div>
</body>
</html>
