<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../inc/login_header.jsp"%>
<style>
	.main{
	width: 1450px;
    text-align: center;
    margin: auto;
    font-size: 180px;
    font-family: 'GmarketSansLight';
    padding: 190px 
	}


</style>
   <div class="main">
        <p>이용해주셔서 감사합니다</p>
		
   </div>
 <script>
	setTimeout(function (){
		location.href="<%=request.getContextPath()%>";
	}, 3000);
	</script> 
<%@ include file="../inc/footer.jsp"%>