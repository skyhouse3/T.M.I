package Board.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import Board.Dao.boardmanDao;
import Board.model.Boardman;
import Board.model.Reply;

public class BoardmanService {

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new boardmanDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Boardman> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<Boardman> list = new boardmanDao().selectList(conn, currentPage, boardLimit);
		close(conn);
		return list;
	}

	public Boardman selectBoard(String bnum) {
		Connection conn = getConnection();
		boardmanDao bdo = new boardmanDao();
		Boardman b = bdo.selectBoard(conn,bnum);
		close(conn);
		return b;
	}

	public int deleteb(String bid) {
		Connection conn = getConnection();
		boardmanDao bdo = new boardmanDao();
		int result = bdo.deleteb(conn,bid);
		close(conn);
		return result;
	}

	public ArrayList<Reply> selectReplyList(String bnum) {
		Connection conn = getConnection();
		ArrayList<Reply> rlist = new boardmanDao().selectReplyList(conn, bnum);
		close(conn);
		return rlist;
	}

	public int deleter(String rid) {
		Connection conn = getConnection();
		boardmanDao bdo = new boardmanDao();
		int result = bdo.deleter(conn,rid);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertbo(Boardman board) {
		Connection conn = getConnection();
		boardmanDao bdo = new boardmanDao();
		int result = bdo.insertb(conn,board);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updatebo(String content, String bid) {
		Connection conn = getConnection();
		boardmanDao bdo = new boardmanDao();
		int result = bdo.updateb(conn,content,bid);
		System.out.println(result+"어케됨");
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertReply(String rnum, String mcode, String rcontent, String rwriter) {
		Connection conn = getConnection();
		boardmanDao bdo = new boardmanDao();
		int result = bdo.insertReply(conn,rnum,mcode,rcontent,rwriter);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;

	}





}
