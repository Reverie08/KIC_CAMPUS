package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.GmBoardDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.GmBoard;

@WebServlet("/board/*")
public class GmBoardController extends MskimRequestMapping {
	HttpSession session;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		System.out.println("service");
		super.service(request, response);
	}
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/index.jsp";
	}
	
	@RequestMapping("gmMain")
	public String gmMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/single/gmMain.jsp";
	}
	
	@RequestMapping("gmBoardForm")
	public String gmBoardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/view/board/gmBoardForm.jsp";
	}
	
	@RequestMapping("gmBoardPro")
	public String gmBoardPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String path = request.getServletContext().getRealPath("/") + "storage/board/";
		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8");
		
		String boardid = (String) session.getAttribute("boardid");
		GmBoard gb = new GmBoard();
		gb.setName(multi.getParameter("name"));
		gb.setPass(multi.getParameter("pass"));
		gb.setSubject(multi.getParameter("subject"));
		gb.setContent(multi.getParameter("content"));
		gb.setFile1(multi.getFilesystemName("file1"));
		gb.setBoardid(boardid);
		System.out.println(gb);
		
		GmBoardDAO dao = new GmBoardDAO();
		int num = dao.insertBoard(gb);
		String msg = "게시물 등록 성공";
		String url = "gmBoardList?boardid="+boardid;
		if(num == 0) {
			msg="게시물 등록 실패";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/view/alert.jsp";
	}
	
	@RequestMapping("gmBoardList")
	public String gmBoardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GmBoardDAO dao = new GmBoardDAO();
		String boardid = request.getParameter("boardid");
		session.setAttribute("boardid", boardid);
		if(session.getAttribute("boardid")==null) boardid="1";
		
		String pageNum = request.getParameter("pageNum");
		session.setAttribute("pageNum", pageNum);
		if(session.getAttribute("pageNum")==null) pageNum="1";
		
		String boardName = "";
		switch (boardid) {
		case "1":
			boardName = "공지사항";
			break;
		case "2":
			boardName = "자유게시판";
			break;
		case "3":
			boardName = "Q&A";
			break;
		default:
			boardName = "공지사항";
		}
		session.setAttribute("boardName", boardName);
		int count = dao.boardCount(boardid);
		int limit = 3;
		int pageInt = Integer.parseInt(pageNum);
		int boardNum = count - ((pageInt-1)*limit); //page의 번호(ser) 계산
		// 각 페이지 당 맨 상단 게시글 번호
		
		int bottomLine = 3;
		int start = (pageInt - 1) / bottomLine * bottomLine + 1;
		int end = start + limit -1;
		int maxPage = (count /limit) + (count % limit == 0 ? 0 : 1); 
		if(end > maxPage) {
			end = maxPage; 
		}
		
		List<GmBoard> li = dao.gmBoardList(boardid, pageInt, limit);
		
		request.setAttribute("bottomLine", bottomLine);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("pageInt", pageInt);
		request.setAttribute("boardNum", boardNum);
		
		request.setAttribute("boardName", boardName);
		request.setAttribute("li", li);
		request.setAttribute("boardid", boardid);
		request.setAttribute("nav", boardid);
		request.setAttribute("count", count);
		
		System.out.println(li);
		
		return "/view/board/gmBoardList.jsp";
	}
	
	@RequestMapping("gmBoardInfo")
	public String gmBoardInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8090/gmModel2/gmBoard/gmBoardInfo?num=10
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		GmBoardDAO dao = new GmBoardDAO();
		int count = dao.addReadCount(num);
		GmBoard board = dao.getBoard(num);
		
		request.setAttribute("board", board);
		return "/view/board/gmBoardInfo.jsp";
	}
	
	@RequestMapping("gmBoardUpdForm")
	public String gmBoardUpdForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		GmBoardDAO dao = new GmBoardDAO();
		GmBoard board = dao.getBoard(num);
		
		request.setAttribute("board", board);
		
		return "/view/board/gmBoardUpdForm.jsp";
	}
	
	@RequestMapping("gmBoardUpdPro")
	public String gmBoardUpdPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getServletContext().getRealPath("/") + "storage/board/";
		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");
		
		int num = Integer.parseInt(multi.getParameter("num"));
		String pass = multi.getParameter("pass");
		System.out.println(num);
		GmBoardDAO dao = new GmBoardDAO();
		GmBoard board = new GmBoard();
		GmBoard boarddb = dao.getBoard(num);
		board.setNum(num);
		board.setName(multi.getParameter("name"));
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		
		if(multi.getFilesystemName("file1") == null) {
			board.setFile1(multi.getParameter("originfile"));
		} else {
			board.setFile1(multi.getFilesystemName("file1"));
		}
		
		String msg = "수정 할 수 없습니다";
		String url = "gmBoardUpdForm?num=" + num;
		
		if(boarddb != null) {
			if(pass.equals(boarddb.getPass())) {
				int count = dao.updateBoard(board);
				if(count == 1) {
					msg = "수정 하였습니다";
					dao.updateBoard(board);
					url = "gmBoardInfo?num=" + num;
				}
			} else {
				msg = "비밀번호가 틀렸습니다";
			}
		} else {
			msg = "게시물이 없습니다";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}
	
	
	@RequestMapping("gmBoardDelForm")
	public String gmBoardDelForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * int num = Integer.parseInt(request.getParameter("num"));
		 * System.out.println(num); 
		 * GmBoardDAO dao = new GmBoardDAO(); 
		 * GmBoard board = dao.getBoard(num);
		 * 
		 * request.setAttribute("board", board);
		 */
		
		request.setAttribute("num", request.getParameter("num"));
		return "/view/board/gmBoardDelForm.jsp";
	}
	
	@RequestMapping("gmBoardDelPro")
	public String gmBoardDelPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		String boardid = (String) session.getAttribute("boardid");
		GmBoardDAO dao = new GmBoardDAO();
		GmBoard boarddb = dao.getBoard(num);
		String msg = "삭제 되지 않았습니다";
		String url = "gmBoardDelForm?num=" + num;
		
		if (boarddb != null) {
			if(pass.equals(boarddb.getPass())) {
				int count = dao.deleteBoard(num);
				if(count == 1) {
					msg = "삭제 되었습니다";
					url = "gmBoardList?boardid=" + boardid;
				}
			} else {
				msg = "비밀번호를 확인 하세요";
			}
		} else {
			msg = "게시물이 없습니다";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/view/alert.jsp";
	}
	
	
	
	
	
	
	

}
