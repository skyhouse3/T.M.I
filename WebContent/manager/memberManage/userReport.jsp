<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, Member.model.vo.*, Board.model.*, basket.model.vo.*"%>
<%
	ArrayList<RpReport> rlist = (ArrayList<RpReport>) request.getAttribute("rlist");
	ArrayList<BoReport> blist = (ArrayList<BoReport>) request.getAttribute("blist");
	ArrayList<Reply> pdr = (ArrayList<Reply>)request.getAttribute("pdr");
	String mem = (String) request.getAttribute("mnum");
	String contextPath = request.getContextPath();
	for(BoReport b : blist){
		System.out.println(b);
	}
	System.out.println(mem);
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

.tableArea {
	text-align: center;
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
						<h4>신고받은 댓글</h4>
						<table id="table">
							<tr>
								<th width=30%>회원명</th>
								<th width=30%>댓글내용</th>
								<th width=30%>신고자</th>
							</tr>
							<%
								if (!rlist.isEmpty()) {
									for (RpReport list : rlist) {
										if (list.getWriter().equals(mem)) {
							%>
							<tr>
								<td><%=list.getWriter()%></td>
								<td><%=list.getRnum()%></td>
								<td><%=list.getReporter()%></td>
							</tr>
							<%
								}
							%>

							<%
								}
							%>
							<%
								} else {
							%>
							<tr>
								<td colspan="5">조회된 리스트가 없습니다.</td>
							</tr>
							<%
								}
							%>

						</table>
					</div>

					<div class="tableArea">
						<h4>신고빋은 게시글</h4>
						<table id="table">
							<tr>
								<th width=30%>회원명</th>
								<th width=30%>게시글번호</th>
								<th width=30%>신고자</th>
							</tr>
							<%
								if (!blist.isEmpty()) {
									for (BoReport list : blist) {
										if (list.getWriter().equals(mem)) {
							%>
							<tr>
								<td><%=list.getWriter()%></td>
								<td><a href="<%=request.getContextPath()%>/bodetailman.bt?bnum=<%=list.getBnum()%>"><%=list.getBnum()%></a></td>
								<td><%=list.getReporter()%></td>
							</tr>
							<%
								}
							%>

							<%
								}
							%>
							<%
								} else {
							%>
							<tr>
								<td colspan="5">조회된 리스트가 없습니다.</td>
							</tr>
							<%
								}
							%>
						</table>
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
