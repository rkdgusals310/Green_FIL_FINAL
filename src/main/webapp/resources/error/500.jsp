<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"   %>  
<%  response.setStatus(200);  %>   
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>500 ERROR</title> 
<!-- <meta http-equiv="refresh" content="3;url=index.jsp" /> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container panel panel-danger">
		<h3 class="panel-heading">500페이지입니다.</h3>
		<p>관리자에게 문의바랍니다.</p>
		<p><img src="<%=request.getContextPath() %>/images/error.png"  alt="error페이지"/></p> 
		<!-- request.getContextPath() : 현재 파일의 폴더 경로 -->
		<%=exception.getMessage() %>
		<script>
			setTimeout(function(){
				location.href='<%=request.getContextPath()%>/';
			}, 3000);
		</script>
	</div><!-- end container -->	
</body>
</html>



