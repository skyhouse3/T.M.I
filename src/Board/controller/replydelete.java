package Board.controller;

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
import Board.service.BoardmanService;

/**
 * Servlet implementation class replydelete
 */
@WebServlet("/delete.r")
public class replydelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public replydelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		String bnum = request.getParameter("bid");
		int result = 0;
		result = new BoardmanService().deleter(rid);
		Boardman bo = new BoardmanService().selectBoard(bnum);
		ArrayList<Reply> rlist = new BoardmanService().selectReplyList(bnum);
		RequestDispatcher view = request.getRequestDispatcher("manager/boardManage/boardmanDetailView.jsp");
		request.setAttribute("board", bo);
		request.setAttribute("rlist", rlist);
		if(result > 0) {
			view.forward(request,response);
		}else {
			
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
