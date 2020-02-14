package Qna.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import Qna.dao.QnamanDao;
import Qna.model.Qna;

public class QnaService {

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new QnamanDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public static ArrayList<Qna> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();

		ArrayList<Qna> list = new QnamanDao().selectList(conn, currentPage, boardLimit);

		close(conn);

		return list;
	}

	public Qna selectQna(String qnum) {
		Connection conn = getConnection();
		QnamanDao qdo = new QnamanDao();
		Qna q = qdo.selectQna(conn,qnum);
		close(conn);
		return q;
	}

	public int answerQna(String qid,String qanswer) {
		Connection conn = getConnection();
		int result = 0;
		int result2 = 0;
		result = new QnamanDao().answerQna(conn,qid,qanswer);
		result2 = new QnamanDao().answerQnachange(conn,qid);
		if(result == result2) {
			if(result >0) {
				commit(conn);
			}
		}
		close(conn);
		
		return result;
	}

}
