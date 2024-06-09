package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GtMemberDao;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.GtMember;

@WebServlet("/member/*")
public class MemberController extends MskimRequestMapping {
	HttpSession session;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		System.out.println("service");
		super.service(request, response); 
	}
	
	@RequestMapping("joinok")
	public String joinOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/view/member/joinok.jsp";
	}
	
	@RequestMapping("joinokPro")
	public String joinOkPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/view/member/join.jsp";
	}
	
	@RequestMapping("join")
	public String join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nav", "join");
		return "/view/member/join.jsp";
		//return "/member/join.jsp" 으로 했을 경우 500오류
		//url mapping이 member(@WebServlet("/member/*"))으로 되어있기 때문에
	}

	
	@RequestMapping("joinPro")
	public String joinPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id"); 
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth"); 
		String address = request.getParameter("address"); 
		GtMemberDao  dao = new GtMemberDao(); 
		GtMember gt = new GtMember();  //DTO bean
		gt.setUserid(id);
		gt.setPw(pw);
		gt.setName(name);
		gt.setGender(gender);
		gt.setPhone(phone);
		gt.setEmail(email);
		gt.setBirth(birth); 
		gt.setAddress(address); 
		System.out.println(gt);
		int num = dao.insertMember(gt);

		String msg="";
		String url="";

		if (num>0) {
			msg=name+"님의 회원가입이 완료 되었습니다";
			url="login";
		} else {
			msg="회원가입이 실패 하였습니다";
			url="join";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
		
	}

}
