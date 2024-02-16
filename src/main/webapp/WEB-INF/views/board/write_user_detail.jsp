<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/login_header.jsp" %>


<div class="container">
  
  <div class="write_notice">
    <h3>게시글</h3> 	
    <p>${queDetail.user_name}님의 게시글입니다</p>				
    			
    <div class="panel"  >
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  제목</span> 
         <p>${queDetail.board_title}</p>
      </div>	
    </div>
    <div class="panel"  >
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  내용</span>
        <p>${queDetail.board_content}</p>
      </div> 
    </div>
    
    <div class="panel"  >
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  답변</span>
        <p>${queDetail.macro_content}</p>
      </div> 
    </div>	

    
    <c:choose >
    	<c:when test="${login.grade_no eq 3 and login.user_no eq queDetail.user_no and queDetail.status_no==2}">
    	  <div class="text-right"    >
       <a href="${pageContext.request.contextPath}/edit_user.hm?board_no=${queDetail.board_no}"  class="btn btn-danger" >수정</a> 
       <a href="${pageContext.request.contextPath}/delete_u.hm?board_no=${queDetail.board_no}&user_no=${login.user_no}"  class="btn btn-danger" >삭제</a>    
       <!-- <a href="javascript:window.history.back();"  class="btn btn-info" >목록보기</a>  -->
       <a href="${pageContext.request.contextPath}/home.hm?user_no=${login.user_no}"  class="btn btn-info" >목록보기</a> 
    </div>
       </c:when>
       <c:otherwise>
       	 <a href="${pageContext.request.contextPath}/home.hm?user_no=${login.user_no}"  class="btn btn-info" >목록보기</a> 
       </c:otherwise>
    </c:choose>		
 
    
    					 

  </div>	
<%@ include  file="../inc/footer.jsp" %>
