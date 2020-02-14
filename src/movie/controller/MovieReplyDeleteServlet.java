package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import joinPage.model.vo.Join;
import movie.model.service.MovieService;


@WebServlet("/mreply.del")
public class MovieReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MovieReplyDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mrid=request.getParameter("mrid");
		int deleteSucusses=new MovieService().deleteReplyMovie(mrid);
		response.setContentType("application/json; charset=utf-8");
		
        String print="삭제 성공!";
		System.out.println("deleteSucusses : "+deleteSucusses);
		
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
            out.print(print);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
