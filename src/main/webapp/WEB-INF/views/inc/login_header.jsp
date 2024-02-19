<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- prefix -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/5a8cdaf6f7.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/modal.css">

<link rel="shortcut icon" sizes="192x192"
	href="${pageContext.request.contextPath}/resources/image/feel_logo.png" />
<link rel="stylesheet"   href="${pageContext.request.contextPath}/resources/css/base.css"/>
<link rel="stylesheet"   href="${pageContext.request.contextPath}/resources/css/home.css"/>
<meta name="mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes">

<title>feel in like</title>

<style>
#start_img{
    position: absolute;
    top: 205px;
    left: 850px;
    }
   #calendar {
	width: 60%;
	margin: 20px auto;
	margin-top: 80px;
</style>

</head>
<body>
	<header>
		<h1 class="myhidden">feel in like</h1>
		<nav class="navbar">
			<h2 class="myhidden">주메뉴</h2>
			<div class="navbar_logo">
				<a href="home.js"><img class="logo"
					src="${pageContext.request.contextPath}/resources/image/newLogo_3.png" /></a>
			</div>

			<ul class="navbar_menu" style="margin-bottom: -5px">
				<li class="highlight"><a href="calendar.khm">오늘의 일기</a></li>
				<li class="active">|</li>
				<c:if test="${login.user_no eq null}">
				<li class="highlight"><a href="login.js">고객 문의</a></li>
				</c:if>
				<c:if test="${login.user_no != null}">
				<li class="highlight"><a href="home.hm?user_no=${login.user_no}">고객 문의</a></li>
				</c:if>
				<!-- <li class="active">|</li>
				<li class="highlight"><a href="more_info.feel">FIL 알아보기</a></li> -->
			</ul>
			<c:choose>
				<c:when test="${login.grade_no eq 3}">
					<div class="dropdown">
						<button type="button" data-toggle="dropdown" style="border: none; background-color: #DCDCDC;">
							<p> <img src="${pageContext.request.contextPath}/resources/image/mypage.png" alt="mypage"> </p>
						</button>
						<ul class="dropdown-menu" style="left: -110px; color: black">
							<li><a href="mypage.js?user_no=${login.user_no }">내 정보</a></li>
							<li><a href="#">내 저장 콘텐츠</a></li>
							<li><a href="home.hm?user_no=${login.user_no}">내 문의 내역</a></li>
							<li><a href="logout.js">로그아웃</a></li>
						</ul>
					</div>
				</c:when>
				<c:when test="${login.grade_no eq none }">
					<ul class="navbar_login">
						<li><a href="login.js" class="login">LOGIN</a></li>
						<li>|</li>
						<li><a href="sign_agree.js">SIGNUP</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<div class="dropdown">
						<button type="button" data-toggle="dropdown" style="border: none; background-color: #DCDCDC;">
							<p> <img src="${pageContext.request.contextPath}/resources/image/mypage.png" alt="mypage"> </p>
						</button>
						<ul class="dropdown-menu" style="left: -110px; color: black">
							<li><a href="mypage.js?user_no=${login.user_no}">내 정보</a></li>
							<li><a href="#">내 저장 콘텐츠</a></li>
							<li><a href="#">콘텐츠관리</a></li>
							<li><a href="adminpage_list.js">회원관리</a></li>
							<li><a href="logout.js">로그아웃</a></li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</nav>
	</header>