<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,movie.model.vo.* "%>

<%

String contextPath = request.getContextPath();
String mem = request.getParameter("mem");
String mcode = request.getParameter("mcode");
System.out.println(mcode);

	request.setCharacterEncoding("utf-8");
	String[] ch=request.getParameterValues("ch");
	String s="";
	
	for(String c:ch)

		s+=c+" ";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<%for(String a:ch){%>
<input type="text" id="mem" value=<%=mem%>>
<input type="text" id="mcode" value=<%=mcode%>>
<input type="text" id="seat" value=<%=a%>>
<%}%>
<button onclick="go();">완료</button>
<script>
function go(){ 
	var mem = $("#mem").val();
	var mcode = $("#mcode").val();
	var seat = $("#seat").val();
	
	location.href="<%=contextPath%>/inserttk.tk?mem="+mem+"&mcode="+mcode+"&seat="+seat;
	
}
</script>

</body>
</html>