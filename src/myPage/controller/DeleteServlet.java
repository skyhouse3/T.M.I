package myPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import joinPage.model.vo.Join;
import myPage.model.service.MyPageService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete.me")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Join j = (Join)request.getSession().getAttribute("loginUser");
		
		int result = new MyPageService().deleteMember(j.getUser_Id());
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser");
			
			session.setAttribute("msg", "회원 탈퇴가 완료되었습니다." + "지금까지 이용해주셔서 감사합니다.^^");
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} else {
			request.setAttribute("msg", "회원 탈퇴에 실패햇습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
