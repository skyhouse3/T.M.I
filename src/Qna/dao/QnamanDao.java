package Qna.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import Qna.model.Qna;

public class QnamanDao {
	private Properties prop = new Properties();
	public QnamanDao() {
		String fileName = QnamanDao.class.getResource("/sql/qna/qnaman-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getListCountM");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		
		return 0;
	}

	public ArrayList<Qna> selectList(Connection conn, int currentPage, int boardLimit) {
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListM");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (currentPage - 1)*boardLimit+1;
			int endRow = startRow + boardLimit - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Qna(
						rset.getString(2),
						rset.getString(3),
						rset.getDate(4),
						rset.getString(5)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public Qna selectQna(Connection conn, String qnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna q = null;
		String query = prop.getProperty("selectQnaM");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,qnum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				q = new Qna(rset.getString(1),
						rset.getString(2),
						rset.getString(3),
						rset.getString(4),
						rset.getString(5),
						rset.getString(6),
						rset.getDate(7),
						rset.getString(8)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}
	public int answerQna(Connection conn,String qid, String answer) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("answerQnaM");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, answer);
			pstmt.setString(2, qid);
			result = pstmt.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int answerQnachange(Connection conn, String qid) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("answerStsM");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qid);
			result = pstmt.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
}
