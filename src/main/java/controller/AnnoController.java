package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import dao.AnnoDAO;
import model.Anno;
import model.Skill;

@WebServlet("/anno/*")
public class AnnoController extends MskimRequestMapping {
	AnnoDAO annoDao = new AnnoDAO();

	@RequestMapping("business-anno-insert-form")
	public String BusinessAnnoInsertForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Skill> skills = annoDao.getAllSkills();
		request.setAttribute("skills", skills);
		return "/view/anno/businessAnnoInsertForm.jsp";
	}

	@RequestMapping("anno-insert-pro")
	public String annoInsertPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String businessName = request.getParameter("businessName");
		String welfare = request.getParameter("welfare");
		String annoTitle = request.getParameter("annoTitle");
		String annoCareer = request.getParameter("annoCareer");
		String annoSalary = request.getParameter("annoSalary");
		String annoEdu = request.getParameter("annoEdu");
		String annoGrade = request.getParameter("annoGrade");
		String annoWorkType = request.getParameter("annoWorkType");
		String annoWorkDay = request.getParameter("annoWorkDay");
		String annoWorkPlace = request.getParameter("annoWorkPlace");
		String annoCommon = request.getParameter("annoCommon");
		String annoQualification = request.getParameter("annoQualification");
		int annoPickNum = parseIntOrDefault(request.getParameter("annoPickNum"), 0);
		String annoContent = request.getParameter("annoContent");
		String businessId = request.getParameter("businessId");
		int skillId = parseIntOrDefault(request.getParameter("skillId"), 0);
		String selectedSkills = request.getParameter("selectedSkills");
		System.out.println(selectedSkills);

		Anno anno = new Anno();

		anno.setBusinessName(businessName);
		anno.setWelfare(welfare);
		anno.setAnnoTitle(annoTitle);
		anno.setAnnoCareer(annoCareer);
		anno.setAnnoSalary(annoSalary);
		anno.setAnnoEdu(annoEdu);
		anno.setAnnoGrade(annoGrade);
		anno.setAnnoWorkType(annoWorkType);
		anno.setAnnoWorkDay(annoWorkDay);
		anno.setAnnoWorkPlace(annoWorkPlace);
		anno.setAnnoCommon(annoCommon);
		anno.setAnnoQualification(annoQualification);
		anno.setAnnoPickNum(annoPickNum);
		anno.setAnnoContent(annoContent);
		anno.setBusinessId(businessId);
		anno.setSkillId(skillId);
		System.out.println(anno);

		int num = annoDao.insertAnno(anno);
		int annoId = annoDao.getAnnoId();

		if (num > 0 && selectedSkills != null && !selectedSkills.isEmpty()) {
			String[] skills = selectedSkills.split(",");
			Skill skill = new Skill();
			for (String skillName : skills) {
				skill.setAnnoId(annoId);
				if (skillName.equals("java"))
					skill.setJava("java");
				if (skillName.equals("jsp"))
					skill.setJsp("jsp");
				if (skillName.equals("html"))
					skill.setHtml("html");
				if (skillName.equals("css"))
					skill.setCss("css");
				if (skillName.equals("javascript"))
					skill.setJavascript("javascript");
				if (skillName.equals("react"))
					skill.setReact("react");
				if (skillName.equals("springframework"))
					skill.setSpringframework("springframework");
				if (skillName.equals("springboot"))
					skill.setSpringboot("springboot");
				if (skillName.equals("python"))
					skill.setPython("python");
				if (skillName.equals("typescript"))
					skill.setTypescript("typescript");
				if (skillName.equals("express"))
					skill.setExpress("express");
				if (skillName.equals("oracle"))
					skill.setOracle("oracle");
				if (skillName.equals("mysql"))
					skill.setMysql("mysql");
				if (skillName.equals("mongodb"))
					skill.setMongodb("mongodb");
			}
			annoDao.insertSkill(skill);
		}

		String msg = "";
		String url = "business-anno-list";

		if (num > 0) {
			msg = businessName + "의 공고가 등록되었습니다.";
		} else {
			msg = "공고 등록이 실패했습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	// Other methods...

	@RequestMapping("user-anno-list")
	public String userAnnoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Anno> li = annoDao.getAnnoList();
		String businessId = request.getParameter("businessId");
		String businessName = request.getParameter("businessName");
		String annoTitle = request.getParameter("annoTitle");
		String annoGrade = request.getParameter("annoGrade");
		String annoWorkType = request.getParameter("annoWorkType");
		String annoWorkPlace = request.getParameter("annoWorkPlace");
		String annoDate = request.getParameter("annoDate");
		String skillId = request.getParameter("skillId");
		String annoId = request.getParameter("annoId");

		request.setAttribute("businessId", businessId);
		request.setAttribute("annoId", annoId);
		request.setAttribute("businessName", businessName);
		request.setAttribute("annoTitle", annoTitle);
		request.setAttribute("annoGrade", annoGrade);
		request.setAttribute("annoWorkType", annoWorkType);
		request.setAttribute("annoWorkPlace", annoWorkPlace);
		request.setAttribute("annoDate", annoDate);
		request.setAttribute("skillId", skillId);
		request.setAttribute("li", li);

		System.out.println("li size: " + li.size());
		for (Anno anno : li) {
			System.out.println(anno.getBusinessName() + " " + anno.getAnnoTitle());
		}

		// 공고들의 정보를 출력하는 코드
		for (Anno anno : li) {
			System.out.println("annoId: " + anno.getAnnoId());
		}

		return "/view/anno/userAnnoList.jsp";
	}

	@RequestMapping("business-anno-list")
	public String businessAnnoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Anno> li = annoDao.getAnnoList();
		String businessId = request.getParameter("businessId");
		String businessName = request.getParameter("businessName");
		String annoTitle = request.getParameter("annoTitle");
		String annoGrade = request.getParameter("annoGrade");
		String annoWorkType = request.getParameter("annoWorkType");
		String annoWorkPlace = request.getParameter("annoWorkPlace");
		String annoDate = request.getParameter("annoDate");
		String skillId = request.getParameter("skillId");
		String annoId = request.getParameter("annoId");

		request.setAttribute("businessId", businessId);
		request.setAttribute("annoId", annoId);
		request.setAttribute("businessName", businessName);
		request.setAttribute("annoTitle", annoTitle);
		request.setAttribute("annoGrade", annoGrade);
		request.setAttribute("annoWorkType", annoWorkType);
		request.setAttribute("annoWorkPlace", annoWorkPlace);
		request.setAttribute("annoDate", annoDate);
		request.setAttribute("skillId", skillId);
		request.setAttribute("li", li);

		System.out.println("li size: " + li.size());
		for (Anno anno : li) {
			System.out.println(anno.getBusinessName() + " " + anno.getAnnoTitle());
		}

		// 공고들의 정보를 출력하는 코드
		for (Anno anno : li) {
			System.out.println("annoId: " + anno.getAnnoId());
		}

		return "/view/anno/businessAnnoList.jsp";
	}

	@RequestMapping("business-anno-info")
	public String BusinessAnnoInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);
		List<Skill> skills = annoDao.getSkillsByAnnoId(annoId);

		request.setAttribute("anno", anno);
		request.setAttribute("skills", skills);

		// 스킬 정보를 출력하는 코드 추가
		System.out.println("Skills for AnnoId: " + annoId);
		for (Skill skill : skills) {
			System.out.println(skill);
		}

		return "/view/anno/businessAnnoInfo.jsp";
	}

	@RequestMapping("user-anno-info")
	public String userAnnoInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);

		request.setAttribute("anno", anno);

		return "/view/anno/userAnnoInfo.jsp";
	}

	@RequestMapping("business-anno-update-form")
	public String businessAnnoUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);

		request.setAttribute("anno", anno);

		return "/view/anno/businessAnnoUpdateForm.jsp";
	}

	@RequestMapping("anno-update-pro")
	public String annoUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// Check if the parameter is received correctly
		String annoIdStr = request.getParameter("annoId");
		System.out.println("Received annoId: " + annoIdStr);

		int annoId = parseIntOrDefault(annoIdStr, 0);

		Anno anno = new Anno();
		anno.setAnnoId(annoId);
		anno.setBusinessName(request.getParameter("businessName"));
		anno.setWelfare(request.getParameter("welfare"));
		anno.setAnnoTitle(request.getParameter("annoTitle"));
		anno.setAnnoCareer(request.getParameter("annoCareer"));
		anno.setAnnoSalary(request.getParameter("annoSalary"));
		anno.setAnnoEdu(request.getParameter("annoEdu"));
		anno.setAnnoGrade(request.getParameter("annoGrade"));
		anno.setAnnoWorkType(request.getParameter("annoWorkType"));
		anno.setAnnoWorkDay(request.getParameter("annoWorkDay"));
		anno.setAnnoWorkPlace(request.getParameter("annoWorkPlace"));
		anno.setAnnoCommon(request.getParameter("annoCommon"));
		anno.setAnnoQualification(request.getParameter("annoQualification"));
		anno.setAnnoPickNum(parseIntOrDefault(request.getParameter("annoPickNum"), 0));
		anno.setAnnoContent(request.getParameter("annoContent"));
		anno.setBusinessId(request.getParameter("businessId"));
		anno.setSkillId(parseIntOrDefault(request.getParameter("skillId"), 0));

		System.out.print(anno);

		int num = annoDao.updateAnno(anno);

		String msg = "";
		String url = "business-anno-list";

		if (num == 1) {
			msg = "공고가 수정되었습니다.";
			url = "business-anno-info?annoid=" + annoId;
		} else {
			msg = "공고 수정에 실패했습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	@RequestMapping("anno-delete-pro")
	public String annoDeletePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// Check if the parameter is received correctly
		Anno anno = new Anno();
		String annoIdStr = request.getParameter("annoId");
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
			url = "business-anno-info?annoid=" + annoId;
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	@RequestMapping("business-anno-management")
	public String businessAnnoManagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int annoId = Integer.parseInt(request.getParameter("annoId"));
		Anno anno = annoDao.getAnnoFromAnnoId(annoId);

		request.setAttribute("anno", anno);

		return "/view/anno/businessAnnoManagement.jsp";
	}

	private int parseIntOrDefault(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
}
