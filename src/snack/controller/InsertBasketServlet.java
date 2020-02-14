package snack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.model.vo.SkBasket;
import joinPage.model.vo.Join;
import snack.model.service.SnackService;

/**
 * Servlet implementation class InsertBasketServlet
 */
@WebServlet("/InsertBasket.sn")
public class InsertBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String Ccode = request.getParameter("Ccode");
		String kinds = request.getParameter("kinds");
		System.out.println(kinds);
		System.out.println(Ccode);
		String skCode = request.getParameter("skCode");
		int skQuantity = Integer.parseInt(request.getParameter("skQuantity"));
		Join loginUser = (Join)request.getSession().getAttribute("loginUser");
		String User_Id = String.valueOf(loginUser.getUser_Id());
		
		SkBasket skB = new SkBasket(skCode,skQuantity,User_Id);
		
		int result = new SnackService().insertskBasket(skB);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/SnackList.sn?Ccode="+Ccode+"&kinds="+kinds);
			
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
