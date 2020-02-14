package movie.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import attachment.model.vo.Attachment;
import common.MyFileRenamePolicy;
import movie.model.service.MovieService;
import movie.model.vo.Movie;

@WebServlet("/update.rmo")
public class UpdateMovieDetailForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMovieDetailForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "/resources/MovieImg_upload/";
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());
			ArrayList<String> changeFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();

			Enumeration<String> files = multiRequest.getFileNames();
			while (files.hasMoreElements()) {
				// files에 담겨있는 파일 리스트들의 name 값을 반환
				String name = files.nextElement();

				// 해당 파일이 null이 아닌 경우
				if (multiRequest.getFilesystemName(name) != null) {
					// getFilesystemName() - MyRenamePolicy의 rename 메소드에서
					// 작성한대로 rename 된 파일명
					String changeName = multiRequest.getFilesystemName(name);

					// getOriginalFileName() - 실제 사용자가 업로드 할 때 파일명
					String originName = multiRequest.getOriginalFileName(name);

					changeFiles.add(changeName);
					originFiles.add(originName);
				}
			}
			String mcode=multiRequest.getParameter("mrid");
			String mtitle=multiRequest.getParameter("mtitle");
			String mtitleeng=multiRequest.getParameter("mtitleEng");
			String mtitleplot=multiRequest.getParameter("mtitlePlot");
			String plot = multiRequest.getParameter("plot");
			String Stringkinds=multiRequest.getParameter("kinds");
			
			String[] kinds=Stringkinds.split(",");
			
			String director = multiRequest.getParameter("director");
			String actor = multiRequest.getParameter("actor");
			String category=multiRequest.getParameter("category");
			String info=multiRequest.getParameter("info");
			String agecut=multiRequest.getParameter("agecut");
			Date release=Date.valueOf(multiRequest.getParameter("release"));
			String[] url=multiRequest.getParameterValues("url");
			
			Movie m =new Movie();
			m.setMcode(mcode);
			m.setMtitle(mtitle);
			m.setMtitleEng(mtitleeng);
			m.setMtitlePlot(mtitleplot);
			m.setPlot(plot);
			for(String i : kinds) {
				m.setKinds(i);	
			}
			m.setmDirector(director);
			m.setmActor(actor);
			m.setCategory(category);
			m.setInfo(info);
			m.setAgeCut(agecut);
			m.setRelease(release);
			
			ArrayList<Attachment> fileList =new ArrayList<>();
			
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(changeFiles.get(i));
				if(i == originFiles.size()-1) {
					at.setFileLevel("0"); //영화 포스터 0번으로 구분	
				}else{
					at.setFileLevel("1");
				}
				
				fileList.add(at);
			}
			
			
			MovieService mService= new MovieService();
			ArrayList<Attachment> mplist=mService.selectImgList(mcode); 
			System.out.println("Servlet에서의 mplist : "+mplist);
			System.out.println("Servlet에서의 fileList : "+fileList);
			
			mplist.get(0).setOriginName(fileList.get(0).getOriginName());
			mplist.get(0).setChangeName(fileList.get(0).getChangeName());
			mplist.get(0).setFilePath(fileList.get(0).getFilePath());
			mplist.get(0).setFileLevel(fileList.get(0).getFileLevel());

			mplist.get(1).setOriginName(fileList.get(1).getOriginName());
			mplist.get(1).setChangeName(fileList.get(1).getChangeName());
			mplist.get(1).setFilePath(fileList.get(1).getFilePath());
			mplist.get(1).setFileLevel(fileList.get(1).getFileLevel());

			
			int res=mService.updateMovieBoard(m,mplist);
			System.out.println(res);
			if(res > 0) {
				response.sendRedirect("list.mo");
				
			}else {
				// 실패 시 저장된 사진 삭제
				for(int i = 0; i < changeFiles.size(); i++) {
					// 파일 시스템에 저장 된 이름으로 파일 객체 생성함
					File failedFile = new File(savePath + changeFiles.get(i));
					failedFile.delete();
				}
				
				request.setAttribute("msg", "사진 게시판 등록 실패!!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
