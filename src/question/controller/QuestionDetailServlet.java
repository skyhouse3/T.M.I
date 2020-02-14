package question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.model.Service;
import question.model.service.QuestionService;




/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/detail.qu")
public class QuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sNum = request.getParameter("snum");
		String mem = request.getParameter("mem");
		Service qo = new QuestionService().selectFaq(sNum);
		RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeFaqDetail.jsp");
		request.setAttribute("Question", qo);
		request.setAttribute("mem",mem);
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
