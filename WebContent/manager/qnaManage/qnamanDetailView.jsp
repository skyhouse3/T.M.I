<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Qna.model.*,java.util.*"%>
<%
	Qna q = (Qna) request.getAttribute("qna");
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
.col_one_third{
float:left;
margin-left:auto;
width:100%;

}
.left{
float:left;
width:40%;
height:100%;
margin:auto;
}
.center{
float:left;
width:20%;
height:100%;
margin:auto;
}
.container{
text-align:center;
width:80%;
}
.postcontent{
text-align:left;
width:100%;
}
.clearfix{
text-align:left;}
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
					class="promo promo-light promo-full header-stick nobottommargin" style="text-align:left;">
					<div class="container clearfix">
						<h3>관리자 페이지입니다.</h3>
						<span>현재 페이지에서는 문의내용 답변과 조회를 진행할 예정입니다.</span>
					</div>
				</div>
				<!-- End Promo -->
				<section id="content">

					<div class="section content-wrap notopmargin nobottommargin bgcolor-grey" id="boody">

						<div class="container clearfix">

							<!-- Postcontent
                            ============================================= -->
							<div class="postcontent nobottommargin">

								<h3>답변하기</h3>

								<div id="contact-form-result" data-notify-type="success"
									data-notify-msg="<i class=icon-ok-sign></i> Message Sent Successfully!"></div>

								<form class="nobottommargin" id="template-contactform"
									name="template-contactform" action="include/sendemail.php"
									method="post">

									<div class="form-process"></div>
									
									<div class="col_one_third">
										<div class="left">
										<label>제목</label> <input
											type="text" id="template-contactform-name"
											value="<%=q.getOtitle()%>"
											class="sm-form-control required" readonly />
										</div>
										<div class="center">
										<button style="visibility:hidden;"></button>
										</div>
										<div class="left">
										<label for="template-contactform-name">작성자</label> <input
											type="text" id="template-contactform-name"
											value="<%=q.getUserId()%>"
											class="sm-form-control required" readonly />
										</div>
									</div>

									<div class="col_full">
										<label for="template-contactform-message">작성내용</label>
										<textarea class="required sm-form-control"
											id="template-contactform-message"
											name="template-contactform-message" rows="6" cols="30"
											readonly><%=q.getOcontent()%></textarea>
									</div>

									<div class="col_full">
										<label for="template-contactform-message">답변내용</label>
										<textarea class="required sm-form-control"
											id="answer"
											name="template-contactform-message" rows="6" cols="30"><%if(q.getOanswer()!= null){%><%=q.getOanswer()%><%}else{%>작성된 내용이 없습니다.<%}%></textarea>
											
									</div>

									<div class="col_full hidden">
										<input type="text" id="template-contactform-botcheck"
											name="template-contactform-botcheck" value=""
											class="sm-form-control" />
									</div>
									<div class="col_full">
										<button class="btn button nomargin" type="button" onclick="Answer('<%= q.getOnum() %>');">답변하기</button>
									</div>
								</form>
								<script>
									function Answer(id){
										var answer = $('#answer').val();
										location.href="<%= contextPath %>/answer.qna?qid=" + id + "&answer=" + answer;
									}
								</script>
							</div>
							<!-- .postcontent end -->
						</div>
					</div>
				</section>
				<!-- #content end -->
			</div>
			<!-- #wrapper end -->
			</section>
			<!-- Go To Top
    ============================================= -->
			<div id="gotoTop" class="icon-angle-up"></div>

			<!-- Footer Scripts
    ============================================= -->
			<script type="text/javascript" src="js/functions.js"></script>
</body>
</html>
