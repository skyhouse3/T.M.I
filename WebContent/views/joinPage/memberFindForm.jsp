<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>비밀번호 찾기</h1><br><br>
	<form name="write_form_member" id="write_form_member"
		action="<%=request.getContextPath()%>/find.jo" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" maxlength="50" name="User_Id" required> 
				</td>
			</tr>
			<tr>
				<th>비밀번호 힌트/답변</th>
				<td><select name='PW_HINT' size='1' class='select' >
						<option value=''>선택하세요</option>
						<option value='졸업한 초등학교 이름은?'>졸업한 초등학교 이름은?</option>
						<option value='제일 친한 친구의 핸드폰 번호는?'>제일 친한 친구의 핸드폰 번호는?</option>
						<option value='아버지 성함은?'>아버지 성함은?</option>
						<option value='어머니 성함은?'>어머니 성함은?</option>
						<option value='어릴 적 내 별명은?'>어릴 적 내 별명은?</option>
						<option value='가장 아끼는 물건은?'>가장 아끼는 물건은?</option>
						<option value='좋아하는 동물은?'>좋아하는 동물은?</option>
						<option value='좋아하는 색깔은?'>좋아하는 색깔은?</option>
						<option value='좋아하는 음식은?'>좋아하는 음식은?</option>
				</select></td>
			</tr>
			<tr>
				<th>답변</th>
				<td><input type='text' maxlength="50" name='HINT'></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><br>
					<button id="joinBtn">비밀번호 찾기</button> 
					<input type="reset" onclick="history.back();" value="취소">
				</td>
			</tr>		
		</table>
	</form>


</body>
</html>