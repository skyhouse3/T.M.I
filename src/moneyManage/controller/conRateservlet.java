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
import moneyManage.model.conRateDetail;
import moneyManage.service.MoneyService;

/**
 * Servlet implementation class conRateservlet
 */
@WebServlet("/conrate.cr")
public class conRateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public conRateservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MoneyService mService = new MoneyService();
		String cate = request.getParameter("cate");
		ArrayList<conRateDetail> crd = null;
		crd = new ArrayList<conRateDetail>();
		ArrayList<conRate> cr = null;
		cr = new ArrayList<conRate>();
		RequestDispatcher view = request.getRequestDispatcher("manager/moneyManage/condetail.jsp");
		if (cate.equals("d")) {
			crd = mService.concateddetail();
			cr = null;
		} else {
			cr = mService.concategorydetail(cate);
			crd = null;
		}
		request.setAttribute("crd", crd);
		request.setAttribute("cr", cr);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
