<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/board/bInfo_main.css">
</head>

<body>
    <div class="container">
        <div class="board-info">
            <h4 class="title">게시물 정보</h4>
            <table class="board-table">
                <tr>
                    <td class="label">글번호</td>
                    <td class="value">${board.num }</td>
                </tr>
                <tr>
                    <td class="label">제목</td>
                    <td class="value">${board.subject }</td>
                </tr>
                <tr>
                    <td class="label">작성자</td>
                    <td class="value">${board.name }</td>
                </tr>
                <tr>
                    <td class="label">내용</td>
                    <td class="value">${board.content }</td>
                </tr>
                <tr>
                    <td class="label">조회수</td>
                    <td class="value">${board.readcnt }</td>
                </tr>
                <tr>
                    <td class="label">이미지</td>
                    <td class="value"><img class="board-image"
                        src="${pageContext.request.contextPath}/storage/board${board.file1}" /></td>
                </tr>
                <tr>
                    <td class="actions" colspan="2">
                        <a class="action-link" href="${pageContext.request.contextPath}/board/gmBoardUpdForm?num=${board.num}">글 수정</a>
                        <a class="action-link" href="${pageContext.request.contextPath}/board/gmBoardDelForm?num=${board.num}">글 삭제</a>
                        <a class="action-link" href="${pageContext.request.contextPath}/board/gmBoardList?boardid=${sessionScope.boardid}">글 목록</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
