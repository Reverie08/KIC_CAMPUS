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

@WebServlet("/anno/*")
public class AnnoController extends MskimRequestMapping {
    AnnoDAO annoDAO = new AnnoDAO();

    // 구인 공고 입력 폼
    @RequestMapping("businessannoinsertform")
    public String BusinessAnnoInsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/view/anno/BusinessAnnoInsertForm.jsp";
    }

    // 구인 공고 입력 처리
    @RequestMapping("annoinsertpro")
    public String AnnoInsertPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bName = request.getParameter("bName");
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
        String bId = request.getParameter("bId");
        int skillId = parseIntOrDefault(request.getParameter("skillId"), 0);
        
        Anno anno = new Anno();
        
        anno.setbName(bName);
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
        anno.setbId(bId); 
        anno.setSkillId(skillId);
        System.out.print(anno);
        
        int num = annoDAO.insertAnno(anno);
        
        String msg = "";
        String url = "businessannolist";
        
        if (num > 0) {
            msg = bName + "의 공고가 등록되었습니다.";
        } else {
            msg = "공고 등록이 실패했습니다.";
        }
        
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/view/alert.jsp";
    }
    
    // 사용자 구인 공고 목록
    @RequestMapping("userannolist")
    public String UserAnnoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Anno> li = annoDAO.getAnnoList();
        String bId = request.getParameter("bId");
        String bName = request.getParameter("bName");
        String annoTitle = request.getParameter("annoTitle");
        String annoGrade = request.getParameter("annoGrade");
        String annoWorkType = request.getParameter("annoWorkType");
        String annoWorkPlace = request.getParameter("annoWorkPlace");
        String annoDate = request.getParameter("annoDate");
        String skillId = request.getParameter("skillId");
        String annoId = request.getParameter("annoId");
        
        request.setAttribute("bid", bId);
        request.setAttribute("annoid", annoId);
        request.setAttribute("bName", bName);
        request.setAttribute("annotitle", annoTitle);
        request.setAttribute("annograde", annoGrade);
        request.setAttribute("annoworktype", annoWorkType);
        request.setAttribute("annoworkplace", annoWorkPlace);
        request.setAttribute("annodate", annoDate);
        request.setAttribute("skillid", skillId);
        request.setAttribute("li", li);
        
        System.out.println("li size: " + li.size());
        for (Anno anno : li) {
            System.out.println(anno.getbName() + " " + anno.getAnnoTitle());
        }

        // 모든 구인 공고 리스트를 출력하는 예제
        for (Anno anno : li) {
            System.out.println("annoId: " + anno.getAnnoId());
        }

        return "/view/anno/userannolist.jsp";
    }
    
    // 사업자 구인 공고 목록
    @RequestMapping("businessannolist")
    public String BusinessAnnoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Anno> li = annoDAO.getAnnoList();
        String bid = request.getParameter("bid");
        String bName = request.getParameter("bName");
        String annotitle = request.getParameter("annotitle");
        String annograde = request.getParameter("annograde");
        String annoworktype = request.getParameter("annoworktype");
        String annoworkplace = request.getParameter("annoworkplace");
        String annodate = request.getParameter("annodate");
        String skillid = request.getParameter("skillid");
        String annoid = request.getParameter("annoid");
        
        request.setAttribute("bid", bid);
        request.setAttribute("annoid", annoid);
        request.setAttribute("bName", bName);
        request.setAttribute("annotitle", annotitle);
        request.setAttribute("annograde", annograde);
        request.setAttribute("annoworktype", annoworktype);
        request.setAttribute("annoworkplace", annoworkplace);
        request.setAttribute("annodate", annodate);
        request.setAttribute("skillid", skillid);
        request.setAttribute("li", li);
        
        System.out.println("li size: " + li.size());
        for (Anno anno : li) {
            System.out.println(anno.getbName() + " " + anno.getAnnoTitle());
        }

        // 모든 구인 공고 리스트를 출력하는 예제
        for (Anno anno : li) {
            System.out.println("annoid: " + anno.getAnnoId());
        }

        return "/view/anno/BusinessAnnoList.jsp";
    }

    // 사업자 구인 공고 정보
    @RequestMapping("businessannoinfo")
    public String BusinessAnnoInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int annoid = Integer.parseInt(request.getParameter("annoid"));
        Anno anno = annoDAO.getAnnoFromAnnoId(annoid);
        
        request.setAttribute("anno", anno);

        return "/view/anno/BusinessAnnoInfo.jsp";
    }
    
    // 사용자 구인 공고 정보
    @RequestMapping("userannoinfo")
    public String UserAnnoInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int annoid = Integer.parseInt(request.getParameter("annoid"));
        Anno anno = annoDAO.getAnnoFromAnnoId(annoid);
        
        request.setAttribute("anno", anno);

        return "/view/anno/UserAnnoInfo.jsp";
    }
    
    // 사업자 구인 공고 수정 폼
    @RequestMapping("businessannoupdateform")
    public String BusinessAnnoUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int annoid = Integer.parseInt(request.getParameter("annoid"));
        Anno anno = annoDAO.getAnnoFromAnnoId(annoid);
        
        request.setAttribute("anno", anno);
        
        return "/view/anno/BusinessAnnoUpdateForm.jsp";
    }
    
    // 구인 공고 수정 처리
    @RequestMapping("annoupdatepro")
    public String AnnoUpdatePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Check if the parameter is received correctly
        String annoidStr = request.getParameter("annoid");
        System.out.println("Received annoId: " + annoidStr);

        int annoid = parseIntOrDefault(annoidStr, 0);

        Anno anno = new Anno();
        anno.setAnnoId(annoid);
        anno.setbName(request.getParameter("bName"));
        anno.setWelfare(request.getParameter("welfare"));
        anno.setAnnoTitle(request.getParameter("annotitle"));
        anno.setAnnoCareer(request.getParameter("annocareer"));
        anno.setAnnoSalary(request.getParameter("annosalary"));
        anno.setAnnoEdu(request.getParameter("annoedu"));
        anno.setAnnoGrade(request.getParameter("annograde"));
        anno.setAnnoWorkType(request.getParameter("annoworktype"));
        anno.setAnnoWorkDay(request.getParameter("annoworkday"));
        anno.setAnnoWorkPlace(request.getParameter("annoworkplace"));
        anno.setAnnoCommon(request.getParameter("annocommon"));
        anno.setAnnoQualification(request.getParameter("annoqualification"));
        anno.setAnnoPickNum(parseIntOrDefault(request.getParameter("annopicknum"), 0));
        anno.setAnnoContent(request.getParameter("annocontent"));
        anno.setbId(request.getParameter("bId")); 
        anno.setSkillId(parseIntOrDefault(request.getParameter("skillid"), 0));

        System.out.print(anno);
        
        int num = annoDAO.updateAnno(anno);

        String msg = "";
        String url = "businessannolist";
        
        if (num == 1) {
            msg = "공고가 수정되었습니다.";
            url = "businessannoinfo?annoid=" + annoid;
        } else {
            msg = "공고 수정이 실패했습니다.";
        }
        
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/view/alert.jsp";
    }
    
    // 구인 공고 삭제 처리
    @RequestMapping("annodeletepro")
    public String AnnoDeletePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Check if the parameter is received correctly
        Anno anno = new Anno();
        String annoidStr = request.getParameter("annoid");
        int annoid = parseIntOrDefault(annoidStr, 0);
        anno.setAnnoId(annoid);
        
        String msg = "";
        String url = "";
        
        int num = annoDAO.deleteAnno(annoid);
        if (num == 1) {
            msg = "공고가 삭제되었습니다.";
            url = "BusinessAnnoList";
        } else {
            msg = "공고 삭제가 실패했습니다.";
            url = "BusinessAnnoInfo?annoid=" + annoid;
        }
        
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/view/alert.jsp";
    }
    
    // 사업자 구인 공고 관리
    @RequestMapping("businessannomanagement")
    public String BusinessAnnoManagement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int annoid = Integer.parseInt(request.getParameter("annoid"));
        Anno anno = annoDAO.getAnnoFromAnnoId(annoid);
        
        request.setAttribute("anno", anno);

        return "/view/anno/BusinessAnnoManagement.jsp";
    }
    
    // 문자열을 정수로 변환하거나 기본값을 반환하는 메서드
    private int parseIntOrDefault(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
