package movie.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import attachment.model.vo.Attachment;
import movie.model.dao.MovieDao;
import movie.model.vo.Movie;
import movie.model.vo.MovieCharmingPoint;
import movie.model.vo.Preview;
import movie.model.vo.Reply;

public class MovieService {

	public ArrayList selectList(int flag, int currentPage, int boardLimit) {
		Connection con = getConnection();
		ArrayList list=null;
		MovieDao mDao= new MovieDao();
		if(flag==1) {
			list = mDao.selectList(con,currentPage,boardLimit);
		}else if(flag==2){
			list = mDao.selectNoList(con,currentPage,boardLimit);	
		}else {
			list= mDao.selectFlist(con);
		}
		close(con);
		return list;
	}
	public ArrayList<Movie> selectListMovie() {
		Connection con =getConnection();
		ArrayList<Movie> mlist=new MovieDao().selectMovieList(con);
		
		
		close(con);
		
		return mlist;
	}
	public Movie selectMovie(String mcode) {
		Connection con = getConnection();
		
		MovieDao mDao= new MovieDao();
		int res= mDao.increaseCount(con,mcode);
		Movie m = null;
		
		if(res>0) {
			m=mDao.selectMovie(con,mcode);
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return m;
	}

	public int insertMovie(Movie m, ArrayList<Attachment> fileList) {
		Connection con= getConnection();
		ArrayList<Preview> plist = new ArrayList<>();
		MovieDao mDao= new MovieDao();
		
		
		int res1=mDao.insertMovie(con,m);
		plist=m.getPlist();
		int res2=mDao.insertPreview(con,plist);
		int res3=mDao.insertImgAttachment(con,fileList);
		
		if(res1 > 0 && res2> 0 && res3>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return res1;
	}

	public Movie selectMovieNoCnt(String mCode) {
		Connection con =getConnection();
		
		Movie m = new MovieDao().selectMovie(con, mCode);
		
		close(con);
		
		return m;
	}

	public ArrayList<Attachment> selectMovieThumbnail(String mCode) {
		Connection con = getConnection();
		ArrayList<Attachment> list = new MovieDao().selectMovieThumbnail(con,mCode);
		
		close(con);
		
		return list;
	}

	public ArrayList<Preview> selectPrevieList(String mCode) {
		Connection con = getConnection();
		ArrayList<Preview> list = new MovieDao().selectPreviewList(con,mCode);
		
		close(con);
		
//		System.out.println("service의 list : "+list);
		return list;
	}

	public ArrayList<Reply> insertMovieReply(Reply r) {
		Connection con = getConnection();
		MovieDao mDao = new MovieDao();
		
		int res=mDao.insertMovieReply(con,r);
		ArrayList<Reply> rlist=null;
		
		if(res>0) {
//			System.out.println("res>0이다.");
			commit(con);
			rlist=mDao.selectMovieReplyList(con,r.getMcode());
		}else {
			rollback(con);
		}
		close(con);
		
		return rlist;
	}

	public ArrayList<Reply> selectMovieReplyList(String mCode) {
			Connection con = getConnection();
			ArrayList<Reply> list = new MovieDao().selectMovieReplyList(con, mCode);
			
			close(con);
		
		return list;
	}

	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new MovieDao().getListCount(con);
		
		return listCount;
	}

	public int deleteReplyMovie(String mrid) {
		
		Connection con = getConnection();
		int res=new MovieDao().deleteReplyMovie(con,mrid);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return res;
	}

	public int modifiedReplyMovie(String mrid, String content) {
		Connection con = getConnection();
		int res=new MovieDao().modifiedReplyMovie(con,mrid,content);
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return res;
	}

	public int DeleteMovie(String mrid) {
		Connection con = getConnection();
		int res=new MovieDao().deleteMovie(con, mrid);
		
		if(res>0) {
			commit(con);
			
		}else {
			rollback(con);
		}
		close(con);
		
		return res;
	}

	public ArrayList<Attachment> selectImgList(String mcode) {
		Connection con = getConnection();
		ArrayList<Attachment> ImgList=new MovieDao().selectImg(con,mcode);
		
		close(con);
		
		System.out.println("service에서 ImgList : "+ ImgList);
		
		return ImgList;
	}

	public int updateMovieBoard(Movie m, ArrayList<Attachment> mpList) {
		Connection con = getConnection();
		MovieDao mDao=new MovieDao();
		
		int res1=mDao.updateMovie(con,m);
		int res2=mDao.updateAttachment(con,mpList,m);
		if(res1>0&&res2>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res1;
	}
	public ArrayList<MovieCharmingPoint> selectPointerList() {
		Connection con =getConnection();
		
		
//		MovieCharmingPoint mcp = new MovieDao().selectPointer(con);
		ArrayList<MovieCharmingPoint> mcplist = new MovieDao().selectPointerList(con);
		close(con);
		
		return mcplist;
	}
	public MovieCharmingPoint selectPointer(String mCode) {
		Connection con =getConnection();
		
		
		MovieCharmingPoint mcp = new MovieDao().selectPointer(con,mCode);
		close(con);
		
		return mcp;
	}

	// 실시간차트 리스트
		// 최신순
		public ArrayList<Movie> selectcList(String category) {
			Connection conn = getConnection();
			ArrayList<Movie> cList = new MovieDao().selectcList(conn,category);
			
			close(conn);

			
			return cList;
		}
		// 평점
		public ArrayList<Movie> selectcList2(String category) {
			Connection conn = getConnection();
			ArrayList<Movie> cList = new MovieDao().selectcList2(conn,category);
			
			close(conn);

			
			return cList;
		}
		// 예매율
		public ArrayList<Movie> selectcList3(String category) {
			Connection conn = getConnection();
			ArrayList<Movie> cList = new MovieDao().selectcList3(conn,category);
			
			close(conn);

			
			return cList;
		}
}
