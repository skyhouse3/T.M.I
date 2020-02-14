package moneyManage.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import moneyManage.dao.Moneydao;
import moneyManage.model.conRate;
import moneyManage.model.conRateDetail;
import moneyManage.model.movRate;
import moneyManage.model.paydate;
import moneyManage.model.paydatedetail;

public class MoneyService {

	
	public ArrayList<paydate> paycategory() {
		Connection conn = getConnection();
		Moneydao mdo = new Moneydao();
		ArrayList<paydate> payment = mdo.paycategory(conn);
		close(conn);
		return payment;
	}

	public ArrayList<movRate> movcategory() {
		Connection conn = getConnection();
		Moneydao mdo = new Moneydao();
		ArrayList<movRate> mr = mdo.movcategory(conn);
		close(conn);
		return mr;
	}

	public ArrayList<conRate> concategory() {
		Connection conn = getConnection();
		Moneydao mdo = new Moneydao();
		ArrayList<conRate> cr = mdo.concategory(conn);
		close(conn);
		return cr;
	}

	public ArrayList<conRate> concategorydetail(String cate) {
		Connection conn = getConnection();
		Moneydao mdo = new Moneydao();
		ArrayList<conRate> list = mdo.conRateDetail(conn,cate);
		close(conn);
		System.out.println(list);
		return list;
	}

	public ArrayList<conRateDetail> concateddetail() {
		Connection conn = getConnection();
		Moneydao mdo = new Moneydao();
		ArrayList<conRateDetail> list = mdo.conRatedDetail(conn);
		close(conn);
		return list;
	}

	public ArrayList<paydatedetail> getpdetail(String cate) {
		Connection conn = getConnection();
		Moneydao mdo = new Moneydao();
		ArrayList<paydatedetail> list = mdo.paydatedetail(conn,cate);
		close(conn);
		return list;
	}

}
