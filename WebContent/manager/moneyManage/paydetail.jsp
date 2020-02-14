<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,moneyManage.model.*"%>
<%
	ArrayList<paydatedetail> pd = (ArrayList<paydatedetail>) request.getAttribute("pd");
	String contextPath = request.getContextPath();
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
					<div class="tableArea" id="right">
						<table id="table">
							<tr>
								<th width=30%>결제일</th>
								<th width=30%>고객명</th>
								<th width=30%>결제금액</th>
							</tr>	
							<%for(paydatedetail p : pd){%>
							<tr>
								<td><%=p.getPayday()%></td>
								<td><%=p.getUser_id()%></td>
								<td><%=p.getMoney()%></td>
							</tr>
							<%} %>
						</table>
					</div>

					<div id="left">
					<div id="part">
					<a href="<%=contextPath%>/payrate.pr?cate=f"
					class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
					class="icon-angle-left"></i><span>1분기</span></a>
					</div>
					<div id="part">
					<a href="<%=contextPath%>/payrate.pr?cate=s"
					class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
					class="icon-angle-left"></i><span>2분기</span></a>
					</div>
					<div id="part">
					<a href="<%=contextPath%>/payrate.pr?cate=t"
					class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
					class="icon-angle-left"></i><span>3분기</span></a>
					</div>
					<div id="part">
					<a href="<%=contextPath%>/payrate.pr?cate=fo"
					class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
					class="icon-angle-left"></i><span>4분기</span></a>
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
