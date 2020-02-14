<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, movie.model.vo.*"%>
<%
	ArrayList<Movie> mc = (ArrayList<Movie>)request.getAttribute("cList");
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    
  	
<style>
.navbar{
	
	padding-left:10%;
	width:100%;
	
}

</style>
</head>
<body>
<header class="navbar">
	<%@include file ="../common/menubar.jsp" %>
</header>
<div class="container">
<!-- movie - tab-list  -->
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" onclick="goChart1();">개봉일</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" onclick="goChart2();">평점</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" onclick="goChart3();">예매율</a>
        </li>
    </ul>
<!--  -->

    <br>
    <div class="tab-content">
         <!-- qwe 영역 -->
        <div class="tab-pane fade show active" id="qwe">
            <div class="row movie-list" >
                <div class="col-8">
                <!-- 영화 리스트 -->
                    <hr>
                    
                     <%if(mc.isEmpty()){ %>
			
				<% } else { 
				for(Movie m : mc){
				int num = (int)(Double.parseDouble(m.getReservationrate()) * 100);
				%>
				
			<div class="card">
                    <div class="row no-gutters">
                        <div class="col-4">
                            <img src="<%=request.getContextPath() %>/resources/MovieImg_upload/<%= m.getChange_name() %>"  class="card-img main-movie-img" />
                        </div>
                    <div class="col-8">
                        <div class="card-body">
                            <h4><%= m.getMtitle() %></h4>
                            <p class="card-text">예매율 :<span class="point"> <%= num %>%</span> &nbsp;|&nbsp; <span class="point">평점 : <%= m.getRrate()%></span></p>
                            <p class="card-text">
                                <ul class="movie-info">
                                    <li><span>기본정보개봉 : </span><%= m.getRelease() %>/<%= m.getKinds() %> </li>
                                    <li><span>감독 : </span> <%= m.getmDirector() %></li>
                                    <li><span>배우 : </span> <%= m.getmActor() %></li>
                                </ul>
                            </p>
                        </div>
                    </div>
                    </div>
                   
                </div>
       		
				<%}
				}%>
          
                <hr>
                
                <!-- next movie area -->
                       

                </div>
                <!-- 영화 리스트 end -->
                <div class="col-4 float-right">
                <h4 align="center">연령별 예매 순위</h4>
                <!-- movie kind -rank - tab - list  -->
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#20s" onclick="replay(50);">20대</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#30s">30대</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#40s">40대</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#50s">50대</a>
                    </li>
                </ul>

                <!-- tab-20,30,40,50대  choice tab end  -->
                   
                    <div class="tab-content">
                        <!-- 20대 탭 -->
                        <div class="tab-pane fade show active" id="20s">
                            <!-- 예매율 start -->
                            <!-- collapsible start -->
                            <div class="accordion" id="accordionExample">
                            <div class="card">
                                <div class="card-header" id="headingOne">
                                    <h2 class="mb-0">
                                        <button class="btn btn-link small-movie-title" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" onclick="replay();">
                                            1.터미네이터2 3D
                                        </button>
                                    </h2>
                                </div>
                            </div>
                            <!-- collapsible end -->
                        </div> 
                    </div>
                    <!-- 예매율 end -->
                    <!-- 30대 탭 -->
                    <div class="tab-pane fade show active" id="30s">

                    </div>
                    <!-- 40대 탭 -->
                    <div class="tab-pane fade show active" id="40s">
                        
                    </div>
                    <!-- 50대 탭 -->
                    <div class="tab-pane fade show active" id="50s">
                        
                    </div>
                </div>
                </div>         
            </div>     
        </div>   
        <!-- qwe영역 끝 -->
        
        <!-- asd 영역 시작 -->
        <div class="tab-pane fade" id="asd">
        </div><!--asd 영역 끝-->

        <!-- zxc 영역 시작 -->
        <div class="tab-pane fade" id="zxc">
        </div>
        <!-- zxc영역 끝 -->

    </div>
</div>
<%@include file="../common/footer.jsp" %>

<script>
function goChart1(){
	location.href="<%=request.getContextPath()%>/clist.mo?ver=a"
}
function goChart2(){
	location.href="<%=request.getContextPath()%>/clist.mo?ver=b"
}
function goChart3(){
	location.href="<%=request.getContextPath()%>/clist.mo?ver=c"
}
</script>

            
          
</body>
</html>