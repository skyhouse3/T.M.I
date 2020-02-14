package review.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import review.model.vo.Reply;
import review.model.vo.Review;

public class ReviewDao {
	private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/review/review-query.properties").getPath();
		
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

	
	// 1. 리뷰 리스트 조회용 dao
	public ArrayList<Review> selectList(Connection conn, int currentPage, int boardLimit) {
		ArrayList<Review> list = new ArrayList<>();
		
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
				list.add(new Review(rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
	

		return list;
	}

	// 2. 리뷰글 작성용 dao
	public int insertReview(Connection conn, Review r) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertReview");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, r.getMcode());
			pstmt.setString(2, r.getRtitle());
			pstmt.setString(3, r.getrWriter());
			pstmt.setString(4, r.getRcontent());
			pstmt.setString(5, r.getRrate());
			pstmt.setString(6, r.getCharmingPoint());
			pstmt.setString(7, r.getDirector_production());
			pstmt.setString(8, r.getOST());
			pstmt.setString(9, r.getAction_acting());
			pstmt.setString(10, r.getStory());
			pstmt.setString(11, r.getMovie_beauty());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}
	
	// 3. 리뷰 조회수 증가용 dao
	public int increaseCount() {
		return 0;
	}

	// 4. 리뷰 상세보기 dao
	public Review selectReview(Connection conn, String rnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = new Review();

		String query = prop.getProperty("selectReview");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, rnum);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				 r.setMcode(rset.getString("mcode")); 
				 r.setRtitle(rset.getString("rtitle")); 
				 r.setrWriter(rset.getString("rWriter"));
				 r.setRcontent(rset.getString("rcontent")); 
				 r.setMrvDate(rset.getDate("mrvDate")); 
				 r.setRnum(rnum); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}

	// 5. 리뷰 수정 dao
	public int updateBoard(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateReview");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, review.getRcontent());
			pstmt.setString(2, review.getRnum());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 6. 공지사항 삭제용 dao
	public int deleteReview(Connection conn, String bid) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteReview");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bid);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	// 댓글 입력 dao
		public int insertReply(Connection conn, Reply r) {
			PreparedStatement pstmt = null;
			
			int result = 0;
			
			String sql = prop.getProperty("insertReply");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, r.getRcontent());
				pstmt.setString(2, r.getRid());
				pstmt.setString(2, r.getRwriter());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

	// 댓글 리스트 셀렉 dao
	public ArrayList<Reply> selectReplyList(Connection conn, String rnum) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Reply> rlist = null;
		
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rnum);
			
			rs = pstmt.executeQuery();
			
			rlist = new ArrayList<Reply>();
			
			while(rs.next()) {
				rlist.add(new Reply(rs.getString("Rid"),
									rs.getString("Rnum"),
									rs.getString("Rcontent"),
									rs.getString("Rwriter"),
									rs.getDate("Create_date"),
									rs.getDate("Modify_date"),
									rs.getString("Status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return rlist;
	}

	public int reportReply(Connection conn, String rid, String mem) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("reportReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem);
			pstmt.setString(2, "reply");
			pstmt.setString(3, rid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int reportBo(Connection conn, String bid, String mem) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("reportBo");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem);
			pstmt.setString(2, "board");
			pstmt.setString(3, bid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
