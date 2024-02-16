<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"   %>  
<%  response.setStatus(200);  %> 
<%--  성공적인 페이지임을 알려줌  --%>
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>404 ERROR</title> 
<meta http-equiv="refresh" content="3;url=index.jsp" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container panel panel-danger">
		<h3 class="panel-heading">404페이지입니다.</h3>
		<p>요청하신 페이지가 없습니다.</p>
		<p><img src="<%=request.getContextPath() %>/images/error.png"  alt="error페이지"/></p> 
		<p><a href="<%=request.getContextPath() %>/">HOME</a></p>
		<%-- request.getContextPath() : 현재 파일의 폴더 경로 --%>
	</div><!-- end container -->	
</body>
</html>