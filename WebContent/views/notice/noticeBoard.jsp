<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, question.model.vo.*"%>
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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

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

.accordion {
            background-color: #eee;
            color: #444;
            cursor: pointer;
            padding: 18px;
            width: 100%;
            border: none;
            text-align: left;
            outline: none;
            font-size: 15px;
            transition: 0.4s;
        }
        .accordion2 {
            background-color: #A6A6A6;
            color: #444;
            padding: 18px;
            width: 100%;
            border: none;
            text-align: center;
            outline: none;
            font-size: 15px;
            transition: 0.4s;
        }

        .accordion:hover {
            background-color: #ccc; 
        }

        .panel {
            padding: 0 18px;
            display: none;
            background-color: white;
            overflow: hidden;
        }

</style>

</head>

<body class="stretched">
<%@include file="../common/menubar.jsp"%>

		

		<section id="content">
			<div class="content-wrap">

				<!-- Promo -->
				<div
					class="promo promo-light promo-full header-stick nobottommargin">
					<div class="container clearfix">
						<button class="accordion2"><h3 align="center">공지사항</h3><br>
						<h2><span>공지사항을 꼭 확인해주세요.</span></h2></button>
					</div>
				</div>
				<!-- End Promo -->
				
				<div class="content-wrap">
					<br>
					<div class="tableArea">
						<button class="accordion"><h3 align="center">[CGV 구로] 주차 요금 유인 정산 진행</h3></button>
						<div class="panel">
						<p>안녕하십니까, CGV구로입니다.<br>
						항상 CGV구로를 방문해주시는 고객님들께 깊은 감사의 말씀드립니다.<br>
						주차 무인 정산기 점검으로 해당 기간동안 사전 정산없이 출차 시 유인 정산이 진행됩니다.<br>
						CGV구로 이용 고객님께서는 확인 후 이용에 불편 없으시길 바라며, 고객님의 너그러운 양해를 부탁드립니다.<br>
						■ 기기 점검 기간 : 10/19(토) 자정 ~ 10/27(일), 총 9일간<br>
						■ 주차 정산 방법 : 영화 티켓 소지 후 출차 시, 주차장 입구에서 유인 정산 진행 (모바일 티켓 가능)<br>
						앞으로도 CGV구로 많은 이용 부탁드립니다.<br>
						감사합니다.</p>
						</div>
						<button class="accordion"><h3 align="center">아이폰 앱 예매 서비스 정상 이용 안내</h3></button>
						<div class="panel">
						<p>안녕하세요.<br>
						T.M.I입니다.<br>
						IOS 13.2버전을 이용하시는 고객님의 앱에서 예매 서비스가 11/4일 부로 정상화 되었습니다.<br>
						IOS 13.2버전을 이용하시는 고객님 중 예매가 정상적으로 진행되지 않는 경우,<br>
						기존 앱을 삭제해주시고 최신 버전(3.2.1)으로 재설치 후 이용해주시기 바랍니다.<br>
						그동안 불편을 겪으신 고객님께 양해의 말씀을 드리며, 보다 나은 서비스로 보답하겠습니다.<br>
						감사합니다.</p>
						</div>
						<button class="accordion"><h3 align="center">전산시스템 점검에 따른 서비스 일시 중단 안내</h3></button>
						<div class="panel">
						<p>안녕하세요, T.M.I입니다.<br>
						전산시스템 점검으로 인해 아래의 서비스가 중단 될 예정이오니,<br>
						참고하셔서 이용에 불편 없으시길 바랍니다.<br>
						더욱 안정되고 원활한 서비스로 찾아 뵙겠습니다.<br><br>
						<시스템 점검 시간 및 내용><br>
						1. 중단일시 : 2019년 11월 11일(월) 01:00 ~ 05:00 (4시간)<br>
						2. 중단내용 : 포인트 사용 서비스 불가<br><br>
						감사합니다.</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- #content end -->
		
		<script>
        $(function () {
            $(".accordion").click(function(){
                $(this).next().toggle(300);
                $(".accordion").not(this).next().hide(300);
            });
        });
    </script>

	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript" src="js/functions.js"></script>
</body>
</html>