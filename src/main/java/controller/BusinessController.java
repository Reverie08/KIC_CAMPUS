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
	@RequestMapping("business-main")
	public String business(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String businessId = (String) session.getAttribute("businessId");
		Business business = businessDao.getBusiness(businessId);
		request.setAttribute("business", business);

		return "/view/business/businessMain.jsp";
	}
	
	// 기업 회원가입폼
	@RequestMapping("business-join")
	public String businessJoin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/view/business/businessJoin.jsp";
	}

	
	// 기업 회원 가입 처리 
	@RequestMapping("business-join-pro")
	public String businessJoinPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String businessId = request.getParameter("businessId");
		String businessPw = request.getParameter("businessPw");
		String businessName = request.getParameter("businessName");
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
		business.setBusinessId(businessId);
		business.setBusinessPw(businessPw);
		business.setBusinessName(businessName);
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
		int businessNum = businessDao.insertBusiness(business);

		String msg = "";
		String url = "";

		if (businessNum > 0) {
			msg = businessName + "님의 회원가입이 완료 되었습니다";
			url = "business-login";
		} else {
			msg = "회원가입이 실패 하였습니다";
			url = "business-join";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 기업 로그인 폼
	@RequestMapping("business-login")
	public String businessLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/view/business/businessLogin.jsp";
	}

	
	// 기업 로그인 처리
	@RequestMapping("business-login-pro")
	public String businessLoginPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String businessId = request.getParameter("businessId");
		String businessPw = request.getParameter("businessPw");

		// Connection 객체
		Business business = businessDao.getBusiness(businessId);
		String msg = "";
		String url = "business-main";
		if (business != null) {
			if (businessPw.equals(business.getBusinessPw())) {
				session.setAttribute("businessId", businessId);
				msg = business.getBusinessName() + "님이 로그인 하셨습니다";
			} else {
				msg = "비밀번호가 맞지 않습니다";
				url = "business-login";
			}
		} else {
			msg = "사업자번호를 확인 하세요";
			url = "business-login";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	// 기업 로그아웃
	@RequestMapping("business-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다");
		request.setAttribute("url", "business-main");
		return "/view/alert.jsp";
	}

	// 기업 리스트
	@RequestMapping("business-list")
	public String businessList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Business> businessList = businessDao.businessList();
		request.setAttribute("businessList", businessList);

		return "/view/business/businessList.jsp";
	}

	// 기업 정보
	@RequestMapping("business-info")
	public String businessInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String businessId = (String)session.getAttribute("businessId");
//		String businessId = session.getParameter("businessId");
		Business business = businessDao.getBusiness(businessId);
		request.setAttribute("business", business);

		return "/view/business/businessInfo.jsp";
	}

	// 기업 정보 수정 폼
	@RequestMapping("business-update")
	public String businessUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String businessId = (String) session.getAttribute("businessId");
		Business business = businessDao.getBusiness(businessId);
		if (business != null) {
			String content = business.getContent();
			content = content.replace("<br>", "\n");
			business.setContent(content);
		}
		request.setAttribute("business", business);
		return "/view/business/businessUpdate.jsp";
	}

	// 기업 정보 수정 처리
	@RequestMapping("business-update-pro")
	public String businessUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String businessId = (String) session.getAttribute("businessId");
		String businessPw = request.getParameter("businessPw");
		String businessName = request.getParameter("businessName");
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

		Business businessDb = businessDao.getBusiness(businessId);
		Business business = new Business();
		business.setBusinessId(businessId);
		business.setBusinessPw(businessPw);
		business.setBusinessName(businessName);
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
		String msg = "";
		String url = "business-update?businessid=" + businessId;

		if (businessDb != null) {
			if (businessDb.getBusinessPw().equals(businessPw)) {
				msg = "수정하였습니다";
				businessDao.updateBusiness(business);
				url = "business-info?businessid=" + businessId;
			} else {
				System.out.println(businessDb.getBusinessPw());
				System.out.println(businessPw);
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
	@RequestMapping("business-delete")
	public String businessDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String businessId = (String) session.getAttribute("businessId");
		Business business = businessDao.getBusiness(businessId);

		request.setAttribute("business", business);

		return "/view/business/businessDelete.jsp";
	}

	// 기업 탈퇴 처리
	@RequestMapping("business-delete-pro")
	public String businessDeletePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String businessId = (String) session.getAttribute("businessId");
		String businessPw = request.getParameter("businessPw");
		Business businessDb = businessDao.getBusiness(businessId);

		String msg = "";
		String url = "business-delete";

		if (businessDb != null) {
			if (businessDb.getBusinessPw().equals(businessPw)) {
				msg = "탈퇴 하였습니다.";
				session.invalidate();
				businessDao.deleteBusiness(businessId);
				url = "business-login";
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
	@RequestMapping("search-business-list")
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
