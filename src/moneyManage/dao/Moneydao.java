package moneyManage.dao;

import static common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import moneyManage.model.conRate;
import moneyManage.model.conRateDetail;
import moneyManage.model.movRate;
import moneyManage.model.paydate;
import moneyManage.model.paydatedetail;

public class Moneydao {
	private Properties prop = new Properties();

	public Moneydao() {
		String fileName = Moneydao.class.getResource("/sql/money/moneyman-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<paydate> paycategory(Connection conn) {
		ArrayList<paydate> array = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Calendar first = Calendar.getInstance();
		first.add(Calendar.MONTH, -3);
		Calendar second = Calendar.getInstance();
		second.add(Calendar.MONTH, -6);
		Calendar third = Calendar.getInstance();
		third.add(Calendar.MONTH, -9);
		Calendar four = Calendar.getInstance();
		four.add(Calendar.MONTH, -12);

		String sql = prop.getProperty("payDatecate");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			array = new ArrayList<paydate>();
			while (rset.next()) {
				if (rset.getString(5).equals("N")) {
					Calendar pd = Calendar.getInstance();
					pd.setTime(rset.getDate(4));
					int caldate = pd.compareTo(first);
					if (caldate > 0) {
						array.add(new paydate(rset.getString(1), 1, Integer.parseInt(rset.getString(3))));
					} else {
						caldate = pd.compareTo(second);
						if (caldate > 0) {
							array.add(new paydate(rset.getString(1), 2, Integer.parseInt(rset.getString(3))));
						} else {
							caldate = pd.compareTo(third);
							if (caldate > 0) {
								array.add(new paydate(rset.getString(1), 3, Integer.parseInt(rset.getString(3))));
							} else {
								caldate = pd.compareTo(four);
								if (caldate > 0) {
									array.add(new paydate(rset.getString(1), 4, Integer.parseInt(rset.getString(3))));
								}
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return array;
	}

	public ArrayList<movRate> movcategory(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<movRate> mr = null;
		String sql = prop.getProperty("movcategory");
		mr = new ArrayList<movRate>();
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			 while(rset.next()) {
				mr.add(new movRate(rset.getString(2), rset.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(movRate m : mr) {
			System.out.println(m);
		}
		return mr;
	}

	public ArrayList<conRate> concategory(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<conRate> cr = null;
		Calendar now = Calendar.getInstance();
		String sql = prop.getProperty("concategory");
		cr = new ArrayList<conRate>();
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(rset.getDate(3));
				if (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
					int month = cal.get(Calendar.MONTH);
					cr.add(new conRate(month, 1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cr;
	}

	public ArrayList<conRate> conRateDetail(Connection conn, String cate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("concategory");
		Calendar now = Calendar.getInstance();
		ArrayList<conRate> list = null;
		list = new ArrayList<conRate>();
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			switch (cate) {
			case "y":
				while (rset.next()) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(rset.getDate(3));
					int year = cal.get(Calendar.YEAR);
					list.add(new conRate(year,1));
				}
				break;
			case "m":
				while (rset.next()) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(rset.getDate(3));
					if (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
						int month = cal.get(Calendar.MONTH);
						list.add(new conRate(month, 1));
					}
				}
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	public ArrayList<conRateDetail> conRatedDetail(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("concategory");
		Calendar now = Calendar.getInstance();
		ArrayList<conRateDetail> list = null;
		list = new ArrayList<conRateDetail>();
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(rset.getDate(3));
				if(cal.get(Calendar.YEAR)==now.get(Calendar.YEAR)) {
					list.add(new conRateDetail(
								rset.getString(1),
								rset.getString(2),
								rset.getDate(3)
							));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<paydatedetail> paydatedetail(Connection conn, String cate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Calendar first = Calendar.getInstance();
		first.add(Calendar.MONTH, -3);
		Calendar second = Calendar.getInstance();
		second.add(Calendar.MONTH, -6);
		Calendar third = Calendar.getInstance();
		third.add(Calendar.MONTH, -9);
		Calendar four = Calendar.getInstance();
		four.add(Calendar.MONTH, -12);
		String sql = prop.getProperty("paydetail");
		ArrayList<paydatedetail> list = null;
		Calendar pd = Calendar.getInstance();
		try {
			pstmt= conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<paydatedetail>();
			while(rset.next()) {
				System.out.println(rset.getDate(2)+""+rset.getString(3)+""+Integer.parseInt(rset.getString(4)));
				pd.setTime(rset.getDate(2));
				if (rset.getString(5).equals("N")) {
				int caldate = pd.compareTo(first);
				if (caldate > 0) {
					list.add(new paydatedetail(4,rset.getDate(2), rset.getString(3), Integer.parseInt(rset.getString(4))));
					System.out.println("4분기");
				} else {
					caldate = pd.compareTo(second);
					if (caldate > 0) {
						list.add(new paydatedetail(3,rset.getDate(2), rset.getString(3), Integer.parseInt(rset.getString(4))));
						System.out.println("3분기");
					} else {
						caldate = pd.compareTo(third);
						if (caldate > 0) {
							list.add(new paydatedetail(2,rset.getDate(2), rset.getString(3), Integer.parseInt(rset.getString(4))));
							System.out.println("2분기");
						} else {
							caldate = pd.compareTo(four);
							if (caldate > 0) {
								list.add(new paydatedetail(1,rset.getDate(2), rset.getString(3), Integer.parseInt(rset.getString(4))));
								System.out.println("1분기");
							}
						}
					}
				}
			}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<paydatedetail> rlist = null;
		rlist = new ArrayList<paydatedetail>();
		if(cate.equals("f")) {
			for(paydatedetail p : list) {
				if(p.getPcate()==1) {
					rlist.add(p);
					System.out.println("1분기");
				}
			}
		}else if(cate.equals("s")) {
			for(paydatedetail p : list) {
				if(p.getPcate()==2) {
					rlist.add(p);
					System.out.println("2분기");
				}
			}
		}else if(cate.equals("t")) {
			for(paydatedetail p : list) {
				if(p.getPcate()==3) {
					rlist.add(p);
					System.out.println("3분기");
				}
			}
		}else if(cate.equals("fo")) {
			for(paydatedetail p : list) {
				if(p.getPcate()==4) {
					rlist.add(p);
					System.out.println("4분기");
				}
			}
		}
		
		return rlist;
	}

}
