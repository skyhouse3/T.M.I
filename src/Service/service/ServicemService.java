package Service.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;


import Service.Dao.ServiceManDao;
import Service.model.Service;


public class ServicemService {

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new ServiceManDao().getListCount(conn);
		close(conn);
		return listCount;
	}
	public static ArrayList<Service> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();

		ArrayList<Service> list = new ServiceManDao().selectList(conn, currentPage, boardLimit);

		close(conn);

		return list;
	}
	public Service selectService(String snum) {
		Connection conn = getConnection();
		ServiceManDao sdo = new ServiceManDao();
		Service ser = sdo.selectService(conn,snum);
		close(conn);
		return ser;
	}
	public int answerSv(String sid, String answer) {
		Connection conn = getConnection();
		System.out.println(sid + answer);
		int result = 0;
		int result2 = 0;
		result = new ServiceManDao().answerSv(conn,sid,answer);
		result2 = new ServiceManDao().answerSvchange(conn,sid);
		System.out.println(result+" "+result2);
		if(result == result2) {
			if(result >0) {
				commit(conn);
			}
		}
		close(conn);
		
		return result;
	}

}
