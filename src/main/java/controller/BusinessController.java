package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusinessDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Business;
import model.Search;

@WebServlet("/business/*")
public class BusinessController extends MskimRequestMapping {

	HttpSession session;
	BusinessDAO businessDao = new BusinessDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		System.out.println("service");
		super.service(request, response);
	}
	
	// 메인
	@RequestMapping("main")
	public String business(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bId = (String) session.getAttribute("bId");
		Business business = businessDao.getBusiness(bId);
		request.setAttribute("business", business);

		return "/view/main.jsp";
	}
	
	// 기업 회원가입폼
	@RequestMapping("businessjoin")
	public String businessJoin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/view/business/businessJoin.jsp";
	}

	
	// 기업 회원 가입 처리 
	@RequestMapping("businessjoinpro")
	public String businessJoinPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bId = request.getParameter("bId");
		String bpw = request.getParameter("bpw");
		String bname = request.getParameter("bname");
		String address = request.getParameter("address");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String welfare = request.getParameter("welfare");
		String ceo = request.getParameter("ceo");
		int sales = Integer.parseInt(request.getParameter("sales"));
		int employees = Integer.parseInt(request.getParameter("employees"));
		String type = request.getParameter("type");
		String industry = request.getParameter("industry");
		String detailIndustry = request.getParameter("detailIndustry");
		String homepage = request.getParameter("homepage");
		String content = request.getParameter("content");
		
		content = content.replace("\n", "<br>");

		Business business = new Business();
		business.setbId(bId);
		business.setbPw(bpw);
		business.setbName(bname);
		business.setAddress(address);
		business.setSalary(salary);
		business.setWelfare(welfare);
		business.setCeo(ceo);
		business.setSales(sales);
		business.setEmployees(employees);
		business.setType(type);
		business.setIndustry(industry);
		business.setDetailIndustry(detailIndustry);
		business.setHomepage(homepage);
		business.setContent(content);
		System.out.println(business);
		int bnum = businessDao.insertBusiness(business);

		String msg = "";
		String url = "";

		if (bnum > 0) {
			msg = bname + "님의 회원가입이 완료 되었습니다";
			url = "businesslogin";
		} else {
			msg = "회원가입이 실패 하였습니다";
			url = "businessjoin";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 기업 로그인 폼
	@RequestMapping("businesslogin")
	public String businessLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/view/business/businessLogin.jsp";
	}

	
	// 기업 로그인 처리
	@RequestMapping("businessloginpro")
	public String businessLoginPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bId = request.getParameter("bId");
		String bpw = request.getParameter("bpw");

		// Connection 객체
		Business business = businessDao.getBusiness(bId);
		String msg = "";
		String url = "main";
		if (business != null) {
			if (bpw.equals(business.getbPw())) {
				session.setAttribute("bId", bId);
				msg = business.getbName() + "님이 로그인 하셨습니다";
			} else {
				msg = "비밀번호가 맞지 않습니다";
				url = "businesslogin";
			}
		} else {
			msg = "사업자번호를 확인 하세요";
			url = "businesslogin";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 기업 로그아웃
	@RequestMapping("businesslogout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다");
		request.setAttribute("url", "main");
		return "/view/alert.jsp";
	}

	// 기업 리스트
	@RequestMapping("businesslist")
	public String businessList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Business> businessList = businessDao.businessList();
		request.setAttribute("businessList", businessList);

		return "/view/business/businessList.jsp";
	}

	// 기업 정보
	@RequestMapping("businessinfo")
	public String businessInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String bId = (String)session.getAttribute("bId");
		String bId = request.getParameter("bId");
		Business business = businessDao.getBusiness(bId);
		request.setAttribute("business", business);

		return "/view/business/businessInfo.jsp";
	}

	// 기업 정보 수정 폼
	@RequestMapping("businessupdate")
	public String businessUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bId = (String) session.getAttribute("bId");
		Business business = businessDao.getBusiness(bId);
		if (business != null) {
			String content = business.getContent();
			content = content.replace("<br>", "\n");
			business.setContent(content);
		}
		request.setAttribute("business", business);
		return "/view/business/businessUpdate.jsp";
	}

	// 기업 정보 수정 처리
	@RequestMapping("businessupdatepro")
	public String businessUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bId = (String) session.getAttribute("bId");
		String bPw = request.getParameter("bPw");
		String bName = request.getParameter("bName");
		String address = request.getParameter("address");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String welfare = request.getParameter("welfare");
		String ceo = request.getParameter("ceo");
		int sales = Integer.parseInt(request.getParameter("sales"));
		int employees = Integer.parseInt(request.getParameter("employees"));
		String type = request.getParameter("type");
		String industry = request.getParameter("industry");
		String detailIndustry = request.getParameter("detailIndustry");
		String homepage = request.getParameter("homepage");
		String content = request.getParameter("content");
		
		content = content.replace("\n", "<br>");

		Business businessDb = businessDao.getBusiness(bId);
		Business business = new Business();
		business.setbId(bId);
		business.setbPw(bPw);
		business.setbName(bName);
		business.setAddress(address);
		business.setSalary(salary);
		business.setEmployees(employees);
		business.setType(type);
		business.setIndustry(industry);
		business.setDetailIndustry(detailIndustry);
		business.setHomepage(homepage);
		business.setContent(content);
		String msg = "";
		String url = "businessupdate?bid=" + bId;

		if (businessDb != null) {
			if (businessDb.getbPw().equals(bPw)) {
				msg = "수정하였습니다";
				businessDao.updateBusiness(business);
				url = "businessinfo?bid=" + bId;
			} else {
				msg = "비밀번호를 확인해주세요";
			}
		} else {
			msg = "수정이 불가능합니다";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 기업 탈퇴 폼
	@RequestMapping("businessdelete")
	public String businessDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bId = (String) session.getAttribute("bId");
		Business business = businessDao.getBusiness(bId);

		request.setAttribute("business", business);

		return "/view/business/businessDelete.jsp";
	}

	// 기업 탈퇴 처리
	@RequestMapping("businessdeletepro")
	public String businessDeletePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bId = (String) session.getAttribute("bId");
		String bPw = request.getParameter("bPw");
		Business businessDb = businessDao.getBusiness(bId);

		String msg = "";
		String url = "businessdelete";

		if (businessDb != null) {
			if (businessDb.getbPw().equals(bPw)) {
				msg = "탈퇴 하였습니다.";
				session.invalidate();
				businessDao.deleteBusiness(bId);
				url = "businesslogin";
			} else {
				msg = "비밀번호가 틀렸습니다.";
			}
		} else {
			msg = "탈퇴 할 수 없습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 기업 검색
	@RequestMapping("searchbusinesslist")
	public String searchBusinessList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String part = request.getParameter("part");
		String searchData = request.getParameter("searchData");
		Search search = new Search();
		search.setPart(part);
		search.setSearchData("%" + searchData + "%");

		BusinessDAO businessDao = new BusinessDAO();
		List<Business> searchBusinessList = businessDao.searchBusinessList(search);
		request.setAttribute("searchBusinessList", searchBusinessList);

		return "/view/business/searchBusinessList.jsp";
	}

}
