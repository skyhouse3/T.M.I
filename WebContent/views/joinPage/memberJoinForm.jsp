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
   <h1>회원가입</h1><br><br>
   <form name="write_form_member" id="write_form_member"
      action="<%=request.getContextPath()%>/insert.jo" method="post" onsubmit="return joinValidate();">
      <table>
         <tr>
            <th>아이디</th>
            <td><input type="text" maxlength="50" name="User_Id" required> 
            <!-- <input name="idCheck" type="button" value="중복확인"> -->
            <button id="idCheck" type="button">중복확인</button>
            </td>
         </tr>

         <tr>
            <th>비밀번호</th>
            <td><input type="password" maxlength="50" name="User_Pw" required> 영문/숫자포함 6자 이상</td>
         </tr>

         <tr>
            <th>비밀번호 확인</th>
            <td><input type="password" maxlength="50" name="User_Pw2" required></td>
            <td><label id="pwdResult"></label></td>
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
            <th>이름</th>
            <td><input type="text" maxlength="50" name="User_name"></td>
         </tr>

         <tr>
            <th>생년월일</th>
            <td>
            <!-- <input type="text" maxlength="50" name="Birth"> -->
            <input type="date" class="input-data" name="Birth">
            
            </td>
         </tr>

         <tr>
            <th>성별</th>
            <td><input type="checkbox" name="gender" value="남자" /> 남자 <input
               type="checkbox" name="gender" value="여자" /> 여자</td>
         </tr>

         <tr>
            <th>핸드폰 번호</th>
            <td><input type="tel" maxlength="20" name="Phone" placeholder="(-없이 입력)"></td>
         </tr>

         <tr>
            <th>이메일</th>
            <td><input type="Email" name="Email"></td>
         </tr>

         <tr>
            <th>주소</th>
            <td><input type="text" name="Address" placeholder="서울시 강남구 역삼동 123-123"></td>
         </tr>

         <tr>
            <th>관심분야</th>
            <td>
               <input type='checkbox' name='Favorite' value='액션'>액션 
               <input type='checkbox' name='Favorite' value='SF / 판타지'> SF / 판타지 
               <input type='checkbox' name='Favorite' value='드라마'> 드라마
               <input type='checkbox' name='Favorite' value='로맨틱'> 로맨틱 
               <input type='checkbox' name='Favorite' value='코미디'> 코미디 
               <input type='checkbox' name='Favorite' value='애니메이션'> 애니메이션
               
            </td>
         </tr>
         
         <tr>
            <td colspan="2" align="center"><br>
               <button id="joinBtn" disabled>회원가입</button> 
               <input type="reset" value="취소">
            </td>
         </tr>
         
      </table>
   </form>

   <script>
   
         <%-- function returnToMain(){
            location.href="<%=request.getContextPath()%>";
         } --%>
         
         // 유효성 검사
         function joinValidate(){
            
             if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#write_form_member input[name=User_Id]").val()))){
            alert('아이디는 영소문자로 시작해서 4~12자 입력(숫자 포함 가능)');
            $("#write_form_member input[name=User_Id]").select();
            console.log($("#write_form_member input[name=User_Id]").val());
            return false;
            }
             
            if(!(/^[a-z\d][A-Z\d]{5,}$/i.test($("#write_form_member input[name=User_Pw]").val()))){
            alert('비밀번호는 6글자 이상 입력');
            $("#write_form_member input[name=User_Pw]").select();
            console.log($("#write_form_member input[name=User_Pw]").val());
            return false;
            
            }
             
            if($("#write_form_member input[name=User_Pw]").val() != $("#write_form_member input[name=User_Pw2]").val()){
            $("#pwdResult").text("비밀번호 불일치").css("color"," red");
            return false;
         }
            
            if(!(/^[가-힣]{2,}$/.test($("#write_form_member input[name=User_name]").val()))){
            alert('이름은 한글로 2글자 이상 입력');
            $("#write_form_member input[name=User_name]").select();
            
            return false;
         }
            
         return true;
      }
         
       
       $(function(){
          
          
          var isUsable = false;
          
          $("#idCheck").click(function(){
             
             var User_Id = $("#write_form_member input[name='User_Id']");
             
             console.log(User_Id);
             if(!User_Id || User_Id.val().length < 4){
                alert("아이디는 최소 4글자 이상이어야 합니다.");
                User_Id.focus();
             }else{
                $.ajax({
                   url : "<%=request.getContextPath()%>/idCheck.jo",
                  type : "post",
                  data : {
                     User_Id : User_Id.val()
                  },
                  success : function(data) {
                     
                     if (data == "fail") {
                        alert("사용할 수 없는 아이디 입니다.");
                        User_Id.focus();
                     } else {
                        if (confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")) {
                           User_Id.prop('readonly', true);
                           
                           isUsable = true; 
                        } else {
                           User_Id.focus();
                        }

                        if (isUsable) {
                           $("#joinBtn").removeAttr("disabled");
                        }
                     }
                  },
                  error : function() {
                     console.log('서버 통신 안됨');
                  }
               });
            }
         });
      });
     
   </script>

</body>
</html>