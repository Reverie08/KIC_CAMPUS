package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GmBoard;
import model.GmProduct;

public class GmProductDAO {
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

	public int insertProd(GmProduct prod) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into gmproduct values (gmprodseq.nextval,?,?,?,sysdate,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prod.getProdname());
			pstmt.setInt(2, prod.getPrice());
			pstmt.setString(3, prod.getProdcontent());
			pstmt.setString(4, prod.getCategory());
			pstmt.setString(5, prod.getFile2());

			int num = pstmt.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public List<GmProduct> gmProdList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from gmproduct";
		List<GmProduct> li = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				GmProduct gp = new GmProduct();
				gp.setProdid(rs.getInt("prodid"));
				gp.setProdname(rs.getString("prodname"));
				gp.setPrice(rs.getInt("price"));
				gp.setFile2(rs.getString("file2"));
				/* gp.setProdregdate(rs.getTimestamp("prodregdate")); */
				li.add(gp);
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public GmProduct getProd(int prodid) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from gmproduct where prodid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prodid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				GmProduct prod = new GmProduct();
				prod.setProdid(rs.getInt("prodid"));
				prod.setProdname(rs.getString("prodname"));
				prod.setPrice(rs.getInt("price"));
				prod.setProdcontent(rs.getString("prodcontent"));
				prod.setCategory(rs.getString("category"));
				prod.setFile2(rs.getString("file2"));

				return prod;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateProd(GmProduct prod) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update gmproduct set prodname=?, price=?, prodcontent=?, category=?, file2=? where prodid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prod.getProdname());
			pstmt.setInt(2, prod.getPrice());
			pstmt.setString(3, prod.getProdcontent());
			pstmt.setString(4, prod.getCategory());
			pstmt.setString(5, prod.getFile2());
			pstmt.setInt(6, prod.getProdid());

			int num = pstmt.executeUpdate();

			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteProd(int prodid) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from gmproduct where prodid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prodid);
			
			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
				
	}

}
