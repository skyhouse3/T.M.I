package snack.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import basket.model.vo.SkBasket;
import review.model.vo.Review;
import snack.model.dao.SnackDao;
import snack.model.vo.Snack;

public class SnackService {
	
	// 1. 스낵스토어 조회용 서비스
	public ArrayList<Snack> selectList(String Ccode, String kinds) {
		Connection conn = getConnection();
		ArrayList<Snack> snList = new SnackDao().selectList(conn,Ccode,kinds);
		
		close(conn);

		
		return snList;
	}

	// 2. 스낵스토어 상세보기 서비스
	public ArrayList<Snack> selectDetail(String skCode) {
		Connection conn = getConnection();
		ArrayList<Snack> DeList = new SnackDao().selectDetail(conn,skCode);
		
		close(conn);
		return DeList;
	}

	public int insertskBasket(SkBasket skB) {
		
		Connection conn = getConnection();
		int result = new SnackDao().insertskBasket(conn, skB);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	
	

	

}
