package basket.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import basket.model.dao.BasketDao;

public class BasketService {

	// 스낵 장바구니
	public int InsertBasket(int bCode, int skCode) {
		Connection conn = getConnection();
		int result = new BasketDao().InsertBasket(conn,bCode,skCode);
		return 0;
	}



}
