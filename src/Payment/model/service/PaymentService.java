package Payment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import Payment.model.dao.PaymentDao;

import static common.JDBCTemplate.*;

import movie.model.vo.Movie;

public class PaymentService {
	
	public int ticketing(String mem, String mcode, String seat) {
		Connection conn = getConnection();
		
		PaymentDao pDao = new PaymentDao();
		
		int result = pDao.ticketing(conn,mem,mcode,seat);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		String tNum =pDao.fticketing(conn,mem,mcode,seat);
		
		int result2=pDao.mbk(conn,tNum,mem);
		
		
		
		
		
		
		
		
		
		
		
		close(conn);
		
		return result2;
	}

}
