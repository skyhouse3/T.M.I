package movie.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import attachment.model.vo.Attachment;
import movie.model.vo.Movie;
import movie.model.vo.MovieCharmingPoint;
import movie.model.vo.Preview;
import movie.model.vo.Reply;

public class MovieDao {
	private Properties prop = new Properties();

	public MovieDao() {
		
		String path=MovieDao.class.getResource("/sql/movie/movie-query.properties").getPath();
		
		try {
			prop.load(new FileReader(path));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<Movie> selectList(Connection con, int currentPage, int boardLimit) {
		
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		ArrayList<Movie> list = new ArrayList<>();
		Movie m=null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt=con.prepareStatement(sql);
			int startRow = (currentPage-1) * boardLimit +1;
			int endRow = startRow + boardLimit -1 ;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Movie();
				m.setMcode(rset.getString("MCODE"));
				m.setMbcode(rset.getString("MBCODE"));
				m.setMtitle(rset.getString("MTITLE"));
				m.setmDirector(rset.getString("MDIRECTOR"));
				m.setmActor(rset.getString("MACTOR"));
				m.setRelease(rset.getDate("RELEASE"));
				m.setAgeCut(rset.getString("AGECUT"));
				m.setRate(rset.getFloat("RATE"));

				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Movie selectMovie(Connection con, String mcode) {
		PreparedStatement pstmt=null;
		ResultSet rset =null;
		String sql=prop.getProperty("selectMovie");
		Movie m = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mcode);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				m=new Movie();
				m.setMcode(rset.getString("MCODE"));
				m.setMtitle(rset.getString("MTITLE"));
				m.setMtitleEng(rset.getString("MTITLEENG"));
				m.setMtitlePlot(rset.getString("MTITLEPLOT"));
				m.setPlot(rset.getString("PLOT"));
				m.setCategory(rset.getString("CATEGORY"));
				m.setmDirector(rset.getString("MDIRECTOR"));
				m.setmActor(rset.getString("MACTOR"));
				m.setKinds(rset.getString("KINDS"));
				m.setInfo(rset.getString("INFO"));
				m.setAgeCut(rset.getString("AGECUT"));
				m.setRelease(rset.getDate("RELEASE"));
				m.setmCount(Integer.parseInt(rset.getString("count")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public ArrayList<Movie> selectListChart(Connection con) {
		
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		ArrayList<Movie> list = new ArrayList<>();
		Movie m=null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt=con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Movie();
				/*내용 작성*/
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertMovie(Connection con, Movie m) {
		PreparedStatement pstmt=null;
		Movie returnMovie=null;
		int res=0;
		int mCode=0;
		ResultSet rset=null;
		
		String sql=prop.getProperty("insertMovie");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, m.getMtitle());
			pstmt.setString(2, m.getMtitleEng());
			pstmt.setString(3, m.getMtitlePlot());
			pstmt.setString(4, m.getPlot());
			pstmt.setString(5, m.getCategory());
			pstmt.setString(6, m.getmDirector());
			pstmt.setString(7, m.getmActor());
			pstmt.setString(8, m.getKinds());
			pstmt.setString(9, m.getInfo());
			pstmt.setDate(10,m.getRelease());
			pstmt.setString(11,m.getAgeCut());
			res=pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return res;
	}

	public int insertPreview(Connection con, ArrayList<Preview> plist) {
		PreparedStatement pstmt =null;
		int res=0;
		String sql=prop.getProperty("insertPreview");

		try {
			
			for(int i=0;i<plist.size();i++) {
				Preview p = plist.get(i);
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, p.getYurl());
				res=pstmt.executeUpdate();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(pstmt);
		}
		
		
		return res;
	}

	public int insertImgAttachment(Connection con, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("insertImgAttachment");

		try {
			/*System.out.println("fileList 사이즈 : "+fileList.size());*/
			for (int i = 0; i < fileList.size(); i++) {
				Attachment at = fileList.get(i);
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setString(4, at.getFileLevel());

				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList selectFlist(Connection con) {
		ArrayList<Attachment> list = new ArrayList<Attachment>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectFList");

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Attachment at = new Attachment();
				at.setmCode(rset.getString("MCODE"));
				at.setChangeName(rset.getString("CHANGE_NAME"));

				list.add(at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public ArrayList<Attachment> selectImg (Connection con,String mcode) {
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		Attachment at=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectImgList");
		System.out.println("mcode : "+mcode);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mcode);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				at = new Attachment();
				at.setmCode(rset.getString("MCODE"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setFileLevel(rset.getString("FILE_LEVEL"));
				at.setFilePath(rset.getString("FILE_PATH"));

				list.add(at);
			}
			
			System.out.println("Dao에서 "+list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int increaseCount(Connection con, String mcode) {
		PreparedStatement pstmt = null;
		int res=0;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mcode);
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return res;
	}

	public ArrayList<Attachment> selectMovieThumbnail(Connection con, String mCode) {
		PreparedStatement pstmt=null;
		ResultSet rset= null;
		ArrayList<Attachment> list =new ArrayList<Attachment>();
		
		String sql= prop.getProperty("selectMovieThumbnail");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mCode);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFid(rset.getString("FID"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setUploadDate(rset.getDate("UPLOAD_DATE"));
				
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Preview> selectPreviewList(Connection con, String mCode) {
		PreparedStatement pstmt=null;
		ArrayList<Preview> list = new ArrayList<>();
		ResultSet rset=null;
		String sql = prop.getProperty("selectPreviewList");
//		System.out.println("Dao의 selectPreviewList 의 mCode : "+ mCode);
		try {
//			System.out.println("Dao의 selectPreviewList 의 mCode2 : "+ mCode);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mCode);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Preview p = new Preview();
				p.setYurl(rset.getString("YURL"));
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
//		System.out.println("Dao의 selectPreviewList 의 list: "+ list);
		return list;
	}

	public int insertMovieReply(Connection con, Reply r) {
		
		PreparedStatement pstmt = null;
		int res=0;
		String sql = prop.getProperty("insertMovieReply");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, r.getMcode());
			pstmt.setString(2, r.getRcontent());
			pstmt.setString(3, r.getRwriter());
			pstmt.setString(4, r.getReply_level());
			
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
//		System.out.println("insert 성공");
		return res;
	}

	public ArrayList<Reply> selectMovieReplyList(Connection con, String mcode) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql= prop.getProperty("selectMovieReplyList");
		ArrayList<Reply> rlist=null;
		Reply r=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mcode);
			rset=pstmt.executeQuery();
			rlist=new ArrayList<>();
			
			while(rset.next()) {
				
				r =new Reply();
				r.setRid(rset.getString("RID"));
				r.setRcontent(rset.getString("RCONTENT"));
				r.setRwriter(rset.getString("RWRITER"));
				r.setCreate_date(rset.getDate("CREATE_DATE"));
				r.setModify_date(rset.getDate("MODIFY_DATE"));
				
				rlist.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("selectMovieReplyList : "+rlist);
		return rlist;
	}

	public int getListCount(Connection con) {
		int listCount=0;
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		String sql = prop.getProperty("getListMovieCount");
		
		try {
			pstmt=con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				listCount=rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return listCount;
	}

	public int deleteReplyMovie(Connection con, String mrid) {
		PreparedStatement pstmt=null;
		int res=0;
		String sql=prop.getProperty("deleteReplyMovie");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(mrid));
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return res;
	}

	public int modifiedReplyMovie(Connection con, String mrid, String content) {
		PreparedStatement pstmt=null;
		int res=0;
		String sql = prop.getProperty("modifiedReplyMovie");
		try {	
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, Integer.parseInt(mrid));
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}finally {
			close(pstmt);
		}
		
		return res;
	}

	public int deleteMovie(Connection con, String mrid) {
		PreparedStatement pstmt=null;
		int res=0;
		String sql=prop.getProperty("deleteMovie");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mrid);
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return res;
	}

	public int updateMovie(Connection con, Movie m) {
		PreparedStatement pstmt=null;
		int res=0;
		String sql=prop.getProperty("updateMovie");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, m.getMtitle());
			pstmt.setString(2, m.getMtitleEng());
			pstmt.setString(3, m.getMtitlePlot());
			pstmt.setString(4, m.getPlot());
			pstmt.setString(5, m.getCategory());
			pstmt.setString(6, m.getmDirector());
			pstmt.setString(7, m.getmActor());
			pstmt.setString(8, m.getKinds());
			pstmt.setString(9, m.getInfo());
			pstmt.setDate(10, m.getRelease());
			pstmt.setString(11, m.getAgeCut());
			pstmt.setString(12, m.getMcode());
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return res;
	}

	public int updateAttachment(Connection con, ArrayList<Attachment> mpList, Movie m) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateAttachment");

		try {
			/*System.out.println("fileList 사이즈 : "+fileList.size());*/
			for (int i = 0; i < mpList.size(); i++) {
				Attachment at = mpList.get(i);
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setString(4, at.getFileLevel());
				pstmt.setString(5, m.getMcode());
				
				result += pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList selectNoList(Connection con, int currentPage, int boardLimit) {

		PreparedStatement pstmt=null;
		ResultSet rset = null;
		ArrayList<Movie> list = new ArrayList<>();
		Movie m=null;
		String sql = prop.getProperty("selectNoList");
		try {
			pstmt=con.prepareStatement(sql);
			int startRow = (currentPage-1) * boardLimit +1;
			int endRow = startRow + boardLimit -1 ;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Movie();
				m.setMcode(rset.getString("MCODE"));
				m.setMbcode(rset.getString("MBCODE"));
				m.setMtitle(rset.getString("MTITLE"));
				m.setmDirector(rset.getString("MDIRECTOR"));
				m.setmActor(rset.getString("MACTOR"));
				m.setRelease(rset.getDate("RELEASE"));
				m.setAgeCut(rset.getString("AGECUT"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Movie> selectMovieList(Connection con) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		ArrayList<Movie> list=new ArrayList<>();
		Movie m=null;
		String sql=prop.getProperty("selectMovieList");
		try {
			pstmt=con.prepareStatement(sql);
			if(pstmt !=null) {
				rset=pstmt.executeQuery();	
			}
			
			while(rset.next()) {
				m = new Movie();
				m.setMcode(rset.getString("MCODE"));
				m.setMtitle(rset.getString("MTITLE"));
				list.add(m);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public MovieCharmingPoint selectPointer(Connection con, String mCode) {
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectPointer");
		ResultSet rset= null;
		MovieCharmingPoint mcp=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mCode);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
			
				mcp=new MovieCharmingPoint();
				mcp.setRrate(rset.getFloat(1));
				mcp.setCharmingPoint(rset.getFloat(2));
				mcp.setDirector_production(rset.getFloat(3));
				mcp.setOST(rset.getFloat(4));
				mcp.setAction_acting(rset.getFloat(5));
				mcp.setStory(rset.getFloat(6));
				mcp.setMovie_beauty(rset.getFloat(7));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return mcp;
	}

	public ArrayList<MovieCharmingPoint> selectPointerList(Connection con) {
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectPointerList");
		ResultSet rset=null;
		ArrayList<MovieCharmingPoint> mcplist=new ArrayList<MovieCharmingPoint>();
		MovieCharmingPoint mcp=null;
		try {
			pstmt=con.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				mcp=new MovieCharmingPoint();
				mcp.setRrate(rset.getFloat(1));
				
				mcplist.add(mcp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
				
		
		return mcplist;
	}

	// 3사 chart리스트
			public ArrayList<Movie> selectcList(Connection conn, String category) {
				ArrayList<Movie> cList = new ArrayList<>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectcList");
				
				try {
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, category);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						
						cList.add(new Movie(
							
								rset.getString("MTITLE"),
								rset.getString("CHANGE_NAME"),
								rset.getDate("release"),
								rset.getString("KINDS"),
								rset.getString("Mdirector"),
								rset.getString("Mactor"),
								rset.getString("Rrate"),
								rset.getString("reservationrate")	
								));										
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}
				System.out.println(cList);
				return cList;
				
			}

			public ArrayList<Movie> selectcList2(Connection conn, String category) {
				ArrayList<Movie> cList = new ArrayList<>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectcList2");
				
				try {
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, category);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						
						cList.add(new Movie(
								rset.getString("MTITLE"),
								rset.getString("CHANGE_NAME"),
								rset.getDate("release"),
								rset.getString("KINDS"),
								rset.getString("Mdirector"),
								rset.getString("Mactor"),
								rset.getString("Rrate"),
								rset.getString("reservationrate")	
								));										
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}
				System.out.println(cList);
				return cList;
			}

			public ArrayList<Movie> selectcList3(Connection conn, String category) {
				ArrayList<Movie> cList = new ArrayList<>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectcList3");
				
				try {
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, category);
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						
						cList.add(new Movie(
								rset.getString("MTITLE"),
								rset.getString("CHANGE_NAME"),
								rset.getDate("release"),
								rset.getString("KINDS"),
								rset.getString("Mdirector"),
								rset.getString("Mactor"),
								rset.getString("Rrate"),
								rset.getString("reservationrate")	
								));										
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}
				System.out.println(cList);
				return cList;
			}

	

}
