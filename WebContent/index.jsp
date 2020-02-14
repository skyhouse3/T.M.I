<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
   <title>TMI MOVIE's</title>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->   
   <link rel="icon" type="image/png" href="<%= request.getContextPath() %>/resources/mainLogin/images/icons/favicon.ico"/>
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>resources//mainLogin/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/mainLogin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/mainLogin/vendor/animate/animate.css">
<!--===============================================================================================-->   
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/mainLogin/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/mainLogin/vendor/select2/select2.min.css">
<!--===============================================================================================-->
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/mainLogin/css/util.css">
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/mainLogin/css/main.css">
<!--===============================================================================================-->

</head>
<body>
   <div class="limiter">
      <div class="container-login100">
         <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
               <img src="resources/mainLogin/images/logo1.png" alt="IMG">
            </div>

            <form class="login100-form validate-form" action="<%=request.getContextPath()%>/login.jo" method="post">
               <span class="login100-form-title">
                  TMI MOVIE's
               </span>

               <div class="wrap-input100 validate-input" data-validate = "ID is required">
                  <input class="input100" type="text" name="User_Id" placeholder="ID">
                  <span class="focus-input100"></span>
                  <span class="symbol-input100">
                     <i class="fa fa-user" aria-hidden="true"></i>
                  </span>
               </div>

               <div class="wrap-input100 validate-input" data-validate = "Password is required">
                  <input class="input100" type="password" name="User_Pw" placeholder="Password">
                  <span class="focus-input100"></span>
                  <span class="symbol-input100">
                     <i class="fa fa-lock" aria-hidden="true"></i>
                  </span>
               </div>
               
               <div class="container-login100-form-btn">
                  <button class="login100-form-btn">
                     로그인
                  </button>
               </div>

               <div class="text-center p-t-12">
                  <!-- <span class="txt1"> -->
                     
                  <!-- </span> -->
                  <a class="txt2" href="<%= request.getContextPath() %>/views/joinPage/memberFindForm.jsp">
                     비밀번호 찾기
                  </a>
               </div>

               <div class="text-center p-t-136">
                  <a class="txt2" href="<%= request.getContextPath() %>/views/joinPage/memberJoinForm.jsp">
                     회원가입
                     <i class="fa fa-sign-in" aria-hidden="true"></i>
                  </a>
               </div>
            </form>
         </div>
      </div>
   </div>

   
   
<!--===============================================================================================-->   
   <script src="<%= request.getContextPath() %>/resources/mainLogin/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
   <script src="<%= request.getContextPath() %>/resources/mainLogin/vendor/bootstrap/js/popper.js"></script>
   <script src="<%= request.getContextPath() %>/resources/mainLogin/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
   <script src="<%= request.getContextPath() %>/resources/mainLogin/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
   <script src="<%= request.getContextPath() %>/resources/mainLogin/vendor/tilt/tilt.jquery.min.js"></script>
   
   <script >
      $('.js-tilt').tilt({
         scale: 1.1
      })
   </script>
   
<!--===============================================================================================-->
   <script src="<%= request.getContextPath() %>/resourcesmainLogin/js/main.js"></script>

</body>
</html>