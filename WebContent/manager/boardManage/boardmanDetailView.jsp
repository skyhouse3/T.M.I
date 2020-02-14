<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Board.model.*,java.util.*"%>
<%
	Boardman b = (Boardman)request.getAttribute("board");
	String contextPath = request.getContextPath();
	ArrayList<Reply> rlist = (ArrayList<Reply>)request.getAttribute("rlist");
%>
<!DOCTYPE html>
<html dir="ltr" lang="ko">
<head>
	<meta name="description" content="Bootstrap 3 Website Template" />

    <!-- Stylesheets
    ============================================= -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
    <link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
	<link href="http://fonts.googleapis.com/css?family=PT+Sans:300,400,500,600,700" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <link rel="stylesheet" href="css/dark.css" type="text/css" />
    <link rel="stylesheet" href="css/font-icons.css" type="text/css" />
    <link rel="stylesheet" href="css/animate.css" type="text/css" />
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css" />

    <link rel="stylesheet" href="css/responsive.css" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/plugins.js"></script>

    <!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
    <script type="text/javascript" src="include/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
    <script type="text/javascript" src="include/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
    <link rel="stylesheet" type="text/css" href="include/rs-plugin/css/settings.css" media="screen" />

	<title>Home | Chocolat</title>

    <style>
        #mleft{
            text-align: left;
        }
        #mright{
            text-align: right;
        }
        #movbarboard{
            width: 80%;
            margin-left: auto;
            margin-right: auto;
        }
        .movbtn{
            margin: 3px;
        }
        #movbar{
            width: 50%;
            text-align: center;
            float: left;
        }
        td{
            height: 50px;
            text-align: center;
            border-bottom:  1px solid gray;
        }
        th{
          text-align: center;
          border-bottom:  2px solid gray;
        }
        #table{
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
			font-weight:bold;
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
		
		.left{
		float:left;
		width:50%;
		padding:3%;
		margin-left:auto;
		}
		.right{
		float:left;
		width:50%;
		padding:3%;
		margin-left:auto;
		}
		.first{
		float:left;
		width:100%;
		text-align:center;
		}
		.second{
		float:left;
		width:100%;
		text-align:center;
		}
		.third{
		float:left;
		width:100%;
		text-align:center;
		}
		.four{
		width:100%;
		text-align:right;
		}
		.nobottommargin{
		text-align:center;
		}
		.postcontent{
			text-align:center;
			width:100%;
		}
		.container{
			text-align:left;
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
                <div class="promo promo-light promo-full header-stick nobottommargin">
                    <div class="container clearfix">
                        <h3>관리자 페이지입니다.</h3>
                        <span>현재 페이지에서는 게시글관리를 진행할 예정입니다.</span>
                   </div>
       	  	  	</div><!-- End Promo -->
                <section id="content">

                    <div class="section content-wrap notopmargin nobottommargin bgcolor-grey">

                        <div class="container clearfix">

                            <!-- Postcontent
                            ============================================= -->
                            <div class="postcontent nobottommargin">

                                <h3>게시글관리</h3>

                                <div id="contact-form-result" data-notify-type="success" data-notify-msg="<i class=icon-ok-sign></i> Message Sent Successfully!"></div>

                                <form class="nobottommargin" id="template-contactform" name="template-contactform" action="include/sendemail.php" method="post">

                                    <div class="first">
                                    	<div class="left">
                                    	<label for="template-contactform-message" >rnum</label>
                                        <input type="text" id="rnum" value="<%= b.getRnum() %>" class="sm-form-control required" readonly/>
                                        <br>
                                        <label for="template-contactform-message" >mcode</label>
                                        <input type="text" id="mcode" value="<%= b.getMcode() %>" class="sm-form-control required" readonly/>
                                    	</div>
                                        <div class="right">
                                        <label for="template-contactform-name">제목</label>
                                        <input type="text" id="rtitle" value="<%= b.getRtitle() %>" class="sm-form-control required" readonly/>
                                        <br>
                                        <label for="template-contactform-name">작성자</label>
                                        <input type="text" id="rwriter" value="<%= b.getrWriter() %>" class="sm-form-control required" readonly/>
                                    	</div>
                                    </div>

                                    <div class="second">
                                        <label for="template-contactform-message" >작성내용</label>
                                        <textarea class="required sm-form-control" id="template-contactform-message" name="template-contactform-message" rows="6" cols="30" readonly><%= b.getRcontent() %></textarea>
                                    </div>
                                    <div class="third">
                                    	<div class="left">
                                        <label for="template-contactform-message">평점</label>
                                        <input type="text" id="rRate" value="<%= b.getRrate() %>" class="sm-form-control required" name = "posting" readonly/>
										<br>
                                        <label for="template-contactform-message">매력점</label>
                                        <input type="text" id="charmpoint" value="<%= b.getCharmingPoint() %>" class="sm-form-control required" name = "posting" readonly/>
	                                    </div>
	                                    <div class="right">
                                        <label for="template-contactform-message">감독점</label>
                                        <input type="text" id="directerpoint" value="<%= b.getDirector_production() %>" class="sm-form-control required" name = "posting" readonly/> 
	                                    <br>
                                        <label for="template-contactform-message">OST</label>
                                        <input type="text" id="OSTpoint" value="<%= b.getOST() %>" class="sm-form-control required" name = "posting" readonly/>
	                                    <br>
	                                    </div>
	                                    <div class="left">
                                        <label for="template-contactform-message">연기점</label>
                                        <input type="text" id="actpoint" value="<%= b.getAction_acting() %>" class="sm-form-control required" name = "posting" readonly/>
	                                    <br>
                                        <label for="template-contactform-message">내용점</label>
                                        <input type="text" id="storypoint" value="<%= b.getStory() %>" class="sm-form-control required" name = "posting" readonly/>
	                                    <br>
	                                    </div>
	                                    <div class="right">
                                        <label for="template-contactform-message">영상미</label>
                                        <input type="text" id="moviepoint" value="<%= b.getMovie_beauty() %>" class="sm-form-control required" name = "posting" readonly/>
	                                    <br>
                                        <label for="template-contactform-message">작성일</label>
                                        <input type="text" id="mrvdate" value="<%= b.getMrvDate() %>" class="sm-form-control required" name = "posting" readonly/>
	                                    <br>
	                                    </div>
	        
                                    </div>
                                </form>
                                <div class="four">
	                                    <button class="btn button nomargin" type="button" id="template-contactform-submit" onclick="deleteB('<%=b.getRnum()%>');">삭제하기</button>
	                                   	<br><br>
	                                    </div>
                                    	<script>
											function deleteB(id){
													var bid = id;
													location.href="<%= contextPath %>/delete.b?bid=" + bid;
													}
										</script>
                            </div>
                            <div>
                            	 <form class="nobottommargin" id="template-contactform" name="template-contactform">
                            	 <h3>댓글 관리</h3>
                                	<table id="table">
                                	<tr>
										<th width=20%>글쓴이</th>
										<th width=40%>내용</th>
										<th width=20%>작성일</th>
										<th width=20%>삭제</th>
									</tr>
									<% if(rlist != null){ %>
										<% for(Reply r : rlist){ %>
									<tr>
										<td width="20%"><%= r.getRwriter() %></td>
										<td width="40%"><%= r.getRcontent() %></td>
										<td width="20%"><%= r.getModify_date() %></td>
										<td width="20%"><button type="button" onclick="deleteR('<%= r.getRid() %>','<%=b.getRnum()%>');">삭제</button></td>
									</tr>
									
									<% } %>
									<%} %>
									</table>  
									<script>
											function deleteR(Rid,bid){
													var rid = Rid;
													var bid = bid;
													location.href="<%= contextPath %>/delete.r?rid=" + rid + "&bid=" + bid;
													}
										</script>            
                                </form>
                            </div>
                        </div>
                    </div>
                </section><!-- #content end -->
    </div><!-- #wrapper end -->
	</section>
    <!-- Go To Top
    ============================================= -->
    <div id="gotoTop" class="icon-angle-up"></div>

    <!-- Footer Scripts
    ============================================= -->
    <script type="text/javascript" src="js/functions.js"></script>

</body>
</html>