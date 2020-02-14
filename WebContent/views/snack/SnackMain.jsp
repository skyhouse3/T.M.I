<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, snack.model.vo.Snack" %>
<% 
ArrayList<Snack> sn = (ArrayList<Snack>)request.getAttribute("snList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>

    <style>
        .snack-content{
            margin-left: 10%;
            margin-right: 10%;
        }

        #snack-nav-wrap{
        background:white;
		width:100%;
		height:30%;
        border-block-end: 1px solid black;
        border-block-start:1px solid black; 
        
        }
        
        
        .sanck-nav{
        width:100%;
        }
        
        #snack-nav1{
        background:white;
		color:black;
		text-align:center;
        vertical-align: middle;
		width:150px;
        height: 30px;
		margin-top:5px;
		display:inline-block;
        padding-left: 115px;

        }
        
        a{
        color:black;
        text-decoration: white;    
        }
        
        #snack-nav1:hover a{
            color: orange;
        }
        
        #snack-prd{
        	height : 70%;
        }
        
        #snack-prd-li{
            list-style: none;
            width: 20%;
            display: inline-block;
            margin: 6%;
            margin-bottom: 0;
            margin-top: 0;
        }
        
        #price{
            margin-top:0;
            margin-bottom: 0;
        }
        
        #snack-main-image{
        	width:100%;
        }
        #skcode{
        display:none;
        }
        #snack-main-image{
        	padding-left:7%;
        	padding-top:3%;

        }
        
        
    </style>
</head>
<body>
<%@include file ="../common/menubar.jsp" %>
<br><br><br><br>

	<div id="snack-main-image"><img src="<%= request.getContextPath() %>/resources/images/snackimage/snackmain.jpg"></div>
    <div class="snack-content">
    <nav>
        <div id="snack-nav-wrap">
            <ul class="snack-nav">
                <li id="snack-nav1"><a onclick="goSnackCom();">콤보</a></li>
                <li id="snack-nav1"><a onclick="goSnackPop();">팝콘</a></li>
                <li id="snack-nav1"><a onclick="goSnackDri();">음료</a></li>
                <li id="snack-nav1"><a onclick="goSnackEtc();">스낵</a></li>
            </ul>
        </div>
    </nav>
    <div id="snack-prd">
     <%if(sn.isEmpty()){ %>
			
				<% } else { 
				for(Snack s : sn){%>
				
			<li id="snack-prd-li">
			
	            <img id="detail-image"  src="<%= request.getContextPath() %>/resources/images/snackimage/snack/<%= s.getPicture() %>.jpg" height="200px">
	            <dl>
	            	<dt id="product-name" ><strong><%= s.getSkName() %></strong></dt>
	            	<dt id="price">가격:<%= s.getSkPrice() %></dt>
	            	<dt id="price">구성품:<%= s.getSkcontent() %></dt>
	            </dl>
	            <input id="input" type="hidden" value="<%= s.getSkCode() %>">
	            <input id="input2" type="hidden" value="<%= s.getCcode() %>">
	            
       		</li>
       		
				<%}
				}%>
	<script>
       		$("img").click(goSnackltDe);
       		function goSnackltDe(){
       			var code =	$(this).siblings('input').val();
       			//console.log(code);
       			location.href='<%= request.getContextPath() %>/SnackDetail.sn?skCode='+code;
       		}
       		</script>
    </div>
    </div>
     <script>
     
     
			var Ccode = $('#input2').val();
          function goSnackCom(){
    			location.href="<%=request.getContextPath()%>/SnackList.sn?kinds=c&Ccode="+Ccode;
    			console.log(Ccode);
    		}
          function goSnackPop(){
  			location.href="<%=request.getContextPath()%>/SnackList.sn?kinds=p&Ccode="+Ccode;
  		}
          function goSnackDri(){
  			location.href="<%=request.getContextPath()%>/SnackList.sn?kinds=d&Ccode="+Ccode;
  		}
          function goSnackEtc(){
        	  location.href="<%=request.getContextPath()%>/SnackList.sn?kinds=e&Ccode="+Ccode;
  		}
            
          </script>
   
    <%@include file ="../common/footer.jsp" %>

    
</body>
</html>
