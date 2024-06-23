package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.MemberDAO;
import dao.ResumeDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import mapper.MemberMapper;
import model.Member;
import model.Resume;

@WebServlet("/member/*")
public class MemberController extends MskimRequestMapping {

	HttpSession session;
	MemberDAO memberDao = new MemberDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		System.out.println("service");
		super.service(request, response);
	}

	// 메인
	@RequestMapping("main")
	public String main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/main.jsp";
	}

	// 회원 가입 폼
	@RequestMapping("member-join")
	public String memberJoin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/view/member/memberJoin.jsp";
	}

	// 회원 가입 처리
	@RequestMapping("member-join-pro")
	public String memberJoinPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		int gender = Integer.parseInt((request.getParameter("gender")));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");

		Member member = new Member();

		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setName(name);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		member.setBirth(birth);

		System.out.println(member);

		int num = memberDao.insertMember(member);

		String msg = "";
		String url = "";

		if (num > 0) {
			msg = name + "님이 회원가입이 완료 되었습니다.";
			url = "member-login";
		} else {
			msg = "회원가입이 실패 하였습니다. 다시 시도해 주세요";
			url = "member-join";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 로그인 폼
	@RequestMapping("member-login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/member/memberLogin.jsp";
	}

	// 로그인 메인 폼
	@RequestMapping("member-main")
	public String memberMain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResumeDAO resumeDao = new ResumeDAO();
		String memberId = (String) session.getAttribute("memberId");
		Member member = memberDao.getMember(memberId);
		int resumeId = resumeDao.selectResumeId();
		List<Resume> memberResumeList = resumeDao.getMemberReumeList(memberId);

		String profileImage;

		if (memberResumeList.size() == 0) {
			profileImage = "";
		} else {
			int listNum = memberResumeList.size() - 1;
			profileImage = memberResumeList.get(listNum).getProfileImage();
		}
		request.setAttribute("profileImage", profileImage);

		request.setAttribute("memberResumeList", memberResumeList);
		request.setAttribute("member", member);

		return "/view/member/memberMain.jsp";
	}

	@RequestMapping("update-profileImage")
	public String updateProFileImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletContext().getRealPath("/") + "img/member/";
		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");

		request.setCharacterEncoding("utf-8");

		String memberId = (String) session.getAttribute("memberId");
		Member member = memberDao.getMember(memberId);

		String url = "";
		String msg = "";

		String profileImage = multi.getFilesystemName("profileImage");
		if (profileImage != null) {
			member.setProfileImage(profileImage);
			int num = memberDao.updateProfileImage(member.getProfileImage(), memberId);
			
			if (num > 0) {
				msg = "프로필 이미지가 업데이트 되었습니다.";
				url = "member-main";
			} else {
				msg = "프로필 이미지 업데이트에 실패했습니다.";
				url = "member-main"; // 실패 시 경로 설정
			}
		} else {
			msg = "이미지를 선택 해주세요.";
			url = "member-main"; // 이미지가 업로드되지 않았을 때 경로 설정
		}

		System.out.println(member.getProfileImage());
		System.out.println(multi.getFilesystemName("profileImage"));

		session.setAttribute("member", member);

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 로그인 처리
	@RequestMapping("member-login-pro")
	public String memberLoginPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		String msg = "";
		String url = "member-main";
		Member member = memberDao.getMember(memberId);

		if (member != null) {
			System.out.println(memberId);

			if (memberPw.equals(member.getMemberPw())) {
				session.setAttribute("memberId", memberId);
				msg = member.getName() + "님이 로그인 하셨습니다.";

			} else {
				msg = "비밀번호가 맞지 않습니다.";
				url = "member-login";
			}

		} else {
			msg = "id를 확인하세요.";
			url = "member-login";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	// 회원 정보
	@RequestMapping("member-info")
	public String memberInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = (String) session.getAttribute("memberId");
		Member member = memberDao.getMember(memberId);

		request.setAttribute("member", member);
		request.setAttribute("nav", "memberinfo");

		return "/view/member/memberInfo.jsp";
	}

	// 로그아웃
	@RequestMapping("member-logout")
	public String memberLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.setAttribute("url", "main");

		return "/view/alert.jsp";
	}

	// 회원 정보 수정
	@RequestMapping("member-update")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = (String) session.getAttribute("memberId");
		Member member = memberDao.getMember(memberId);

		request.setAttribute("member", member);
		request.setAttribute("nav", "memberinfo");

		return "/view/member/memberUpdate.jsp";
	}

	// 정보 수정 처리
	@RequestMapping("member-update-pro")
	public String memberUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");

		Member memberDb = memberDao.getMember(memberId);
		Member member = new Member();

		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setEmail(email);
		member.setPhone(phone);
		member.setBirth(birth);

		String msg = "";
		String url = "";

		if (memberDb != null) {
			if (memberDb.getMemberPw().equals(memberPw)) {
				msg = "수정 하였습니다.";
				memberDao.updateMember(member);
				url = "member-info";
			} else {
				System.out.println(memberDb.getMemberPw());
				System.out.println(memberPw);
				msg = "비밀번호가 맞지 않습니다.";

			}
		} else {
			msg = "수정할 수 없습니다.";
			url = "member-update";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	// 회원 비밀번호 수정
	@RequestMapping("member-change-pw")
	public String memberChangePw(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = (String) session.getAttribute("memberId");
		Member member = memberDao.getMember(memberId);

		request.setAttribute("member", member);

		return "/view/member/memberChangePw.jsp";
	}

	// 회원 비밀번호 수정 처리
	@RequestMapping("member-change-pw-pro")
	public String memberChangePwPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String memberId = (String) session.getAttribute("memberId");
		String memberPw = request.getParameter("memberPw");
		String changePw = request.getParameter("changePw");

		Member memberDb = memberDao.getMember(memberId);

		String msg = "";
		String url = "member-chang-pw";

		if (memberDb != null) {
			if (memberDb.getMemberPw().equals(memberPw)) {
				msg = "비밀번호를 변경 하였습니다.";
				session.invalidate();
				memberDao.changePw(memberId, changePw);
				url = "member-login";
			} else {
				msg = "비밀번호가 맞지 않습니다.";
			}
		} else {
			msg = "비밀번호를 변경할 수 없습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	// 회원 탈퇴 폼
	@RequestMapping("member-delete")
	public String memberDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = (String) session.getAttribute("memberId");
		Member member = memberDao.getMember(memberId);

		request.setAttribute("member", member);

		return "/view/member/memberDelete.jsp";
	}

	// 회원 탈퇴 처리
	@RequestMapping("member-delete-pro")
	public String memberDeletePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = (String) session.getAttribute("memberId");
		String memberPw = request.getParameter("memberPw");
		Member memberDb = memberDao.getMember(memberId);

		String msg = "";
		String url = "member-delete";

		if (memberDb != null) {
			if (memberDb.getMemberPw().equals(memberPw)) {
				msg = "탈퇴 하였습니다.";
				session.invalidate();
				memberDao.deleteMember(memberId);
				url = "member-login";
			} else {
				msg = "비밀번호가 맞지 않습니다.";
			}
		} else {
			msg = "탈퇴할 수 없습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

}
