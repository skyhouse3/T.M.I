<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, movie.model.vo.*, attachment.model.vo.*"%>
<%
	
	Movie movie = (Movie) request.getAttribute("movie");
	ArrayList<Attachment> img = (ArrayList<Attachment>) request.getAttribute("Img");
	Attachment titleImg = img.get(0);
	
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
	#main-title{
		float:left;
	}
	input{
		background-color:transparent;
	}
	#main-title >#display-main-title{
		border:none;
		color:white;
	}
	#small-title >#display-main-title-eng,#input-poster-title-eng{
		border:none;
		color:orange;
	}
	#main-plot>#display-main-plot{
		border:none;
		color:white;
	}

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
		<form action="<%=request.getContextPath() %>/update.rmo" method="post" enctype="multipart/form-data">
		<!-- 시작 -->
			<div id="titleImgArea" class="jumbotron main-title-bg" style="background-image:url('<%=request.getContextPath()%>/resources/MovieImg_upload/<%=img.get(1).getChangeName()%>')">
			
			<div class="container ">
				<h1><div id="main-title"><input type="text" id="display-main-title" value="<%=movie.getMtitle()%>" readonly></div>
				<span id="small-title"><input type="text" id="display-main-title-eng" value="<%=movie.getMtitleEng()%>" readonly></span>
				</h1>
				<h6><div id="main-plot"><input type="text" id="display-main-plot" value="<%=movie.getMtitlePlot()%>" readonly></div></h6>
			</div>
		</div>

		<div class="container">
			<!-- Example row of columns -->

			<div class="container">
				<div class="row">

					<div class="col-12">
						<p>영화</p>	
						
						<button type="submit" class="btn btn-info">수정하기</button>
						<!-- 값 숨겨놓기  -->
						<input type="hidden" value="<%=movie.getMcode()%>" name="mrid">
						<!-- 값 숨겨놓기 끝-->
						<button type="button" class="btn btn-info" onclick="location.href='<%= request.getContextPath() %>/detail.mo?mcode='+<%= movie.getMcode() %>">취소하기</button>
				
						<div class="card">
							<div class="row no-gutters">
								<div class="col-4" id="mainPoster">
									<img src="<%=request.getContextPath()%>/resources/MovieImg_upload/<%=titleImg.getChangeName() %>"
										alt="" class="card-img movie-poster" id="poster">
								</div>
								<div class="col-8">
									<div class="card-body">
										<h4><div id="main-title"><input type="text" id="input-poster-title" value="<%=movie.getMtitle()%>" name="mtitle"></div>
										<span id="small-title"><input type="text" id="input-poster-title-eng" value="<%=movie.getMtitleEng()%>" name="mtitleEng">
										<strong>예매율 : </strong></span>
										</h4>

										<table class="table table-bordered">
											<tbody>
												<tr>
													<th scope="row">감독</th>
													<td><div id="director"><input type="text" name="director" value="<%=movie.getmDirector()%>"></div></td>
												</tr>
												<tr>
													<th scope="row">배우</th>
													<td><div id="actor"><input type="text" name="actor" value="<%=movie.getmActor()%>"></div></td>
												</tr>
												<tr>
													<th scope="row">장르</th>
													<td><div id="kinds"><input type="text" name="kinds" value="<%=movie.getKinds()%>" placeholder=",로 구분해서 넣어주세요."></div></td>
												</tr>
												<tr>
													<th scope="row">기본</th>
													<td colspan="2"><div id="info"><input type="text" name="info" value="<%=movie.getInfo()%>"></div></td>
												</tr>
												<tr>
													<th scope="row">개봉</th>
													<td colspan="2"><div id="release"><input type="date" class="input-data" name="release" value="<%=movie.getRelease()%>"></div></td>
												</tr>
												<tr>
													<th scope="row">카테고리</th>
													<td><select class="custom-select" name="category">
															<option selected value="now_playing_movie">방영작</option>
															<option value="intended_movie">예정작</option>
													</select></td>
												</tr>
												<tr>
													<th scope="row">연령</th>
													<td colspan="2"><div id="release"><input type="text" class="input-data" name="agecut" value="<%=movie.getAgeCut()%>"></div></td>
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
<div id="plot">			
<textarea rows="15" cols="80" name="plot" style="resize:none;"><%=movie.getPlot()%></textarea>
</div>
<br> 
  <strong><div id="main-plot"><input type="text" id="input-main-plot" value="<%=movie.getMtitlePlot()%>" name="mtitlePlot"></div></strong>

      </pre>

			
			</div>

			<div id="fileArea">
				<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="LoadImg(this,1)">
				<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="LoadImg(this,2)">
			</div>
				
				<script>
				// 내용 작성 부분의 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
				$(function(){
					$("#fileArea").hide();
					
					$("#titleImgArea").click(function(){
						$("#thumbnailImg1").click();
					});
					
					$("#mainPoster").click(function(){
						$("#thumbnailImg2").click();

					});
					
					/* 타이틀 제목 동시에 입력하기  */
			      	$("#input-poster-title").keydown(function(){
			          $("#display-main-title").val($(this).val());
			        });
			        $("#input-poster-title").change(function(){
			          $("#display-main-title").val($(this).val());
			        });
			        /* 영어 타이틀 제목 동시에 입력하기  */
			        $("#input-poster-title-eng").keydown(function(){
			            $("#display-main-title-eng").val($(this).val());
		         	 });
		         	 $("#input-poster-title-eng").change(function(){
			            $("#display-main-title-eng").val($(this).val());
		          	});
		         	/* 제목타이틀줄거리,메인줄거리한줄짜리 동시에 입력하기  */
	         	  
				      $("#input-main-plot").keydown(function(){
				        $("#display-main-plot").val($(this).val());
				      });
				      $("#input-main-plot").change(function(){
				        $("#display-main-plot").val($(this).val());
				      });
				  
			        /* 타이틀 제목 동시에 입력하기 끝 */
				});
				
				// 파일 첨부 했을 때 미리보기 공간에 미리보기가 가능하게 하는 함수
				function LoadImg(value, num){
					
					// value => input type="file"
					// num => 이후에 조건문 작성하여 번호에 맞춰서 img 적용 시킬 것
					
					// file이 존재하는지 확인
					if(value.files && value.files[0]){
						// 파일을 읽어 들일 FileReader 객체 생성
						var reader = new FileReader();
						
						// 파일 읽기가 다 완료 되었을 때 실행되는 메소드
						reader.onload = function(e){
							
							switch(num){
							case 1:
								// e.target.result -> data:URL (파일의 컨텐츠)
								 $("#titleImgArea").css({"background":"url("+e.target.result+")","background-size": "cover"});
								break;
							case 2:
								/* $("#contentImg1").attr("src", e.target.result); */
								/* $("#mainPoster").css({"background":"url("+e.target.result+")","background-size": "cover"});
								 */
								 $("#poster").attr("src",e.target.result);
								break;
							}
						}
						// 파일 내용을 읽어들여 dataURL 형식의 문자열로 설정
						reader.readAsDataURL(value.files[0]);
					}
				}
				</script>			
		
		</form>
		
		</div>
		<!-- /container -->




	<!-- footbar  -->
	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/functions.js"></script>	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
  


</body>
</html>