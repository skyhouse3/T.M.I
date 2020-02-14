<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	var msg = "<%= msg %>";

	$(function() {
		if (msg != "null") {
			alert(msg);
		}
		if (msg == "비밀번호 변경을 완료하였습니다.") {
			window.close();
		}
	});
</script>
<style>
h3 {
	text-align: center;
}

table {
	margin: auto;
}

td {
	text-align: right;
}

button {
	height: 22px;
	width: 100px;
	background: yellowgreen;
	border: yellowgreen;
	color: white;
	border-radius: 5px;
}

button:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<h3>비밀번호 변경</h3>
	<br>
	<form id="updatePwForm"
		action="<%=request.getContextPath()%>/updatePw.me" method="post" onsubmit="return checkPwd();">
		<table>
			<tr>
				<td><label>현재 비밀번호</label></td>
				<td width="50"></td>
				<td><input type="password" name="User_pw" id="User_pw"
					maxlength="50"></td>
			</tr>
			<tr>
				<td><label>변경할 비밀번호</label></td>
				<td></td>
				<td><input type="password" name="newPw" id="newPw"
					maxlength="50"></td>
			</tr>
			<tr>
				<td><label>변경할 비밀번호 확인</label></td>
				<td></td>
				<td><input type="password" name="newPw2" id="newPw2"
					maxlength="50"></td>
			</tr>
		</table>
		<br>
		<br>
		<div class="btns" align="center">
			<button id="updatePwBtn">변경하기</button>
		</div>
	</form>
	
	<script>
		function checkPwd(){
			var User_pw = $("#User_pw");
			var newPw = $("#newPw");
			var newPw2 = $("#newPw2");
			
			if(User_pw.val().trim() == "" || newPw.val().trim() == ""
					|| newPw2.val().trim() == ""){
				alert("비밀번호를 입력해주세요.");
				return false;
				}
			
			if(newPw.val() != newPw2.val()){
				alert("비밀번호가 다릅니다.");
				newPw2.select();
				return false;
			}
			return true;
		}
	</script>

</body>
</html>