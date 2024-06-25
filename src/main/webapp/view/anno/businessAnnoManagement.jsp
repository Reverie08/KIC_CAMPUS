<%@page import="model.Anno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>칸반 보드</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    <style>
        .card {
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 0.5rem;
        }
        .column {
            min-height: 80vh;
            position: relative;
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
                <h1 class="text-2xl font-bold">칸반 보드</h1>
            </div>
        </header>
        <div class="flex flex-grow">
            <!-- 사이드바 -->
            <aside class="bg-white rounded-lg shadow p-4 fixed-sidebar">
                <h2 class="text-lg font-bold mb-4">사이드바</h2>
                <ul>
                		<li class="mb-2"><a href="${pageContext.request.contextPath}/business/business-main" class="text-blue-500">메인화면</a></li>
                    <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/business-anno-info?annoId=${anno.annoId}" class="text-blue-500">공고내용</a></li>
                    <li class="mb-2"><a href="${pageContext.request.contextPath}/anno/business-anno-management?annoId=${anno.annoId}" class="text-blue-500"><b>이력서 관리</b></a></li>
                    <li class="mb-2"><a href="#" class="text-blue-500">미정</a></li>
                </ul>
                <button class="bg-blue-500 text-white px-4 py-2 rounded mt-4" id="add-column">+ 칼럼 추가</button>
            </aside>
            <!-- 컬럼 컨테이너 -->
            <div class="main-content w-5/6 p-4 overflow-x-auto" id="columns-container">
                <div class="flex space-x-4" id="column-wrapper">
                    <!-- 예제 컬럼 -->
                    <div class="column bg-white rounded-lg shadow p-4 w-60">
                        <h2 class="text-lg font-bold mb-4 flex justify-between items-center">
                            서류 평가
                            <div>
                                <button type="button" class="text-red-500" onclick="deleteColumn(this)">x</button>
                            </div>
                        </h2>
                        <div class="card bg-gray-50 p-4 mb-4">
                            <h3 class="font-bold text-sm">강진아</h3>
                            <p class="text-gray-600 text-xs">서울 홈페이지</p>
                            <p class="text-gray-600 text-xs">2024.04.20</p>
                            <p class="text-gray-600 text-xs">평가 완료 (12/12)</p>
                            <p class="text-gray-600 text-xs text-green-500">95점</p>
                        </div>
                        <div class="card bg-gray-50 p-4 mb-4">
                            <h3 class="font-bold text-sm">도민지</h3>
                            <p class="text-gray-600 text-xs">서울 홈페이지</p>
                            <p class="text-gray-600 text-xs">2024.08.12</p>
                            <p class="text-gray-600 text-xs">평가 중 (8/12)</p>
                            <p class="text-gray-600 text-xs text-red-500">56점</p>
                        </div>
                        <div class="card bg-gray-50 p-4 mb-4">
                            <h3 class="font-bold text-sm">류도경</h3>
                            <p class="text-gray-600 text-xs">wanted.co.kr</p>
                            <p class="text-gray-600 text-xs">2024.04.22</p>
                            <p class="text-gray-600 text-xs">평가 중 (8/12)</p>
                            <p class="text-gray-600 text-xs text-red-500">28점</p>
                        </div>
                    </div>
                    <!-- 칼럼 추가 버튼 -->
                    <div class="flex items-center">
                        <button type="button" class="text-blue-500 text-2xl" id="dynamic-add-column">+</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#dynamic-add-column').on('click', function() {
                addColumn();
            });

            function addCard(button) {
                const $column = $(button).closest('.column');
                const $card = $('<div>', { class: 'card bg-gray-50 p-4 mb-4' });
                $card.html('<h3 class="font-bold text-sm">New Task</h3><p class="text-gray-600 text-xs">Details about the new task</p>');
                $column.find('h2').after($card);
            }

            function addColumn() {
                const $container = $('#column-wrapper');
                const $column = $('<div>', { class: 'column bg-white rounded-lg shadow p-4 w-60' });
                $column.html(`
                    <h2 class="text-lg font-bold mb-4 flex justify-between items-center">
                        New Column
                        <div>
                            <button class="text-red-500" onclick="deleteColumn(this)">x</button>
                        </div>
                    </h2>
                `);
                // 칼럼을 추가한 후 버튼을 이동합니다.
                $('#dynamic-add-column').closest('.flex.items-center').before($column);
            }

            function deleteColumn(button) {
                $(button).closest('.column').remove();
            }

            window.addCard = addCard;
            window.deleteColumn = deleteColumn;
        });
    </script>
</body>
</html>