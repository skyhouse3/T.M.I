<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Service.model.*,java.util.*"%>
<%
	Service s = (Service) request.getAttribute("Question");
	String mem = (String) request.getAttribute("mem");
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

<title>문의내역</title>

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

.container clearfix {
	margin-left: auto;
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

#id {
	display: none;
}

#btnplace {
	text-align: right;
	width: 100%;
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
			<section id="content">

				<div
					class="section content-wrap notopmargin nobottommargin bgcolor-grey"
					id="boody">

					<div class="container clearfix">

						<div class="postcontent nobottommargin">

							<h3>문의내용</h3>

							<div id="contact-form-result" data-notify-type="success"
								data-notify-msg="<i class=icon-ok-sign></i> Message Sent Successfully!"></div>

							<form class="nobottommargin" id="template-contactform"
								name="template-contactform" action="include/sendemail.php"
								method="post">

								<div class="form-process"></div>

								<div class="col_one_third">
									<div class="left">
										<label>제목</label> <input type="text"
											id="title"
											class="sm-form-control required"/>
									</div>
									<div class="center">
										<button style="visibility: hidden;"></button>
									</div>
									<div class="left">
										<label for="template-contactform-name">작성자</label> <input
											type="text" id="userId"
											value="<%=mem%>" class="sm-form-control required"
											readonly />
									</div>
								</div>

								<div class="col_full">
									<label for="template-contactform-message">작성내용</label>
									<textarea class="required sm-form-control" id="userContent"
										name="template-contactform-message" rows="6" cols="30"></textarea>
								</div>
								<div class="col_full">
									<label for="template-contactform-message">답변내용</label>
									<textarea class="required sm-form-control" id="answer"
										name="template-contactform-message" rows="6" cols="30"
										readonly></textarea>

								</div>
								<div class="col_full hidden">
									<input type="text" id="template-contactform-botcheck"
										name="template-contactform-botcheck" value=""
										class="sm-form-control" />
								</div>
								<div id="btnplace">
									<button class="btn button nomargin" type="button"
										name="template-contactform-submit" onclick="insertservice();">수정하기</button>
								</div>
								</form>
						</div>
						<script>
									function insertservice(){
										var title = $("#title").val();
										var userid = $("#userId").val();
										var content = $('#userContent').val();
										location.href="<%=contextPath%>/insertsev.sv?title="+title+"&userid="+userid+"&content="+content;
									}
						</script>
					</div>
				</div>
				</section>
		</div>
	</section>


	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript" src="js/functions.js"></script>
</body>
</html>