package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GmMemberDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.GmMember;

@WebServlet("/member/*")
public class GmMemberController extends MskimRequestMapping {
	HttpSession session;
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		System.out.println("service");
		super.service(request, response);
	}
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/index.jsp";
	}
	
	@RequestMapping("gmMain")
	public String gmMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)session.getAttribute("id");
		GmMemberDAO dao=new GmMemberDAO();
		GmMember mem = dao.getMember(id);
		request.setAttribute("mem", mem);
		
		return "/single/gmMain.jsp";
	}

	@RequestMapping("gmJoin")
	public String gmJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/member/gmJoin.jsp";
		//return "/member/join.jsp" 으로 했을 경우 500오류
		//url mapping이 member(@WebServlet("/member/*"))으로 되어있기 때문에
	}
	
	@RequestMapping("gmJoinPro")
	public String gmJoinPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pro=====");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id"); 
		int trader = Integer.parseInt(request.getParameter("trader"));
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");

		GmMemberDAO  dao = new GmMemberDAO(); 
		GmMember gm = new GmMember();  //DTO bean 
		gm.setId(id);
		gm.setTrader(trader);
		gm.setPass(pass);
		gm.setName(name);
		gm.setTel(tel);
		gm.setEmail(email);
		
		System.out.println(gm);

		int num = dao.insertMember(gm);

		String msg="";
		String url="";

		if (num>0) {
			msg=name+"님의 회원가입이 완료 되었습니다";
			url="gmLogin";
		} else {
			msg="회원가입이 실패 하였습니다";
			url="gmJoin";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
		
		//return "/member/join.jsp" 으로 했을 경우 500오류
		//url mapping이 member(@WebServlet("/member/*"))으로 되어있기 때문에
	}

	@RequestMapping("gmJoinInfo")
	public String gmJoinInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) session.getAttribute("id");
		GmMemberDAO dao = new GmMemberDAO();
		GmMember mem = dao.getMember(id);
		request.setAttribute("mem", mem);

		return "/view/member/gmJoinInfo.jsp";
	}

	@RequestMapping("gmLogin")
	public String gmLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/member/gmLogin.jsp";
	}

	@RequestMapping("gmLogout")
	public String gmLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다");
		request.setAttribute("url", "gmMain");
		return "/view/alert.jsp";
	}

	@RequestMapping("gmLoginPro")
	public String gmLoginPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// Connection 객체
		GmMemberDAO dao = new GmMemberDAO();
		String msg = id + "님이 로그인 하셨습니다";
		String url = "gmMain";
		GmMember mem = dao.getMember(id);
		if (mem != null) {
			if (pass.equals(mem.getPass())) {
				session.setAttribute("id", id);
				session.setAttribute("trader", mem.getTrader());
			} else {
				msg = "비밀번호가 맞지 않습니다";
				url = "gmLogin";
			}
		} else {
			msg = "id를 확인 하세요";
			url = "gmLogin";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	@RequestMapping("gmMemberUpdForm")
	public String memberUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)session.getAttribute("id");
		GmMemberDAO dao=new GmMemberDAO();
		GmMember mem = dao.getMember(id);
		request.setAttribute("mem", mem);
	
		return "/view/member/gmMemberUpdForm.jsp";
	}
	
	
	@RequestMapping("gmMemberUpdPro")
	public String gmMemberUpdPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = (String) session.getAttribute("id");
		int trader = Integer.parseInt(request.getParameter("trader"));
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		GmMemberDAO  dao = new GmMemberDAO();
		GmMember memdb = dao.getMember(id); 
		GmMember gm = new GmMember();  //DTO bean
		gm.setId(id);
		gm.setTrader(trader);
		gm.setPass(pass);
		gm.setName(name);
		gm.setTel(tel);
		gm.setEmail(email);
		String msg = "";
		String url = "gmMemberUpdForm";

		if (memdb!=null){
			if (memdb.getPass().equals(pass)) {
				msg="수정 하였습니다";
				dao.updateMember(gm);
				url="gmJoinInfo";
			} else {
				msg="비밀번호가 틀렸습니다";
			}
			
			
		} else {
			msg="수정 할 수 없습니다";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	@RequestMapping("gmMemberDelForm")
	public String gmMemberDelForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/member/gmMemberDelForm.jsp";
	}
	
	@RequestMapping("gmMemberDelPro")
	public String memberDeletePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) session.getAttribute("id");
		String pass = request.getParameter("pass");
		GmMemberDAO dao = new GmMemberDAO();
		GmMember memdb = dao.getMember(id);

		String msg = "";
		String url = "gmMemberDelForm";

		if (memdb!=null){
			if (memdb.getPass().equals(pass)) {
				msg="탈퇴 하였습니다";
				session.invalidate();
				dao.deleteMember(id);   
				url="gmLogin";
			} else {
				msg="비밀번호가 틀렸습니다";
			}
			
			
		} else {
			msg="탈퇴 할 수 없습니다";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	@RequestMapping("gmMemberPassForm")
	public String gmMemberPassForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/member/gmMemberPassForm.jsp";
	}
	
	@RequestMapping("gmMemberPassPro")
	public String gmMemberPassPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) session.getAttribute("id");
		String pass = request.getParameter("pass");
		String chgpass = request.getParameter("chgpass");
		GmMemberDAO dao = new GmMemberDAO();
		GmMember memdb = dao.getMember(id);

		String msg = "";
		String url = "gmMemberPassForm";
		if (memdb!=null){
			if (memdb.getPass().equals(pass)) {
				msg="비밀번호를 수정 하였습니다";
				session.invalidate();
			 	dao.chgPassMember(id, chgpass);   
				url="gmLogin";
			} else {		msg="비밀번호가 틀렸습니다";	}
		} else {
			msg="비밀번호를 수정 할 수 없습니다";}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	
	@RequestMapping("gmMemberList")
	public String gmMemberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		GmMemberDAO dao = new GmMemberDAO();
		List<GmMember> li = dao.gmMemberList();  
		request.setAttribute("li", li); 
		
		return "/view/member/gmMemberList.jsp";
	}

}
