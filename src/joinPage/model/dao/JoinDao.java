package joinPage.model.dao;
import java.io.*;
import java.sql.*;
import java.util.*;

import joinPage.model.vo.Join;
import static common.JDBCTemplate.*;

public class JoinDao {
	private Properties prop = new Properties();
	
	public JoinDao() {
		String fileName = JoinDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public Join loginMember(Connection conn, String id, String pw) {
	      Join loginUser = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("loginMember");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, id);
	         pstmt.setString(2, pw);
	         
	         rset = pstmt.executeQuery();
	               
	         if(rset.next()) {
	            loginUser = new Join(rset.getString("User_Id"),
	                            rset.getString("User_Pw"),
	                            rset.getString("PW_HINT"),
	                            rset.getString("HINT"),
	                            rset.getString("User_name"),
	                            rset.getString("gender"),
	                            rset.getString("BIRTH"),
	                            rset.getString("PHONE"),
	                            rset.getString("EMAIL"),
	                            rset.getString("ADDRESS"),
	                            rset.getString("FAVORITE"),
	                            rset.getString("MVP"),
	                            rset.getString("BREAKDOWN"),
	                            rset.getString("STATUS"));
	                            
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return loginUser;
	   }
	   // 2. 회원가입용 dao
	   public int insertMember(Connection conn, Join j) {
	      int result = 0;
	      PreparedStatement pstmt = null;
	      String query = prop.getProperty("insertMember");
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         
	         pstmt.setString(1, j.getUser_Id());
	         pstmt.setString(2, j.getUser_pw());
	         pstmt.setString(3, j.getPW_HINT());
	         pstmt.setString(4, j.getHINT());
	         pstmt.setString(5, j.getUser_name());
	         pstmt.setString(6, j.getGender());
	         pstmt.setString(7, j.getBirth());
	         pstmt.setString(8, j.getPhone());
	         pstmt.setString(9, j.getEmail());
	         pstmt.setString(10, j.getAddress());
	         pstmt.setString(11, j.getFavorite());
	         
	         result = pstmt.executeUpdate();
	               
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      return result;
	   }
	   
	// 3. 회원 찾기용 dao
	public Join searchMember() {
		return null;
	}
	
	// 4.아이디중복체크용 dao
	public int idCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("idCheck");
		
		System.out.println(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	// 5. 접속자 수 증가
	public int countUp(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("countup");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public String findpwd(Connection conn, String userId, String pWHINT, String hINT) {
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String pwd = "";
		String sql = prop.getProperty("findpwd");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, hINT);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pwd = rset.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return pwd;
	}
}
