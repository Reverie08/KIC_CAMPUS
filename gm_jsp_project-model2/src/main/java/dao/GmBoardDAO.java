package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GmBoard;

public class GmBoardDAO {
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kic24", "1234");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertBoard(GmBoard board) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into gmboard values (gmboardseq.nextval,?,?,?,?,?,sysdate,0,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getPass());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getFile1());
			pstmt.setString(6, board.getBoardid());

			int num = pstmt.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public List<GmBoard> gmBoardList(String boardid, int pageInt, int limit) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from ("
				+ " select rownum rnum, a.* from ("
				+ " select * from gmboard where boardid = ? "
				+ " order by num desc) a) "
				+ " where rnum between ? and ?";
		List<GmBoard> li = new ArrayList<GmBoard>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardid);
			pstmt.setInt(2, (pageInt-1)*limit+1);
			pstmt.setInt(3, pageInt*limit);
			/* pstmt.setInt(3, (pageInt-1)*limit+1+limit-1); */
			//pageInt*limit-limit+limit+1-1 --> pageInt*limit
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				GmBoard b = new GmBoard();
				b.setNum(rs.getInt("num"));
				b.setPass(rs.getString("pass"));
				b.setName(rs.getString("name"));
				b.setSubject(rs.getString("subject"));
				b.setContent(rs.getString("content"));
				b.setFile1(rs.getString("file1"));
				b.setRegdate(rs.getTimestamp("regdate"));
				b.setReadcnt(rs.getInt("readcnt"));
				b.setBoardid(rs.getString("boardid"));
				li.add(b);
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int boardCount(String boardid) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select nvl(count(*), 0) from gmboard where boardid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public GmBoard getBoard(int num) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from gmboard where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				GmBoard board = new GmBoard();
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setPass(rs.getString("pass"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setFile1(rs.getString("file1"));
				board.setReadcnt(rs.getInt("readcnt"));

				return board;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int addReadCount(int num) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update gmboard set readcnt = readcnt + 1 where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int updateBoard(GmBoard board) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update gmboard set name=?, subject=?, content=?, file1=? where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFile1());
			pstmt.setInt(5, board.getNum());
			
			int num = pstmt.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return 0;
	}
	
	public int deleteBoard(int num) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from gmboard where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int count = pstmt.executeUpdate();
			
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
