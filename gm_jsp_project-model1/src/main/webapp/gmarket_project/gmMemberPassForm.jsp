<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="../css/mem_delpage/md_main.css">
   <link rel="stylesheet" href="../css/mem_delpage/md_footer.css">
   <title>G마켓 - 로그인</title>
</head>
<style>
   @font-face {
      font-family: 'GmarketSansMedium';
      src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
      font-weight: normal;
      font-style: normal;
   }

   #container {
      width: 1900px;
      height: 1500px;
      overflow-x: hidden;
      overflow-y: hidden;
   }

   
</style>

<body>
   <div id="container">

      <!-- main -->
      <div class="main">
      <form action="gmMemberPassPro.jsp" method="post">
         <div><img src="../imgs/logo.png"></div>
         <div class="loginbox">
            <div class="member_ox">
               <button>회원</button>
               <button>비회원</button>
            </div>
            <div class="id"><img src="../imgs/idlogo.png"><input type="text" placeholder="아이디" name="id"></div>
            <div class="password">
               <img src="../imgs/pwlogo.png">
               <input type="password" placeholder="비밀번호" name="pass">
            </div>
            <div class="password">
               <img src="../imgs/pwlogo.png">
               <input type="password" placeholder="수정비번" name="chgpass">
            </div>
            <!-- <div class="id_save"><input type="checkbox"><span>아이디 저장</span></div> -->
            <div class="loginBtn">
               <button type="submit">완료</button>
            </div>
            <!-- <div class="mini_tag">
               <table>
                  <tr>
                     <td><a href="#">아이디 찾기</a></td>
                     <td><a href="#">비밀번호 재설정</a></td>
                     <td><a href="../gmarket_project/gmJoin.html">회원가입</a></td>
                  </tr>
               </table>
            </div>
         </div>
         <div class="simple_login">
            <div>간편 로그인</div>
            <ul>
               <li><img src="../imgs/kakao.png"></li>
               <li><img src="../imgs/toss.png"></li>
               <li><img src="../imgs/apple.png"></li>
               <li><img src="../imgs/naver.png"></li>
            </ul>
            <div><img src="../imgs/bigad.jpg"></div>
         </div> -->
         </form>
      </div>

      <!-- footer -->
      <div class="footer">
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
         </div>

         <div class="footer_2">
            <br>
            <hr>
            <div>
               <p><b>주식회사 지마켓</b></p>
               <p>서울특별시 강남구 테헤란로 152 (역삼동, 강남파이낸스센터)</p>
               <p>사업자등록번호 : 220-81-83676 | 통신판매업신고 : 강남 10630호
               <div class="bs_info">사업자정보확인></div>
               </p>
               <p>대표이사 : 전항일</p>
            </div>
            <div>
               <p><b>고객센터</b> ></p>
               <p>경기도 부천시 원미구 부일로 223, 9층(상동)</p>
               <p>Tel : <span>1566-5701</span> | 신세계 유니버스 클럽 전용 Tel : <span>1522-5700</span></p>
               <p>Fax : 02-589-8842 | Mail : gmarket@corp.gmarket.co.kr</p>
            </div>
         </div>
         <div class="footer_3">
            <br>
            <hr>
            <ul>
               <li>전자금융분쟁처리 ></li>
               <li> Tel : 1566-5701 | Fax : 02-589-8844 | Mail : gmk_cs@corp.gmarket.co.kr</li>
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
            <p>G마켓은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 G마켓은 상품·거래 정보 및 가격에 대하여 책임을 지지 않습니다.</p>
            <p>본 사이트의 모든 정보, 콘텐츠, UI 등에 대한 무단 복제, 전송, 배포, 스크래핑 등의 행위는 엄격히 금지됩니다. <span>콘텐츠산업 진흥법에 따른 표시</span></p>
            <p>Copyright Gmarket Inc. All rights reserved.</p>
            <p><img src="../imgs/kolsa.png">한국온라인쇼핑협회 <span>수상·인증 내역</span></p>
         </div>
      </div>
   </div>


<script> window.addEventListener('load', () => { const forms = document.getElementsByClassName('validation-form'); Array.prototype.filter.call(forms, (form) => { form.addEventListener('submit', function (event) { if (form.checkValidity() === false) { event.preventDefault(); event.stopPropagation(); } form.classList.add('was-validated'); }, false); }); }, false); </script>
</body>

</html>