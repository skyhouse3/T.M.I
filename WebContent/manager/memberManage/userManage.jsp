<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, Member.model.vo.*"%>
<%
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
	ArrayList<RpReport> rlist = (ArrayList<RpReport>) request.getAttribute("rlist");
	ArrayList<BoReport> blist= (ArrayList<BoReport>) request.getAttribute("blist");
	PageInfo pi = (PageInfo) request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	String contextPath = request.getContextPath();
%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html dir="ltr" lang="ko">
<head>

<meta name="description" content="Bootstrap 3 Website Template" />

<!-- Stylesheets
    ============================================= -->
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon/favicon-16x16.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="images/favicon/favicon-32x32.png">
<link
	href="http://fonts.googleapis.com/css?family=PT+Sans:300,400,500,600,700"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/dark.css" type="text/css" />
<link rel="stylesheet" href="css/font-icons.css" type="text/css" />
<link rel="stylesheet" href="css/animate.css" type="text/css" />
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />

<link rel="stylesheet" href="css/responsive.css" type="text/css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/plugins.js"></script>

<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script type="text/javascript"
	src="include/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript"
	src="include/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

<!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
<link rel="stylesheet" type="text/css"
	href="include/rs-plugin/css/settings.css" media="screen" />

<title>사용자 관리 페이지</title>

<style>
#mleft {
	text-align: left;
}

#mright {
	text-align: right;
}

#movbarboard {
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

.movbtn {
	margin: 3px;
}

#movbar {
	width: 50%;
	text-align: center;
	float: left;
}

td {
	height: 50px;
	text-align: center;
	border-bottom: 1px solid gray;
}

th {
	text-align: center;
	border-bottom: 2px solid gray;
}

#table {
	text-align: center;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

.revo-slider-emphasis-text {
	font-size: 70px;
	font-weight: 700;
	letter-spacing: 0px;
	padding: 15px 20px;
	border-top: 2px solid #FFF;
	border-bottom: 2px solid #FFF;
}

.revo-slider-desc-text {
	font-size: 26px;
	width: 650px;
	text-align: center;
	line-height: 1.5;
}

.revo-slider-caps-text {
	font-size: 30px;
	font-weight: 400;
}

.tparrows.preview2 .tp-arr-titleholder {
	text-transform: uppercase;
	font-weight: bold;
}
</style>

</head>

<body class="stretched">

	<!-- Document Wrapper
    ============================================= -->
	<div id="wrapper" class="clearfix">

		<%@include file ="../managerbar.jsp"%>


		<!-- Content
        ============================================= -->
		<section id="content">
			<div class="content-wrap">

				<!-- Promo -->
				<div
					class="promo promo-light promo-full header-stick nobottommargin">
					<div class="container clearfix">
						<h3>관리자 페이지입니다.</h3>
						<span>현재 페이지에서는 회원의 정보를 관리할 수 있도록 조치할 예정입니다.</span>
					</div>
				</div>
				<!-- End Promo -->
				<div class="content-wrap">
					<br>
					<div class="tableArea">
						<table id="table">
							<tr>
								<th width=20%>회원명</th>
								<th width=15%>회원등급</th>
								<th width=15%>회원활동</th>
								<td width=15%>신고누적</td>
								<th colspan="2" width=35%>제제사항</th>
							</tr>
							<%
								if (list.isEmpty()) {
							%>
							<tr>
								<td colspan="5">조회된 리스트가 없습니다.</td>
							</tr>
							<%
								} else {
							%>
							<%
								for (Member m : list) {
							%>
							<tr>
								<td><%=m.getMemId()%></td>
								<td><button onclick="down('<%=m.getMemId()%>','d')">▼</button> <%=m.getMvp()%> <button onclick="up('<%=m.getMemId()%>','u')">▲</button></td>
								<td><a href="<%=request.getContextPath()%>/manmanagedetail.mm?mnum=<%=m.getMemId()%>"><%=m.getMemId()%>의 활동기록</a></td>
								<%	int j =0;
									for(RpReport li : rlist){
										if(li.getWriter().equals(m.getMemId())){
											j++;
										}
									}
									for(BoReport li : blist){
										if(li.getWriter().equals(m.getMemId())){
											j++;
										}
									} 
									
								%>
								<td><a href="<%=request.getContextPath()%>/manmanagereport.mm?mnum=<%=m.getMemId()%>"><%= j %></a></td>
								<%
									if (m.getPunish() != null) {
								
									int i = sf.format(nowTime).compareTo(sf.format(m.getPunish()));
								
									if (i > 0) {
								%>
								<td><%=m.getPunish() %>에 정지가 해제되었습니다.</td>
								<td><button type="button"
										onclick="adaystop('<%=m.getMemId()%>');">영구정지</button></td>
								<%
									} else {
								%>
								<td><%=m.getPunish()%></td>
								<td><button type="button"
										onclick="pcancel('<%=m.getMemId()%>');">정지취소</button> <%}%>
							 <%} else { %>
								<td><button type="button"
										onclick="fdaystop('<%=m.getMemId()%>');">5일정지</button></td>
								<td><button type="button"
										onclick="adaystop('<%=m.getMemId()%>');">영구정지</button></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<%
								}
							%>
						</table>
						<script>
						function down(id,set){
							var mid = id;
							var set = set;
							location.href="<%=contextPath%>/mvpc.m?mid=" + mid + "&set=" + set;
						}
						function up(id,set){
							var mid = id;
							var set = set;
							location.href="<%=contextPath%>/mvpc.m?mid=" + mid + "&set=" + set;
						}
						function pcancel(id){
							var mid = id;
							location.href="<%=contextPath%>/cancel.p?mid=" + mid;
						}
						function fdaystop(id){
							var mid = id;
							location.href="<%=contextPath%>/fday.f?mid=" + mid;
						}
						function adaystop(id){
							var mid = id;
							location.href="<%=contextPath%>/aday.a?mid="+ mid;
							}
						</script>
						<div class="pagingArea" align="center">
							<!--  맨 처음으로 (<<) -->
							<a href="<%=contextPath%>/manmanage.mc?currentPage=1"
								class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
								class="icon-angle-left"></i><span>처음으로</span></a>

							<!-- 이전 페이지로(<) -->
							<%
								if (currentPage == 1) {
							%>
							<%
								} else {
							%>
							<a
								href="<%=contextPath%>/manmanage.mc?currentPage=<%=currentPage - 1%>"
								class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
								class="icon-angle-left"></i><span>이전</span></a>
							<%
								}
							%>
							<%
								if (currentPage == maxPage) {
							%>
							<%
								} else {
							%>
							<a
								href="<%=contextPath%>/manmanage.mc?currentPage=<%=currentPage + 1%>"
								class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
								class="icon-angle-right"></i><span>다음</span></a>
							<%
								}
							%>
							<a href="<%=contextPath%>/manmanage.mc?currentPage=<%=maxPage%>"
								class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
								class="icon-angle-right"></i><span>끝으로</span></a>
						</div>
					</div>
				</div>
			</div>




		</section>
		<!-- #content end -->

	</div>
	<!-- #wrapper end -->

	<!-- Go To Top
    ============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- Footer Scripts
    ============================================= -->
	<script type="text/javascript" src="js/functions.js"></script>

</body>
</html>
