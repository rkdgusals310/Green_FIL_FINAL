<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/login_header.jsp" %>


<div class="container">


  <div class="container"  style="margin-top:5%; min-height:500px">
    <h3>매크로 답변</h3> 			
    			
    <div class="panel">
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">번호</span> 
         <p>${detail.macro_no}</p>
      </div>	
    </div>
    <div class="panel"  >
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  내용</span>
        <p>${detail.macro_content}</p>
      </div> 
    </div>

    </div>	
    <div class="text-right">
       <a href="${pageContext.request.contextPath}/edit_macro.hm?macro_no=${detail.macro_no}"  class="btn btn-danger" >수정</a> 
       <a href="${pageContext.request.contextPath}/delete_macro.hm?macro_no=${detail.macro_no}"  class="btn btn-danger" >삭제</a>    
       <!-- <a href="javascript:window.history.back();"  class="btn btn-info" >목록보기</a>  -->
       <a href="${pageContext.request.contextPath}/macro.hm"  class="btn btn-info" >목록보기</a> 
    </div>						 
  </div>	
<%@ include  file="../inc/footer.jsp" %>
