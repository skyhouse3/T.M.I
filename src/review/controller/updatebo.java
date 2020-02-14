package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.model.Boardman;
import Board.service.BoardmanService;

/**
 * Servlet implementation class updatebo
 */
@WebServlet("/update.re")
public class updatebo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatebo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mem = request.getParameter("mem");
		String content = request.getParameter("content");
		String bid = request.getParameter("bid");
		int result= new BoardmanService().updatebo(content,bid);
		System.out.println("content = " + content + "mem =" + mem + "bid = " + bid + "결과 = " + result);
		response.sendRedirect("list.re?mem="+mem);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
