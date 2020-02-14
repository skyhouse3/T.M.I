<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, movie.model.vo.*, attachment.model.vo.*, common.model.*"%>
<%
	ArrayList<Movie> mlist = (ArrayList<Movie>) request.getAttribute("movieList");
	ArrayList<Attachment> mplist = (ArrayList<Attachment>) request.getAttribute("imgFileList"); //2019-11-01 23:35 작업끝

	String[] actor = null;

	PageInfo pi = (PageInfo) request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css"
	type="text/css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style>
.table .text {
	position: relative;
}

.table .text span {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	position: absolute;
	width: 100%;
}

.text:before {
	content: '';
	display: inline-block;
}
</style>
</head>
<body>
	<!-- menu  -->
	<%@include file="../common/menubar.jsp"%>
	<br>
	<br>
	<!-- menu End  -->
	<div class="container">
		<h1 align="center">상영 예정 영화</h1>
		<!-- 관리자 권한 -->
		<%if(loginUser.getUser_Id().equals("admin")) {%>
		<span>
			<button type="button" class="btn btn-info" onclick="InsertMovie();">추가</button>
		</span>
		<%} %>
		<!-- 관리자 권한 -->
		<hr>
		<div class="container">
			<div class="row">
				<!-- movie -->
				<!-- movie -->
				<%
					for (Movie b : mlist) {
				%>
				<div class="col-4 float-left movie-thumb-list">
					<div class="card">
						<%-- <input type="hidden" value="<%=b.getMcode() %>"/> --%>
						<%
							for (Attachment at : mplist) {
						%>
						<%
							if (b.getMcode().equals(at.getmCode())) {
						%>
						<img
							src="<%=request.getContextPath()%>/resources/MovieImg_upload/<%=at.getChangeName()%>"
							alt="" class="card-img-top" />
						<%
							}
						%>
						<%
							}
						%>
						<div class="card-body">
							<h5 class="card-title"><%=b.getMtitle()%></h5>
							<p class="card-text">
								<!-- table-area -->
							<table class="table table-borderless table-responsive">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">감독</th>
										<th scope="col">배우</th>
										<th scope="col">평점</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row"><%=b.getMbcode() %></th>
										<td class="text"><span data-toggle="tooltip"
											data-placement="bottom" title="<%=b.getmDirector()%>"><%=b.getmDirector()%></span></td>
										<%
											actor = b.getmActor().split(",");
										%>
										
										<td class="text"><span data-toggle="tooltip"
											data-placement="bottom" title="<%=b.getmActor()%>"><%=b.getmActor()%></span></td>
										<td><%=b.getRate() %></td>
									</tr>
								</tbody>
							</table>
							<!-- table-area-end  -->
							</p>
							<button id="detail_btn" class="btn btn-info" type="button"
								onclick="location.href='<%=request.getContextPath()%>/detail.mo?mcode=<%=b.getMcode()%>'">자세히
								보기</button>
						<%if(loginUser.getUser_Id().equals("admin")) {%>
						<!-- 삭제하는 영역  -->
						<button type="button" class="btn btn-info" onclick="location.href='<%= request.getContextPath() %>/Delete.mo?mrid='+<%= b.getMcode() %>">삭제</button>
						
						<!-- 끝  -->
						<%} %>
						</div>

					</div>
				</div>
				<%
					}
				%>
				<!-- movie end -->
			</div>
		</div>
	</div>

	<!-- pagination -->
	<div aria-label="Page navigation example" class="container">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#"
				aria-label=""><span aria-hidden="true"
					onclick="location.href='<%=request.getContextPath()%>/list.mo?currentPage=1'">&laquo;&laquo;</span></a>
			</li>
				<% if(currentPage==1){ %>
				<li class="page-item disabled">
					<a class="page-link" href="#" aria-label="Previous">
		                <span aria-hidden="true">&laquo;</span>
		                <span class="sr-only">Previous</span>
	                </a>
				</li>
				
				<% } else { %>
					<li class="page-item">
						<a class="page-link" href="#"aria-label="Previous"> 
							<span aria-hidden="true"onclick="location.href='<%=request.getContextPath()%>/list.mo?currentPage=<%=currentPage - 1%>'">&laquo;</span>
							<span class="sr-only">Previous</span>
						</a>
					</li>
				
				<% }%>
				
				<!-- 페이지 뿌려지는곳  -->
			<!-- 10개의 페이지 목록 -->
			<%System.out.println(endPage); %>
			<% for(int p = startPage; p <= endPage; p++){ 
				 if(p == currentPage){ %>
					<li class="page-item disabled"><a class="page-link" href="#"><%=p %></a></li>
				<% } else { %>
					<li class="page-item">
						<a class="page-link" href="#" onclick="location.href='<%= request.getContextPath() %>/list.mo?currentPage=<%= p %>'"><%=p %></a>
					</li>
				
					<% } %>
			<% } %>
				<!-- 페이지 뿌려지는곳  -->
				
			<%if(currentPage == maxPage){ %>
				<li class="page-item disabled">
					<a class="page-link" aria-label="Next">
		                <span aria-hidden="true">&raquo;</span>
		                <span class="sr-only">Next</span>
	                </a>
				</li>
			<%} else { %>
			
			<li class="page-item">
				<a class="page-link" href="#"aria-label="Next"> 
					<span aria-hidden="true"onclick="location.href='<%=request.getContextPath()%>/list.mo?currentPage=<%= currentPage + 1 %>'">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
			<%} %>
			<li class="page-item"><a class="page-link" href="#"
				aria-label=""><span aria-hidden="true"
					onclick="location.href='<%=request.getContextPath()%>/list.mo?currentPage=<%=maxPage%>'">&raquo;&raquo;</span></a>
			</li>

		</ul>
	</div>
	<!-- pagination end -->

	<script>
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
			/* 영화 추가 삭제 수정  */
			
		});
		function InsertMovie() {
			//console.log("실행 확인");
			location.href="<%=request.getContextPath()%>/views/movie/MovieInsertForm.jsp";
		};
	</script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
	<!-- footbar  -->
	<%@include file="../common/footer.jsp"%>
	<!-- footbar End  -->


</body>
</html>