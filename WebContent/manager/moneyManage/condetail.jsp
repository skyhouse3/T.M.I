<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,moneyManage.model.*"%>
<%
	ArrayList<conRate> clist = (ArrayList<conRate>) request.getAttribute("cr");
	ArrayList<conRateDetail> cdlist = (ArrayList<conRateDetail>) request.getAttribute("crd");
	String contextPath = request.getContextPath();
	ArrayList<conRate> yearver = null;
	ArrayList<conRate> monver = null;
	int[] years = new int[10];
	int[] ycount = new int[10];
	int[] months = new int[12];
	int[] mcount = new int[12];
	Calendar now = Calendar.getInstance();
	for (int i = 0; i <= 11; i++) {
		months[i] = i + 1;
	}
	for (int i = 0; i <= 9; i++) {
		years[i] = now.get(Calendar.YEAR) - 9 + i;
	}
	if(cdlist == null){
		for (conRate c : clist) {
			if (c.getMonth() <= 50) {
				for (int i = 0; i <= 11; i++) {
					if (c.getMonth() == months[i]) {
						mcount[i + 1] = mcount[i + 1] + 1;
					}
				}
			} else {
				for (int i = 0; i <= 9; i++) {
					if (c.getMonth() == years[i]) {
						ycount[i] = ycount[i] + 1;
						System.out.println(ycount[i]);
					}
				}
			}
		}
	}
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


<title>Home | Chocolat</title>

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

#table {
	text-align: center;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

.linkbtn {
	width: 50%;
	margin-left: auto;
}

.chart {
	width: 30%;
	margin: auto;
	float: left;
	text-align: center;
}
#part{
	width:100%;
	height:30%;
}
#left{
	width:10%;
	height:100%;
	float:left;
}
#right{
	width:90%;
	height:100%;
	float:left;
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
						<span>현재 페이지에서는 매출 관리를 진행할 예정입니다.</span>
					</div>
				</div>
				<div class="content-wrap">
					<%if(cdlist == null){ %>
					<div class="tableArea" id="right">
						<table id="table">
							<tr>
								<th width=50%>범례</th>
								<th width=50%>인원</th>
							</tr>	
								<%if(clist.get(0).getMonth()>=50) {%>
									<% for (int i = 0; i <= 9; i++) {%>
									<tr><td><%=years[i]%>년</td><td><%=ycount[i]%></td></tr>
									<%} %>	
									<%}else{%>
									<% for (int i = 0; i <= 11; i++) {%>
									<tr><td><%=months[i]%>월</td><td><%=mcount[i]%></td></tr>
									<%} %>	
								<%}%>
						</table>
					</div>
					<%} %>
					<%if(clist == null){ %>
					<div class="tableArea" id="right">
						<table id="table">
							<tr>
								<th width=30%>접속번호</th>
								<th width=30%>접속자 ID</th>
								<th width=30%>접속일</th>
							</tr>	
							<%for(conRateDetail b : cdlist){%>
							<tr>
								<td><%=b.getConrateNum()%></td>
								<td><%=b.getUser_id()%></td>
								<td><%=b.getCondate()%></td>
							</tr>
							<%} %>
						</table>
					</div>
					<%}%>
					<div id="left">
					<div id="part">
					<a href="<%=contextPath%>/conrate.cr?cate=d"
					class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
					class="icon-angle-left"></i><span>일별로 조회</span></a>
					</div>
					<div id="part">
					<a href="<%=contextPath%>/conrate.cr?cate=m"
					class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
					class="icon-angle-left"></i><span>월별로 조회</span></a>
					</div>
					<div id="part">
					<a href="<%=contextPath%>/conrate.cr?cate=y"
					class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
					class="icon-angle-left"></i><span>연별로 조회</span></a>
					</div>
					</div>
				</div>
			</div>
		</section>
		<!-- #content end -->
	</div>
	<!-- #wrapper end -->
	<script>
		
	</script>
	<!-- Go To Top
    ============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- Footer Scripts
    ============================================= -->
	<script type="text/javascript" src="js/functions.js"></script>
</body>
</html>
