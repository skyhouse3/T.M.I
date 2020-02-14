package question.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import Qna.model.Qna;
import Service.model.Service;
import question.model.dao.QuestionDao;
import question.model.vo.Question;

public class QuestionService {
	
			// 0. 게시판 리스트 갯수 조회용 서비스
			public int getListCount() {
			Connection conn = getConnection();
			int listCount = new QuestionDao().getListCount(conn);
			close(conn);
			return listCount;
			}
	
			// 1. 문의 리스트 조회용 dao
			public ArrayList<Service> selectList(int currentPage, int boardLimit) {
				Connection conn = getConnection();
				ArrayList<Service> list = new QuestionDao().selectList(conn, currentPage, boardLimit);
				close(conn);
				return list;
			}


			// 3. 문의 상세보기 dao
			public Service selectFaq(String sNum) {
				Connection conn = getConnection();
				System.out.println(sNum);
				Service q = new QuestionDao().selectQuestion(conn, sNum);
				
				close(conn);

				return q;
			}
			// 5. 문의 삭제용 dao
			public int deleteFaq(String bid) {
				Connection conn = getConnection();
				int result = new QuestionDao().deleteQuestion(conn, bid);
				if (result > 0) {
					commit(conn);
				} else {
					rollback(conn);
				}
				close(conn);
				return result;
			}

			public Service updateFaq(String sNum, String content) {
				Connection conn = getConnection();
				int result = new QuestionDao().updateQuestion(conn,sNum,content);
				Service q = new QuestionDao().selectQuestion(conn, sNum);
				if(result != 0) {
					commit(conn);
					System.out.println("수정성공");
				}else {
					rollback(conn);
				}
				close(conn);
				
				return q;
			}

			public int insertFaq(String title, String userid, String content) {
				Connection conn = getConnection();
				int result = new QuestionDao().insertQuestion(conn,title,userid,content);
				if(result != 0) {
					commit(conn);
					System.out.println("입력성공");
				}else {
					rollback(conn);
				}
				close(conn);
				
				return result;
			}

			public int insertOvo(String title, String mem, String cate, String content) {
				Connection conn = getConnection();
				int result = new QuestionDao().insertOvo(conn,title,mem,cate,content);
				if(result != 0) {
					commit(conn);
					System.out.println("입력성공");
				}else {
					rollback(conn);
				}
				close(conn);
				return result;
			}

			public Qna selectOvo(String mem) {
				Connection conn = getConnection();
				Qna result = new QuestionDao().selectOvo(conn,mem);
				close(conn);
				return result;
			}

			public int updateOvo(String title, String mem, String cate, String content) {
				Connection conn = getConnection();
				int result = new QuestionDao().updateOvo(conn,title,mem,cate,content);
				if(result != 0) {
					commit(conn);
					System.out.println("변경성공");
				}else {
					rollback(conn);
				}
				close(conn);
				return result;
			}
			
}
