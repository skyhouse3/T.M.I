package movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attachment.model.vo.Attachment;
import movie.model.service.MovieService;
import movie.model.vo.Movie;
import movie.model.vo.MovieCharmingPoint;
import movie.model.vo.Preview;
import movie.model.vo.Reply;


@WebServlet("/detail.mo")
public class MovieDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieDetailViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mCode=request.getParameter("mcode");
		MovieService mService=new MovieService(); 
		Movie m = null;
//		mService.selectMovie(mCode);
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie c : cookies) {
				// bId 쿠키가 있는 경우
				if (c.getName().equals("mCode" + mCode)) {
					flag = true;
				}
			}
			// bId 쿠키가 없는 경우
			if (!flag) {
				// 게시글을 처음 클릭했으므로 조회수 증가 + 셀렉
				m = new MovieService().selectMovie(mCode);
				// 쿠키 객체 생성
				Cookie c1 = new Cookie("mCode" + mCode, String.valueOf(mCode));
				// 하루동안 저장
				c1.setMaxAge(1 * 24 * 60 * 60);
				response.addCookie(c1);
			} else {
				// bId 쿠키가 있는 경우는 게시글을 하루 안에 다시 클릭하는 것이므로
				// 조회수 증가하지 않고 셀렉
				m = new MovieService().selectMovieNoCnt(mCode);
			}

		}
		MovieCharmingPoint mcp= mService.selectPointer(mCode);
		
		ArrayList<Attachment> fileList =mService.selectMovieThumbnail(mCode);

		ArrayList<Preview> previewList = mService.selectPrevieList(mCode);
		
		ArrayList<Reply> rlist=mService.selectMovieReplyList(mCode);
		
		if(m !=null) {
			request.setAttribute("movie", m);
			request.setAttribute("fileList", fileList);
			request.setAttribute("previewList", previewList);
			request.setAttribute("mcp", mcp);
//			System.out.println("if문 실행 확인!");
			
			if(rlist !=null) {
				request.setAttribute("mrlist", rlist);
			}
			request.getRequestDispatcher("views/movie/MovieDetailForm.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg", "무비게시판 상세 보기 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);	
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
