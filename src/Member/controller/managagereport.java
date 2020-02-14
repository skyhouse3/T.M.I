package Member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.model.Reply;
import Member.model.vo.BoReport;
import Member.model.vo.RpReport;
import Member.service.MemberService;

/**
 * Servlet implementation class managagereport
 */
@WebServlet("/manmanagereport.mm")
public class managagereport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managagereport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mnum = request.getParameter("mnum");
		MemberService mService = new MemberService();
		ArrayList<RpReport> rlist = MemberService.selectRlist();
		ArrayList<BoReport> blist = MemberService.selectBlist();
		ArrayList<Reply> pdr = mService.getreply(mnum);
		RequestDispatcher view = request.getRequestDispatcher("manager/memberManage/userReport.jsp");
		request.setAttribute("rlist", rlist);
		request.setAttribute("blist", blist);
		request.setAttribute("mnum", mnum);
		request.setAttribute("pdr",pdr);
		view.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
