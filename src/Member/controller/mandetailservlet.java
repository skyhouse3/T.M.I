package Member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.model.Boardman;
import Board.model.Reply;
import Member.service.MemberService;
import basket.model.vo.ticket;

/**
 * Servlet implementation class mandetailservlet
 */
@WebServlet("/manmanagedetail.mm")
public class mandetailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mandetailservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberService();
		String mnum = request.getParameter("mnum");
		ArrayList<Boardman> mbm = mService.getboard(mnum);
		ArrayList<Reply> pdr = mService.getreply(mnum);
		ArrayList<ticket> pd = mService.getticket(mnum);
		RequestDispatcher view = request.getRequestDispatcher("manager/memberManage/memberdetail.jsp");
		request.setAttribute("mbm", mbm);
		request.setAttribute("pdr", pdr);
		request.setAttribute("pd", pd);
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
