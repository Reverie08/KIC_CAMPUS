<%@page import="gmarket.gmMember"%>
<%@page import="gmarket.gmMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/menubar.css">
<link rel="stylesheet" href="../css/homepage/hp_header.css">
<link rel="stylesheet" href="../css/homepage/hp_main.css">
<link rel="stylesheet" href="../css/homepage/hp_footer.css">
<title>G마켓-지금부터의 마켓</title>
<style>
@font-face {
	font-family: 'GmarketSansMedium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

#container {
	width: 1900px;
	height: 2730px;
	overflow-x: hidden;
	overflow-y: hidden;
}
</style>
</head>
<%

String id = (String)session.getAttribute("id");
gmMemberDAO dao=new gmMemberDAO();
gmMember mem = dao.getMember(id); 

%>
<body>
	<div id="container">
		<!-- header -->
		<div class="header">
			<div class="logo">
				<a href="<%=request.getContextPath()%>/common/gmMain.jsp"><img src="../imgs/logo.png"></a>
			</div>
			<div class="search">
				<input type="text" placeholder="상품을 입력해주세요"> <img
					src="../imgs/search.png">
			</div>
			<div class="user_info">
				<ul>
					<li><a href="#"><img src="../imgs/ad.png"></a></li>
					<li><a href="<%=request.getContextPath()%>/gmarket_project/gmLogin.jsp"><img
							src="../imgs/login.png"></a></li>
					<li><a href="#"><img src="../imgs/interest.png"></a></li>
					<li><a href="#"><img src="../imgs/shopping.png"></a></li>
				</ul>
			</div>
			<div class="category1">
				<div class="cate_box">
					<div id="menubar">
						<div id="burger">
							<div class="line"></div>
							<div class="line"></div>
							<div class="line"></div>
						</div>
					</div>
					<div class="all_cate">
						<a href="#">전체 카테고리</a>
					</div>
				</div>
				<ul>
					<li><a href="#">베스트</a></li>
					<li><a href="#">슈퍼딜</a></li>
					<li><a href="#">쿠폰·출첵</a></li>
					<li><a href="#">유니버스 클럽</a></li>
					<li><a href="#">스마일프레시</a></li>
					<li><a href="#">스마일배송</a></li>
					<li><a href="#">사업자 클럽</a></li>
				</ul>
				<table>
					<tbody>
						<tr>
							<%
							if (session.getAttribute("id") == null) {
							%>
							<td><a href="<%=request.getContextPath() %>/gmarket_project/gmLogin.jsp">로그인</a></td>
							<td><a href="<%=request.getContextPath() %>/gmarket_project/gmJoin.jsp">회원가입</a></td>
							<%
							} else {
							%>
							<td><b><a href="<%=request.getContextPath() %>/gmarket_project/gmJoinInfo.jsp"><%=mem.getName() %>님</a></b></td>
							<td><a href="<%=request.getContextPath() %>/gmarket_project/gmLogout.jsp">로그아웃</a></td>
							<%
							}
							%>
							<td><a href="#">고객센터</a></td>
							<td><a href="#">Global</a></td>

						</tr>
					</tbody>
				</table>

			</div>

			<div class="category2">
				<ul>
					<li><a href="#">브랜드패션</a></li>
					<li><a href="#">패션의류 · 잡화 · 뷰티</a></li>
					<li><a href="#">유아동</a></li>
					<li><a href="#">식품 · 생필품</a></li>
					<li><a href="#">홈테코 · 문구 · 취미 · 반려</a></li>
					<li><a href="#">컴퓨터 · 디지털 · 가전</a></li>
					<li><a href="#">스포츠 · 건강 · 렌탈</a></li>
					<li><a href="#">자동차 · 공구</a></li>
					<li><a href="#">여행 · 도서 · e쿠폰</a></li>
				</ul>
				<div class="banner">
					<img src="../imgs/banner1.jpg">
				</div>
			</div>
		</div>

		<div class="mid_banner">
			<img src="../imgs/mid_banner.jpg">
		</div>
		<!-- main -->
		<div class="main">
			<div class="main_tag1">
				지금 제일 잘 나가는 상품
				<div class="full_tag1">
					전체보기
					<div>
						<img src="../imgs/arrow.png">
					</div>
				</div>
				<div class="item_list">
					<div class="nth_item">
						<img src="../imgs/item01.jpg">
						<div>[ 시투와이 ]{행사가 9900원} 쫀쫀한 모찌 클렌징폼 220ml 4개 폼클렌징</div>
						<div>
							<span>9,900</span>원
						</div>
					</div>
					<div class="nth_item">
						<img src="../imgs/item02.png">
						<div>(신세계 규격)(신세계의정부점)깨끗한나라 순수프리미엄 30m30롤 3팩</div>
						<div>
							<span>39,630</span>원
						</div>
					</div>
					<div class="nth_item">
						<img src="../imgs/item03.jpg">
						<div>하남쭈꾸미쭈꾸미볶음 500g 3팩</div>
						<div>
							<span>31,410</span>원
						</div>
					</div>
					<div class="nth_item">
						<img src="../imgs/item04.jpg">
						<div>(유니버스클럽 전용 쿠폰적용가 5천원) 메가박스 일반예매권 2D-주중/</div>
						<div>
							<span>15,000</span>원
						</div>
					</div>
					<div class="nth_item">
						<img src="../imgs/item05.jpg">
						<div>[더미식]더미식 백미밥 210g 24개 + 하림 닭육수 쌀라면 4개 증정</div>
						<div>
							<span>23,300</span>원
						</div>
					</div>
				</div>
			</div>
			<div class="main_tag2_1">
				지금부터의 신선마켓, 스마일프레시
				<div class="shortcut_tag1">
					바로가기
					<div>
						<img src="../imgs/arrow.png">
					</div>
				</div>
				<div class="tag2_img1">
					<div class="p">
						<p class="p1">
							<span>스마일</span>프레시
						</p>
						<p class="p2">클럽 고객은</p>
						<p class="p2">매일 15% 할인</p>
						<p class="p3">하루 2번 중복 혜택과 함께</p>
					</div>
					<div>
						<img src="../imgs/tag2img1.png">
					</div>
				</div>
				<table>
					<tr>
						<th>하나더</th>
						<th>전단상품</th>
						<th>오반장</th>
					</tr>
				</table>
				<div class="tag2_body1">
					<div>
						<div class="minitem">
							<img src="../imgs/minitem01.png">
						</div>
						<div class="item_info">
							<img src="../imgs/minitag1.png">
							<div>
								<span>코디</span> 코디 해피퍼피 미용티슈 250매6입
							</div>
							<div>
								<span>10,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem02.png">
						</div>
						<div id="info_even" class="item_info">
							<img src="../imgs/minitag1.png">
							<div>
								<span>크리넥스</span> 크리넥스 내추럴 소프트 미용티슈 270매6입
							</div>
							<div>
								<span>18,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem03.png">
						</div>
						<div class="item_info">
							<img src="../imgs/minitag1.png">
							<div>
								<span>하겐다즈</span> 하겐다즈 메가 파인트 딸기 650 ml
							</div>
							<div>
								<span>19,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem04.png">
						</div>
						<div id="info_even" class="item_info">
							<img src="../imgs/minitag1.png">
							<div>
								<span>페리오</span> 페리오 멀티케어 120g8
							</div>
							<div>
								<span>10,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem05.png">
						</div>
						<div class="item_info">
							<img src="../imgs/minitag1.png">
							<div>
								<span>비비고</span> CK 비비고 소고기듬뿍 설렁탕 460g
							</div>
							<div>
								<span>6,980</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem06.png">
						</div>
						<div id="info_even" class="item_info">
							<img src="../imgs/minitag1.png">
							<div>
								<span>하겐다즈</span> 하겐다즈 메가 파인트 초코렛 650 ml
							</div>
							<div>
								<span>19,900</span>원
							</div>
						</div>
					</div>
					<div class="tag2_body1_bott">
						하나더 상품 더보기<img src="../imgs/arrow.png">
					</div>
				</div>
			</div>

			<div class="main_tag2_2">
				오늘 주문 내일 도착, 스마일배송
				<div class="shortcut_tag2">
					바로가기
					<div>
						<img src="../imgs/arrow.png">
					</div>
				</div>
				<div class="tag2_img2">
					<div class="p">
						<p class="p1">
							<span>스마일</span>배송
						</p>
						<p class="p2">이달의 할인</p>
						<p class="p2">인기 브랜드 모음</p>
						<p class="p3">누구나 첫 구매 시 30%할인</p>
					</div>
					<div>
						<img src="../imgs/tag2img2.png">
					</div>
				</div>
				<table>
					<tr>
						<th>베스트</th>
						<th>무료배송</th>
					</tr>
				</table>
				<div class="tag2_body2">
					<div>
						<div class="minitem">
							<img src="../imgs/minitem07.png">
						</div>
						<div class="item_info">
							<img src="../imgs/no1.png">
							<div>
								<span>미래생활</span> 잘풀리는집 순수 PURE천연펄프 25m 30롤
							</div>
							<div>
								<span>42,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem08.png">
						</div>
						<div id="info_even" class="item_info">
							<img src="../imgs/no2.png">
							<div>
								<span>오뚜기</span> 오뚜기 진라면 매운맛 멀티팩(120g x 5개입)
							</div>
							<div>
								<span>29,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem09.png">
						</div>
						<div class="item_info">
							<img src="../imgs/no3.png">
							<div>
								<span>나무야나무야</span> 잘풀리는집 나무야나무야 도톰한3겹
							</div>
							<div>
								<span>42,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem10.png">
						</div>
						<div id="info_even" class="item_info">
							<img src="../imgs/no4.png">
							<div>
								<span>제주삼다수</span> 삼다수 2L 24펫(유라벨/무라벨 랜덤출
							</div>
							<div>
								<span>32,000</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem11.png">
						</div>
						<div class="item_info">
							<img src="../imgs/no5.png">
							<div>
								<span>코카콜라 제로</span> (사전예약_5/7이후 순차발송)코카콜
							</div>
							<div>
								<span>24,900</span>원
							</div>
						</div>
					</div>
					<div>
						<div class="minitem">
							<img src="../imgs/minitem12.png">
						</div>
						<div id="info_even" class="item_info">
							<img src="../imgs/no6.png">
							<div>
								<span>햇반</span> 햇반 210g x24입
							</div>
							<div>
								<span>29,500</span>원
							</div>
						</div>
					</div>
					<div class="tag2_body1_bott">
						베스트 상품 더보기<img src="../imgs/arrow.png">
					</div>
				</div>
			</div>

		</div>

		<!-- footer -->
		<div class="footer">
			<a href="https://corp.gmarket.com/fonts/" target="_blank"><img
				src="../imgs/footer.png"></a>
			<div class="footer_1">
				<ul>
					<li>G마켓 소개</li>
					<li>채용정보</li>
					<li>이용약관</li>
					<li><b>개인정보처리방침</b></li>
					<li>청소년보호정책</li>
					<li>전자금융거래약관</li>
					<li>제휴·광고</li>
				</ul>
				<ul>
					<li><select name="" id="">
							<option value="">판매자서비스</option>
					</select></li>

				</ul>
			</div>

			<div class="footer_2">
				<br>
				<hr>
				<div>
					<p>
						<b>주식회사 지마켓</b>
					</p>
					<p>서울특별시 강남구 테헤란로 152 (역삼동, 강남파이낸스센터)</p>
					<p>사업자등록번호 : 220-81-83676 | 통신판매업신고 : 강남 10630호
					<div class="bs_info">사업자정보확인></div>
					</p>
					<p>대표이사 : 전항일</p>
				</div>
				<div>
					<p>
						<b>고객센터</b> >
					</p>
					<p>경기도 부천시 원미구 부일로 223, 9층(상동)</p>
					<p>
						Tel : <span>1566-5701</span> | 신세계 유니버스 클럽 전용 Tel : <span>1522-5700</span>
					</p>
					<p>Fax : 02-589-8842 | Mail : gmarket@corp.gmarket.co.kr</p>
				</div>
			</div>
			<div class="footer_3">
				<br>
				<hr>
				<ul>
					<li>전자금융분쟁처리 ></li>
					<li>Tel : 1566-5701 | Fax : 02-589-8844 | Mail :
						gmk_cs@corp.gmarket.co.kr</li>
					<li>전자상거래법상의 소비자분쟁해결기준 ></li>
				</ul>
				<ul>
					<li>오픈마켓 자율준수규약 ></li>
					<li>윤리경영 ></li>
					<li>사이버범죄 신고시스템 ></li>
					<li>VeRO Program ></li>
					<li>안전거래센터 ></li>
					<li>저작권침해신고 ></li>
				</ul>
			</div>

			<div class="footer_4">
				<br>
				<hr>
				<p>G마켓은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 G마켓은 상품·거래 정보 및 가격에 대하여
					책임을 지지 않습니다.</p>
				<p>
					본 사이트의 모든 정보, 콘텐츠, UI 등에 대한 무단 복제, 전송, 배포, 스크래핑 등의 행위는 엄격히 금지됩니다. <span>콘텐츠산업
						진흥법에 따른 표시</span>
				</p>
				<p>Copyright Gmarket Inc. All rights reserved.</p>
				<p>
					<img src="../imgs/kolsa.png">한국온라인쇼핑협회 <span>수상·인증 내역</span>
				</p>
			</div>
		</div>
	</div>
</body>

</html>