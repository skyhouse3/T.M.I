<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, snack.model.vo.Snack"%>
    <% 
	ArrayList<Snack> de = (ArrayList<Snack>)request.getAttribute("DeList");
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <title>Document</title>

    <style>
        .snack-detail-wrap{
            width:100%;
            height:550px;
        }
        #snack-detail-inner{
            margin-left: 10%;
            margin-right:10%;
            height: 70%;
        }
        #snack-detail-left{
            float:left;
            width: 45%;
            border-right: 1px solid black;
            height: 380px;
            
        }
        #snack-detail-right{
            float:right;
            width: 50%;
            
            
        }
        #detail-li{
            display: inline;
            margin-left: 10px; 
        }
        #detail-table{
            height: 40%;
            margin-top: 3%;
            margin-bottom: 3%;
        }
        #detail-table>th{
            display: block;
        }
        #quantity{
            width:62%;
            background-color:#f5f5f5;
            height: 80px;
        }
        
        #quantity-input{
            width: 90px;
            height: 30px;
            padding: 6px 10px 10px 10px;
            border: 0;
            color: #242021;
            font-size: 36px;
            font-weight: bold;
            font-family: 'linlivertine';
            text-align: center;
            vertical-align: middle;
            background: #f5f5f5;
            margin-bottom: 20px;
        }
        #minus{
            margin-left: 27%;
            margin-top:30px; 
        }
        #basket-snack-detail{
            margin-top: 5%; 
            height: 70px;
            width: 150px;
        }
        #snack-all-list{
            margin-left:70px;
            height: 70px;
            width: 150px;
        }
        #pd-image{
        	margin-left:100px;
        	margin-top:50px;
        }
        #skCode{
        	display:none;
        }
        
        
  </style>
</head>
<body>
<%@include file ="../common/menubar.jsp" %>

	<form action="<%=request.getContextPath()%>/InsertBasket.sn" method="post">
        <% if(de.isEmpty()){ %>
			
				<% } else { 
				for(Snack s : de){%>
       		
       		<div class="snack-detail-wrap">
            <div id="snack-detail-inner">
                <div id="snack-detail-left">
                    <img id="pd-image" src="<%= request.getContextPath() %>/resources/images/snackimage/snack/<%= s.getPicture() %>.jpg"alt="">
                </div>
                <div id="snack-detail-right">
                	
                        <p><strong><%= s.getSkName() %></strong></p>
                        <p>가격 : <%= s.getSkPrice() %></p>
                        <div id="detail-table">
                        <th>상품구성 : </th><td><li id="detail-li"><%= s.getSkcontent() %></li></td><br>
                        <th>구매제한 : </th><td><li id="detail-li">5개이하</li></td>
                        <input id="Ccode" type="hidden" name="Ccode" value="<%= s.getCcode()%>">
                        <input id="skCode" readonly="readonly" name="skCode" value="<%= s.getSkCode() %>">
                        </div>
                        <div id="quantity">
                            <a id="minus-a"><img id="minus" src="<%= request.getContextPath() %>/resources/images/snackimage/quantityIcon/minus.jpg"></a>
                            <input id="quantity-input" type="text" name="skQuantity" value="1" readonly="readonly">
                            <a id="plus-a"><img id="plus" src="<%= request.getContextPath() %>/resources/images/snackimage/quantityIcon/plus.jpg"></a>
                        </div>
                        <button id="basket-snack-detail" type="submit">장바구니넣기</button>
                        <input id="kinds"  name="kinds" value="<%= s.getKinds()%>" type="hidden"> 
                        <button id="snack-all-list" onclick="goPList();">상품 리스트</button>
                </div>
            </div>
        </div>
       		
				<%}
				}%>
				</form>
<script>	
		$(function(){
			$("#minus").click(function(){
				if(Number($("#quantity-input").val())>1){
				$(this).parent().siblings('input').val(Number($(this).parent().siblings('input').val())-1);
				
				}else{
					$(this).parent().siblings('input').val(Number($(this).parent().siblings('input').val())-0);
					alert("1개 이상의 상품을 선택해주세요")
				}
				});	
			$("#plus").click(function(){
				if(Number($("#quantity-input").val())<5){
				$(this).parent().siblings('input').val(Number($(this).parent().siblings('input').val())+1);
				
				}else{
					$(this).parent().siblings('input').val(Number($(this).parent().siblings('input').val())+0);
					alert("5개 이하만 구매 가능합니다")
				}
					});
				
		});
		var kinds = $("#kinds").val();
		var Ccode = $("#Ccode").val();
		function goPList(){
			location.href="<%=request.getContextPath()%>/SnackList.sn?kinds="kinds+"&Ccode="+Ccode;
		}
				
				</script>
        
            <%@include file ="../common/footer.jsp" %>
</body>
</html>