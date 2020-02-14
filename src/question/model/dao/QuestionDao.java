package question.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import Qna.model.Qna;
import Service.model.Service;
import question.model.vo.Question;

import static common.JDBCTemplate.*;

public class QuestionDao {
	private Properties prop = new Properties();

	public QuestionDao() {
		String fileName = QuestionDao.class.getResource("/sql/question/question-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 0. 게시판 리스트 갯수 조회용 dao
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

		// 1. 문의 리스트 조회용 dao
		public ArrayList<Service> selectList(Connection conn, int currentPage, int boardLimit) {
			ArrayList<Service> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectQna");
			
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
		// 3. 문의 상세보기 dao
		public Service selectQuestion(Connection conn, String sNum) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Service ser = null;
			String query = prop.getProperty("selectSv");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, sNum);
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

		public int deleteQuestion(Connection conn, String bid) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("deleteQuestion");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, bid);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

		public int updateQuestion(Connection conn, String sNum, String content) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("updateQuestion");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, content);
				pstmt.setString(2, sNum);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			System.out.println(result);
			return result;
		}

		public int insertQuestion(Connection conn, String title, String userid, String content) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("insertQuestion");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userid);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				
				result = pstmt.executeUpdate();
				System.out.println(content);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

		public int insertOvo(Connection conn, String title, String mem, String cate, String content) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("insertOvo");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, mem);
				pstmt.setString(2, cate);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

		public Qna selectOvo(Connection conn, String mem) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Qna q = null;
			String query = prop.getProperty("selectOvo");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,mem);
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

		public int updateOvo(Connection conn, String title, String mem, String cate, String content) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query = prop.getProperty("updateOvo");
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, mem);
				pstmt.setString(2, cate);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				pstmt.setString(5, mem);
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
