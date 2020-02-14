package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;
import movie.model.vo.Movie;

@WebServlet("/movie.li")
public class ReviewMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewMovieListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Movie> mlist=new MovieService().selectListMovie();
		String mem = request.getParameter("mem");
		
		if(mlist !=null) {
			RequestDispatcher view = request.getRequestDispatcher("views/review/reviewInsert.jsp");
			request.setAttribute("mlist", mlist);
			request.setAttribute("mem", mem);
			System.out.println(mem);
			view.forward(request, response);				
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
