package movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attachment.model.vo.Attachment;
import common.model.PageInfo;
import movie.model.service.MovieService;
import movie.model.vo.Movie;
import movie.model.vo.MovieCharmingPoint;


@WebServlet("/list.mo")
public class MovieListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MovieListViewServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieService bService = new MovieService();
		
		
		int listCount = bService.getListCount();
		int currentPage;		// 현재 페이지
		int pageLimit;			// 한 페이지 하단에 보여질 페이지 수
		int maxPage;			// 전체 페이지에 가장 마지막 페이지
		int startPage;			// 한 페이지 하단에 보여질 시작 페이지
		int endPage;			// 한 페이지 하단에 보여질 끝 페이지
		
		int boardLimit = 10;	// 
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// * pageLimit : 한 페이지 하단에 보여질 페이지 수
		pageLimit = 10;
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		// * endPage : 현재 페이지에서 보여질 마지막 페이지 수
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		
		ArrayList<Movie> mlist = bService.selectList(1,currentPage,boardLimit);
		ArrayList<Attachment> mplist= bService.selectList(3,currentPage,boardLimit);
		ArrayList<MovieCharmingPoint> mcplist=bService.selectPointerList();
		
		
		if(mlist !=null && mplist !=null) {
			request.setAttribute("movieList", mlist);
			request.setAttribute("imgFileList", mplist);
			request.setAttribute("pi", pi);
			request.setAttribute("mcplist", mcplist);
			request.getRequestDispatcher("views/movie/MovieListViewForm.jsp").forward(request, response);
					
		}else {
			request.setAttribute("msg", "사진 게시판 조회 실패!!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
