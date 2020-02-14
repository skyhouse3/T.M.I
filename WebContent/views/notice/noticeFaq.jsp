<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, Service.model.Service, question.model.vo.*"%>
<%
	ArrayList<Service> list = (ArrayList<Service>) request.getAttribute("list");
	String mem = (String)request.getAttribute("mem");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
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

<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script type="text/javascript"
	src="include/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript"
	src="include/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

<!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
<link rel="stylesheet" type="text/css"
	href="include/rs-plugin/css/settings.css" media="screen" />

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
#leftside{
	text-align:right;
}
#hiddentext{
	display : none;
}
</style>

</head>

<body class="stretched">

		   <header id="header">
                
            <div id="header-wrap">

                <div class="container clearfix">
                        
                    <div id="primary-menu-trigger"><i class="icon-reorder"></i></div>

                    <!-- Logo
                    ============================================= -->
                    <div id="logo">
                        <a href="<%= request.getContextPath() %>/views/common/MainHome.jsp" class="standard-logo" data-dark-logo="/kh-SemiProject-T.M.I/resources/images/logo/logo-dark.png"><img src="/kh-SemiProject-T.M.I/resources/images/logo1.png"></a>
                    </div>
                    <nav id="primary-menu">

                        <ul class="">
                            <li><a href="#"><div>티켓예매</div></a></li>
                            <li><a href="#"><div>영화</div></a>
                                <ul>
                                    <li><a onclick="goChart();"><div >3사 통합 실시간 영화차트</div></a></li>
                                    <li><a onclick="goPrMovie();"><div>현재 상영 영화정보</div></a>
                                    <li><a href="#"><div>상영예정작</div></a></li>     
                                    <li><a onclick="goReview();"><div>후기</div></a></li>                              
                                </ul>
                            </li>
                            <li><a href="#"><div>스낵스토어</div></a>
                                <ul>
                                	<li><a href="#"><div>CGV</div></a></li>
                                	<li><a href="#"><div>메가박스</div></a></li>
                                    <li><a onclick="goSnacklt();"><div>롯데시네마</div></a></li>
                                </ul>                            
                            </li>                            
                            <li class="current"><a href="<%= request.getContextPath() %>/servicemain.sm?mem=<%=mem%>"><div>고객센터</div></a>
                                <ul>
                                	<li><a href="<%=contextPath%>/list.qu?mem=<%=mem%>"><div>Q&A</div></a></li>
                                    <li><a href="#"><div>공지사항</div></a></li>
                                </ul>                            
                            </li>
                            <li><a href="<%= request.getContextPath() %>/views/myPage/myPageHome.jsp"><div>마이페이지</div></a></li>
                        </ul>
                    </nav><!-- #primary-menu end -->
                </div>

          </div>
          <script>
          
          function goSnacklt(){
  			location.href="<%=request.getContextPath()%>/SnackList.sn";
  		  }
          function goPrMovie(){
        	  location.href="<%=request.getContextPath()%>/list.mo";
          }
          function goReview() {
        	  location.href="<%=request.getContextPath()%>/list.re";
          }
          function goChart(){
        	  location.href="<%=request.getContextPath()%>/clist.mo"
          }
          
          </script>

        </header><!-- #header end -->

		<section id="content">
			<div class="content-wrap">

				<!-- Promo -->
				<div
					class="promo promo-light promo-full header-stick nobottommargin">
					<div class="container clearfix">
						<h3>FAQ</h3>
						<span>궁금하신 사항이 있으면 부담없이 등록해주세요!</span>
					</div>
					<div class="container clearfix" id="leftside">
					<button class="btn button nomargin" type="button"
										name="template-contactform-submit" onclick="ask();">문의하기</button>
					<input type="text" value="<%=mem%>" id="hiddentext">
					</div>
					<script>
						function ask(){
							var mem = $('#hiddentext').val();
							location.href="<%=contextPath%>/insert.sv?sNum=" + mem;
						}
					</script>
				</div>
				<!-- End Promo -->
				<div class="content-wrap">
					<br>
					<div class="tableArea">
						<table id="table">
							<tr>
								<th width=25%>문의 번호</th>
								<th width=25%>문의 제목</th>
								<th width=25%>게시일</th>
								<th width=25%>답변 상황</th>
							</tr>
							<%
								if (list.isEmpty()) {
							%>
							<tr>
								<td colspan="4">조회된 리스트가 없습니다.</td>
							</tr>
							<%
								} else {
							%>
							<%
								for (Service s : list) {
									
							%>
							<tr>
								<td><%=s.getsNum()%></td>
								<td><a href="<%=request.getContextPath()%>/detail.qu?snum=<%=s.getsNum()%>&mem=<%=mem%>"><%=s.getStitle()%></a></td>
								<td><%=s.getSdate()%></td>
								<td><%=s.getStatus()%></td>

							</tr>
							<%		
								}
							%>
							<%
								}
							%>
						</table>
						<div class="pagingArea" align="center">
							<a href="<%=contextPath%>/list.qu?currentPage=1"
								class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
								class="icon-angle-left"></i><span>처음으로</span></a>
							<%
								if (currentPage == 1) {
							%>
							<%
								} else {
							%>
							<a
								href="<%=contextPath%>/list.qu?currentPage=<%=currentPage - 1%>"
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
								href="<%=contextPath%>/list.qu?currentPage=<%=currentPage + 1%>"
								class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
								class="icon-angle-right"></i><span>다음</span></a>
							<%
								}
							%>
							<a href="<%=contextPath%>/list.qu?currentPage=<%=maxPage%>"
								class="button button-light bgcolor-grey-light button-rounded button-reveal button-small button-3d tright"><i
								class="icon-angle-right"></i><span>끝으로</span></a>
						</div>
					</div>
				</div>
			</div>




		</section>
		<!-- #content end -->

	</div>
	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript" src="js/functions.js"></script>

</body>
</html>