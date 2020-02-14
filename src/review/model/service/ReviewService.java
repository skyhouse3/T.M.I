package review.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import review.model.dao.ReviewDao;
import review.model.vo.Reply;
import review.model.vo.Review;

public class ReviewService {
	
	// 0. 게시판 리스트 갯수 조회용 서비스
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new ReviewDao().getListCount(conn);
		close(conn);
		return listCount;
	}
	
	// 1. 리뷰게시판 조회용 서비스
	public ArrayList<Review> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<Review> list = new ReviewDao().selectList(conn, currentPage, boardLimit);
		close(conn);
		return list;
	}
	
	// 2. 리뷰 글 작성용 서비스
	public int insertReview(Review r) {
		Connection conn = getConnection();

		int result = new ReviewDao().insertReview(conn, r);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 3. 리뷰 상세보기 서비스
	public Review selectReview(String rnum) {
		Connection conn = getConnection();

		Review r = new ReviewDao().selectReview(conn, rnum);
		
		close(conn);

		return r;
	}
	
	// 게시글 선택해오기
	public Review selectBoardNoCnt(String rnum) {
		Connection conn = getConnection();

		//ReviewDao bDao = new ReviewDao();
		
		Review r = new ReviewDao().selectReview(conn, rnum);
		
		//Review r = null;
		
		close(conn);

		return r;
	}

	// 4. 리뷰 수정용 서비스
	public int updateReview(Review review) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().updateBoard(conn, review);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// 5. 공지사항 삭제용 서비스
	public int deleteReview(String bid) {
		Connection conn = getConnection();

		int result = new ReviewDao().deleteReview(conn, bid);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	// 댓글 추가 후 새로 갱신 된 댓글 리스트 조회용 서비스
		public ArrayList<Reply> insertReply(Reply r) {
			Connection conn = getConnection();
			
			ReviewDao bDao = new ReviewDao();
			
			int result = bDao.insertReply(conn, r);
			
			ArrayList<Reply> rlist = null;
			
			if(result > 0) {
				commit(conn);
				rlist = bDao.selectReplyList(conn, r.getRid());
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return rlist;
		}

	// 선택한 게시글의 댓글 리스트 조회용 서비스
	public ArrayList<Reply> selectReplyList(String rnum) {
		Connection conn = getConnection();
		
		ArrayList<Reply> rlist = new ReviewDao().selectReplyList(conn, rnum);
		
		close(conn);
		
		return rlist;
	}

	public int reportReply(String rid, String mem) {
		Connection conn = getConnection();
		int result = new ReviewDao().reportReply(conn,rid,mem);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int reportBo(String bid, String mem) {
		Connection conn = getConnection();
		int result = new ReviewDao().reportBo(conn,bid,mem);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
