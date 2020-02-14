<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="joinPage.model.vo.*, java.util.*"%>
<%
	Join j = (Join)session.getAttribute("loginUser");

	String User_Id = j.getUser_Id();
	String User_pw = j.getUser_pw();
	String PW_HINT = j.getPW_HINT();
	String HINT = j.getHINT();
	String User_name = j.getUser_name();
	String gender = j.getGender();
	String Birth = j.getBirth();
	String Phone = (j.getPhone() != null) ? j.getPhone() : "";
	String Email = (j.getEmail() != null) ? j.getEmail() : "";
	String Address = (j.getAddress() != null) ? j.getAddress() : "";
	
	String[] checkFavorite = new String[6];
	
	if(j.getFavorite() != null){
		String[] Favorites = j.getFavorite().split(",");
		
		for(int i = 0; i < Favorites.length; i++){
			switch(Favorites[i]){
			case "액션" : checkFavorite[0] = "checked"; break;
			case "SF / 판타지" : checkFavorite[1] = "checked"; break;
			case "드라마" : checkFavorite[2] = "checked"; break;
			case "로맨틱" : checkFavorite[3] = "checked"; break;
			case "코미디" : checkFavorite[4] = "checked"; break;
			case "애니메이션" : checkFavorite[5] = "checked"; break;
			}
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
body {
	background-image: url("../../resources/mainLogin/images/login2.jpg");
	background-size: 100%;
	margin: 7%;
	padding: auto;
}

table {
	width: 1000px;
	height: 600px;
	border: 2px solid black;
	margin: auto;
}

h1 {
	text-align: center;
	text-decoration-line: underline;
}
</style>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form name="updateForm" id="updateForm" action="<%=request.getContextPath()%>/update.me" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" maxlength="50" name="User_Id" value="<%= User_Id %>" readonly></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" maxlength="50" name="User_Pw" readonly></td>
				<td><button id="pwdUpdateBtn" onclick="updatePw();" type="button">비밀번호 변경</button></td>
			</tr>

			<tr>
				<th>비밀번호 힌트/답변</th>
				<td><select name='PW_HINT' size='1' class='select'>
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
				<th>이름</th>
				<td><input type="text" maxlength="50" name="User_name" value="<%= User_name %>" required></td>
			</tr>

			<tr>
				<th>성별</th>
				<td><input type="checkbox" name="gender" value="남자" /> 남자 <input
					type="checkbox" name="gender" value="여자" /> 여자</td>
			</tr>
			
			<tr>
				<th>생년월일</th>
				<td><input type="text" maxlength="50" name="Birth" value="<%= Birth %>"></td>
			</tr>


			<tr>
				<th>핸드폰 번호</th>
				<td><input type="tel" maxlength="20" name="Phone" placeholder="(-없이 입력)" value="<%= Phone %>"></td>
			</tr>

			<tr>
				<th>이메일</th>
				<td><input type="Email" name="Email" value="<%= Email %>"></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" name="Address" placeholder="서울시 강남구 역삼동 123-123" value="<%= Address %>"></td>
			</tr>

			<tr>
				<th>관심분야</th>
				<td>
					<input type='checkbox' name='Favorite' value='액션' <%= checkFavorite[0] %>>액션 
					<input type='checkbox' name='Favorite' value='SF / 판타지' <%= checkFavorite[1] %>> SF / 판타지 
					<input type='checkbox' name='Favorite' value='드라마' <%= checkFavorite[2] %>> 드라마
					<input type='checkbox' name='Favorite' value='로맨틱' <%= checkFavorite[3] %>> 로맨틱 
					<input type='checkbox' name='Favorite' value='코미디' <%= checkFavorite[4] %>> 코미디 
					<input type='checkbox' name='Favorite' value='애니메이션' <%= checkFavorite[5] %>> 애니메이션
					
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><br>
					<button id="updateBtn">수정 하기</button>
					<button id="deleteBtn" onclick="deleteMember();">회원 탈퇴</button>
				</td>
			</tr>
			
		</table>
	</form>
	
	<script>
	
	// 메인으로 돌아가기
		<%-- function returnToMain(){
			location.href = "<%= request.getContextPath() %>";
		} --%>
			
		// 비밀번호 변경 새창 띄우기
		function updatePw(){
			window.open("pwUpdateForm.jsp", "비밀번호 변경 창", "width=500, height=300");
			
			}
		
		// 회원 탈퇴
		function deleteMember(){
			var pw = prompt("비밀번호를 입력해주세요.");
			
			if("<%= User_pw %>" == pw){
				var bool = confirm("탈퇴하시겠습니까?");
				
				if(bool){
					$("#updateForm").attr("action", "<%= request.getContextPath() %>/delete.me");
					$("#updateForm").submit();
				}
			} else {
				alert("비밀번호를 잘못 입력하였습니다.");
			}
		}
		
		
	</script>

</body>
</html>