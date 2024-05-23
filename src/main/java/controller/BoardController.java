package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KicBoardDAO;
import dao.KicMemberDAO;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.KicBoard;
import model.KicMember;

@WebServlet("/board/*")
public class BoardController extends MskimRequestMapping {

	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/view/index.jsp";
	}

	@RequestMapping("boardForm")
	public String boardForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/view/board/boardForm.jsp";
	}

	@RequestMapping("boardPro")
	public String boardPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		KicBoard kicboard = new KicBoard();
		kicboard.setName(request.getParameter("name"));
		kicboard.setPass(request.getParameter("pass"));
		kicboard.setSubject(request.getParameter("subject"));
		kicboard.setContent(request.getParameter("content"));
		kicboard.setFile1("");
		System.out.println(kicboard);
		KicBoardDAO dao = new KicBoardDAO();
		int num = dao.insertBoard(kicboard);
		String msg = "게시물 등록 성공";
		String url = "boardList";
		if (num == 0) {
			msg = "게시글 등록 실패";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/view/alert.jsp";
	}

	@RequestMapping("boardList")
	public String boardList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KicBoardDAO dao = new KicBoardDAO();
		List<KicBoard> li = dao.BoardList();
		request.setAttribute("li", li);
		return "/view/board/boardList.jsp";
	}

	@RequestMapping("boardInfo")
	public String boardInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/kicmodel2/board/boardInfo?num=10
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		KicBoardDAO dao = new KicBoardDAO();
		KicBoard board = dao.getBoard(num);

		request.setAttribute("board", board);
		return "/view/board/boardInfo.jsp";
	}

	@RequestMapping("boardUpdateForm")
	public String boardUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/kicmodel2/board/boardInfo?num=10
		// url은 controller로 간다

		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		KicBoardDAO dao = new KicBoardDAO();
		KicBoard board = dao.getBoard(num);

		request.setAttribute("board", board);

		return "/view/board/boardUpdateForm.jsp";
	}

	@RequestMapping("boardUpdatePro")
	public String boardUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/kicmodel2/board/boardInfo?num=10
		// url은 controller로 간다
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		System.out.println(num);
		KicBoardDAO dao = new KicBoardDAO();
		KicBoard board = new KicBoard();
		KicBoard boarddb = dao.getBoard(num);
		board.setNum(num);
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setFile1(request.getParameter("file1"));
		String msg = "수정 할 수 없습니다";
		String url = "boardUpdateForm?num=" + num;

		if (boarddb != null) {
			if (pass.equals(boarddb.getPass())) {
				int count = dao.updateBoard(board);
				if (count == 1) {
					msg = "수정 하였습니다";
					dao.updateBoard(board);
					url = "boardInfo?num=" + num;
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
	
	
	@RequestMapping("boardDeleteForm")
	public String boardDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/kicmodel2/board/boardInfo?num=10
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		KicBoardDAO dao = new KicBoardDAO();
		KicBoard board = dao.getBoard(num);

		request.setAttribute("board", board);
		return "/view/board/boardDeleteForm.jsp";
	}
	
	@RequestMapping("boardDeletePro")
	public String boardDeletePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("num");
		KicBoardDAO dao = new KicBoardDAO();
		KicBoard board = new KicBoard();
		KicBoard boarddb = dao.getBoard(num);
		String msg="삭제 되지 않았습니다";
		String url = "boardUpdateForm?num=" + num;
		
		if (boarddb != null) {
			if (pass.equals(boarddb.getPass())) {
				int count = dao.deleteBoard(board);
				if (count == 1) {
					msg = "삭제 되었습니다";
					dao.deleteBoard(board); 
					url = "boardList";
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
