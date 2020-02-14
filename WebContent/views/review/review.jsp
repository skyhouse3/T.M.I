<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, review.model.vo.*"%>
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	String mem = (String)request.getAttribute("mem");
	String contextPath = request.getContextPath();
	Review result = (Review)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<style>

td {
	height: 50px;
	text-align: center;
	border-bottom: 1px solid gray;
}

th {
	text-align: center;
	border-bottom: 2px solid gray;
}

#listArea {
	text-align: center;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

.poster  ul {
	padding:10%;
	margin-left:15%;
}

.poster  ul li {
	list-style-type: none;
}
#right{
	margin:auto;
	width:80%;
	text-align : right;
}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>
	
	<section id="content">
		<div class="poster">
			<ul>
				<li>
				<img src="<%= request.getContextPath() %>/resources/img/review/1.jpg" width="15.1%">
				<img src="<%= request.getContextPath() %>/resources/img/review/2.jpg" width="15%">
				<img src="<%= request.getContextPath() %>/resources/img/review/3.jpg" width="14.8%">
				<img src="<%= request.getContextPath() %>/resources/img/review/4.jpg" width="15.1%">
				<img src="<%= request.getContextPath() %>/resources/img/review/5.jpg" width="15.1%">
				<br>
				<img src="<%= request.getContextPath() %>/resources/img/review/6.jpg" width="15.1%">
				<img src="<%= request.getContextPath() %>/resources/img/review/7.jpg" width="15.1%">
				<img src="<%= request.getContextPath() %>/resources/img/review/8.jpg" width="14.6%">
				<img src="<%= request.getContextPath() %>/resources/img/review/9.jpg" width="15.1%">
				<img src="<%= request.getContextPath() %>/resources/img/review/10.jpg" width="15%"></li>
			</ul>
		</div>

		
		<!-- 불러온 리스트 보여주기 -->
		<div id="Area">
			<table id="listArea">
				<tr>
					<th width="100">글번호</th>
					<th width="100">영화</th>
					<th width="100">글제목</th>
					<th width="100">별점</th>
					<th width="150">작성일</th>
				</tr>
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<% } else { %>
					<% for(Review r : list) {%>
					<tr>
						<td><%= r.getRnum() %></td>
						<td><%= r.getMcode() %></td>
						<td><a href="<%=request.getContextPath()%>/detail.re?rnum=<%=r.getRnum()%>&mem=<%=mem%>"><%=r.getRtitle() %></a></td>
						<td><%= r.getRrate() %></td>
						<td><%= r.getMrvDate() %></td>
					</tr>
					<% } %>
				<% } %>		
			</table>
			<div id="right">
			<br>
		<button class="btn btn-secondary" id="insertBtn" onclick="location.href='<%= contextPath %>/movie.li?mem=<%=mem%>'">작성하기</button>
		</div>
		</div>
	</section>

		<div class="pagingArea" align="center">
			<button class="btn btn-secondary" onclick="location.href='<%= contextPath %>/list.re?currentPage=1'"> &lt;&lt; </button>
			<% if(currentPage == 1){ %>
				<button class="btn btn-secondary" disabled> &lt; </button>
			<% } else { %>
				<button class="btn btn-secondary" onclick="location.href='<%= contextPath %>/list.re?currentPage=<%= currentPage - 1 %>'"> &lt; </button>
			<% } %>
			<% for(int p = startPage; p <= endPage; p++){ %>
				<% if(p == currentPage){ %>
					<button class="btn btn-secondary" disabled> <%= p %> </button>
				<% } else { %>
					<button class="btn btn-secondary" onclick="location.href='<%= contextPath %>/list.re?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			<% if(currentPage == maxPage){ %>
				<button class="btn btn-secondary" disabled> &gt; </button>
			<% } else { %>
				<button class="btn btn-secondary" onclick="location.href='<%= contextPath %>/list.re?currentPage=<%= currentPage + 1 %>'"> &gt; </button>
			<% } %>
			<button class="btn btn-secondary" onclick="location.href='<%= contextPath %>/list.re?currentPage=<%= maxPage %>'"> &gt;&gt; </button>
		</div>
		<br>
		
		
	 <%@include file ="../common/footer.jsp" %>
</body>
</html>