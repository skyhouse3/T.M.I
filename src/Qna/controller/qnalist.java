package Qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.model.vo.PageInfo;
import Qna.model.Qna;
import Qna.service.QnaService;

/**
 * Servlet implementation class qnalist
 */
@WebServlet("/qnalist.ql")
public class qnalist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qnalist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnaService mService = new QnaService();
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
		maxPage = (int)Math.ceil((double)listCount/boardLimit)+1;
		startPage = (currentPage -1)/pageLimit*pageLimit + 1;
		endPage = startPage + pageLimit -1;
		if(maxPage <endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		ArrayList<Qna> list = QnaService.selectList(currentPage,boardLimit);
		RequestDispatcher view = request.getRequestDispatcher("manager/qnaManage/qnaManage.jsp");
		request.setAttribute("list", list);
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
