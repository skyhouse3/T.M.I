package moneyManage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moneyManage.model.conRate;
import moneyManage.model.movRate;
import moneyManage.model.paydate;
import moneyManage.service.MoneyService;



/**
 * Servlet implementation class moneyMain
 */
@WebServlet("/moneyman.mm")
public class moneyMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public moneyMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MoneyService mService = new MoneyService();
		ArrayList<paydate> pd = mService.paycategory();
		ArrayList<movRate> mr = mService.movcategory();
		ArrayList<conRate> cr = mService.concategory();
		RequestDispatcher view = request.getRequestDispatcher("manager/moneyManage/moneyManage.jsp");
		request.setAttribute("pd", pd);
		request.setAttribute("mr", mr);
		request.setAttribute("cr", cr);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
