package Payment.controller;

import static common.JDBCTemplate.getConnection;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Payment.model.service.PaymentService;
import movie.model.service.MovieService;
import movie.model.vo.Movie;

/**
 * Servlet implementation class MovieSellServlet
 */
@WebServlet("/MovieSell.pa")
public class MovieSellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieSellServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		ArrayList<Movie> mlist=new MovieService().selectListMovie();
		String mem = request.getParameter("mem");
		
		if(mlist !=null) {
			RequestDispatcher view = request.getRequestDispatcher("views/payment/MoviePayForm.jsp");
			request.setAttribute("mlist", mlist);
			request.setAttribute("mem", mem);
			System.out.println(mem);
			view.forward(request, response);				
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
