package Payment.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static common.JDBCTemplate.*;

import movie.model.dao.MovieDao;
import movie.model.vo.Movie;


public class PaymentDao {
	
	private Properties prop = new Properties();
	
public PaymentDao() {
		
		String path=MovieDao.class.getResource("/sql/payment/payment-query.properties").getPath();
		
		try {
			prop.load(new FileReader(path));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}	
	public int ticketing(Connection conn, String mem, String mcode, String seat) {
		PreparedStatement pstmt = null;
        String sql = prop.getProperty("tickeing");
        int result = 0;
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mcode);
			pstmt.setString(2, mem);
			pstmt.setString(3, seat);
			
			result = pstmt.executeUpdate();
						
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		
		return result;
	}
	public String fticketing(Connection conn, String mem, String mcode, String seat) {
		PreparedStatement pstmt = null;
        String sql = prop.getProperty("ftickeing");
        ResultSet rset = null; 
        String tNum = "";
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mcode);
			pstmt.setString(2, mem);
			pstmt.setString(3, seat);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				tNum=rset.getString(1);
			}
						
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);		
		}
	
		return tNum;
	}
	public int mbk(Connection conn, String tNum, String mem) {
		PreparedStatement pstmt = null;
        String sql = prop.getProperty("mbk");
        int result = 0;
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNum);
			pstmt.setString(2, mem);

			
			result = pstmt.executeUpdate();
						
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		
		return result;
	}
}
