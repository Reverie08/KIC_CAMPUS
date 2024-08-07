import { Link } from "react-router-dom";
import { useCookies } from 'react-cookie';
import { useNavigate } from 'react-router-dom';



function Head(props) {

  //const COOKIE_KEY = window.LOGIN_KEY; // 상수화시킨 쿠키 값을 넣어줬다.
  const [, , removeCookie] = useCookies(); // 쓰지 않는 변수는 (공백),처리해주고 removeCookie 옵션만 사용한다

  const navigate = useNavigate()
  const logout = () => {

    removeCookie("id", { path: '/' });    // 쿠키삭제후
    navigate('/member/login');		// 현재url을 변경해준다.
  }



  return (
    <div  >
      <nav className="navbar navbar-expand-sm bg-light navbar-light">
        {/* Brand  */}
        <a className="navbar-brand" href="pageContext.request.contextPath/member/index.jsp">
          <img src="/logo192.png" width="30%" /></a>
        <ul className="navbar-nav"   >


          {/* <!-- Links --> */}
          {props.cook == null &&
            <li className="nav-item">
              <Link to="/member/join" className="nav-link">회원가입</Link>

            </li>}
          {props.cook == null &&
            <li className="nav-item">
              <Link className="nav-link" to="/member/login">로그인</Link>
            </li>}

          {props.cook != null &&
            <li className="nav-item">
              <Link to="#" className="nav-link" onClick={logout} >&nbsp;로그아웃 &nbsp;</Link>[{props.cook}]
            </li>}

          <li className="nav-item">
            <Link className="nav-link" to="/member/memberList">memberList</Link>
          </li>
          {/* <!-- Dropdown --> */}
          <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
              게시판
            </a>
            <div className="dropdown-menu">
              <a className="dropdown-item" href="/board/boardList?boardid=1">공지사항</a>
              <a className="dropdown-item" href="/board/boardList?boardid=2">자유게시판</a>
              <a className="dropdown-item" href="/board/boardList?boardid=3">QnA</a>
            </div>
          </li>


        </ul>

      </nav>

    </div>
  );
}

export default Head;
