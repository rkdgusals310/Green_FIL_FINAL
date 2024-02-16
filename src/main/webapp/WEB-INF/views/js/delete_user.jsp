<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../inc/login_header.jsp"%>
<style>
#main{
margin:70px;
  font-family: 'GmarketSansLight'; 
    font-weight : bold;
}
.required{
color:crimson;
font-size:17px;
}
.bold{
	margin:10px 0px;
 font-size:17px;
 
}
.flex{
	display:flex;
	align-items: baseline;
}

.flex input[type="checkbox"]{
	margin-right:10px;
}

.text{
    background: #eee;
    height: 300px;
    padding: 35px 35px 0px 35px;
    margin: 20px 0px;
     overflow:auto;
    }
.myinfo{
	    background: #eee;
    height: 110px;
    padding: 35px;
    margin: 20px 0px;
    line-height: 0.5em;
    
}
input[type="submit"]{
	width: 55px;
	height:40px;
    font-family: 'GmarketSansLight';
    padding: 10px 10px 10px 10px;
    color: white;
    background-color: #2CA6C7;
    }
    .delete_check{
    margin-bottom:20px;
    }
</style>
   <div id="main">
    <h3>회원탈퇴</h3>
    <div class="myinfo">
    
        <div class="form-group flex">
            <p><strong class="bold" >아이디</strong></p>
            <p style="margin-left:36px">${login.user_email }</p>
        </div>
        <div class="form-group flex">
            <p><strong class="bold" style="letter-spacing:16px">이름</strong></p>
            <p style="margin-left:20px">${login.user_name }</p>
        </div>
    </div>
        <div class="text">

            <p><strong class="required"> ※ 탈퇴 전 안내사항을 꼭 확인해 주세요</strong></p>
            <p>  탈퇴 시 회원님의 feel in like 이용정보가 삭제되어 복구가 불가능하며, feel in like 서비스를 더 이상 이용할 수 없습니다.</p>
                <strong class="bold" style="line-height: 55px">feel in like 이용정보 삭제</strong>
                <p>회원정보 및 개인 이용기록은 모두 삭제되며, 동일한 이메일로 재가입하더라도 삭제된 데이터는 복구되지 않습니다.</p>
                <strong class="bold" style="line-height: 55px">게시판형 서비스에 등록한 게시글 유지</strong>
                <p>게시글은 탈퇴 후 본인의 게시글임을 확인할 방법이 없어 임의로 삭제해 드릴 수 없습니다.
                삭제를 원하시는 게시글이 있다면 반드시 탈퇴 전 비공개로 변경하거나 삭제하시기 바랍니다.
            </p>
        </div>

        <div>
            <form action="delete_user.js?user_no=${login.user_no }" method="post" id="deleteuser">
                <fieldset>
                    <legend>회원탈퇴</legend>
                    <div class="delete_check">
	                    <div class="flex">
	                        <input type="checkbox" id="delete_user1" name="delete_user">
	                        <label for="delete_user1">탈퇴후 개인의 데이터를 복구할 수 없습니다.</label>
	                    </div>
	                    <div class="flex">
	                        <input type="checkbox" id="delete_user2" name="delete_user">
	                        <label for="delete_user2">위 안내사항을 모두 확인했습니다.</label>
	                    </div>
                    </div>
                    <div>
                        <input type="button" class="btn btn-default" value="취소">
                        <input type="submit" value="탈퇴" class="btn btn-default">
                    </div>
                </fieldset>
            </form>
           <script>
           $(function(){
        	   $("#deleteuser").on("submit", function(){
        		   if(!($("#delete_user1").prop("checked"))||!($("#delete_user2").prop("checked"))){
        			   alert("체크 확인 해주세요");
        			   return false
        		   };
        	   });
       	});
           
           </script>
        </div>
      </div>
<%@ include file="../inc/footer.jsp"%>