package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.MemberDAO;
import dao.ResumeDAO;
import model.Career;
import model.Edu;
import model.Member;
import model.MemberPortfolio;
import model.MemberProject;
import model.Resume;

@Controller
@RequestMapping("/resume/")
public class ResumeController {

	Model model;
	HttpSession session;
	HttpServletRequest request;

	@Autowired
	ResumeDAO resumeDao = new ResumeDAO();
	
	@Autowired
	MemberDAO memberDao = new MemberDAO();

	@ModelAttribute
	protected void service(HttpServletRequest request, Model model) throws ServletException, IOException {
		session = request.getSession();
		this.request = request;
		this.model = model;
		System.out.println("service");
	}

	// 이력서 상세 정보 조회
	@RequestMapping("resume-info")
	public String getresume(int resumeId)
			throws ServletException, IOException {
//		int resumeId = Integer.parseInt(request.getParameter("resumeId"));
		Resume resume = resumeDao.getResume(resumeId);
		if (resume == null) {
			return "";
		} else {
			model.addAttribute("resume", resume);
			return "resume/resumeInfo";
		}
	}

	// 회원이 작성한 이력서 목록 조회
	@RequestMapping("get-member-resume-list")
	public String getMemberReumeList()
			throws ServletException, IOException {
		String memberId = (String) session.getAttribute("memberId");
		List<Resume> resumeList = resumeDao.getMemberReumeList(memberId);

		for (Resume r : resumeList) {
			System.out.println(r.getRegistdate());
			System.out.println(r.getResumeTitle());
			System.out.println(r.getSelfInfo());
		}
		model.addAttribute("resumeList", resumeList);
		return "";
	}

	// 사업자가 작성한 이력서 목록 조회
	@RequestMapping("get-business-resume-list")
	public String getBusinessReumeList()
			throws ServletException, IOException {
		String bStrId = (String) session.getAttribute("businessId");
		int businessId = Integer.parseInt(bStrId);
		List<Resume> resumeList = resumeDao.getBusinessReumeList(businessId);

		model.addAttribute("resumeList", resumeList);
		return "";
	}

	// 공고에 지원한 이력서 목록 조회
	@RequestMapping("get-anno-resume-list")
	public String getAnnoReumeList()
			throws ServletException, IOException {
		int annoId = 0;
		List<Resume> resumeList = resumeDao.getAnnoReumeList(annoId);

		model.addAttribute("resumeList", resumeList);
		return "resume/resumeAnnoList";
	}

	// 이력서 작성 폼으로 이동
	@RequestMapping("resume-register-form")
	public String insertResumeForm()
			throws ServletException, IOException {
		String memberId = (String) session.getAttribute("memberId");
		
		Member member = memberDao.getMember(memberId);

		model.addAttribute("member", member);
		return "resume/resumeRegisterForm";
	}

	// 이력서 작성 처리
	@RequestMapping("insert-resume")
	public String insertResume(@RequestParam("profileImageFile") MultipartFile multipartFile, Edu edu, Career career, MemberProject project, MemberPortfolio portfolio, Resume resume)
			throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/") + "img/member/";
		String profileImage = "";
		if(!multipartFile.isEmpty()) {
			File file = new File(path, multipartFile.getOriginalFilename()); 
			profileImage=multipartFile.getOriginalFilename();
			
			multipartFile.transferTo(file);
		}
		
		resume.setProfileImage(profileImage);
		
//		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");

		// 회원 정보: 회원 아이디를 가져와서 회원 테이블에서 조회
		String memberId = (String) session.getAttribute("memberId");

		// 이력서 아이디 가져오기
		int resumeId = resumeDao.selectResumeId();

		// 교육 정보 설정
//		Edu edu = new Edu();
//		edu.setSchoolType(multi.getParameter("schoolType"));
//		edu.setSchoolName(multi.getParameter("schoolName"));
//		edu.setAdmissionDate(multi.getParameter("admissionDate"));
//		edu.setGraduateDate(multi.getParameter("graduateDate"));
//		edu.setGraduateState(multi.getParameter("graduateState"));
//		edu.setMajor(multi.getParameter("major"));
//		edu.setScore(multi.getParameter("score"));
//		edu.setTotalScore(multi.getParameter("totalScore"));
		edu.setResumeId(resumeId);

		// 경력 정보 설정
//		Career career = new Career();
//		career.setCompanyName(multi.getParameter("companyName"));
//		career.setDepartment(multi.getParameter("department"));
//		career.setWorkPart(multi.getParameter("workPart"));
//		career.setPosition(multi.getParameter("position"));
//		career.setWorkType(multi.getParameter("workType"));
//		career.setIsWorking(multi.getParameter("isWorking"));
//		career.setWorkPeriod(multi.getParameter("workPeriod"));
		career.setResumeId(resumeId);

		// 프로젝트 정보 설정
//		MemberProject project = new MemberProject();
//		project.setProjectName(multi.getParameter("projectName"));
//		project.setTeam(multi.getParameter("team"));
//		project.setIsGoing(multi.getParameter("isGoing"));
//		project.setProjectPeriod(multi.getParameter("projectPeriod"));
//		project.setProjectInfo(multi.getParameter("projectInfo"));
		project.setResumeId(resumeId);

		// 포트폴리오 정보 설정
//		MemberPortfolio portfolio = new MemberPortfolio();
//		portfolio.setPortfolioUrl(multi.getParameter("portfolioUrl"));
//		portfolio.setPortfolioFile(multi.getFilesystemName("portfolioFile"));
		portfolio.setResumeId(resumeId);

		// 이력서 정보 설정
//		Resume resume = new Resume();
//		resume.setName(multi.getParameter("name"));
//		resume.setBirth(multi.getParameter("birth"));
//		resume.setPhone(multi.getParameter("phone"));
//		resume.setEmail(multi.getParameter("email"));
//		resume.setResumeTitle(multi.getParameter("resumeTitle"));
//		resume.setResumeId(resumeId);
//		resume.setMemberId(memberId);
//		resume.setEdu(edu);
//		resume.setCareer(career);
//		resume.setProject(project);
//		resume.setPortfolio(portfolio);
//		resume.setSelfInfo(multi.getParameter("selfInfo"));
//		resume.setCertification(multi.getParameter("certification"));
//		resume.setLanguage(multi.getParameter("language"));
//		resume.setAddress(multi.getParameter("address"));
//		resume.setProfileImage(multi.getFilesystemName("profileImage"));

		System.out.println(profileImage);
		System.out.println("resume" + resume);
		System.out.println("edu" + edu);
		System.out.println("career" + career);
		System.out.println("project" + resume.getProject());
		System.out.println("portfolio" + resume.getPortfolio());
		System.out.println("selfInfo" + resume.getSelfInfo());
		System.out.println("certification" + resume.getCertification());
		System.out.println("language" + resume.getLanguage());
		System.out.println("address" + resume.getAddress());

		int num = resumeDao.insertResume(resume);

		String url = "";
		String msg = "";

		if (num > 0) {
			System.out.println("이력서 작성 성공");
			url = "member-main";
			msg = "이력서 작성 성공";

		} else {
			System.out.println("이력서 작성 실패");
		}

		List<Resume> memberResumeList = resumeDao.getMemberReumeList(memberId);

		model.addAttribute("profileImage", resume.getProfileImage());
		model.addAttribute("memberResumeList", memberResumeList);
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "alert";
	}

	@RequestMapping("member-main")
	public String memberMain()
			throws ServletException, IOException {

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
		model.addAttribute("profileImage", profileImage);

		model.addAttribute("memberResumeList", memberResumeList);
		model.addAttribute("member", member);

		return "member/memberMain";
	}

	// 이력서 수정 처리
	@RequestMapping("update-resume")
	public String updateResume()
			throws ServletException, IOException {

		return "";
	}
	
//	// 이력서 수정 처리
//	@RequestMapping("update-resume")
//	public String updateResume(@RequestParam("profileImageFile") MultipartFile multipartFile, Edu edu, Career career, MemberProject project, MemberPortfolio portfolio, Resume resume)
//			throws ServletException, IOException {
//		String path = request.getServletContext().getRealPath("/") + "img/member/";
//		Resume resuemDb = resumeDao.getResume(resume.getResumeId()); 
//		String profileImage = "";
//		if(!multipartFile.isEmpty()) {
//			File file = new File(path, multipartFile.getOriginalFilename()); 
//			profileImage=multipartFile.getOriginalFilename();
//			
//			multipartFile.transferTo(file);
//			resume.setProfileImage(profileImage);
//		} else { //업로드를 안했을 경우
//			resume.setProfileImage(resuemDb.getProfileImage());
//		}
//		return "";
//	}

	// 이력서 삭제 처리
	@RequestMapping("delete-resume")
	public String deleteResume(int resumeId)
			throws ServletException, IOException {
//		int resumeId = Integer.parseInt(request.getParameter("resumeId"));

		int num = resumeDao.deleteResume(resumeId);
		String url = "";
		String msg = "";
		if (num > 0) {
			System.out.println("이력서 삭제 성공");
			url = "member-main";
			msg = "이력서 삭제 성공";
		} else {
			System.out.println("이력서 삭제 실패");
		}

		model.addAttribute("url", url);
		return "alert";
	}

}
