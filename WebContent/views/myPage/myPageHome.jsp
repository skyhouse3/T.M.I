<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String msg = (String)request.getSession().getAttribute("msg");
%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>TMI.MOVI's</title>
<script>
	var msg = "<%= msg %>";

	$(function() {
		if (msg != "null") {
			
			alert(msg);
			<% request.getSession().removeAttribute("msg"); %>
		}
		/* if (msg == "성공적으로 회원정보를 수정했습니다.") {
			window.close();
		}  */
	});
</script>

<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath() %>/resources/myPageMain/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/resources/myPageMain/css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

<%@include file ="../common/menubar.jsp" %>

	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<div class="list-group list-group-flush">
				<a href="<%= request.getContextPath() %>/views/myPage/updateJoinForm.jsp" class="list-group-item list-group-item-action bg-light" name="updateForm">회원 수정 및 탈퇴</a>
				<a href="<%= request.getContextPath() %>/views/myPage/commingSoon.jsp" class="list-group-item list-group-item-action bg-light">영화 예매 확인 및 취소</a>
				<a href="<%= request.getContextPath() %>/views/myPage/commingSoon.jsp" class="list-group-item list-group-item-action bg-light">장바구니 확인 및 취소</a>
				<a href="<%= request.getContextPath() %>/views/myPage/commingSoon.jsp" class="list-group-item list-group-item-action bg-light">회원 등급 확인</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">결재내역 확인</a>
				<!-- <a href="#" class="list-group-item list-group-item-action bg-light">메뉴6</a> -->
			</div>
		</div>
		<!-- /#sidebar -->
	</div>
	<!-- /#wrapper -->

	<!-- Bootstrap core JavaScript -->
	<script src="<%= request.getContextPath() %>/resources/myPageMain/vendor/jquery/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/myPageMain/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>