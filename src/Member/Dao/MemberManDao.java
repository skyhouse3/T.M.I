package Member.Dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import Board.model.Boardman;
import Board.model.Reply;
import Member.model.vo.BoReport;
import Member.model.vo.Member;
import Member.model.vo.RpReport;
import basket.model.vo.ticket;

public class MemberManDao {
	private Properties prop = new Properties();
	public MemberManDao() {
		String fileName = MemberManDao.class.getResource("/sql/member/memberman-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getListCount(Connection conn) {
		int listCount = 0;

		Statement stmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("getListCount");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	public ArrayList<Member> selectList(Connection conn, int currentPage, int boardLimit) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (currentPage - 1) * boardLimit + 1;
			int endRow = startRow + boardLimit - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Member(
						rset.getString(2),
						rset.getString(3),
						rset.getDate(4)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public int fdayMem(Connection conn, String mid) {
		PreparedStatement pstmt = null;
		int result= 0;
		String sql = prop.getProperty("fdaymem");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int cpunish(Connection conn, String mid) {
		PreparedStatement pstmt = null;
		int result= 0;
		String sql = prop.getProperty("cpunish");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
	}
	public int adayMem(Connection conn, String mid) {
		PreparedStatement pstmt = null;
		int result= 0;
		String sql = prop.getProperty("adaymem");

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public ArrayList<Boardman> getboard(Connection conn, String mnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Boardman> list = null;
		String sql = prop.getProperty("selboard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mnum);
			rset = pstmt.executeQuery();
			list = new ArrayList<Boardman>();
			while(rset.next()) {
				list.add(new Boardman(rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}	
		return list;
	}
	public ArrayList<Reply> getReply(Connection conn, String mnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> list = null;
		String sql = prop.getProperty("selreply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mnum);
			rset = pstmt.executeQuery();
			list = new ArrayList<Reply>();
			while(rset.next()) {
				list.add(new Reply(rset.getString(1),
									rset.getString(2),
									rset.getString(3),
									rset.getDate(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<ticket> getticket(Connection conn, String mnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ticket> list = null;
		String sql = prop.getProperty("selticket");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mnum);
			rset = pstmt.executeQuery();
			list = new ArrayList<ticket>();
			while(rset.next()) {
				list.add(new ticket(rset.getString(1),
									rset.getString(2),
									rset.getString(3),
									rset.getString(4),
									rset.getString(5),
									rset.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public ArrayList<RpReport> selectRlist(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RpReport> list = null;
		String sql = prop.getProperty("selectRlist");
		int a = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<RpReport>();
			while(rset.next()) {
				list.add(new RpReport(
						rset.getString(1),
						rset.getString(2),
						rset.getString(3)
						));
				a++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public ArrayList<BoReport> selectBlist(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoReport> list = null;
		int a = 0;
		String sql = prop.getProperty("selectBlist");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<BoReport>();
			while(rset.next()) {
				list.add(new BoReport(
						rset.getString(1),
						rset.getString(2),
						rset.getString(3)
						));
				a++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public int mvpc(Connection conn, String mid, String set) {
		System.out.println(mid);
		System.out.println(set);
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		ResultSet rset = null;
		int result = 0;
		String mvp = "";
		String sql = prop.getProperty("mvpg");
		String sql2 = prop.getProperty("mvpc");

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					mvp = rset.getString(1);
				}
				pstmt2 = conn.prepareStatement(sql2);
				if(mvp.equals("C")) {
					if(set.equals("u")) {
						pstmt2.setString(1, "B");
						pstmt2.setString(2,mid);
					}
				}else if(mvp.equals("B")){
					if(set.equals("u")) {
						pstmt2.setString(1, "A");
						pstmt2.setString(2,mid);
					}else {
						pstmt2.setString(1, "C");
						pstmt2.setString(2,mid);
					}
				}else if(mvp.equals("A")) {
					if(set.equals("u")) {
						pstmt2.setString(1, "S");
						pstmt2.setString(2,mid);
					}else {
						pstmt2.setString(1, "B");
						pstmt2.setString(2,mid);
					}
				}else if(mvp.equals("S")) {
					if(set.equals("d")) {
						pstmt2.setString(1, "A");
						pstmt2.setString(2,mid);
					}
				}
				result = pstmt2.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
				close(pstmt2);
			}
			
			

		return result;
	}
}
