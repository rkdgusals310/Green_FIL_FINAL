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
        <div style="font-size: 30px;" >
            <p><a href="login.js">X</a></p>
        </div>
          <div>
			<p><img src="resources/image/logo2.png" style="    vertical-align: middle;
                margin: auto;
                padding: 40px;
    width: 370px;"></p>
		</div>
        <div >
            <h4 style="font-weight: bold;">아이디 찾기</h4>
            <p>내정보>연락처에 등록된 이름/휴대폰번호가 일치해야만 인증번호를 받으실 수 있습니다.</p>

        </div>
        <div>
            <form action="login.js" method="get">
                <fieldset>
                    <legend style="display: none;">아이디찾기</legend>
                    <div >
                        <input type="text" name="findid" value="${id.user_email }" readonly style="font-size: 20px ;border:none; background-color: #fff; border-bottom: 0.5px solid gray ; margin: 10px 20px 10px 20px; height: 50px;">
                    </div>
            
                    <div class="text-center">
                        <input type="submit" class="btn btn-lg" value="처음으로" style="width: 400px; margin: 100px 0 30px 0;" >
                    </div>

                </fieldset>
            </form>
        </div>
        <div>
            <a href="findpass.js">비밀번호 찾기</a>
        </div>
    </div>
    

</body>
</html>