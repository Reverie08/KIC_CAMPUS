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

	@RequestMapping("main")
	public String business(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = (String) session.getAttribute("bid");
		Business business = businessDao.getBusiness(bid);
		request.setAttribute("business", business);

		return "/view/main.jsp";
	}

	@RequestMapping("businessjoin")
	public String businessJoin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/view/business/businessJoin.jsp";
	}

	@RequestMapping("businessjoinpro")
	public String businessJoinPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bid = request.getParameter("bid");
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
		business.setBid(bid);
		business.setBpw(bpw);
		business.setBname(bname);
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

	@RequestMapping("businesslogin")
	public String businessLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/view/business/businessLogin.jsp";
	}

	@RequestMapping("businessloginpro")
	public String businessLoginPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bid = request.getParameter("bid");
		String bpw = request.getParameter("bpw");

		// Connection 객체
		Business business = businessDao.getBusiness(bid);
		String msg = "";
		String url = "main";
		if (business != null) {
			if (bpw.equals(business.getBpw())) {
				session.setAttribute("bid", bid);
				msg = business.getBname() + "님이 로그인 하셨습니다";
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

	@RequestMapping("businesslogout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다");
		request.setAttribute("url", "main");
		return "/view/alert.jsp";
	}

	@RequestMapping("businesslist")
	public String businessList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Business> businessList = businessDao.businessList();
		request.setAttribute("businessList", businessList);

		return "/view/business/businessList.jsp";
	}

	@RequestMapping("businessinfo")
	public String businessInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String bid = (String)session.getAttribute("bid");
		String bid = request.getParameter("bid");
		Business business = businessDao.getBusiness(bid);
		request.setAttribute("business", business);

		return "/view/business/businessInfo.jsp";
	}

	@RequestMapping("businessupdate")
	public String businessUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = (String) session.getAttribute("bid");
		Business business = businessDao.getBusiness(bid);
		request.setAttribute("business", business);

		return "/view/business/businessUpdate.jsp";
	}

	@RequestMapping("businessupdatepro")
	public String businessUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bid = (String) session.getAttribute("bid");
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

		Business businessDb = businessDao.getBusiness(bid);
		Business business = new Business();
		business.setBid(bid);
		business.setBpw(bpw);
		business.setBname(bname);
		business.setAddress(address);
		business.setSalary(salary);
		business.setEmployees(employees);
		business.setType(type);
		business.setIndustry(industry);
		business.setDetailIndustry(detailIndustry);
		business.setHomepage(homepage);
		business.setContent(content);
		String msg = "";
		String url = "businessupdate?bid=" + bid;

		if (businessDb != null) {
			if (businessDb.getBpw().equals(bpw)) {
				msg = "수정하였습니다";
				businessDao.updateBusiness(business);
				url = "businessinfo?bid=" + bid;
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

		String bid = (String) session.getAttribute("bid");
		Business business = businessDao.getBusiness(bid);

		request.setAttribute("business", business);

		return "/view/business/businessDelete.jsp";
	}

	// 기업 탈퇴 절차
	@RequestMapping("businessdeletepro")
	public String businessDeletePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bid = (String) session.getAttribute("bid");
		String bpw = request.getParameter("bpw");
		Business businessDb = businessDao.getBusiness(bid);

		String msg = "";
		String url = "businessdelete";

		if (businessDb != null) {
			if (businessDb.getBpw().equals(bpw)) {
				msg = "탈퇴 하였습니다.";
				session.invalidate();
				businessDao.deleteBusiness(bid);
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
