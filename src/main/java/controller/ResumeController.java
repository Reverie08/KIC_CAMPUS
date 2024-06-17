package controller;

import java.io.IOException;
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
import model.Career;
import model.Edu;
import model.Member;
import model.MemberPortfolio;
import model.MemberProject;
import model.Resume;

@WebServlet("/resume/*")
public class ResumeController extends MskimRequestMapping{

    HttpSession session;
    ResumeDAO resumeDao = new ResumeDAO();

    @Override
    protected void service(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        System.out.println("service");
        super.service(request, response);
    }

    // 이력서 상세 정보 조회
    @RequestMapping("resumeInfo")
    public String getresume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int resumeId = Integer.parseInt(request.getParameter("resumeId"));
        Resume resume = resumeDao.getResume(resumeId);
        if (resume == null) {
            return "";
        } else {
            request.setAttribute("resume", resume);
            return "/view/resume/resumeInfo.jsp";
        }
    }

    // 회원이 작성한 이력서 목록 조회
    @RequestMapping("/getMemberReumeList")
    public String getMemberReumeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = (String) session.getAttribute("memberId");
        List<Resume> resumeList = resumeDao.getMemberReumeList(memberId);

        for (Resume r : resumeList) {
            System.out.println(r.getRegistdate());
            System.out.println(r.getResumeTitle());
            System.out.println(r.getSelfInfo());
        }
        request.setAttribute("resumeList", resumeList);
        return "";
    }

    // 사업자가 작성한 이력서 목록 조회
    @RequestMapping("/getBusinessReumeList")
    public String getBusinessReumeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bStrId = (String) session.getAttribute("bid");
        int bid = Integer.parseInt(bStrId);
        List<Resume> resumeList = resumeDao.getBusinessReumeList(bid);

        request.setAttribute("resumeList", resumeList);
        return "";
    }

    // 공고에 지원한 이력서 목록 조회
    @RequestMapping("getAnnoReumeList")
    public String getAnnoReumeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int annoId = 0;
        List<Resume> resumeList = resumeDao.getAnnoReumeList(annoId);

        request.setAttribute("resumeList", resumeList);
        return "/view/resume/resumeAnnoList.jsp";
    }

    // 이력서 작성 폼으로 이동
    @RequestMapping("resumeRegisterForm")
    public String insertResumeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = (String) session.getAttribute("memberId");
        MemberDAO mdao = new MemberDAO();
        Member member = mdao.getMember(memberId);

        request.setAttribute("member", member);
        return "/view/resume/resumeRegisterForm.jsp";
    }

    // 이력서 작성 처리
    @RequestMapping("insertResume")
    public String insertResume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletContext().getRealPath("/") + "img/resume/";
        MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");

        // 회원 정보: 회원 아이디를 가져와서 회원 테이블에서 조회
        String memberId = (String) session.getAttribute("memberId");

        // 이력서 아이디 가져오기
        int resumeId = resumeDao.selectResumeId();

        // 교육 정보 설정
        Edu edu = new Edu();
        edu.setSchoolType(multi.getParameter("schoolType"));
        edu.setSchoolName(multi.getParameter("schoolName"));
        edu.setAdmissionDate(multi.getParameter("admissionDate"));
        edu.setGraduateDate(multi.getParameter("graduateDate"));
        edu.setGraduateState(multi.getParameter("graduateState"));
        edu.setMajor(multi.getParameter("major"));
        edu.setScore(multi.getParameter("score"));
        edu.setTotalScore(multi.getParameter("totalScore"));
        edu.setResumeId(resumeId);

        // 경력 정보 설정
        Career career = new Career();
        career.setCompanyName(multi.getParameter("companyName"));
        career.setDepartment(multi.getParameter("department"));
        career.setWorkPart(multi.getParameter("workPart"));
        career.setPosition(multi.getParameter("position"));
        career.setWorkType(multi.getParameter("workType"));
        career.setIsWorking(multi.getParameter("isWorking"));
        career.setWorkPeriod(multi.getParameter("workPeriod"));
        career.setResumeId(resumeId);

        // 프로젝트 정보 설정
        MemberProject project = new MemberProject();
        project.setProjectName(multi.getParameter("projectName"));
        project.setTeam(multi.getParameter("team"));
        project.setIsGoing(multi.getParameter("isGoing"));
        project.setProjectPeriod(multi.getParameter("projectPeriod"));
        project.setProjectInfo(multi.getParameter("projectInfo"));
        project.setResumeId(resumeId);

        // 포트폴리오 정보 설정
        MemberPortfolio portfolio = new MemberPortfolio();
        portfolio.setPortfolioUrl(multi.getParameter("portfolioUrl"));
        portfolio.setPortfolioFile(multi.getFilesystemName("portfolioFile"));
        portfolio.setResumeId(resumeId);

        // 이력서 정보 설정
        Resume resume = new Resume();
        resume.setName(multi.getParameter("name"));
        resume.setBirth(multi.getParameter("birth"));
        resume.setPhone(multi.getParameter("phone"));
        resume.setEmail(multi.getParameter("email"));
        resume.setResumeTitle(multi.getParameter("resumeTitle"));
        resume.setResumeId(resumeId);
        resume.setMemberId(memberId);
        resume.setEdu(edu);
        resume.setCareer(career);
        resume.setProject(project);
        resume.setPortfolio(portfolio);
        resume.setSelfInfo(multi.getParameter("selfInfo"));
        resume.setCertification(multi.getParameter("certification"));
        resume.setLanguage(multi.getParameter("language"));
        resume.setAddress(multi.getParameter("address"));
        resume.setProfileImage(multi.getFilesystemName("profileImage"));

        System.out.println("resume" + resume);
        System.out.println("edu" + edu);
        System.out.println("career" + career);
        System.out.println("project" + project);
        System.out.println("portfolio" + portfolio);
        System.out.println("selfInfo" + resume.getSelfInfo());
        System.out.println("certification" + resume.getCertification());
        System.out.println("language" + resume.getLanguage());
        System.out.println("address" + resume.getAddress());

        int num = resumeDao.insertResume(resume);

        if (num > 0) {
            System.out.println("이력서 작성 성공");
        } else {
            System.out.println("이력서 작성 실패");
        }

        List<Resume> memberResumeList = resumeDao.getMemberReumeList(memberId);

        request.setAttribute("profileImage", resume.getProfileImage());
        request.setAttribute("memberResumeList", memberResumeList);

        return "/member/membermain";
    }

    // 이력서 수정 처리
    @RequestMapping("/updateResume")
    public String updateResume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "";
    }

    // 이력서 삭제 처리
    @RequestMapping("/deleteResume")
    public String deleteResume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int resumeId = Integer.parseInt(request.getParameter("resumeId"));
        int num = resumeDao.deleteResume(resumeId);
        return "";
    }
}
