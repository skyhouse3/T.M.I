package myPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import joinPage.model.vo.Join;
import myPage.model.service.MyPageService;
import myPage.model.vo.MyPage;


/**
 * Servlet implementation class UpdateServlet
 */
@SuppressWarnings("unused")
@WebServlet("/update.me")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	      
	      String UserId = request.getParameter("User_Id");
	      String Userpw = request.getParameter("User_Pw");
	      String PWHINT = request.getParameter("PW_HINT");
	      String HINT = request.getParameter("HINT");
	      String Username = request.getParameter("User_name");
	      String gender = request.getParameter("gender");
	      String Birth = request.getParameter("Birth");
	      String Phone = request.getParameter("Phone");
	      String Email = request.getParameter("Email");
	      String Address = request.getParameter("Address");
	      
	      String arr[] = request.getParameterValues("Favorite");
	      
	      System.out.println(arr);
	      String Favorite = "";
	      if(arr != null) {
	         Favorite = String.join(",", arr);
	      }
	      
	      Join j = new Join(UserId, Userpw, PWHINT, HINT, Username, gender, Birth, Phone, Email, Address, Favorite);
	      
	      Join updateMember = new MyPageService().updateMember(j);
	      
	      if(updateMember != null) {
	    	  System.out.println(updateMember);
				request.getSession().setAttribute("msg", "성공적으로 회원정보를 수정했습니다.");
				request.getSession().setAttribute("loginUser", updateMember);
				response.sendRedirect(request.getContextPath()+"/views/myPage/myPageHome.jsp");
				
			}else {
				request.setAttribute("msg", "회원정보 수정에 실패했습니다.");
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
