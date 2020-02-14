<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Board.model.*,java.util.*"%>
<%
	Boardman b = (Boardman) request.getAttribute("board");
	String contextPath = request.getContextPath();
	String mem = (String) request.getAttribute("mem");
	ArrayList<Reply> rlist = (ArrayList<Reply>) request.getAttribute("rlist");
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

.left {
	float: left;
	width: 50%;
	padding: 3%;
	margin-left: auto;
}

.right {
	float: left;
	width: 50%;
	padding: 3%;
	margin-left: auto;
}

.first {
	float: left;
	width: 100%;
	text-align: center;
}

.second {
	float: left;
	width: 100%;
	text-align: center;
}

.third {
	float: left;
	width: 100%;
	text-align: center;
}

.four {
	width: 100%;
	text-align: right;
}

.nobottommargin {
	text-align: center;
}

.postcontent {
	text-align: center;
	width: 100%;
}

.container {
	text-align: left;
}

#replybox {
	width: 100%;
	float: left;
	margin: auto;
	text-align: right;
}

#reply {
	width: 100%;
}

#hidden {
	display: none;
}
#leftside{
	text-align:left;
}
.hidden{
	display: none;
}
</style>

</head>

<body class="stretched">

	<!-- Document Wrapper
    ============================================= -->
	<div id="wrapper" class="clearfix">

		<header id="header">
                
            <div id="header-wrap">

                <div class="container clearfix">
                        
                    <div id="primary-menu-trigger"><i class="icon-reorder"></i></div>

                    <!-- Logo
                    ============================================= -->
                    <div id="logo">
                        <a href="<%= request.getContextPath() %>/views/common/MainHome.jsp" class="standard-logo" data-dark-logo="/kh-SemiProject-T.M.I/resources/images/logo/logo-dark.png"><img src="/kh-SemiProject-T.M.I/resources/images/logo1.png"></a>
                    </div><!-- #logo end -->

                    <!-- Primary Navigation
                    ============================================= -->
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
                                    <li><a href="contact-2.html"><div>문의사항</div></a></li>
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
				<div
					class="promo promo-light promo-full header-stick nobottommargin">
					<div class="container clearfix">
						<h3>Movie review</h3>
					</div>
				</div>
				<section id="content">

					<div
						class="section content-wrap notopmargin nobottommargin bgcolor-grey">

						<div class="container clearfix">
							<input type="text" value="<%=mem %>" id="hidden">
							<div class="postcontent nobottommargin">
							<%if(mem.equals(b.getrWriter())) {%>
								<form class="nobottommargin" id="template-contactform" method="post">
									<div class="first">
									<input type="text" id="rnum" value="<%=b.getRnum()%>" class="hidden">
									<input type="text" id="mcode" value="<%=b.getMcode()%>" class="hidden">
										<div class="right">
											<label for="template-contactform-name">제목</label> <input
												type="text" id="rtitle" value="<%=b.getRtitle()%>"
												class="sm-form-control required" readonly/> <br> <label
												for="template-contactform-name">작성자</label> <input
												type="text" id="rwriter" value="<%=b.getrWriter()%>"
												class="sm-form-control required" readonly/>
										</div>
									</div>

									<div class="second">
										<label for="template-contactform-message">작성내용</label>
										<textarea class="required sm-form-control" id="usercontent" name="template-contactform-message" rows="6" cols="30"><%=b.getRcontent()%></textarea>
									</div>
									<div class="third">
										<div class="left">
											<label for="template-contactform-message">평점</label> <input
												type="text" id="rRate" value="<%=b.getRrate()%>"
												class="sm-form-control required" name="posting" readonly/>
											<label for="template-contactform-message">매력점</label>
											<input type="text" id="charmpoint"
												value="<%=b.getCharmingPoint()%>"
												class="sm-form-control required" name="posting" readonly/>
										</div>
										<div class="right">
											<label for="template-contactform-message">감독점</label> <input
												type="text" id="directerpoint"
												value="<%=b.getDirector_production()%>"
												class="sm-form-control required" name="posting" readonly/>
											<label for="template-contactform-message">OST</label>
											<input type="text" id="OSTpoint" value="<%=b.getOST()%>"
												class="sm-form-control required" name="posting" readonly/>
											<br>
										</div>
										<div class="left">
											<label for="template-contactform-message">연기점</label> <input
												type="text" id="actpoint" value="<%=b.getAction_acting()%>"
												class="sm-form-control required" name="posting" readonly/>
											<label for="template-contactform-message">내용점</label>
											<input type="text" id="storypoint" value="<%=b.getStory()%>"
												class="sm-form-control required" name="posting" readonly/>
											<br>
										</div>
										<div class="right">
											<label for="template-contactform-message">영상미</label> <input
												type="text" id="moviepoint" value="<%=b.getMovie_beauty()%>"
												class="sm-form-control required" name="posting" readonly/>
											<label for="template-contactform-message">작성일</label>
											<input type="text" id="mrvdate" value="<%=b.getMrvDate()%>"
												class="sm-form-control required" name="posting" readonly/>
											<br>
										</div>

									</div>
									<div class="four">
										<button class="btn button nomargin" type="button"
										onclick="updateB('<%=b.getRnum()%>');">수정하기</button>
										<button class="btn button nomargin" type="button"
											onclick="deleteB('<%=b.getRnum()%>');">삭제하기</button>
									</div>
								</form>
							<%} else {%>
							<form class="nobottommargin" id="template-contactform"
									name="template-contactform" action="<%=contextPath%>/insert.bo"
									method="post">
									<input type="text" id="rnum" value="<%=b.getRnum()%>" class="hidden">
									<input type="text" id="mcode" value="<%=b.getMcode()%>" class="hidden">
									<div class="first">
										<div class="right">
											<label for="template-contactform-name">제목</label> <input
												type="text" id="rtitle" value="<%=b.getRtitle()%>"
												class="sm-form-control required" readonly /> <br> <label
												for="template-contactform-name">작성자</label> <input
												type="text" id="rwriter" value="<%=b.getrWriter()%>"
												class="sm-form-control required" readonly />
										</div>
									</div>

									<div class="second">
										<label for="template-contactform-message">작성내용</label>
										<textarea class="required sm-form-control"
											id="template-contactform-message"
											name="template-contactform-message" rows="6" cols="30"
											readonly><%=b.getRcontent()%></textarea>
									</div>
									<div class="third">
										<div class="left">
											<label for="template-contactform-message">평점</label> <input
												type="text" id="rRate" value="<%=b.getRrate()%>"
												class="sm-form-control required" name="posting" readonly />
											<label for="template-contactform-message">매력점</label>
											<input type="text" id="charmpoint"
												value="<%=b.getCharmingPoint()%>"
												class="sm-form-control required" name="posting" readonly />
										</div>
										<div class="right">
											<label for="template-contactform-message">감독점</label> <input
												type="text" id="directerpoint"
												value="<%=b.getDirector_production()%>"
												class="sm-form-control required" name="posting" readonly />
											 <label for="template-contactform-message">OST</label>
											<input type="text" id="OSTpoint" value="<%=b.getOST()%>"
												class="sm-form-control required" name="posting" readonly />
											<br>
										</div>
										<div class="left">
											<label for="template-contactform-message">연기점</label> <input
												type="text" id="actpoint" value="<%=b.getAction_acting()%>"
												class="sm-form-control required" name="posting" readonly />
											 <label for="template-contactform-message">내용점</label>
											<input type="text" id="storypoint" value="<%=b.getStory()%>"
												class="sm-form-control required" name="posting" readonly />
											<br>
										</div>
										<div class="right">
											<label for="template-contactform-message">영상미</label> <input
												type="text" id="moviepoint" value="<%=b.getMovie_beauty()%>"
												class="sm-form-control required" name="posting" readonly />
												<label for="template-contactform-message">작성일</label>
											<input type="text" id="mrvdate" value="<%=b.getMrvDate()%>"
												class="sm-form-control required" name="posting" readonly />
											<br>
										</div>

									</div>
									<div class="four">
										<button class="btn button nomargin" type="button"
											onclick="reportB('<%=b.getRnum()%>');">신고하기</button>
									</div>
								</form>
								<%} %>
								<script>
											function updateB(id){
												var usercontent = $("#usercontent").val();
												var bid = id;
												var mem = $("#rwriter").val();
												location.href="<%=contextPath%>/update.re?bid=" + bid + "&content=" + usercontent+ "&mem=" + mem;
											}
											function deleteB(id){
													var bid = id;
													var mem = $("#rwriter").val();
													location.href="<%=contextPath%>/delete.re?bid=" + bid+"&mem="+mem;
													}
											function reportB(id){
												var bid = id;
												var mem = $("#hidden").val();
												location.href="<%=contextPath%>/report.bo?bid=" + bid+"&mem="+mem;
												}
								</script>
								<div>
									<form class="nobottommargin" id="template-contactform"
										name="template-contactform">
										<h3>댓글 관리</h3>
										<table id="table">
											<tr>
												<th width=20%>글쓴이</th>
												<th width=40%>내용</th>
												<th width=20%>작성일</th>
												<th width=10%></th>
												<th width=10%></th>
											</tr>
											<%
												if (rlist != null) {
											%>
											<%
												for (Reply r : rlist) {
											%>
											<tr>
												<td width="20%"><%=r.getRwriter()%></td>
												<td width="40%"><%=r.getRcontent()%></td>
												<td width="20%"><%=r.getModify_date()%></td>
												<%if(mem.equals(r.getRwriter())) {%>
												<td width="20%"><button type="button"
														onclick="deleteR('<%=r.getRid()%>','<%=b.getRnum()%>','<%=mem%>');">삭제</button></td>
												<%}else{ %>
												<td width="20%"><button type="button"
														onclick="reportR('<%=r.getRid()%>','<%=b.getRnum()%>','<%=mem%>');">신고</button></td>
												<%} %>
											</tr>

											<%
												}
											%>
											<%
												}
											%>
										</table>
										<input type="text" id="hidden" value="<%=mem%>">
										<div id="replybox">
											<textarea class="required sm-form-control" id="reply"
												rows="2" cols="10"></textarea>
											<button type="button" class="btn button nomargin"
												onclick="insertReply()" value="댓글입력">댓글입력</button>
										</div>
										<script>
											function deleteR(Rid,Bid,mem){
													var rid = Rid;
													var mem = mem;
													location.href="<%=contextPath%>/delete.rp?rid="+rid+"&bid="+Bid+"&mem="+mem;
											}
											function reportR(Rid,Bid,mem){
												var rid = Rid;
												var mem = mem;
												location.href="<%=contextPath%>/report.rp?rid="+rid+"&bid="+Bid+"&mem="+mem;
											}
											function insertReply(){
												var Rnum = $("#rnum").val();
												var mcode = $("#mcode").val();
												var Rcontent = $("#reply").val();
												var Rwriter = $("#hidden").val();
												location.href="<%=contextPath%>/insertreply.rp?Rnum="+Rnum+"&mcode="+mcode+"&Rcontent="+Rcontent+"&Rwriter="+Rwriter;
											}
										</script>
									</form>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</section>
		<div id="gotoTop" class="icon-angle-up"></div>
		<script type="text/javascript" src="js/functions.js"></script>
</body>
</html>