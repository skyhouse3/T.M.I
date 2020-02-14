<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,movie.model.vo.* "%>
	<%
		String contextPath = request.getContextPath();
		ArrayList<Movie> mlist = (ArrayList<Movie>)request.getAttribute("mlist");
		String mem = request.getParameter("mem");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<style>	
button:hover{
	cursor:pointer;
	}
#form {
	margin-top:3%;
	margin-left:40%;
}	
#btn {
	margin-left:15%;
	margin-bottom:5%;
}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>
	
		<div id="form">
			<fieldset>
				<legend>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;리뷰 & 별점</legend>
				<br>
				<form action="<%= contextPath %>/insert.re?mem=<%=mem%>" method="post">
				<ul>
					<li><label>영화: </label> 
					<select name=mcode>						
							<option>----</option>
							<%if(mlist !=null){ %>
								<%for(Movie m : mlist){ %>
									<option value="<%=m.getMcode() %>"><%=m.getMtitle() %></option>
								<%} %>
							<%} %>
					</select>
					</li>
					<br>
					<li>글 제목:
					<input type="text" name="rtitle"> 
					</li>
					<br>
					<li>별점: 
					<input name=rRate type="range" id="starLevel" min="1" max="5" step="1" onchange="starRange1(this.value);"> 
					<input type="text" id="starVal" readonly> 
					</li>
					<br>
					<li>매력점수 : 
					<input name=charmingpoint type="range" id="movieLevel1" min="1" max="5" step="1" onchange="changeRange1(this.value);"> 
					<input type="text" id="rangeVal1" readonly> 
					</li>
					<br> 
					<li>
					감독연출 : 
					<input name=director type="range" id="movieLevel2" min="1" max="5" step="1" onchange="changeRange2(this.value);"> 
					<input type="text" id="rangeVal2" readonly>
					</li>
					<br> 
					<li>
					OST : 
					<input name=ost type="range" id="movieLevel3" min="1" max="5" step="1" onchange="changeRange3(this.value);"> 
					<input type="text" id="rangeVal3" readonly> 
					</li>
					<br> 
					<li>
					배우 연기력 : 
					<input name=actor type="range" id="movieLevel4" min="1" max="5" step="1" onchange="changeRange4(this.value);"> 
					<input type="text" id="rangeVal4" readonly> 
					</li>
					<br> 
					<li>
					Story : 
					<input name=story type="range" id="movieLevel5" min="1" max="5" step="1" onchange="changeRange5(this.value);"> 
					<input type="text" id="rangeVal5" readonly>
					</li> 
					<br> 
					<li>
					영상미 : 
					<input name=beauty type="range" id="movieLevel6" min="1" max="5" step="1" onchange="changeRange6(this.value);"> 
					<input type="text" id="rangeVal6" readonly>
					</li>
					<br>
					<li>한줄 평 : 
					<textarea name=rcontent id="message" rows="2" cols="50"></textarea>
					</li>
				</ul>
			</fieldset>	
			<div id=btn>
			<br>
			<button class="btn btn-secondary" type="button" onclick="javascript:history.back();">취소하기</button>
			<button class="btn btn-secondary" id="submit" type="submit">등록하기</button>
			</div>
			</form>
			</div>	
		<script>
		function changeRange1(grade) {
            document.getElementById("rangeVal1").value = grade;
        }
		function changeRange2(grade) {
            document.getElementById("rangeVal2").value = grade;
        }
		function changeRange3(grade) {
            document.getElementById("rangeVal3").value = grade;
        }
		function changeRange4(grade) {
            document.getElementById("rangeVal4").value = grade;
        }
		function changeRange5(grade) {
            document.getElementById("rangeVal5").value = grade;
        }
		function changeRange6(grade) {
            document.getElementById("rangeVal6").value = grade;
        }
		function starRange1(grade) {
            document.getElementById("starVal").value = grade;
        }
		</script>
</body>
<%@include file ="../common/footer.jsp" %>
</html>