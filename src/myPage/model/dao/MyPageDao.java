package myPage.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import joinPage.model.dao.JoinDao;
import joinPage.model.vo.Join;
import myPage.model.vo.MyPage;

import static common.JDBCTemplate.*;

public class MyPageDao {
	private Properties prop = new Properties();

	public MyPageDao() {
		String fileName = MyPageDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 1. 예매확인용 dao
	public MyPage selledList() {
		return null;
	}

	// 2. 예매취소용 dao
	public MyPage dropTicket() {
		return null;
	}

	// 3. 장바구니 확인용 dao
	public MyPage BasketList() {
		return null;
	}

	// 4. 장바구니 취소용 dao
	public MyPage DropBasket() {
		return null;
	}

	// 5. 회원 정보 수정용 dao
	public int updateMember(Connection conn, Join j) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, j.getUser_name());
			pstmt.setString(2, j.getPhone());
			pstmt.setString(3, j.getEmail());
			pstmt.setString(4, j.getAddress());
			pstmt.setString(5, j.getFavorite());
			pstmt.setString(6, j.getUser_Id());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 6. 비밀번호 변경용 dao
	public int updatePwd(Connection conn, String UserId, String Userpw, String newPw) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updatePw");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, newPw);
			pstmt.setString(2, UserId);
			pstmt.setString(3, Userpw);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 7. 회원 탈퇴용 dao
	public int deleteMember(Connection conn, String user_Id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user_Id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 8. 회원 등급확인용 dao
	public MyPage MemberGrade() {
		return null;
	}

	// 9. 회원 조회용 dao
	public Join selectMember(Connection conn, String UserId) {
		Join jo = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, UserId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				jo = new Join(rset.getString("User_Id"),
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
		
		return jo;
	}

}
