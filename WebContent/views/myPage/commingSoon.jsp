<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <title>TMI_MOVIE's Coming Soon</title>

  <!-- Bootstrap core CSS -->
  <link href="<%= request.getContextPath() %>/resources/commingSoon/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="<%= request.getContextPath() %>/resources/commingSoon/https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
  <link href="<%= request.getContextPath() %>/resources/commingSoon/https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
  <link href="<%= request.getContextPath() %>/resources/commingSoon/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="<%= request.getContextPath() %>/resources/commingSoon/css/coming-soon.min.css" rel="stylesheet">

</head>

<body>

  <div class="overlay"></div>
  <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
    <source src="<%= request.getContextPath() %>/resources/commingSoon/mp4/bg.mp4" type="video/mp4">
  </video>

  <div class="masthead">
    <div class="masthead-bg"></div>
    <div class="container h-100">
      <div class="row h-100">
        <div class="col-12 my-auto">
          <div class="masthead-content text-white py-5 py-md-0">
            <h1 class="mb-3">Coming Soon!</h1>
            <p class="mb-5">이 사이트의 개발을 완료하기 위해 열심히 노력하고 있습니다.
              <strong>목표 출시일은 2020년 1월입니다!</strong>잠시만 기다려주세요^^</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript -->
  <script src="<%= request.getContextPath() %>/resources/commingSoon/vendor/jquery/jquery.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/commingSoon/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="<%= request.getContextPath() %>/resources/commingSoon/js/coming-soon.min.js"></script>

</body>
</html>