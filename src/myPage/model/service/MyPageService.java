package myPage.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import joinPage.model.vo.Join;
import myPage.model.dao.MyPageDao;
import myPage.model.vo.MyPage;


public class MyPageService {
	
		//1. 예매확인용 서비스
		public  MyPage selledList() {
			return null;
		}
		//2. 예매취소용 서비스
		public MyPage dropTicket() {
			return null;
		}	
		//3. 장바구니 확인용 서비스
		public MyPage BasketList() {
			return null;	
		}
		// 4. 장바구니 취소용 서비스
		public MyPage DropBasket() {
			return null;	
		}	
		// 5. 회원 정보 수정용 서비스
		public Join updateMember(Join j) {
			Connection conn = getConnection();
			Join updateMem = null;
			
			int result = new MyPageDao().updateMember(conn, j);
			
			if(result > 0) {
				updateMem = new MyPageDao().selectMember(conn, j.getUser_Id());
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return updateMem;
		}
		// 6. 비밀번호 변경용 서비스
		public Join updatePwd(String UserId, String Userpw, String newPw) {
			Connection conn = getConnection();
			
			int result = new MyPageDao().updatePwd(conn, UserId, Userpw, newPw);
			
			Join updateMember = null;
			
			
			if(result > 0) {
				updateMember = new MyPageDao().selectMember(conn, UserId);
				
				commit(conn);
				
			} else {
				
				rollback(conn);
			}
			
			close(conn);
			
			return updateMember;
		}
		// 7. 회원 탈퇴용 서비스
		public int deleteMember(String user_Id) {
			Connection conn = getConnection();
			
			int result = new MyPageDao().deleteMember(conn, user_Id);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
		// 8. 회원 등급확인용 서비스
		public MyPage MemberGrade() {
			return null;
			
		}
		
	
}
