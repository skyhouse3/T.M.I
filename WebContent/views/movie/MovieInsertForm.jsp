<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int n = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
.textarea {
	width: 100%;
}

.btn-area {
	width: 50%;
	display: inline-block;
	align: center;
}

#thumbnailImg1, #url {
	display: block;
}

.btn {
	line-height: 5px;
}

.custom-select {
	width: auto;
}

#url-btn, #Img-title-area, #Img-area {
	display: block;
}

.img {
	border: 1px solid black;
}

.title {
	width: 150px;
	height: 150px;
}
table{
	width:100%;
}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>
	<br>
	<br>
	<h4 align="center">영화 작성 게시판(관리자용)</h4>
	<div class="container">
		<div class="row">
			<div class="col">

				<form id="insertMovie" action="<%=request.getContextPath()%>/insert.mo" method="post"
					enctype="multipart/form-data" onsubmit="return joinValidate();">
					<table class="table">
						<tbody>
							<tr>
								<th scope="row">영화 제목</th>
								<td><input type="text" name="mtitle" id="mtitle"
									placeholder="영화 제목"></td>
								<td><span id="nameresult"></span></td>
							</tr>
							<tr>
								<th scope="row">영화 제목(영문)</th>
								<td><input type="text" name="mtitleEng" id="mtitle"
									placeholder="영화 제목(영문)"></td>
									<td><span id="nameEngresult"></span></td>
							</tr>
							<tr>
								<th scope="row">제목 줄거리</th>
								<td><textarea rows="5" name="mtitlePlot" class="textarea"
										placeholder="제목 줄거리 20~25자 내외"></textarea></td>
							</tr>
							<tr>
								<th scope="row">줄거리</th>
								<td><textarea rows="5" name="plot" class="textarea"
										placeholder="줄거리"></textarea></td>
							</tr>
							<tr>
								<th scope="row">장르</th>
								<td>
									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input type="checkbox" class="custom-control-input"
											id="defaultInline1" value="액션" name="kinds"> <label
											class="custom-control-label" for="defaultInline1">액션</label>
									</div>

									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input type="checkbox" class="custom-control-input"
											id="defaultInline2" value="로맨스" name="kinds"> <label
											class="custom-control-label" for="defaultInline2">로멘스</label>
									</div>

									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input type="checkbox" class="custom-control-input"
											id="defaultInline3" value="범죄" name="kinds"> <label
											class="custom-control-label" for="defaultInline3">범죄</label>
									</div>
									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input type="checkbox" class="custom-control-input"
											id="defaultInline4" value="재난" name="kinds"> <label
											class="custom-control-label" for="defaultInline4">재난</label>
									</div>
									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input type="checkbox" class="custom-control-input"
											id="defaultInline5" value="드라마" name="kinds"> <label
											class="custom-control-label" for="defaultInline5">드라마</label>
									</div>
									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input type="checkbox" class="custom-control-input"
											id="defaultInline6" value="패밀리" name="kinds"> <label
											class="custom-control-label" for="defaultInline6">가족영화</label>
									</div>
									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input type="checkbox" class="custom-control-input"
											id="defaultInline7" value="기타" name="kinds"> <label
											class="custom-control-label" for="defaultInline7">기타</label>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">감독</th>
								<td><input type="text" class="input-data" name="director"
									placeholder="감독"></td>
								<td><span id="directorresult"></span></td>
							</tr>
							<tr>
								<th scope="row">배우</th>
								<td><input type="text" class="input-data" name="actor"
									placeholder="배우"></td>
								<td><span id="actorresult"></span></td>
							</tr>
							<tr>
								<th scope="row">카테고리</th>
								<td><select class="custom-select" name="category">
										<option selected value="now_playing_movie">방영작</option>
										<option value="intended_movie">예정작</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row">정보</th>
								<td><input type="text" class="input-data" name="info"
									placeholder="정보"></td>
							</tr>
							<tr>
								<th scope="row">연령 제한</th>
								<td><select class="custom-select" name="agecut">
										<option selected value="all">전체</option>
										<option value="15s">15세 이상</option>
										<option value="18s">18세 이상</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row">방영일</th>
								<td><input type="date" class="input-data" name="release"></td>
							</tr>
							<tr>
								<th scope="row">URL</th>
								<td>
									<div id="url-area">
										<input type="text" class="input-data" name="url">
									</div>
									<button id="btn" class="btn btn-info" onclick="addImgfile();"
										type="button">추가하기</button>
									<button id="btn" class="btn btn-info"
										onclick="deleteImgFile();" type="button">제거하기</button>
								</td>
							</tr>
							<tr>
								<th scope="row">첨부파일(사진)</th>
								<td>

									<div id="Img-title-area">
										<h4>타이틀 이미지</h4>
										<img class="title img" id="titleImg" name="titleImg">
									</div> <br>
									<div id="Img-area">
										<h4>썸네일 이미지</h4>
										<!-- 이미지가 뿌려질 곳  -->
									</div>
									<div id="file-btn-area">
										<input type="file" name="MovieTitleImg" id="titlefile"
											onchange="LoadImgTitle(this,1)">
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="btn-area">
						<button type="button" class="btn btn-info btn-sm"
							onclick="addfile();">첨부파일 추가</button>
						<button type="button" class="btn btn-info btn-sm"
							onclick="deleteFile();">첨부파일 삭제</button>
					</div>
					<hr>

					<div class="container" align="center">
						<button class="btn btn-info" type="submit">작성하기</button>
						<button class="btn btn-info" type="button"
							onclick="javascript:history.back();">취소하기</button>
					</div>

				</form>

			</div>
		</div>


	</div>

	<%@include file="../common/footer.jsp"%>
	<script>
		/* 이미지 첨부파일 */
		var fileArea = $("#file-btn-area");
		var imgArea = $("#Img-area");
		var n = 1;
		var loadimgNum = 1;
		var tmp = 0;
		function addfile() {
			var addF = document.createElement("input");
			addF.type = "file";
			addF.id = "thumbnailImg" + (++n);
			addF.name = "thumbnailImg" + n;
			// addF.onchange=LoadImg(this);
			addF.onchange = function(e) {

				console.log(this);
				LoadImg(this);
			};
			fileArea.append(addF);

			// console.log("thumbnailImg(n) : "+"thumbnailImg"+n);
			var Img = document.createElement("img");
			Img.style.width = "150px";
			Img.style.height = "150px";
			Img.className = "body img";
			Img.id = "body-img" + n;

			Img.addEventListener("click", function() {
                var pieces=Img.id.split(/[\D]+/);
                imgNum=pieces[pieces.length-1];
                $("#thumbnailImg"+imgNum).click();

			}); //2019-10-31 저녁 10:21분 작업
			imgArea.append(Img);
		}

		function deleteFile() {
			var deleteFile = document.getElementById("thumbnailImg" + n);
			var deleteImg = document.getElementById("body-img" + n);
			$("#file-btn-area #thumbnailImg" + n + ":last-child").remove();
			$("#Img-area #body-img" + n + ":last-child").remove();// 여기까지 작업-2019-10-31
			if (n > 1) {
				n--; //title의 index값은 고정해야 됨.
			}
			//  console.log(n);
		}

		$(function() {
			$("#file-btn-area").hide();
			$("#titleImg").click(function() {
				$("#titlefile").click();
			});
		});

		// 파일 첨부 했을 때 미리보기 공간에 미리보기가 가능하게 하는 함수
		function LoadImgTitle(value, num) {
			// value => input type="file"
			// num => 이후에 조건문 작성하여 번호에 맞춰서 img 적용 시킬 것
/* 			console.log(num);
			console.log(value);
			console.log("value : " + value); */
			// console.log("loadimg 실행 확인 title :  #contentImg"+n);
			// file이 존재하는지 확인
			if (value.files && value.files[0]) {
				// 파일을 읽어 들일 FileReader 객체 생성
				/* console.log("실행확인!!"); */
				var reader = new FileReader();

				// 파일 읽기가 다 완료 되었을 때 실행되는 메소드
				reader.onload = function(e) {
					/* console.log("reader.onload 실행"); */
					switch (num) {
					case 1:
						$("#titleImg").attr("src", e.target.result);
						break;
					}

					// 파일 내용을 읽어들여 dataURL 형식의 문자열로 설정

				}
				reader.readAsDataURL(value.files[0]);

			}
		}
		function LoadImg(value) {
			// value => input type="file"
			// num => 이후에 조건문 작성하여 번호에 맞춰서 img 적용 시킬 것
			// console.log(num);
			/* console.log("value : " + (value)); */
			// console.log("loadimg 실행 확인 title :  #contentImg"+n);
			// file이 존재하는지 확인
			if (value.files && value.files[0]) {
				// 파일을 읽어 들일 FileReader 객체 생성
				console.log("실행확인!!");
				var reader = new FileReader();

				// 파일 읽기가 다 완료 되었을 때 실행되는 메소드
				reader.onload = function(e) {
					$("#body-img" + imgNum).attr("src", e.target.result);
				}

				// 파일 내용을 읽어들여 dataURL 형식의 문자열로 설정

				reader.readAsDataURL(value.files[0]);
			}
		}
		/* url 추가태그 */
		var urlArea = $("#url-area");
		function addImgfile() {
			var addF = document.createElement("input");
			addF.type = "text";
			addF.id = "url";
			addF.name = "url";
			urlArea.append(addF);
		}
		function deleteImgFile() {
			var deleteFile = document.getElementById("url")
			$("#url-area #url:last-child").remove();
		}
		
		/* 첨부파일 */
		
		/* 유효성검사  */
       $('#insertMovie input[name=mtitle]').change(function(){
            //이름이 정규식을 만족하지 못했을 경우
            var flag=0;
            if(!(/^[가-힣\d\s]{1,}$/i).test($(this).val())){
                $("#nameresult").html("한글로 1글자 이상 입력(숫자포함 가능)").css("color","red");
                $(this).select().css("background","red");
            }else{
                $("#nameresult").html("OK!").css("color","green");
                $(this).css("background","white");
            }
        });
    
/*         $('#insertMovie input[name=mtitleEng]').change(function(){
       	   var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
		  //이름이 정규식을 만족하지 못했을 경우
            var flag=0;
            if(!(/^[a-z][a-z\d]special_pattern{3,}$/i.test($(this).val()))){
                $("#nameEngresult").html("영어 제목은 3글자 이상 입력(숫자포함 가능)").css("color","red");
                $(this).select().css("background","red");
            }else{
                $("#nameEngresult").html("OK!").css("color","green");
                $(this).css("background","white");
            }
        }); */
        
       $('#insertMovie input[name=director]').change(function(){
            //이름이 정규식을 만족하지 못했을 경우
            var flag=0;
            if(!(/^[가-힣\s]{2,}$/i.test($(this).val()))){
                $("#directorresult").html("감독 이름 2글자 이상 입력").css("color","red");
                $(this).select().css("background","red");
            }else{
                $("#directorresult").html("OK!").css("color","green");
                $(this).css("background","white");
            }
        });
       $('#insertMovie input[name=actor]').change(function(){
            //이름이 정규식을 만족하지 못했을 경우
            var flag=0;
            if(!(/^[가-힣\s]{2,}$/i.test($(this).val()))){
                $("#actorresult").html("배우 이름은 2글자 이상 입력").css("color","red");
                $(this).select().css("background","red");
            }else{
                $("#actorresult").html("OK!").css("color","green");
                $(this).css("background","white");
            }
            
        });

		
		function joinValidate(flag){
			var num=flag;
			var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

			if(!(/^[가-힣\d\s]{1,}$/i.test($("#insertMovie input[name=mtitle]").val()))){
				alert('영화제목은 한글로시작해서 1자이상 12글자 이하 입력(숫자 포함 가능)');
				$("#insertMovie input[name=mtitle]").select();
				return false;
			} 
			
			
/*   			if(!(/^[a-z][a-z\d]{3,}special_pattern$/i.test($("#insertMovie input[name=mtitleEng]").val()))){
				alert('영어 제목은  3자이상 입력 12자 이하일 것(숫자 포함 가능)');
				$("#insertMovie input[name=mtitleEng]").select();
				return false;
			}  */
			if(!(/^[가-힣\s]{2,}$/i.test($("#insertMovie input[name=director]").val()))){
				alert('감독 이름은  2자이상  12자 이하 일것.');
				$("#insertMovie input[name=mtitleEng]").select();
				return false;
			}
			if(!(/^[가-힣\s]{2,11}$/i.test($("#insertMovie input[name=director]").val()))){
				alert('배우 이름은  2자이상 입력');
				$("#insertMovie input[name=mtitleEng]").select();
				return false;
			} 
			return true;
		
			
		}
		
	</script>

</body>
</html>