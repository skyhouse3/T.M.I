package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;

@WebServlet(name = "mreply.modi", urlPatterns = { "/mreply.modi" })
public class MovieReplyModifiedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieReplyModifiedServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mrid=request.getParameter("mrid");
		String content=request.getParameter("content");
		int modifiedSucusses=new MovieService().modifiedReplyMovie(mrid,content);
		response.setContentType("application/json; charset=utf-8");
		
        String print="변경 성공!";
		/*System.out.println("modifiedSucusses : "+modifiedSucusses);*/
		
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
            out.print(print);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
