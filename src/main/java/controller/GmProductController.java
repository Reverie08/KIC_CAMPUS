package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.GmMemberDAO;
import dao.GmProductDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.GmMember;
import model.GmProduct;

@WebServlet("/product/*")
public class GmProductController extends MskimRequestMapping {
	HttpSession session;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		System.out.println("service");
		super.service(request, response);
	}

	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/index.jsp";
	}

	@RequestMapping("gmMain")
	public String gmMain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) session.getAttribute("id");
		GmMemberDAO dao = new GmMemberDAO();
		GmMember mem = dao.getMember(id);
		request.setAttribute("mem", mem);

		return "/single/gmMain.jsp";
	}

	@RequestMapping("gmProdForm")
	public String gmProdForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String id = (String)session.getAttribute("id"); GmMemberDAO dao=new
		 * GmMemberDAO(); GmMember mem = dao.getMember(id); request.setAttribute("mem",
		 * mem);
		 */

		return "/view/product/gmProdForm.jsp";
	}

	@RequestMapping("gmProdRegist")
	public String gmProdRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("gmProdRegist ------");
		request.setCharacterEncoding("utf-8");

		String path = request.getServletContext().getRealPath("/") + "storage/product/";
		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8");
		System.out.println(path);

		/* String boardid = (String) session.getAttribute("boardid"); */
		GmProduct gp = new GmProduct();
		gp.setProdname(multi.getParameter("prodname"));
		gp.setPrice(Integer.parseInt(multi.getParameter("price")));
		gp.setProdcontent(multi.getParameter("prodcontent"));
		gp.setCategory(multi.getParameter("category"));
		gp.setFile2(multi.getFilesystemName("file2"));

		System.out.println(gp);

		GmProductDAO dao = new GmProductDAO();
		int num = dao.insertProd(gp);

		String msg = "상품 등록 성공";
		/* String url = "gmProdList?boardid=" + boardid; */
		String url = "gmProdList";
		if (num == 0) {
			msg = "상품 등록 실패";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/view/alert.jsp";
	}

	@RequestMapping("gmProdList")
	public String gmProdList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GmProductDAO dao = new GmProductDAO();
		List<GmProduct> li = dao.gmProdList();
		request.setAttribute("li", li);
		
		String prodid = request.getParameter("prodid");
		session.setAttribute("prodid", prodid);
		

		System.out.println(li);

		return "/view/product/gmProdList.jsp";
	}

	@RequestMapping("gmProdInfo")
	public String gmProdInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8090/gmModel2/gmBoard/gmBoardInfo?num=10
		int prodid = Integer.parseInt(request.getParameter("prodid"));
		System.out.println(prodid);
		GmProductDAO dao = new GmProductDAO();
		GmProduct prod = dao.getProd(prodid);

		request.setAttribute("prod", prod);
		return "/view/product/gmProdInfo.jsp";
	}

	@RequestMapping("gmProdUpdForm")
	public String gmProdUpdForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodid = Integer.parseInt(request.getParameter("prodid"));
		System.out.println(prodid);
		GmProductDAO dao = new GmProductDAO();
		GmProduct prod = dao.getProd(prodid);

		request.setAttribute("prod", prod);

		return "/view/product/gmProdUpdForm.jsp";
	}

	@RequestMapping("gmProdUpd")
	public String gmProdUpd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("gmProdUpd========");
		request.setCharacterEncoding("utf-8");
		String path = request.getServletContext().getRealPath("/") + "storage/product/";
		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");
		
		int prodid = Integer.parseInt(multi.getParameter("prodid")); 
		System.out.println(prodid);
		/* String pass = multi.getParameter("pass"); */
		System.out.println(prodid);
		GmProductDAO dao = new GmProductDAO();
		GmProduct prod = new GmProduct();
		GmProduct proddb = dao.getProd(prodid);
		prod.setProdid(prodid);
		prod.setProdname(multi.getParameter("prodname"));
		prod.setPrice(Integer.parseInt(multi.getParameter("price")));
		prod.setProdcontent(multi.getParameter("prodcontent"));
		prod.setCategory(multi.getParameter("category"));

		if (multi.getFilesystemName("file2") == null) {
			proddb.setFile2(multi.getParameter("currentfile"));
		} else {
			proddb.setFile2(multi.getFilesystemName("file2"));
		}

		String msg = "수정 할 수 없습니다";
		String url = "gmProdUpdInfo?prodid=" + prodid;

		if (proddb != null) {
			/* if(pass.equals(proddb.getPass())) { */
			int count = dao.updateProd(prod);
			if (count == 1) {
				msg = "수정 하였습니다";
				dao.updateProd(prod);
				url = "gmProdInfo?prodid=" + prodid;
			} else {
				msg = "상품이 없습니다";
			}
			/*
			 * } else { msg = "비밀번호가 틀렸습니다"; }
			 */
		} /*
			 * else { msg = "상품이 없습니다"; }
			 */

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	@RequestMapping("gmProdDelForm")
	public String gmProdDelForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/kicmodel2/board/boardInfo?num=10

		request.setAttribute("prodid", request.getParameter("prodid"));
		return "/view/product/gmProdDelForm.jsp";
	}
	
	@RequestMapping("gmProdDel")
	public String gmProdDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodid = Integer.parseInt(request.getParameter("prodid"));
		/* String pass = request.getParameter("pass"); */
		/* String boardid = (String) session.getAttribute("boardid"); */
		GmProductDAO dao = new GmProductDAO();
		GmProduct proddb = dao.getProd(prodid);
		String msg = "삭제 되지 않았습니다";
		String url = "gmProdDelForm?prodid=" + prodid;

		if (proddb != null) {
			/*if (pass.equals(boarddb.getPass())) {*/
				int count = dao.deleteProd(prodid);
				if (count == 1) {
					msg = "삭제 되었습니다";
					url = "gmProdList";
				}
				/* } */
				/*
				 * else { msg = "비밀번호를 확인 하세요"; }
				 */
		} else {
			msg = "상품이 없습니다";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
}
