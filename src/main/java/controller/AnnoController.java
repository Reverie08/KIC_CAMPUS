package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AnnoDAO;
import dao.BusinessDAO;
import dao.MemberDAO;
import dao.ResumeDAO;
import model.Anno;
import model.Business;
import model.Resume;
import model.Search;
import model.Skill;

@Controller
@RequestMapping("/anno/")
public class AnnoController {

	Model model;
	HttpSession session;
	HttpServletRequest request;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	BusinessDAO businessDao = new BusinessDAO();

	@Autowired
	AnnoDAO annoDao = new AnnoDAO();

	@Autowired
	MemberDAO memberDao = new MemberDAO();
	
	@Autowired
	ResumeDAO resumeDao = new ResumeDAO();

	@ModelAttribute
	protected void service(HttpServletRequest request, Model model) throws ServletException, IOException {
		this.request = request;
		this.model = model;
		session = request.getSession();
		System.out.println("service");
	}

	@RequestMapping("business-anno-insert-form")
	public String BusinessAnnoInsertForm() throws ServletException, IOException {
		List<Skill> skills = annoDao.getAllSkills();
		String businessId = (String) session.getAttribute("businessId");
		Business business = businessDao.getBusiness(businessId);
		String welfare = business.getWelfare().replace("<br>", "\n");

		business.setWelfare(welfare);

		for (Skill skill : skills) {
			System.out.println(skill);
		}
		model.addAttribute("business", business);
		model.addAttribute("skills", skills);
		return "anno/businessAnnoInsertForm";
	}

	@RequestMapping("anno-insert-pro")
	public String annoInsertPro(String selectedSkills, Anno anno, Skill skill) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

//		String businessId = (String) session.getAttribute("businessId");
		int skillId = annoDao.selectSkillId();
		int annoId = annoDao.selectAnnoId();
		anno.setAnnoId(annoId);
		System.out.println("annoDao.selectAnnoId():"+annoId);
//      String businessName = request.getParameter("businessName");
//      String welfare = request.getParameter("welfare");
//      String annoTitle = request.getParameter("annoTitle");
//      String annoCareer = request.getParameter("annoCareer");
//      String annoSalary = request.getParameter("annoSalary");
//      String annoEdu = request.getParameter("annoEdu");
//      String annoGrade = request.getParameter("annoGrade");
//      String annoWorkType = request.getParameter("annoWorkType");
//      String annoWorkDay = request.getParameter("annoWorkDay");
//		String annoWorkPlace = request.getParameter("annoWorkPlace");
//      String annoCommon = request.getParameter("annoCommon");
//      String annoQualification = request.getParameter("annoQualification");
//		String annoPickNum = request.getParameter("annoPickNum");
//      String annoContent = request.getParameter("annoContent");
//      String businessId = request.getParameter("businessId");
//      String selectedSkills = request.getParameter("selectedSkills");
		Date annoDeadline = parseDate(request.getParameter("annoDeadline"));
		System.out.println(selectedSkills);

//      anno.setBusinessName(businessName);
//      anno.setWelfare(welfare);
//      anno.setAnnoTitle(annoTitle);
//      anno.setAnnoCareer(annoCareer);
//      anno.setAnnoSalary(annoSalary);
//      anno.setAnnoEdu(annoEdu);
//      anno.setAnnoGrade(annoGrade);
//      anno.setAnnoWorkType(annoWorkType);
//      anno.setAnnoWorkDay(annoWorkDay);
//      anno.setAnnoWorkPlace(annoWorkPlace);
//      anno.setAnnoCommon(annoCommon);
//      anno.setAnnoQualification(annoQualification);
//		anno.setAnnoPickNum(annoPickNum);
//      anno.setAnnoContent(annoContent);
//      anno.setBusinessId(businessId);
		anno.setAnnoDeadline(annoDeadline);
//      anno.setSkillId(annoDao.selectSkillId());

		String welfare = anno.getWelfare().replace("\n", "<br>");
		String annoContent = anno.getAnnoContent().replace("\n", "<br>");
		anno.setWelfare(welfare);
		anno.setAnnoContent(annoContent);

		System.out.println("annoContent:" + annoContent);

		System.out.println(anno);

		int num = annoDao.insertAnno(anno);
		
		if (num > 0 && selectedSkills != null && !selectedSkills.isEmpty()) {
//            Skill skill = new Skill();
            skill.setAnnoId(annoId);
            skill.setSkillId(skillId);
            skill.setSkills(selectedSkills);
            annoDao.insertSkill(skill);
        }

        String msg = num > 0 ? anno.getBusinessName() + "의 공고가 등록되었습니다." : "공고 등록이 실패했습니다.";
        String url = "business-anno-list";


		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "alert";
	}

	// Other methods...

	@RequestMapping("user-anno-list")
	public String userAnnoList() throws ServletException, IOException {
		List<Anno> li = annoDao.getAnnoList();
//      String businessId = request.getParameter("businessId");
//      String businessName = request.getParameter("businessName");
//      String annoTitle = request.getParameter("annoTitle");
//      String annoGrade = request.getParameter("annoGrade");
//      String annoWorkType = request.getParameter("annoWorkType");
//      String annoWorkPlace = request.getParameter("annoWorkPlace");
//      String annoDate = request.getParameter("annoDate");
//      String skillId = request.getParameter("skillId");
//      String annoId = request.getParameter("annoId");

		for (Anno anno : li) {
			if (anno.getAnnoDeadline() != null) {
				Date now = new Date();
				long daysLeft = daysBetweenDates(now, anno.getAnnoDeadline());
				anno.setDaysLeft(daysLeft);
			} else {
				anno.setDaysLeft(-1); // or any other value indicating no deadline set
			}
		}

//		model.addAttribute("businessId", anno.getBusinessId());
//		model.addAttribute("annoId", anno.getAnnoId());
//		model.addAttribute("businessName", anno.getBusinessName());
//		model.addAttribute("annoTitle", anno.getAnnoTitle());
//		model.addAttribute("annoGrade", anno.getAnnoGrade());
//		model.addAttribute("annoWorkType", anno.getAnnoWorkType());
//		model.addAttribute("annoWorkPlace", anno.getAnnoWorkPlace());
//		model.addAttribute("annoDate", anno.getAnnoDate());
//		model.addAttribute("skillId", anno.getSkillId());
		model.addAttribute("li", li);

//		System.out.println("li size: " + li.size());
//		for (Anno anno1 : li) {
//			System.out.println(anno1.getBusinessName() + " " + anno1.getAnnoTitle());
//		}
//
//		// 공고들의 정보를 출력하는 코드
//		for (Anno anno2 : li) {
//			System.out.println("annoId: " + anno2.getAnnoId());
//		}

		return "anno/userAnnoList";
	}

	@RequestMapping("business-anno-list")
	public String businessAnnoList() throws ServletException, IOException {
		String businessId = (String) session.getAttribute("businessId");
		List<Anno> li = annoDao.getAnnoList();
//      List<Anno> li = annoDao.getAnnoListFromBusinessId(businessId);

//      String businessId = request.getParameter("businessId");
//      String businessName = request.getParameter("businessName");
//      String annoTitle = request.getParameter("annoTitle");
//      String annoGrade = request.getParameter("annoGrade");
//      String annoWorkType = request.getParameter("annoWorkType");
//      String annoWorkPlace = request.getParameter("annoWorkPlace");
//      String annoDate = request.getParameter("annoDate");

//      String annoId = request.getParameter("annoId");

		for (Anno anno : li) {
			if (anno.getAnnoDeadline() != null) {
				Date now = new Date();
				long daysLeft = daysBetweenDates(now, anno.getAnnoDeadline());
				anno.setDaysLeft(daysLeft);
			} else {
				anno.setDaysLeft(-1); // or any other value indicating no deadline set
			}
			int resumeCount = annoDao.getResumeCount(anno.getAnnoId());
			anno.setResumeCount(resumeCount);
		}

		model.addAttribute("businessId", businessId);
//		model.addAttribute("annoId", anno.getAnnoId());
//		model.addAttribute("businessName", anno.getBusinessName());
//		model.addAttribute("annoTitle", anno.getAnnoTitle());
//		model.addAttribute("annoGrade", anno.getAnnoGrade());
//		model.addAttribute("annoWorkType", anno.getAnnoWorkType());
//		model.addAttribute("annoWorkPlace", anno.getAnnoWorkPlace());
//		model.addAttribute("annoDate", anno.getAnnoDate());

		model.addAttribute("li", li);

//		System.out.println("li size: " + li.size());
//		// 공고들의 정보를 출력하는 코드
//		for (Anno anno1 : li) {
//			System.out.println(anno1.getBusinessName() + " " + anno1.getAnnoTitle());
//			System.out.println("annoId: " + anno1.getAnnoId());
//		}

		return "anno/businessAnnoList";
	}

	@RequestMapping("user-anno-info")
	public String userAnnoInfo(int annoId) throws ServletException, IOException {
//		int annoId = Integer.parseInt(request.getParameter("annoId"));
	    Anno anno = annoDao.getAnnoFromAnnoId(annoId);
	    Skill skills = annoDao.getSkillsByAnnoId(annoId);
	    String memberId = (String) session.getAttribute("memberId");
	    Resume resume = resumeDao.getMemberResumeDefault(memberId);
	    
	    int resumeId = 0;
	    if(resume != null) {
	    	resumeId = resume.getResumeId();
	    }
	    
	    
	    // 내가 이력서를 지원한 공고인지 확인하는 코드
	    int findResult = resumeDao.isResumeRegister(annoId, resumeId);
	    // 없으면 0이 뜸
	    System.out.println("findResult : "+findResult);
	    model.addAttribute("findResult", findResult);
	    model.addAttribute("anno", anno);
	    model.addAttribute("skills", skills);

		return "anno/userAnnoInfo";
	}

	@RequestMapping("business-anno-info")
	public String businessAnnoInfo(int annoId) throws ServletException, IOException {
//		int annoId = annoDao.getAnnoId();
//		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);
		Skill skills = annoDao.getSkillsByAnnoId(annoId);

		model.addAttribute("anno", anno);
		model.addAttribute("skills", skills);

		// 스킬 정보를 출력하는 코드 추가
		System.out.println("Skills for AnnoId: " + annoId);
		System.out.println(skills);

		return "anno/businessAnnoInfo";
	}

	@RequestMapping("business-anno-update-form")
	public String businessAnnoUpdateForm(int annoId) throws ServletException, IOException {
//		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);

		String welfare = anno.getWelfare().replace("<br>", "\n");
		String annoContent = anno.getAnnoContent().replace("<br>", "\n");
		anno.setWelfare(welfare);
		anno.setAnnoContent(annoContent);

		Skill skills = annoDao.getSkillsByAnnoId(annoId);
		System.out.println("skills ===" + skills);
		String[] skillsArray = skills.getSkills().split(",");
		for (int i = 0; i < skillsArray.length; i++) {
			System.out.println("skillsArray ===" + skillsArray[i]);
		}
		model.addAttribute("anno", anno);
		model.addAttribute("skills", skills);
		model.addAttribute("skillsArray", skillsArray);

		return "anno/businessAnnoUpdateForm";
	}

	@RequestMapping("anno-update-pro")
	public String annoUpdatePro(Anno anno, int annoId, String selectedSkills, Skill skill)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// Check if the parameter is received correctly
//       String annoIdStr = request.getParameter("annoId"); // update form 가서 annoId name을 annoIdStr로 바꿔야할듯
//		System.out.println("Received annoId: " + annoIdStr);
		int skillId = annoDao.selectSkillId();

//		int annoId = parseIntOrDefault(annoIdStr, 0);
		System.out.println("Received adesadsadasdsasadasdsa: " + annoId);
//       Anno anno = new Anno();
		anno.setAnnoId(annoId);
//       anno.setBusinessName(request.getParameter("businessName"));
//       anno.setWelfare(request.getParameter("welfare"));
//       anno.setAnnoTitle(request.getParameter("annoTitle"));
//       anno.setAnnoCareer(request.getParameter("annoCareer"));
//       anno.setAnnoSalary(request.getParameter("annoSalary"));
//       anno.setAnnoEdu(request.getParameter("annoEdu"));
//       anno.setAnnoGrade(request.getParameter("annoGrade"));
//       anno.setAnnoWorkType(request.getParameter("annoWorkType"));
//       anno.setAnnoWorkDay(request.getParameter("annoWorkDay"));
//       anno.setAnnoWorkPlace(request.getParameter("annoWorkPlace"));
//       anno.setAnnoCommon(request.getParameter("annoCommon"));
//       anno.setAnnoQualification(request.getParameter("annoQualification"));
//		anno.setAnnoPickNum(request.getParameter("annoPickNum"));
//       anno.setAnnoContent(request.getParameter("annoContent"));
//       anno.setBusinessId(request.getParameter("businessId"));
		anno.setSkillId(parseIntOrDefault(request.getParameter("skillId"), 0));
//       String selectedSkills = request.getParameter("selectedSkills");
		Date annoDeadline = parseDate(request.getParameter("annoDeadline"));
		
		anno.setAnnoDeadline(annoDeadline);
		
		System.out.println(selectedSkills);
		System.out.print(anno);

		String welfare = anno.getWelfare().replace("\n", "<br>");
		String annoContent = anno.getAnnoContent().replace("\n", "<br>");
		anno.setWelfare(welfare);
		anno.setAnnoContent(annoContent);
		
		
		int num = annoDao.updateAnno(anno);

		if (num > 0 && selectedSkills != null && !selectedSkills.isEmpty()) {
//			Skill skill = new Skill();
			annoDao.deleteSkillsByAnnoId(annoId); // Delete existing skills
			skill.setAnnoId(annoId);
			skill.setSkillId(skillId);
			skill.setSkills(selectedSkills);

			annoDao.insertSkill(skill);
		}

        String msg = num == 1 ? "공고가 수정되었습니다." : "공고 수정에 실패했습니다.";
        String url = num == 1 ? "business-anno-info?annoId=" + annoId : "business-anno-list";


		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "alert";
	}

	@RequestMapping("anno-delete-pro")
	public String annoDeletePro(int annoId) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// Check if the parameter is received correctly
//		Anno anno = new Anno();
//		String annoIdStr = request.getParameter("annoId"); // delettete form 가서 annoId name을 annoIdStr로 바꿔야할듯
//		int annoId = parseIntOrDefault(annoIdStr, 0);
//		anno.setAnnoId(annoId);

		int num = annoDao.deleteAnno(annoId);

		String msg = num > 0 ? "공고가 삭제되었습니다." : "공고 삭제에 실패했습니다.";
		String url = num > 0 ? "business-anno-list" : "business-anno-info?annoId=" + annoId;

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "alert";
	}

	@RequestMapping("business-anno-management")
	public String businessAnnoManagement(int annoId) throws ServletException, IOException {
//		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);
		List<Resume> resumeList = resumeDao.getAnnoResumeList(annoId);
		
		request.setAttribute("resumeList", resumeList);
		model.addAttribute("anno", anno);

		return "anno/businessAnnoManagement";
	}

	@RequestMapping("search-anno-list")
	public String searchAnnoList(String part, String searchData, Search search) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//      String part = request.getParameter("part");
//      String searchData = request.getParameter("searchData");
//      Search search = new Search();
		search.setPart(part);
		search.setSearchData("%" + searchData + "%");
		List<Anno> searchAnnoList = annoDao.searchAnnoList(search);

		model.addAttribute("searchPart", part);
		model.addAttribute("searchData", searchData);
		model.addAttribute("searchAnnoList", searchAnnoList);

		return "anno/searchAnnoList";
	}
	
	@RequestMapping("business-column-save")
	public String businessColumnSave(String columnTitle, int annoId)
			throws ServletException, IOException {
		
//		String columnTitleList = request.getParameter("columnTitle");
		
//		System.out.println(columnTitleList);
		System.out.println(columnTitle);
		
//		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);
//		ResumeDAO rdao = new ResumeDAO();
		List<Resume> resumeList = resumeDao.getAnnoResumeList(annoId);
		
		model.addAttribute("resumeList", resumeList);
		model.addAttribute("anno", anno);

		return "anno/businessAnnoManagement";
	}

	private int parseIntOrDefault(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	private Date parseDate(String dateStr) {
		if (dateStr == null || dateStr.isEmpty()) {
			return null;
		}
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	private long daysBetweenDates(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		startCal.set(Calendar.HOUR_OF_DAY, 0);
		startCal.set(Calendar.MINUTE, 0);
		startCal.set(Calendar.SECOND, 0);
		startCal.set(Calendar.MILLISECOND, 0);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		endCal.set(Calendar.MILLISECOND, 0);

		long diffMillis = endCal.getTimeInMillis() - startCal.getTimeInMillis();
		return diffMillis / (1000 * 60 * 60 * 24);
	}
}