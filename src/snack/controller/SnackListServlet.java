package snack.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import snack.model.service.SnackService;
import snack.model.vo.Snack;

/**
 * Servlet implementation class SnackListServlet
 */
@WebServlet("/SnackList.sn")
public class SnackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnackListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kinds = request.getParameter("kinds");
		String Ccode = request.getParameter("Ccode");
		
		System.out.println(kinds);
		System.out.println(Ccode);

		ArrayList<Snack> snList = new SnackService().selectList(Ccode, kinds);

		request.setAttribute("snList", snList);
		RequestDispatcher view = request.getRequestDispatcher("views/snack/SnackMain.jsp");
		view.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
