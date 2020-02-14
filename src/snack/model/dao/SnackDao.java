package snack.model.dao;

import static common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import basket.model.vo.SkBasket;
import review.model.vo.Review;
import snack.model.vo.Snack;

public class SnackDao {

private Properties prop = new Properties();
	
	public SnackDao() {
		String fileName = SnackDao.class.getResource("/sql/snack/snack-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		// 1. 스낵스토어 조회용 dao
		public ArrayList<Snack> selectList(Connection conn, String Ccode ,String kinds ) {
			ArrayList<Snack> snList = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectsnList");
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, Ccode);
				pstmt.setString(2, kinds);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					
					snList.add(new Snack(rset.getString("Ccode"),
										rset.getString("skCode"),
										rset.getString("skName"),
										rset.getString("Price"),
										rset.getString("skcontent"),
										rset.getString("picture")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			System.out.println(snList);
			return snList;
			
		}

		// 2. 스낵스토어 상세보기 dao
		public ArrayList<Snack> selectDetail(Connection conn, String skCode) {
			ArrayList<Snack> DeList = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectDeList");
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, skCode);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					DeList.add(new Snack(
										rset.getString("Ccode"),
										rset.getString("skCode"),
										rset.getString("skName"),
										rset.getString("Price"),
										rset.getString("skcontent"),
										rset.getString("picture"),
										rset.getString("kinds")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return DeList;
			
		}

		// 3. 장바구니 담기 dao
		public int insertskBasket(Connection conn, SkBasket skB) {
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertskBasket");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, skB.getSkCode());
				pstmt.setInt(2, skB.getSkQuantity());
				pstmt.setString(3, skB.getUser_Id());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
	
		}

	

	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
