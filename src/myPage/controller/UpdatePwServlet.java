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
import myPage.model.vo.MyPage;

/**
 * Servlet implementation class UpdatePwServlet
 */
@SuppressWarnings("unused")
// @WebServlet("/updatePw.me")
@WebServlet(name = "UpdatePwServlet", urlPatterns="/updatePw.me")
public class UpdatePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String UserId = ((Join)session.getAttribute("loginUser")).getUser_Id();
		
		String Userpw = request.getParameter("User_pw");
		String newPw = request.getParameter("newPw");
		
		Join updateMem = new MyPageService().updatePwd(UserId, Userpw, newPw);
		
		if(updateMem != null) {
			request.setAttribute("msg", "비밀번호 변경을 완료하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem);
		} else {
			request.setAttribute("msg", "비밀번호 변경을 실패했습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("views/myPage/pwUpdateForm.jsp");
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
