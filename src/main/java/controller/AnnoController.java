package controller;

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

import dao.AnnoDAO;
import dao.BusinessDAO;
import dao.MemberDAO;
import model.Anno;
import model.Business;
import model.Search;
import model.Skill;

@Controller
@RequestMapping("/anno/")
public class AnnoController {

	Model model;
	HttpSession session;
	HttpServletRequest request;

	@Autowired
	BusinessDAO businessDao = new BusinessDAO();

	@Autowired
	AnnoDAO annoDao = new AnnoDAO();

	@Autowired
	MemberDAO memberDao = new MemberDAO();

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

		String businessId = (String) session.getAttribute("businessId");
		int skillId = annoDao.selectSkillId();
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
		int annoPickNum = parseIntOrDefault(request.getParameter("annoPickNum"), 0);
//      String annoContent = request.getParameter("annoContent");
//      String businessId = request.getParameter("businessId");
//      String selectedSkills = request.getParameter("selectedSkills");
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
		anno.setAnnoPickNum(annoPickNum);
//      anno.setAnnoContent(annoContent);
//      anno.setBusinessId(businessId);
//      anno.setSkillId(annoDao.selectSkillId());

		String welfare = anno.getWelfare().replace("\n", "<br>");
		String annoContent = anno.getAnnoContent().replace("\n", "<br>");
		anno.setWelfare(welfare);
		anno.setAnnoContent(annoContent);

		System.out.println(anno);

		int num = annoDao.insertAnno(anno);
		int annoId = annoDao.getAnnoId();

		if (num > 0 && selectedSkills != null && !selectedSkills.isEmpty()) {
			skill = new Skill();

			skill.setAnnoId(annoId);
			skill.setSkillId(skillId);
			skill.setSkills(selectedSkills);

			annoDao.insertSkill(skill);
		}

		String msg = "";
		String url = "business-anno-list?businessId="+businessId;

		if (num > 0) {
			msg = anno.getBusinessName() + "의 공고가 등록되었습니다.";
		} else {
			msg = "공고 등록이 실패했습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "alert";
	}

	// Other methods...

	@RequestMapping("user-anno-list")
	public String userAnnoList(Anno anno) throws ServletException, IOException {
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

		model.addAttribute("businessId", anno.getBusinessId());
		model.addAttribute("annoId", anno.getAnnoId());
		model.addAttribute("businessName", anno.getBusinessName());
		model.addAttribute("annoTitle", anno.getAnnoTitle());
		model.addAttribute("annoGrade", anno.getAnnoGrade());
		model.addAttribute("annoWorkType", anno.getAnnoWorkType());
		model.addAttribute("annoWorkPlace", anno.getAnnoWorkPlace());
		model.addAttribute("annoDate", anno.getAnnoDate());
		model.addAttribute("skillId", anno.getSkillId());
		model.addAttribute("li", li);

		System.out.println("li size: " + li.size());
		for (Anno anno1 : li) {
			System.out.println(anno1.getBusinessName() + " " + anno1.getAnnoTitle());
		}

		// 공고들의 정보를 출력하는 코드
		for (Anno anno2 : li) {
			System.out.println("annoId: " + anno2.getAnnoId());
		}

		return "anno/userAnnoList";
	}

	@RequestMapping("business-anno-list")
	public String businessAnnoList(Anno anno) throws ServletException, IOException {
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
//
		model.addAttribute("businessId", businessId);
		model.addAttribute("annoId", anno.getAnnoId());
		model.addAttribute("businessName", anno.getBusinessName());
		model.addAttribute("annoTitle", anno.getAnnoTitle());
		model.addAttribute("annoGrade", anno.getAnnoGrade());
		model.addAttribute("annoWorkType", anno.getAnnoWorkType());
		model.addAttribute("annoWorkPlace", anno.getAnnoWorkPlace());
		model.addAttribute("annoDate", anno.getAnnoDate());

		model.addAttribute("li", li);

		System.out.println("li size: " + li.size());
		// 공고들의 정보를 출력하는 코드
		for (Anno anno1 : li) {
			System.out.println(anno1.getBusinessName() + " " + anno1.getAnnoTitle());
			System.out.println("annoId: " + anno1.getAnnoId());
		}

		return "anno/businessAnnoList";
	}

	@RequestMapping("user-anno-info")
	public String userAnnoInfo(int annoId) throws ServletException, IOException {
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);
		Skill skills = annoDao.getSkillsByAnnoId(annoId);

		model.addAttribute("anno", anno);
		model.addAttribute("skills", skills);

		return "anno/userAnnoInfo";
	}

	@RequestMapping("business-anno-info")
	public String businessAnnoInfo() throws ServletException, IOException {
//		int annoId = annoDao.getAnnoId();
		int annoId = Integer.parseInt(request.getParameter("annoId"));
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
	public String businessAnnoUpdateForm() throws ServletException, IOException {
		int annoId = Integer.parseInt(request.getParameter("annoId"));
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
	public String annoUpdatePro(Anno anno, String annoIdStr, String selectedSkills)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// Check if the parameter is received correctly
//       String annoIdStr = request.getParameter("annoId"); // update form 가서 annoId name을 annoIdStr로 바꿔야할듯
		System.out.println("Received annoId: " + annoIdStr);
		int skillId = annoDao.selectSkillId();

		int annoId = parseIntOrDefault(annoIdStr, 0);
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
		anno.setAnnoPickNum(parseIntOrDefault(request.getParameter("annoPickNum"), 0));
//       anno.setAnnoContent(request.getParameter("annoContent"));
//       anno.setBusinessId(request.getParameter("businessId"));
		anno.setSkillId(parseIntOrDefault(request.getParameter("skillId"), 0));
//       String selectedSkills = request.getParameter("selectedSkills");
		System.out.println(selectedSkills);
		System.out.print(anno);
		
		String welfare = anno.getWelfare().replace("\n", "<br>");
		String annoContent = anno.getAnnoContent().replace("\n", "<br>");
		anno.setWelfare(welfare);
		anno.setAnnoContent(annoContent);

		int num = annoDao.updateAnno(anno);

		if (num > 0 && selectedSkills != null && !selectedSkills.isEmpty()) {
			Skill skill = new Skill();
			annoDao.deleteSkillsByAnnoId(annoId); // Delete existing skills
			skill.setAnnoId(annoId);
			skill.setSkillId(skillId);
			skill.setSkills(selectedSkills);

			annoDao.insertSkill(skill);
		}

		String msg = "";
		String url = "business-anno-info?annoId=" + annoId;

		if (num == 1) {
			msg = "공고가 수정되었습니다.";

		} else {
			msg = "공고 수정에 실패했습니다.";

		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "alert";
	}

	@RequestMapping("anno-delete-pro")
	public String annoDeletePro(Anno anno, String annoIdStr) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// Check if the parameter is received correctly
//      Anno anno = new Anno();
//      String annoIdStr = request.getParameter("annoId"); // delettete form 가서 annoId name을 annoIdStr로 바꿔야할듯
		int annoId = parseIntOrDefault(annoIdStr, 0);
		anno.setAnnoId(annoId);

		String msg = "";
		String url = "";

		int num = annoDao.deleteAnno(annoId);
		if (num == 1) {
			msg = "공고가 삭제되었습니다.";
			url = "business-anno-list";
		} else {
			msg = "공고 삭제에 실패했습니다.";
			url = "business-anno-info?annoId=" + annoId;
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "alert";
	}

	@RequestMapping("business-anno-management")
	public String businessAnnoManagement() throws ServletException, IOException {
		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);

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

	private int parseIntOrDefault(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
}