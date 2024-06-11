package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusinessDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Business;


@WebServlet("/business/*")
public class BusinessController extends MskimRequestMapping {
	
	HttpSession session;
	BusinessDAO businessDao = new BusinessDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		System.out.println("service");
		super.service(request, response);
	}
	
//	@RequestMapping("business")
//	public String business(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		return "/view/business.jsp";
//	}
	
	@RequestMapping("businessjoin")
	public String businessjoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/view/business/businessjoin.jsp";
	}
	
	@RequestMapping("businessjoinPro")
	public String businessjoinPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bid = Integer.parseInt(request.getParameter("bid"));
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
		
		Business business = new Business();
		business.setBid(bid); 
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
		
		if(bnum > 0) {
			msg = bname + "님의 회원가입이 완료 되었습니다";
			url = "login";
		} else {
			msg = "회원가입이 실패 하였습니다";
			url = "join";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/view/alert.jsp";
	}
}
