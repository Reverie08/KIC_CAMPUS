package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.KicBoardDAO;
import dao.KicMemberDAO;
import dao.KicMemberMybatis;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.KicBoard;
import model.KicMember;

@WebServlet("/member/*")
public class MemberController extends MskimRequestMapping {

	HttpSession session;
	KicMemberMybatis mybatisdao = new KicMemberMybatis();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		System.out.println("service");
		super.service(request, response);
	}

	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/index.jsp";
	}

	@RequestMapping("join")
	public String join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nav", "join");
		return "/view/member/join.jsp";
		// return "/member/join.jsp" 으로 했을 경우 500오류
		// url mapping이 member(@WebServlet("/member/*"))으로 되어있기 때문에
	}

	@RequestMapping("joinPro")
	public String joinPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
//		KicMemberDAO  dao = new KicMemberDAO();
		
		KicMember kic = new KicMember(); // DTO bean
		kic.setId(id);
		kic.setPass(pass);
		kic.setName(name);
		kic.setGender(gender);
		kic.setTel(tel);
		kic.setEmail(email);
		kic.setPicture(picture);
		System.out.println(kic);
//		int num = dao.insertMember(kic);
		int num = mybatisdao.insertMember(kic);

		String msg = "";
		String url = "";

		if (num > 0) {
			msg = name + "님의 회원가입이 완료 되었습니다";
			url = "login";
		} else {
			msg = "회원가입이 실패 하였습니다";
			url = "join";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";

		// return "/member/join.jsp" 으로 했을 경우 500오류
		// url mapping이 member(@WebServlet("/member/*"))으로 되어있기 때문에
	}

	@RequestMapping("joinInfo")
	public String joinInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) session.getAttribute("id");
//		KicMemberDAO dao = new KicMemberDAO();
//		KicMember mem = dao.getMember(id);
		KicMember mem = mybatisdao.getMember(id);
		request.setAttribute("mem", mem);
		request.setAttribute("nav", "joinInfo");
		return "/view/member/joinInfo.jsp";
	}

	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nav", "login");
		return "/view/member/login.jsp";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다");
		request.setAttribute("url", "index");
		return "/view/alert.jsp";
	}

	@RequestMapping("loginPro")
	public String loginPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// Connection 객체
//		KicMemberDAO dao = new KicMemberDAO();
		String msg = id + "님이 로그인 하셨습니다";
		String url = "index";
//		KicMember mem = dao.getMember(id);
		KicMember mem = mybatisdao.getMember(id);
		if (mem != null) {
			if (pass.equals(mem.getPass())) {
				session.setAttribute("id", id);
			} else {
				msg = "비밀번호가 맞지 않습니다";
				url = "login";
			}
		} else {
			msg = "id를 확인 하세요";
			url = "login";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	@RequestMapping("memberUpdateForm")
	public String memberUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) session.getAttribute("id");
		KicMemberDAO dao = new KicMemberDAO();
		KicMember mem = dao.getMember(id);
		request.setAttribute("mem", mem);

		return "/view/member/memberUpdateForm.jsp";
	}

	@RequestMapping("memberUpdatePro")
	public String memberUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) session.getAttribute("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");

		KicMemberDAO dao = new KicMemberDAO();
		KicMember memdb = dao.getMember(id);
		KicMember kic = new KicMember(); // DTO bean
		kic.setId(id);
		kic.setPass(pass);
		kic.setName(name);
		kic.setGender(gender);
		kic.setTel(tel);
		kic.setEmail(email);
		kic.setPicture(picture);
		String msg = "";
		String url = "memberUpdateForm";

		if (memdb != null) {
			if (memdb.getPass().equals(pass)) {
				msg = "수정 하였습니다";
				dao.updateMember(kic);
				url = "joinInfo";
			} else {
				msg = "비밀번호가 틀렸습니다";
			}

		} else {
			msg = "수정 할 수 없습니다";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	@RequestMapping("memberDeleteForm")
	public String memberDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/view/member/memberDeleteForm.jsp";
	}

	@RequestMapping("memberDeletePro")
	public String memberDeletePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) session.getAttribute("id");
		String pass = request.getParameter("pass");
		KicMemberDAO dao = new KicMemberDAO();
		KicMember memdb = dao.getMember(id);

		String msg = "";
		String url = "memberDeleteForm";

		if (memdb != null) {
			if (memdb.getPass().equals(pass)) {
				msg = "탈퇴 하였습니다";
				session.invalidate();
				dao.deleteMember(id);
				url = "login";
			} else {
				msg = "비밀번호가 틀렸습니다";
			}

		} else {
			msg = "탈퇴 할 수 없습니다";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	@RequestMapping("memberPassForm")
	public String memberPassForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/view/member/memberPassForm.jsp";
	}

	@RequestMapping("memberPassPro")
	public String memberPassPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) session.getAttribute("id");
		String pass = request.getParameter("pass");
		String chgpass = request.getParameter("chgpass");
		KicMemberDAO dao = new KicMemberDAO();
		KicMember memdb = dao.getMember(id);

		String msg = "";
		String url = "memberPassForm";
		if (memdb != null) {
			if (memdb.getPass().equals(pass)) {
				msg = "비밀번호를 수정 하였습니다";
				session.invalidate();
				dao.chgPassMember(id, chgpass);
				url = "login";
			} else {
				msg = "비밀번호가 틀렸습니다";
			}
		} else {
			msg = "비밀번호를 수정 할 수 없습니다";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	@RequestMapping("memberList")
	public String memberList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		KicMemberDAO dao = new KicMemberDAO();
		List<KicMember> li = dao.memberList();
		request.setAttribute("li", li);

		return "/view/member/memberList.jsp";
	}

	@RequestMapping("pictureimgForm")
	public String pictureimgForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/single/pictureimgForm.jsp";
	}

	@RequestMapping("picturePro")
	public String picturePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/") + "/img/member/picture/";
		System.out.println(path);

		String filename = null;

		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");

		filename = multi.getFilesystemName("picture");

		System.out.println(filename);
		request.setAttribute("filename", filename);

		return "/single/picturePro.jsp";
	}

}
