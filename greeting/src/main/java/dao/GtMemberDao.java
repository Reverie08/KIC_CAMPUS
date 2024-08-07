package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.GtMember;

public class GtMemberDao {
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
	
	public GtMember getMember(String id) {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		String sql = 
		"select * from gt_member where id = ?";
		//4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				GtMember m = new GtMember();
				//id 있음
				m.setUserid(rs.getString("userid"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getInt("gender"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setBirth(rs.getString("birth"));
				m.setAddress(rs.getString("address"));
				
				
			return m;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			return null;
		}
		
		
	public int insertMember(GtMember gt) {
		Connection conn = getConnection();
		//3. PreparedStatement
		PreparedStatement pstmt=null;
		String sql = 
		"insert into gt_member values (?,?,?,?,?,?,?,?)";
		//4. mapping
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gt.getUserid());
			pstmt.setString(2, gt.getPw());
			pstmt.setString(3, gt.getName());
			pstmt.setInt(4, gt.getGender());
			pstmt.setString(5, gt.getPhone());
			pstmt.setString(6, gt.getEmail());
			pstmt.setString(7, gt.getBirth());
			pstmt.setString(8, gt.getAddress());
			//sql 실행
			int num = pstmt.executeUpdate();
			
			return num;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
}
