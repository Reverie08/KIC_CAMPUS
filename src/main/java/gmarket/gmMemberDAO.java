package gmarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class gmMemberDAO {
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
	public gmMember getMember(String id) {
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
				gmMember gm = new gmMember();
				// ID 있음
				gm.setId(rs.getString("id"));
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
	public int insertMember(gmMember gm) {
		Connection conn = getConnection();
		
		// 3. PreparedStatement
		PreparedStatement pstmt = null;

		String sql = 
		"insert into gmmember values (?, ?, ?, ?, ?)";

		// 4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gm.getId());
			pstmt.setString(2, gm.getPass());
			pstmt.setString(3, gm.getName());
			pstmt.setString(4, gm.getTel());
			pstmt.setString(5, gm.getEmail());
			
			// sql 실행
			int num = pstmt.executeUpdate();
			return num;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMember(gmMember gm) {
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
	
}
