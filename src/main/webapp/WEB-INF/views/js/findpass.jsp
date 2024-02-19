<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>BASIC001</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
     <div style="background-color:white ;width: 500px; margin: 20px; padding: 20px; height: 1000px; margin:auto; padding: 50px;">
        <div style="font-size: 30px;">
            <p><a href="login.js">X</a></p>
        </div>
         <div>
			<p><img src="resources/image/newLogo_2.png" style="    vertical-align: middle;
                margin: auto;
                padding: 40px;
    width: 370px;"></p>
		</div>
        <div>
            <h4 style="font-weight: bold;">비밀번호 찾기</h4>
            <p>이름과 내정보 > 연락처에 등록된 아이디가 일치해야만 인증번호를 받으실 수 있습니다.</p>

        </div>
        <div>
            <form action="findpass_2.js" method="post" id="findPass">
                <fieldset>
                    <legend  style="display: none;">비밀번호 찾기</legend>
                    <div>
                        <input type="text" id="user_name" name="user_name" placeholder="이름" style="font-size: 20px ;border:none; background-color: #fff; border-bottom: 0.5px solid gray ; margin: 10px 20px 10px 20px; height: 50px;">
                    </div>
                    <div>
                        <input type="text" id="user_email" name="user_email" placeholder="등록된 아이디" style="font-size: 20px ;border:none; background-color: #fff; border-bottom: 0.5px solid gray ; margin: 10px 20px 10px 20px; height: 50px;">
                    </div>
                    <div>
                        <input type="submit" class="btn btn-lg" value="다음 단계" style="width: 400px; margin: 100px 0 30px 0;">
                    </div>
                </fieldset>
            </form>
        </div>
         <script>

		$("#findPass").on("submit", function() {
			
			if ($("#user_name").val() == "") {
				alert("이름을 확인해주세요.");
				$("#user_name").focus();
				return false;
			}
			if ($("#user_email").val() == "") {
				alert("이메일을 확인해주세요.");
				$("#user_email").focus();
				return false;
			}
		}
        
        </script>
        
        <div>
            <a href="findid.js">아이디 찾기</a>
        </div>
    </div>



</body>
</html>