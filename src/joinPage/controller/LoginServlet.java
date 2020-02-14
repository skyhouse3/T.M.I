package joinPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import joinPage.model.service.JoinService;
import joinPage.model.vo.Join;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.jo")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("User_Id");
		String userPw = request.getParameter("User_Pw");
		System.out.println(userId);
		System.out.println(userPw);
		Join loginUser = new JoinService().loginMember(userId, userPw);
		int result = new JoinService().countUp(userId);
//		System.out.println(loginUser);
		response.setContentType("text/html; charset=utf-8");
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect(request.getContextPath()+"/views/common/MainHome.jsp");
		} else {
//			request.setAttribute("msg", "로그인 실패");
//
//			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
//			view.forward(request, response);
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
