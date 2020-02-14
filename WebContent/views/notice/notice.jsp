<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.*, question.model.vo.*, joinPage.model.vo.*"%>
<%
   ArrayList<Question> list = (ArrayList<Question>) request.getAttribute("list");
   String contextPath = request.getContextPath();
   String mem = (String) request.getAttribute("mem");
   System.out.println(mem);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" 
integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" 
crossorigin="anonymous">
</script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<style>
#content {
   width: 115%;
}

#content-1 {
   margin-left: 17%;
   width: 25%;
   height: 20%;
   display: inline-block;
}

#content-2 {
   width: 25%;
   height: 10%;
   display: inline-block;
}

#content-2-1 {
   width: 100%;
   height: 30%;
   display: inline-block;
}

#content-3 {
   margin-left: 23%;
}

#qnalogo {
   margin-left: 25%;
}

#qnalogo2 {
   margin-left: 6%;
   display: inline-block;
}

#accordian li {
   list-style: none !important;
   list-style-type: none !important;
   margin-bottom: 10px;
}

#accordian li>h3 {
   cursor: pointer;
}

li>ul {
   display: none;
   list-style: none !important;
   list-style-type: none !important;
}

li>ul>li {
   color: #000;
   list-style: none !important;
   list-style-type: none !important;
}

li>ul>li>table {
   margin-top: 10px;
   margin-bottom: 10px;
}

a {
   text-decoration: none;
}

p {
   text-align: right;
}

#leftgo {
   text-align: right;
}
</style>

</head>
<body>
   <%@include file="../common/menubar.jsp"%>
   
   <br><br><br>
   <div id="qnalogo">
      <img src="/kh-SemiProject-T.M.I/resources/img/review/logo.PNG"
         width="70%" height="20%"> <img
         src="/kh-SemiProject-T.M.I/resources/img/review/logo-1.PNG"
         width="70%" height="20%">
   </div>
   <br><br><br><br>
   <div id="content">   
      <div id="content-1">
         <h2>&nbsp;&nbsp;&nbsp;FAQ TOP5</h2>
         <div id="accordian">
            <ul>
               <li>
                  <h4 id="acc1">
                     1. 회원가입은 어떻게 하나요?<span id="plus1">+</span>
                  </h4>
                  <ul>
                     <li>사이트에 접속했을 때 해당 페이지의 회원가입 버튼을 클릭한 이후 입력 사항을 입력해주세요</li>
                  </ul>
               </li>
               <li>
                  <h4 id="acc2">
                     2. 온라인 예매 후 예매내역 확인하고 싶어요<span id="plus2">+</span>
                  </h4>
                  <ul>
                     <li>내용</li>
                  </ul>
               </li>
               <li>
                  <h4 id="acc3">
                     3. 예매 취소는 어떻게 하나요?<span id="plus3">+</span>
                  </h4>
                  <ul>
                     <li>내용</li>
                  </ul>
               </li>
               <li>
                  <h4 id="acc4">
                     4. 포인트 적립을 못받았는데 어떻게 하나요?<span id="plus4">+</span>
                  </h4>
                  <ul>
                     <li>내용</li>
                  </ul>
               </li>
               <li>
                  <h4 id="acc5">
                     5. 포인트 소멸은 언제, 어떻게 이루어지나요?<span id="plus5">+</span>
                  </h4>
                  <ul>
                     <li>내용</li>
                  </ul>
               </li>
            </ul>
         </div>
         <div id="leftgo">
            <button id="insertBtn" class="btn btn-secondary"
               onclick="location.href='<%=contextPath%>/list.qu?mem=<%=mem%>'">더보기</button>
         </div>
      </div>

      &nbsp;&nbsp;
      <div id="content-2">
         <h2>&nbsp;공지사항</h2>
         <ul>
            <li>[CGV 구로] 주차 요금 유인 정산 진행</li>
            <li>[롯데시네마 광교아울렛] 주차 변경안내</li>
            <li>[메가박스 강남] <82년생 김지영> 무대인사</li>
         </ul>
         <div id="leftgo">
            <button id="insertBtn" class="btn btn-secondary"
               onclick="location.href='<%=contextPath%>/views/notice/noticeBoard.jsp'">더보기</button>
         </div>
         <div id="content-2-1">
            <h2>&nbsp;1:1 문의</h2>
            &nbsp;&nbsp;더 궁금하신점이 있다면 1:1문의를 이용해주세요
            <div id="leftgo">
               <button id="insertBtn" class="btn btn-secondary"
                  onclick="location.href='<%=contextPath%>/qna.qu?mem=<%=mem%>'">더보기</button>
            </div>
         </div>
      </div>

      <div id="qnalogo2">
         <img src="/kh-SemiProject-T.M.I/resources/img/review/logo2.PNG"
            width="100%" height="100%">
      </div>

      <br> <br>
      <div id="content-3">
         <img src="/kh-SemiProject-T.M.I/resources/img/review/11.jpg"
            width="60%" height="50%">
      </div>
   </div>

   <script>
      $(function() {
         $("#accordian h4").click(function() {

            var clickval = ($(this).attr('id'));

            var plus1 = $("#plus1").text();
            var plus2 = $("#plus1").text();
            var plus3 = $("#plus1").text();
            var plus4 = $("#plus1").text();
            var plus5 = $("#plus1").text();

            if (clickval == 'acc1') {
               if ($("#plus1").text() == '-') {
                  $("#plus1").text(plus1.replace('-', '+'));
               } else {
                  $("#plus1").text(plus1.replace('+', '-'));
               }
               $("#plus2").text(plus2.replace('-', '+'));
               $("#plus3").text(plus3.replace('-', '+'));
               $("#plus4").text(plus4.replace('-', '+'));
               $("#plus5").text(plus5.replace('-', '+'));
            }

            if (clickval == 'acc2') {
               if ($("#plus2").text() == '-') {
                  $("#plus2").text(plus2.replace('-', '+'));
               } else {
                  $("#plus2").text(plus2.replace('+', '-'));
               }
               $("#plus1").text(plus1.replace('-', '+'));
               $("#plus3").text(plus3.replace('-', '+'));
               $("#plus4").text(plus4.replace('-', '+'));
               $("#plus5").text(plus5.replace('-', '+'));
            }

            if (clickval == 'acc3') {
               if ($("#plus3").text() == '-') {
                  $("#plus3").text(plus3.replace('-', '+'));
               } else {
                  $("#plus3").text(plus3.replace('+', '-'));
               }
               $("#plus1").text(plus1.replace('-', '+'));
               $("#plus2").text(plus2.replace('-', '+'));
               $("#plus4").text(plus4.replace('-', '+'));
               $("#plus5").text(plus5.replace('-', '+'));
            }

            if (clickval == 'acc4') {
               if ($("#plus4").text() == '-') {
                  $("#plus4").text(plus4.replace('-', '+'));
               } else {
                  $("#plus4").text(plus4.replace('+', '-'));
               }
               $("#plus1").text(plus1.replace('-', '+'));
               $("#plus2").text(plus2.replace('-', '+'));
               $("#plus3").text(plus3.replace('-', '+'));
               $("#plus5").text(plus5.replace('-', '+'));
            }

            if (clickval == 'acc5') {
               if ($("#plus5").text() == '-') {
                  $("#plus5").text(plus5.replace('-', '+'));
               } else {
                  $("#plus5").text(plus5.replace('+', '-'));
               }
               $("#plus1").text(plus1.replace('-', '+'));
               $("#plus2").text(plus2.replace('-', '+'));
               $("#plus3").text(plus3.replace('-', '+'));
               $("#plus4").text(plus4.replace('-', '+'));
            }
            $("#accordian ul ul").slideUp();
            if (!$(this).next().is(":visible")) {
               $(this).next().slideDown();
            }
         })
      })
   </script>
</body>
</html>