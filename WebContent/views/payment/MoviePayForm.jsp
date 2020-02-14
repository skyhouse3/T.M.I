<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,movie.model.vo.* "%>
<%

ArrayList<Movie> mlist = (ArrayList<Movie>)request.getAttribute("mlist");

String contextPath = request.getContextPath();
String mem = request.getParameter("mem");
System.out.println(mem);
String _row=request.getParameter("row");
String _col=request.getParameter("col"); 


  int row=10, col=10;
if(_row!=null)
	row=Integer.parseInt(_row);
if(_col!=null)
	col=Integer.parseInt(_col); 
int w=30+col*30+col/5*20;
if(col%5==0)
	w-=20;  

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css"
	type="text/css" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<style>
.table .text {
	position: relative;
}

.table .text span {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	position: absolute;
	width: 100%;
}

.text:before {
	content: '';
	display: inline-block;
}

td {
	font-size: 9pt;
	font-family: 돋움;
}
</style>

</head>
<script type="text/javascript">

function send() {
	var f=document.forms[0];
	 // 자바스트립트에서 표현식 사용 가능
	var row="<%=row%>";
	var col="<%=col%>";
	var mem= "<%=mem%>";
	var n=0;
	for(var i=0; i<row*col; i++) {
		if(f.ch[i].checked==true)
			n++;
	}
	if(n<1 || n>5) {
		alert("좌석은 1~5개 까지 가능 합니다.");
		return;
	}
	f.submit();
}

</script>
<body>
	<!-- menu  -->
	<%@include file="../common/menubar.jsp"%>
	<br>
	<br>
	<!-- menu End  -->
	<!--  main   -->


	<form action="views/payment/ch_action.jsp?mem=<%=mem%>" method="post">
		<label>영화: </label> <select id ="mcode" name=mcode>
			<option>----</option>
			<%if(mlist !=null){ %>
			<%for(Movie m : mlist){ %>
			<option value="<%=m.getMcode() %>"><%=m.getMtitle() %></option>
			<%} %>
			<%} %>
		</select>
		

		<table width="<%=w%>">
			<tr height="30">
				<%
	out.println("<td width='30'>&nbsp;</td>");
    for(int i=1; i<=col; i++) {
    	if(i!=1 && i%5==1)
    		out.println("<td width='20'>&nbsp;</td>");
    	out.println("<td width='30' align='center'>"+i+"</td>");
    }
%>
			</tr>
			<%
    String s;
	for(int i=1; i<=row; i++) {
		out.println("<tr height='25'>");
		out.println("<td align='center'>"+i+"</td>");
		for(int j=1; j<=col; j++) {
			if(j!=1 && j%5==1)
				out.println("<td width='20' bgcolor='green'>&nbsp;</td>");
			out.print("<td width='30' align='center'>");
			s=i+":"+j;
			out.print("<input type='checkbox' name='ch' value='"+
			    s+"'>");
			out.println("</td>");
		}
		out.println("</tr><br>");
	}
%>
<input type="text" id="mem" value=<%=mem%>>
		</table>
		<table width="<%=w%>">
			<tr height="50">
				<td align="left"><input type="button" value="좌석예약"
					onclick="send();"></td>
			</tr>
		</table>
		
	</form>


	<!-- main  -->

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
	<!-- footbar  -->
	<%@include file="../common/footer.jsp"%>
	<!-- footbar End  -->


</body>
</html>