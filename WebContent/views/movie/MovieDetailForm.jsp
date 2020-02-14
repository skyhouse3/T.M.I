<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, movie.model.vo.*, attachment.model.vo.*"%>
<%
	Movie movie = (Movie) request.getAttribute("movie");
	ArrayList<Attachment> ImgList = (ArrayList<Attachment>) request.getAttribute("fileList");
	ArrayList<Preview> previewList = (ArrayList<Preview>) request.getAttribute("previewList");
	MovieCharmingPoint mcp=(MovieCharmingPoint)request.getAttribute("mcp");
	
	
	
	
	Attachment titleImg = ImgList.get(0);
	
	ArrayList<Reply> mrlist = (ArrayList<Reply>)request.getAttribute("mrlist");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<!-- 차트 링크 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<!-- Icon API -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-icons.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  	
<title>Insert title here</title>
<style>
.main-title-bg {
	background-image:
		url("<%=request.getContextPath()%>/resources/MovieImg_upload/<%=ImgList.get(1).getChangeName()%>");
	background-size: cover;
	}
	
	#small-title {
		font-size: 12px;
	}
	
	.jumbotron h1, span, h6 {
		color: white;
	}
	
	.img-size {
		height: 480px;
	}
	#replySelectTable{
		width:100%;
		height:100px;
	}
		/* 댓글 볼더  */
	.reply{
	   border :0;
	}
	.Area{
		float:right;
	}
	.oA{
		visibility:hidden;
	}

	/*  */

</style>
</head>
<body>
	<!-- menu  -->

	<%@include file="../common/menubar.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- menu End  -->

	<div class="container">
		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron main-title-bg">
			<div class="container ">
				<h1><%=movie.getMtitle()%><span id="small-title"><%=movie.getMtitleEng()%></span>
				</h1>
				<h6><%=movie.getMtitlePlot()%></h6>
			</div>
		</div>

		<div class="container">
			<!-- Example row of columns -->

			<div class="container">
				<div class="row">

					<div class="col-12">
						<p>영화</p>	
						
						<!-- 수정해야됨  -->
						<%if(loginUser.getUser_Id().equals("admin")){ %>
						
						<button type="button" class="btn btn-info" onclick="location.href='<%= request.getContextPath() %>/update.mo?mrid='+<%= movie.getMcode() %>">수정하기</button>
						
						<%} %> 
						<!-- 수정해야됨  -->
						
						<div class="card">
							<div class="row no-gutters">
								<div class="col-4">
									<img
										src="<%=request.getContextPath()%>/resources/MovieImg_upload/<%=titleImg.getChangeName()%>"
										alt="" class="card-img movie-poster">
								</div>
								<div class="col-8">
									<div class="card-body">
										<h4><%=movie.getMtitle()%><span id="small-title"><%=movie.getMtitleEng()%>
										<strong>평점 : <%=mcp.getRrate() %></strong></span>
										</h4>

										<table class="table table-bordered">
											<tbody>
												<tr>
													<th scope="row">감독</th>
													<td><%=movie.getmDirector()%></td>
												</tr>
												<tr>
													<th scope="row">배우</th>
													<td><%=movie.getmActor()%></td>
												</tr>
												<tr>
													<th scope="row">장르</th>
													<td><%=movie.getKinds()%></td>
												</tr>
												<tr>
													<th scope="row">기본</th>
													<td colspan="2"><%=movie.getInfo()%></td>
												</tr>
												<tr>
													<th scope="row">개봉</th>
													<td colspan="2"><%=movie.getRelease()%></td>
												</tr>
											</tbody>
										</table>
									</div>
									<!-- card-body end -->
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="container">
			<pre class="text-justify">
<div>
<%=movie.getPlot()%>
</div>
<br> 
  <strong><%=movie.getMtitlePlot()%></strong>

      </pre>

			<div class="container">
				<div class="row">
					<div class="col-12 ">
						<h4 align="center" class="alert alert-info">매력포인트</h4>
						<div class="card">
							<!-- 그믈 그래프 분포 -->
							<canvas id="radarChart"></canvas>
							<!-- 그믈 그래프 분포 끝 -->
							<div class="card-body">
								<p class="card-text">
									감독연출 : <%=mcp.getDirector_production() %> 스토리 : <%=mcp.getStory() %> 영상미 : <%=mcp.getMovie_beauty() %><br>배우연기 : <%=mcp.getAction_acting() %> OST : <%=mcp.getOST() %>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script>
				
				// 그물 그래프
				//radar
				var ctxR = document.getElementById("radarChart").getContext(
						'2d');
				var myRadarChart = new Chart(ctxR, {
					type : 'radar',
					data : {
						labels : [ "감독연출", "스토리", "영상미", "배우연기", "OST" ],
						datasets : [ {
							label : "<%=movie.getMtitle()%>",
							data : [ <%=mcp.getDirector_production()%>, <%=mcp.getStory()%>, <%=mcp.getMovie_beauty()%>, <%=mcp.getAction_acting()%>, <%=mcp.getOST()%> ],
							backgroundColor : [ 'rgba(105, 0, 132, .2)', ],
							borderColor : [ 'rgba(200, 99, 132, .7)', ],
							borderWidth : 2

						} ]
					},
					options : {
						responsive : true
					}
				});
				
			</script>

			<!-- Reply Form {s} -->
			<hr>

			<div class="alert alert-primary">
				<h6>
					스틸컷
					<%=ImgList.size()%>
					건 <a href="#"><i class="icon-line-circle-plus stretched-link"></i></a>
				</h6>
			</div>
			<!-- 예고편 모음 게시판으로 -->
			<hr>
			<!-- 스틸컷 슬라이더  -->
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<%
						for (int i = 0; i < ImgList.size(); i++) {
					%>
					<li data-target="#carouselExampleIndicators" data-slide-to="i"></li>
					<%
						}
					%>
				</ol>
				<div class="container">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100 img-size"
								src="<%=request.getContextPath()%>/resources/MovieImg_upload/<%=ImgList.get(0).getChangeName()%>">
							<!-- active 해결해야 함 2019-11-03 08:51  -->
						</div>
						<%
							for (int i = 1; i < ImgList.size(); i++) {
						%>
						<div class="carousel-item">
							<img class="d-block w-100 img-size"
								src="<%=request.getContextPath()%>/resources/MovieImg_upload/<%=ImgList.get(i).getChangeName()%>">
						</div>
						<%
							}
						%>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<!-- 스틸컷 슬라이더 END  -->
			<hr>
			<div class="alert alert-primary">
				<h6>
					예고편
					<%=previewList.size()%>
					건 <a href="#"><i class="icon-line-circle-plus stretched-link"></i></a>
				</h6>
			</div>
			<!-- 예고편 모음 게시판으로 -->
			<hr>

			<!-- 예고편 start -->
			<div class="row justify-content-lg-between text-center no-gutters">
				<div class="container">
					<div id="carouselExampleControls" class="carousel slide"
						data-ride="carousel">

						<div class="carousel-inner">
							<div class="carousel-item active">
								<div class="embed-responsive embed-responsive-16by9">
									<%=previewList.get(0).getYurl()%>
								</div>
							</div>
							<%
								if (previewList.size() > 1) {
									for (int i = 1; i < previewList.size(); i++) {
							%>
							<div class="carousel-item">
								<div class="embed-responsive embed-responsive-16by9">
									<%=previewList.get(i).getYurl()%>
								</div>
							</div>
							<%
								}
								}
							%>

						</div>

						<a class="carousel-control-prev" href="#carouselExampleControls"
							role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> 
							<span class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleControls"
							role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> 
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
			<!-- 예고편 end -->
			<hr>

			<div class="my-3 p-3 bg-white rounded shadow-sm replayArea"
				style="padding-top: 10px">
				<div class="row">
					<div class="col-sm-10">
						<textarea path="content" class="form-control"
							rows="3" placeholder="댓글을 입력해 주세요" id="replyContent" cols="20" wrap="hard"></textarea>
					</div>

					<div class="col-sm-2">
						<button type="button" class="btn btn-sm btn-primary" id="addReply"
							style="width: 100%; margin-top: 10px">입력</button>
					</div>
				</div>
				<!-- Reply Form {e} -->

				<!-- Reply List {s}-->

				<div class="my-3 p-3 bg-white rounded shadow-sm"
					style="padding-top: 10px">
					<h6 class="border-bottom pb-2 mb-0">
						댓글<i class="icon-reply"></i>
					</h6>
					<div id="replyList">
						<table id="replySelectTable" align="center" class="table table-sm border-top-0">
					 		<% if (mrlist != null) { %>
							<%for (Reply r : mrlist) { %>
							<tr>
								<td width="100px"><%=r.getRwriter()%></td>
								<%-- <td width="400px"><%=r.getRcontent()%></td>--%>
								<td>
									<input type="text" class="form-control reply" id="reply<%=r.getRid() %>" value="<%=r.getRcontent()%>" disabled>
								</td>
								<td width="200px"><%=r.getCreate_date()%>
								<%if(r.getRwriter().equals(loginUser.getUser_Id())|| loginUser.getUser_Id().equals("admin")){ %>
									<div class="Area okArea<%=r.getRid()%> oA">&nbsp;<a href=# class="js-action-a"><i class="far fa-thumbs-up text-size" onclick="modiReply_confirm(<%=r.getRid()%>);"></i></a></div>
									<div class="Area modifyArea">&nbsp;<a href=# class="js-action-a"><i class="fas fa-cogs text-size reply" id="reply<%=r.getRid() %>" onclick="modiReply(<%=r.getRid()%>);"></i></a></div>
									<div class="Area delArea">&nbsp;&nbsp;<a href=# class="js-action-a"><i class="far fa-trash-alt text-size" onclick="delReply(<%=r.getRid()%>);"></i></a></div>
									
								<%} %>
								<input type="hidden" value="<%= r.getRid() %>" id="input"></td>
								
							</tr>
							<% } %>
							<%} %>
								
						</table>
					</div>
				</div>

				<!-- Reply List {e}-->
			</div>
			
			
			
			
			<script>
				$(function() {
					/* jquert 시작 */
					
					
					$("#addReply").click(
							function() {
								var writer = "<%=loginUser.getUser_Id()%>";
								var mcode =<%=movie.getMcode()%>;
								var content = $("#replyContent").val();
								
								$.ajax({
									url : "insertMovieReply.mo",
									type : "post",
									dataType : "json",
									data : {
										writer : writer,
										content : content,
										mcode : mcode
									},
									success : function(data) {
										console.log(data);

										$replyTable = $("#replySelectTable");
										$replyTable.html("");

										// 새로 받아온 갱신 된 댓글 리스트를 반복문을 통해 table에 추가
										for ( var key in data) {
											console.log("도는지 확인");
											var $tr = $("<tr class='mrid"+data[key].rid+"'>");
											var $writerTd = $("<td>").text(data[key].rwriter).css("width", "100px");
											var $contentTd=$("<input type='text' class='form-control reply' id='reply"+data[key].rid+"'  value= "+data[key].rcontent+"  disabled >");
											var $Td =$("<td>");											
												$Td.append($contentTd);
											var $dateTd = $("<td>").text(data[key].create_date).css("width", "200px");
											
											if(data[key].rwriter==writer ||writer=='admin'){
												$dateTd.append("<div class='Area okArea"+data[key].rid+" oA' style='visibility:hidden'>&nbsp;<a href=# class='js-action-a'><i class='far fa-thumbs-up text-size' onclick='return modiReply_confirm("+data[key].rid+");'></i></a> <div>");
												$dateTd.append("<div class='Area modifyArea'>&nbsp;<a href=# class='js-action-a'><i class='fas fa-cogs text-size reply' id='reply"+data[key].rid+"' onclick='modiReply("+data[key].rid+");'></i></a><div>");
												$dateTd.append("<div class='Area delArea'>&nbsp;&nbsp;<a href='#'  class='js-action-a' ><i class='far fa-trash-alt text-size' onclick='return delReply("+data[key].rid+");'></i></a><div>");
												
												<%-- 
													
												--%>
												/* $dateTd.append("&nbsp;<a href=# class='js-action-a'><i class='far fa-thumbs-up text-size' onclick='modiReply_confirm("+data[key].rid+");'></i></a>"); */
												
											}
											$dateTd.append("<input type='hidden' value='" + data[key].rid + "'>");
											$tr.append($writerTd);
											$tr.append($Td);
											$tr.append($dateTd);
											$tr.append("<hr>");

											$replyTable.append($tr);
										}

										// 댓글 작성 부분 리셋
										$("#replyContent").val("");

									},
									error : function() {
										console.log("통신 실패!");
									}
								});
							});
						/* add-end  */
					<%-- href='<%=request.getContextPath()%>/mreply.del' --%>
					jQuery(".js-action-a").click(function (e) {
						e.preventDefault();
					});
						/* jquert 끝  */
						
						
						
				});
				function delReply(value){
					
					var mrid = value;
					/* alert("mrid"+value); */
					$.ajax({
						url : "mreply.del",
						type : "post",
						data : {
							mrid : mrid
						},
						dataType:"text",
						success : function(date) {
							var text=date;
							if(text=="삭제 성공!"){
								alert("삭제 성공!");
								$(".mrid"+mrid).remove();
								
							}else{
								console.log("삭제 실패");
							}
							/* return false; */
						},
						error : function(request,status,error) {
							console.log("통신 실패!");
							  alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
					  	}
					});
					<%-- href='<%=request.getContextPath()%>/mreply.del' --%>
					jQuery(".js-action-a").click(function (e) {
						e.preventDefault();
					});
					
					return;
				}
				function modiReply(value){
					var mrid=value;
				/* 	alert(mrid); */
					var reply=$(".reply");
					/* alert(); */
					$("#reply"+mrid).css("border","1");
		            $("#reply"+mrid).removeAttr('disabled');
		            
		            $(".okArea"+mrid).css("visibility","initial");
		            
		            jQuery(".js-action-a").click(function (e) {
						e.preventDefault();
					});
		            return false; 
				}
				function modiReply_confirm(mrid){

					var id = mrid;
					var content=$("#reply"+id).val();
					$(".okArea"+mrid).css("visibility","hidden");
					/* alert("id : "+ id +"content : "+content); */
					$.ajax({
						url : "mreply.modi",
						type : "post",
						data : {
							mrid : id,
							content : content
						},
						dataType:"text",
						success : function(date) {
							/* alert("success 넘어오기 성공!"); */
							
							if(date =="변경 성공!"){
								$("#reply"+id).attr('disabled',true);
								/* $("#reply"+id).style() */
							}
							
							
						},
						error : function(request,status,error) {
							console.log("통신 실패!");
							  alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
					  	}
					  	
					});
		            jQuery(".js-action-a").click(function (e) {
						e.preventDefault();
					});
		            return false;
				
				}

				
				
			</script>


		</div>
		<!-- /container -->
	</div>

	<!-- 메뉴바 -->


	<!-- 메뉴바 end -->


	<!-- Content -->



	<!-- Content End -->



	<!-- footbar  -->
	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/functions.js"></script>	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
  


</body>
</html>