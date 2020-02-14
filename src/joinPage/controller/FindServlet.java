package joinPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import joinPage.model.service.JoinService;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/find.jo")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 String UserId = request.getParameter("User_Id");
	     String PWHINT = request.getParameter("PW_HINT");
	     String HINT = request.getParameter("HINT");
	     String pwd = new JoinService().findPwd(UserId,PWHINT,HINT);
	     RequestDispatcher view = request.getRequestDispatcher("views/joinPage/findsuccess.jsp");
	     request.setAttribute("pwd", pwd);
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
