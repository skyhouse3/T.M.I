package Member.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import Board.model.Boardman;
import Board.model.Reply;
import Member.Dao.MemberManDao;
import Member.model.vo.BoReport;
import Member.model.vo.Member;
import Member.model.vo.RpReport;
import basket.model.vo.ticket;

public class MemberService {

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new MemberManDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public static ArrayList<Member> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();

		ArrayList<Member> list = new MemberManDao().selectList(conn, currentPage, boardLimit);

		close(conn);

		return list;
	}

	public int fdayMem(String mid) {
		Connection conn = getConnection();
		int result = new MemberManDao().fdayMem(conn,mid);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int cpunish(String mid) {
		Connection conn = getConnection();
		int result = new MemberManDao().cpunish(conn,mid);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int adayMem(String mid) {
		Connection conn = getConnection();
		int result = new MemberManDao().adayMem(conn,mid);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Boardman> getboard(String mnum) {
		Connection conn = getConnection();
		ArrayList<Boardman> list = new MemberManDao().getboard(conn,mnum);
		close(conn);
		return list;
	}

	public ArrayList<Reply> getreply(String mnum) {
		Connection conn = getConnection();
		ArrayList<Reply> list = new MemberManDao().getReply(conn,mnum);
		close(conn);
		return list;
	}

	public ArrayList<ticket> getticket(String mnum) {
		Connection conn = getConnection();
		ArrayList<ticket> list = new MemberManDao().getticket(conn,mnum);
		close(conn);
		return list;
	}

	public static ArrayList<RpReport> selectRlist() {
		Connection conn = getConnection();
		ArrayList<RpReport> list = new MemberManDao().selectRlist(conn);
		close(conn);
		return list;
	}

	public static ArrayList<BoReport> selectBlist() {
		Connection conn = getConnection();
		ArrayList<BoReport> list = new MemberManDao().selectBlist(conn);
		close(conn);
		return list;
	}

	public int mvpc(String mid, String set) {
		Connection conn = getConnection();
		int result = new MemberManDao().mvpc(conn,mid,set);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}


}
