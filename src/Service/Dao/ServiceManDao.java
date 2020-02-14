package Service.Dao;

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

import Member.Dao.MemberManDao;
import Member.model.vo.Member;
import Service.model.Service;

public class ServiceManDao {
	private Properties prop = new Properties();
	public ServiceManDao() {
		String fileName = MemberManDao.class.getResource("/sql/service/serviceman-query.properties").getPath();
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

		String sql = prop.getProperty("getListCount");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	public ArrayList<Service> selectList(Connection conn, int currentPage, int boardLimit) {
		ArrayList<Service> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (currentPage - 1) * boardLimit + 1;
			int endRow = startRow + boardLimit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Service(
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
	public Service selectService(Connection conn, String snum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Service ser = null;
		String query = prop.getProperty("selectSv");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, snum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				ser = new Service(rset.getString(1),
								rset.getString(2),
								rset.getString(3),
								rset.getString(4),
								rset.getString(5),
								rset.getDate(6),
								rset.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ser;
	}
	public int answerSv(Connection conn, String sid, String answer) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("answerSv");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, answer);
			pstmt.setString(2, sid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int answerSvchange(Connection conn, String sid) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("answerSts");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}



}
