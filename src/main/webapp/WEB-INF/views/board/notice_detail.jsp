<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/login_header.jsp" %>


<div class="container">


  <div class="container"  style="margin-top:5%; min-height:500px">
    <h3>공지사항</h3> 			
    			
    <div class="panel">
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  제목</span> 
         <p>${noticeDetail.board_title}</p>
      </div>	
    </div>
    <div class="panel"  >
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  내용</span>
        <p>${noticeDetail.board_content}</p>
      </div> 
    </div>

    </div>	

    <c:if test="${login.grade_no!=3}">
    <div class="text-right">
       <a href="${pageContext.request.contextPath}/edit_notice.hm?board_no=${noticeDetail.board_no}"  class="btn btn-danger" >수정</a> 
       <a href="${pageContext.request.contextPath}/delete_notice.hm?board_no=${noticeDetail.board_no}"  class="btn btn-danger" >삭제</a>  
       <a href="${pageContext.request.contextPath}/home.hm?user_no=${login.user_no}"  class="btn btn-info" >목록보기</a>   
       <!-- <a href="javascript:window.history.back();"  class="btn btn-info" >목록보기</a>  -->
    </div>	
    </c:if>	
    
        <c:if test="${login.grade_no==3}">
    <div class="text-right"> 
       <a href="${pageContext.request.contextPath}/home.hm?user_no=${login.user_no}"  class="btn btn-info" >목록보기</a>   
       <!-- <a href="javascript:window.history.back();"  class="btn btn-info" >목록보기</a>  -->
    </div>	
    </c:if>				
    		 
       

  </div>	
<%@ include  file="../inc/footer.jsp" %>
