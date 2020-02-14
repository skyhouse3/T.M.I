<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--  <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
    <title>Document</title>
    <style>
       #copyright{
            width:100%;
            height:230px;
            background-color:#ddd;
        }
        .footer{
        	margin-left: 10%;
            margin-right: 10%;
        }

        .informdetails{
            padding-top:3%;
            font-size: 15px;
        }
                            
        .copyrights-menus{
            float: right;
        }
        #cp-a{
            text-decoration:none;
            color:black;
            margin: 12px;
            font-size: 15px;
        }

    </style>


</head>
<body>
  <footer> 

                <!-- Copyrights
                ============================================= -->
                <div id="copyright">
    
                    <div class="container footer clearfix">
                            <div class="copyrights-menus" >
                                    <a id="cp-a" href="#">회사소개</a> <a id="cp-a" href="#">채용정보</a> <a id="cp-a" href="#">광고/프로모션문의</a> <a id="cp-a" href="#">이용약관</a> <a id="cp-a" href="#">개인정보처리방침</a> 
                                </div>
                        <div class="informdetails">
                            <img src="<%= request.getContextPath() %>/resources/images/logo1.png" alt="" class="footer-logo standard-logo" width="10%">
                           
                            <p class="infodetails">서울 강남구 테헤란로10길 9지번 서울 강남구 역삼동 823-42<br>
                                                  대표이사:김민교 | 사업자 번호:1906-18-200207 | 통신판매업신고번호:2019-서울강남-0618<br>
                                                  개인정보보호 책임자:최승호 | 대표이메일:tmi3jo@kh.com | 대표번호:2019-0618
                            </p>
                        </div>
    
                        
                    </div>
    
                </div><!-- #copyrights end -->
    
            </footer><!-- #footer end -->
</body>
</html>