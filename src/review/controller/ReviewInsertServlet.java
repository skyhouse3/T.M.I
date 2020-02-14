package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myPage.model.vo.MyPage;
import review.model.service.ReviewService;
import review.model.vo.Review;


/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/insert.re")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mem = request.getParameter("mem");
		String mcode = request.getParameter("mcode");
		String rtitle = request.getParameter("rtitle");
		String rWriter = request.getParameter("mem");
		String rRate = request.getParameter("rRate");
		String charmingpoint = request.getParameter("charmingpoint");
		String director = request.getParameter("director");
		String ost = request.getParameter("ost");
		String actor = request.getParameter("actor");
		String story = request.getParameter("story");
		String beauty = request.getParameter("beauty");
		String rcontent = request.getParameter("rcontent");			
		Review r = new Review();
		r.setMcode(mcode);
		r.setRtitle(rtitle);
		r.setrWriter(rWriter);
		r.setRrate(rRate);
		r.setCharmingPoint(charmingpoint);
		r.setDirector_production(director);
		r.setOST(ost);
		r.setAction_acting(actor);
		r.setStory(story);
		r.setMovie_beauty(beauty);
		r.setRcontent(rcontent);
		System.out.println(r);
		
		int result = new ReviewService().insertReview(r);
		
		if(result > 0) { // 성공
			
			response.sendRedirect(request.getContextPath() + "/list.re?mem="+mem);
			
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
