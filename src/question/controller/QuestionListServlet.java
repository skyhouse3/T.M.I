package question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.model.Service;
import Service.service.ServicemService;
import question.model.service.QuestionService;
import question.model.vo.PageInfo;


/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/list.qu")
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionService qService = new QuestionService();
		String mem = request.getParameter("mem");
		int listCount = qService.getListCount();
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
		ArrayList<Service> list = qService.selectList(currentPage,boardLimit);
		RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeFaq.jsp");
		request.setAttribute("list", list);
		request.setAttribute("pi",pi);
		request.setAttribute("mem", mem);
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
