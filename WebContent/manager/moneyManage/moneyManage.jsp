<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,moneyManage.model.*"%>
<%
	ArrayList<paydate> list = (ArrayList<paydate>) request.getAttribute("pd");
	ArrayList<movRate> mlist = (ArrayList<movRate>) request.getAttribute("mr");
	ArrayList<conRate> clist = (ArrayList<conRate>) request.getAttribute("cr");
	String contextPath = request.getContextPath();
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int[] month = new int[12];
	for (int i = 0; i <= 11; i++) {
		month[i] = i + 1;
	}
	int[] count = new int[12];
	System.out.println(count);
	for (paydate s : list) {
		int cate = s.getCategory();
		if (cate == 1) {
			a = a + s.getMoney();
		} else if (cate == 2) {
			b = b + s.getMoney();
		} else if (cate == 3) {
			c = c + s.getMoney();
		} else {
			d = d + s.getMoney();
		}
	}

	for (conRate con : clist) {
		for (int i = 0; i <= 11; i++) {
			if (month[i] == con.getMonth()) {
				count[i] = count[i] + 1;
			}
		}
	}
	Calendar now = Calendar.getInstance();
	int nowmonth = now.get(Calendar.MONTH);
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
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

    // Load Charts and the corechart and barchart packages.
    google.charts.load('current', {'packages':['corechart']});

    // Draw the pie chart and bar chart when Charts is loaded.
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data1 = new google.visualization.DataTable();
      data1.addColumn('string', 'Topping');
      data1.addColumn('number', 'Slices');
      data1.addRows([
    	<%if (nowmonth >= 5) {%>
    		['<%=nowmonth - 3%>월', <%=count[nowmonth - 5]%>],
            ['<%=nowmonth - 2%>월', <%=count[nowmonth - 4]%>],
            ['<%=nowmonth - 1%>월', <%=count[nowmonth - 3]%>],
            ['<%=nowmonth%>월', <%=count[nowmonth - 2]%>],
            ['<%=nowmonth + 1%>월', <%=count[nowmonth - 1]%>]
    	<%} else if (nowmonth >= 4) {%>
        ['<%=nowmonth - 2%>월', <%=count[nowmonth - 4]%>],
        ['<%=nowmonth - 1%>월', <%=count[nowmonth - 3]%>],
        ['<%=nowmonth%>월', <%=count[nowmonth - 2]%>],
        ['<%=nowmonth + 1%>월', <%=count[nowmonth - 1]%>]
    	<%} else if (nowmonth >= 3) {%>
        ['<%=nowmonth - 1%>월', <%=count[nowmonth - 3]%>],
        ['<%=nowmonth%>월', <%=count[nowmonth - 2]%>],
        ['<%=nowmonth + 1%>월', <%=count[nowmonth - 1]%>]
    	<%} else if (nowmonth >= 2) {%>
            ['<%=nowmonth - 1%>월', <%=count[nowmonth - 1]%>],
            ['<%=nowmonth%>월', <%=count[nowmonth]%>]
    	<%} else {%>
        ['<%=nowmonth%>월', <%=count[nowmonth]%>]
    	<%}%>
      ]);

      var data2 = new google.visualization.DataTable();
      data2.addColumn('string', 'Topping');
      data2.addColumn('number', 'Slices');
      data2.addRows([
        ['1분기', <%=d%>],
        ['2분기', <%=c%>],
        ['3분기', <%=b%>],
        ['4분기', <%=a%>]
      ]);
      var data3 = new google.visualization.DataTable();
      data3.addColumn('string', 'Topping');
      data3.addColumn('number', 'Slices');
      data3.addRows([
    	  <%for (movRate m : mlist) {%>
  	  	['<%=m.gettitle()%>',<%=m.getRate()%>],
  	  <%}%>
        ['etc', 0]
      ]);

      var piechart_options = {title:'영화별 예매율',
                     width:400,
                     height:300};
      var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
      piechart.draw(data3, piechart_options);

      var barchart_options = {title:'기간별 접속자수',
                     width:400,
                     height:300,
                     legend: 'none'};
      var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
      barchart.draw(data1, barchart_options);

      var barchart_options = {title:'분기별 매출',
                     width:400,
                     height:300,
                     legend: 'none'};
      var barchart2 = new google.visualization.BarChart(document.getElementById('barchart_div2'));
      barchart2.draw(data2, barchart_options);
    }
    </script>

<title>Home | Chocolat</title>

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
				<!-- End Promo -->
				<section id="content">
					<div class="chart" id="barchart_div"></div>
					<div class="chart" id="barchart_div2"></div>
					<div class="chart" id="piechart_div"></div>
					<div class="chart" id="barchart_div_btn">
						<a href="<%=contextPath%>/conrate.cr?cate=m"
							class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright">
							<span>접속자수 상세보기</span>
						</a>
					</div>
					<div class="chart" id="barchart_div_btn">
						<a href="<%=contextPath%>/payrate.pr?cate=f"
							class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright">
							<span>매출액 상세보기</span>
						</a>
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
