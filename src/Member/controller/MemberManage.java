package Member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.model.vo.BoReport;
import Member.model.vo.Member;
import Member.model.vo.PageInfo;
import Member.model.vo.RpReport;
import Member.service.MemberService;

/**
 * Servlet implementation class MemberManage
 */
@WebServlet("/manmanage.mc")
public class MemberManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberService();
		int listCount = mService.getListCount();
		int currentPage;
		int pageLimit;
		int maxPage;
		int startPage;
		int endPage;
		int boardLimit = 10;
		currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		pageLimit = 10;
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage -1)/pageLimit*pageLimit + 1;
		endPage = startPage + pageLimit -1;
		if(maxPage <endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		ArrayList<Member> list = MemberService.selectList(currentPage,boardLimit);
		ArrayList<RpReport> rlist = MemberService.selectRlist();
		ArrayList<BoReport> blist = MemberService.selectBlist();
		RequestDispatcher view = request.getRequestDispatcher("manager/memberManage/userManage.jsp");
		request.setAttribute("list", list);
		request.setAttribute("rlist", rlist);
		request.setAttribute("blist", blist);
		request.setAttribute("pi",pi);
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
