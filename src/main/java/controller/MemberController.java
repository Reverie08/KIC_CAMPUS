package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.ResumeDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Member;

@WebServlet("/member/*")
public class MemberController extends MskimRequestMapping {
    
    HttpSession session;
    MemberDAO dao = new MemberDAO();
    
    @Override
    protected void service(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        System.out.println("service");
        super.service(request, response);
    }
    
    // 메인 
    @RequestMapping("main")
    public String main(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        return "/view/member/main.jsp";
    }
    // 회원 가입 폼 
    @RequestMapping("memberjoin")
    public String memberJoin(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        return "/view/member/memberjoin.jsp";
    }
    
    // 회원 가입 처리 
    @RequestMapping("memberjoinPro")
    public String memberJoinPro(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException, ParseException {
        
        request.setCharacterEncoding("utf-8");
        String memberId = request.getParameter("memberId");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        int gender = Integer.parseInt((request.getParameter("gender")));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String birth = request.getParameter("birth");
        
        Member mem = new Member();
        
        mem.setMemberId(memberId);
        mem.setPw(pw);
        mem.setName(name);
        mem.setGender(gender);
        mem.setEmail(email);
        mem.setPhone(phone);
        mem.setBirth(birth);

        System.out.println(mem);
        
        int num = dao.insertMember(mem);
        
        String msg = "";
        String url = "";
        
        if( num > 0){
            msg = name + "님이 회원가입이 완료 되었습니다.";
            url = "memberlogin";
        } else {
            msg = "회원가입이 실패 하였습니다. 다시 시도해 주세요";
            url = "memberjoin";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        
        return "/view/alert.jsp";
    }
    
    // 로그인 폼 
    @RequestMapping("memberlogin")
    public String login(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        
        return "/view/member/memberlogin.jsp";
    }
    // 로그인 메인 폼
    @RequestMapping("membermain")
    public String memberMain(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        ResumeDAO resumeDao = new ResumeDAO();
        String memberId = (String)session.getAttribute("memberId");
        Member mem = dao.getMember(memberId);
        
        // String profileImage = resumeDao.getProfileImage(memberId);
        
        // request.setAttribute("profileImage", profileImage);
        request.setAttribute("mem", mem);
        
        
        return "/view/member/membermain.jsp";
    }
    
	// 로그인 처리
    @RequestMapping("memberloginPro")
    public String memberLoginPro(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        String memberId = request.getParameter("memberId");
        String pw = request.getParameter("pw");
        
        
        String msg = "";
        String url = "membermain";
        Member mem = dao.getMember(memberId);
        
        if(mem != null){
            System.out.println(memberId);
            
            if(pw.equals(mem.getPw())) {
                session.setAttribute("memberId", memberId);
                msg = mem.getName() + "님이 로그인 하셨습니다.";
                
                
            } else {
                    msg = "비밀번호가 맞지 않습니다.";
                    url = "memberlogin";
            }
            
            } else {
                msg = "id를 확인하세요.";
                url = "memberlogin";
        }
        
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/view/alert.jsp";
    }
    
    // 회원 정보
    @RequestMapping("memberinfo")
    public String memberInfo(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        String memberId = (String)session.getAttribute("memberId");
        Member mem = dao.getMember(memberId);
        
        request.setAttribute("mem", mem);
        request.setAttribute("nav", "memberinfo");
        
        return "/view/member/memberinfo.jsp";
    }
    
    // 로그아웃
    @RequestMapping("memberlogout")
    public String memberLogout(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        session.invalidate(); 
        request.setAttribute("msg", "로그아웃 되었습니다.");
        request.setAttribute("url", "main");
        
        return "/view/alert.jsp";
    }
    // 회원 정보 수정
    @RequestMapping("memberupdate")
    public String memberUpdate(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
            
        String memberId = (String)session.getAttribute("memberId");
        Member mem = dao.getMember(memberId);
        
        request.setAttribute("mem", mem);
        request.setAttribute("nav", "memberinfo");
        
        return "/view/member/memberupdate.jsp";
    }
    
    // 정보 수정 처리
    @RequestMapping("memberupdatepro")
    public String memberUpdatePro(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        String memberId = request.getParameter("memberId");
        String pw = request.getParameter("pw");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String birth = request.getParameter("birth");
        
        Member memDb = dao.getMember(memberId);
        Member mem = new Member();
        
        mem.setMemberId(memberId);
        mem.setPw(pw);
        mem.setEmail(email);
        mem.setPhone(phone);
        mem.setBirth(birth);
        
        String msg = "";
        String url = "";
        
        if(memDb != null) {
            if(memDb.getPw().equals(pw)) {
                msg = "수정 하였습니다.";
                dao.updateMember(mem);
                url = "memberinfo";
            } else {
                msg = "비밀번호가 맞지 않습니다.";
            }
        } else {
            msg = "수정할 수 없습니다.";
        }
        
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/view/alert.jsp";
    }
    
    // 회원 비밀번호 수정
    @RequestMapping("memberchangepw")
    public String memberChangePw(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        
        String memberId = (String)session.getAttribute("memberId");
        Member mem = dao.getMember(memberId);
        
        request.setAttribute("mem", mem);
        
        
        return "/view/member/memberchangepw.jsp";
    }
    
    // 회원 비밀번호 수정 처리
    @RequestMapping("memberchangepwpro")
    public String memberChangePwPro(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        String memberId = (String)session.getAttribute("memberId");
        String pw = request.getParameter("pw");
        String chgpw = request.getParameter("chgpw");
        
        Member memDb = dao.getMember(memberId);
        
        String msg = "";
        String url = "memberchangpw";
        
        if(memDb != null) {
            if(memDb.getPw().equals(pw)) {
                msg = "비밀번호를 변경 하였습니다.";
                session.invalidate();
                dao.changePw(memberId, chgpw);
                url = "memberlogin";
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
    @RequestMapping("memberdelete")
    public String memberDelete(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
            
        
        String memberId = (String)session.getAttribute("memberId");
        Member mem = dao.getMember(memberId);
        
        request.setAttribute("mem", mem);
        
        return "/view/member/memberdelete.jsp";
    }
    
    // 회원 탈퇴 처리
    @RequestMapping("memberdeletepro")
    public String memberDeletePro(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String memberId = (String) session.getAttribute("memberId");
        String pw = request.getParameter("pw");
        Member memDb = dao.getMember(memberId);
        
        String msg = "";
        String url ="memberdelete";
        
        if(memDb != null) {
            if(memDb.getPw().equals(pw)) {
                msg = "탈퇴 하였습니다.";
                session.invalidate();
                dao.deleteMember(memberId);
                url = "memberlogin";
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
