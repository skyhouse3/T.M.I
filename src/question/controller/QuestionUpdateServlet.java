package question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.model.Service;
import question.model.service.QuestionService;
import question.model.vo.Question;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/update.sv")
public class QuestionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    String sNum = request.getParameter("sNum");
	    String content = request.getParameter("content");
		
		Service result = new QuestionService().updateFaq(sNum, content);
		System.out.println(result);
		String mem = result.getUserId();
		response.sendRedirect("detail.qu?snum="+sNum+"&mem="+mem);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
