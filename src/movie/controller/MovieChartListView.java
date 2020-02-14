package movie.controller;

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
import snack.model.service.SnackService;
import snack.model.vo.Snack;

@WebServlet("/clist.mo")
public class MovieChartListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MovieChartListView() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ver = request.getParameter("ver");
		String Category = request.getParameter("Category");
		System.out.println(Category);
		String Rrate = request.getParameter("Rrate");
		String reservationrate = request.getParameter("reservationrate");
		// 예매율  (티켓)/전체좌석(영화방영코드 seat) - 하루단위 
		System.out.println(ver);
		
		if( Category == null && ver.equals("a")  ) {
			Category = "now_playing_movie";
			ArrayList<Movie> cList = new MovieService().selectcList(Category);
			
			request.setAttribute("cList", cList);
			RequestDispatcher view = request.getRequestDispatcher("views/movie/MovieChartList.jsp");
			view.forward(request, response);
			
		}else if (Category == null && ver.equals("b")) {
			Category = "now_playing_movie";
			ArrayList<Movie> cList = new MovieService().selectcList2(Category);
			
			request.setAttribute("cList", cList);
			RequestDispatcher view = request.getRequestDispatcher("views/movie/MovieChartList.jsp");
			view.forward(request, response);
		}else if(Category == null && ver.equals("c")) {
			Category = "now_playing_movie";
			ArrayList<Movie> cList = new MovieService().selectcList3(Category);
			
			request.setAttribute("cList", cList);
			RequestDispatcher view = request.getRequestDispatcher("views/movie/MovieChartList.jsp");
			view.forward(request, response);
		}

		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
