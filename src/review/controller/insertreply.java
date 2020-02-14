package review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.service.BoardmanService;

/**
 * Servlet implementation class insertreply
 */
@WebServlet("/insertreply.rp")
public class insertreply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertreply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("Rnum");
		String mcode = request.getParameter("mcode");
		String Rcontent = request.getParameter("Rcontent");
		String Rwriter = request.getParameter("Rwriter");
		int result = new BoardmanService().insertReply(rnum,mcode,Rcontent,Rwriter);
		if(result>0) {
			response.sendRedirect(request.getContextPath() + "/detail.re?rnum="+rnum+"&mem="+Rwriter);
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
