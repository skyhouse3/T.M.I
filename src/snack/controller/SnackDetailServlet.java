package snack.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snack.model.service.SnackService;
import snack.model.vo.Snack;

/**
 * Servlet implementation class snackDetailServlet
 */
@WebServlet(name = "SnackDetailServlet", urlPatterns = { "/SnackDetail.sn" })
public class SnackDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnackDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skCode = request.getParameter("skCode");
		
		ArrayList<Snack> DeList = new SnackService().selectDetail(skCode);
		
		String page = "";
		if(DeList != null) {
			request.setAttribute("DeList", DeList);
			page = "views/snack/SnackDetail.jsp";
			
		} 
		System.out.println(DeList);
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
