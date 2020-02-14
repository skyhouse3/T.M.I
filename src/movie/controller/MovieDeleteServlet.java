package movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;

@WebServlet(name = "Delete.mo", urlPatterns = { "/Delete.mo" })
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mrid=request.getParameter("mrid");
		int delMovie=new MovieService().DeleteMovie(mrid);
		
		if(delMovie>0) {
			response.sendRedirect("list.mo");
		}else {
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			request.setAttribute("msg", "영화 삭제에 실패했습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
