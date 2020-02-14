package movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.model.service.MovieService;
import movie.model.vo.Reply;

@WebServlet("/insertMovieReply.mo")
public class MovieReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieReplyInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer=request.getParameter("writer");
		String mcode = request.getParameter("mcode");
		String content=request.getParameter("content");
		
		Reply r = new Reply();
		r.setRwriter(writer);
		r.setMcode(mcode);
		r.setReply_level("1");
		r.setRcontent(content);
		
		ArrayList<Reply> mrlist= new MovieService().insertMovieReply(r);

		response.setContentType("application/json; charset=utf-8"); 
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(mrlist,response.getWriter());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
