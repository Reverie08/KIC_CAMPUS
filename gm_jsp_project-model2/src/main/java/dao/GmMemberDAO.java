package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GmMember;


public class GmMemberDAO {
// DAO(Data Access Object) 
	
	public Connection getConnection() {
		// 1. driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kic24", "1234");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // 2. connection 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public GmMember getMember(String id) {
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;

		String sql = 
		"select * from gmmember where id = ?";

		// 4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				GmMember gm = new GmMember();
				// ID 있음
				gm.setId(rs.getString("id"));
				gm.setTrader(rs.getInt("trader"));
				gm.setPass(rs.getString("pass"));
				gm.setName(rs.getString("name"));
				gm.setTel(rs.getString("tel"));
				gm.setEmail(rs.getString("email"));
				
				return gm;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int insertMember(GmMember gm) {
		Connection conn = getConnection();
		
		// 3. PreparedStatement
		PreparedStatement pstmt = null;

		String sql = 
		"insert into gmmember values (?, ?, ?, ?, ?, ?)";

		// 4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gm.getId());
			pstmt.setInt(2, gm.getTrader());
			pstmt.setString(3, gm.getPass());
			pstmt.setString(4, gm.getName());
			pstmt.setString(5, gm.getTel());
			pstmt.setString(6, gm.getEmail());
			
			// sql 실행
			int num = pstmt.executeUpdate();
			return num;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMember(GmMember gm) {
		Connection conn = getConnection();
		
		// 3. PreparedStatement
		PreparedStatement pstmt = null;
		
		String sql = 
				"update gmmember set pass=?, name=?, tel=?, email=? where id=?";
		
		// 4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gm.getPass());
			pstmt.setString(2, gm.getName());
			pstmt.setString(3, gm.getTel());
			pstmt.setString(4, gm.getEmail());
			pstmt.setString(5, gm.getId());
			// sql 실행
			int num = pstmt.executeUpdate();
			return num;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteMember(String id) {
		Connection conn = getConnection();
		// 3. PreparedStatement
		PreparedStatement pstmt = null;
		String sql = 
				"delete from gmmember where id=?";
		
		// 4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// sql 실행
			int num = pstmt.executeUpdate();
			return num;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	
	public int chgPassMember(String id, String chgpass) {
		Connection conn = getConnection();
		// 3. PreparedStatement
		PreparedStatement pstmt = null;
		
		String sql = 
				"update gmmember set pass=? where id=?";
		
		// 4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chgpass);
			pstmt.setString(2, id);
			
			// sql 실행
			int num = pstmt.executeUpdate();
			return num;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<GmMember> gmMemberList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from gmMember";
		List<GmMember> li = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				GmMember gm = new GmMember();
				gm.setId(rs.getString("id"));
				gm.setTrader(rs.getInt("trader"));
				gm.setPass(rs.getString("pass"));
				gm.setName(rs.getString("name"));
				gm.setTel(rs.getString("tel"));
				gm.setEmail(rs.getString("email"));
				li.add(gm);
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
