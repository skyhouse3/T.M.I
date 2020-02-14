package joinPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import joinPage.model.service.JoinService;
import joinPage.model.vo.Join;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert.jo")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
	      
	      Join j = new Join(UserId, Userpw, PWHINT, HINT, Username, gender, Birth, Phone,  Email, Address, Favorite);
	      
	      System.out.println(j);
	      
	      int result = new JoinService().insertMember(j);
	      
	      if(result > 0) {
	         request.getSession().setAttribute("msg", "회원가입에 성공하였습니다.");
	         response.sendRedirect(request.getContextPath());
	      } else {
	         request.setAttribute("msg", "회원가입에 실패하였습니다.");
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
