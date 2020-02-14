package movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attachment.model.vo.Attachment;
import movie.model.service.MovieService;
import movie.model.vo.Movie;

/**
 * Servlet implementation class MovieUpdateServlet
 */
@WebServlet("/update.mo")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public MovieUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mcode=request.getParameter("mrid");
		MovieService mService= new MovieService();
		
		Movie m = mService.selectMovieNoCnt(mcode);
		ArrayList<Attachment> ImgFile= mService.selectImgList(mcode);
		
		if(m !=null) {
			request.setAttribute("movie", m);
			request.setAttribute("Img", ImgFile);

			request.getRequestDispatcher("views/movie/MovieUpdateForm.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg", "무비게시판 상세 보기 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
