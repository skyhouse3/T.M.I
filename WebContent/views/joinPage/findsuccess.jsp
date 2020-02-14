<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String pwd = (String)request.getAttribute("pwd");
	System.out.println(pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<style>
body {
	background-image: url("../../resources/mainLogin/images/login2.jpg");
	background-size: 100%;
	margin: 7%;
	padding: auto;
}

table {
	width: 1100px;
	height: 600px;
	/* border: 3px solid black; */
	margin: auto;
}

h1 {
	text-align: center;
	text-decoration-line: underline;
}
</style>
</head>
<body>
	<h1>비밀번호 확인</h1><br><br>
	<form name="write_form_member" id="write_form_member"
		action="<%=request.getContextPath()%>/find.jo" method="post" onsubmit="return joinValidate();">
		<table>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" maxlength="50" name="User_Id" value="<%=pwd%>"> 
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><br>
					<button id="joinBtn" onclick="history.go(-2); return false;">메인으로</button> 
				</td>
			</tr>		
		</table>
		
	</form>


</body>
</html>