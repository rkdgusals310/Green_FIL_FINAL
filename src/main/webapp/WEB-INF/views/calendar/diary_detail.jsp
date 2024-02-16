<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/login_header.jsp" %>


<div class="container write_notice">
  <div>
	  <div class="weather_detail">
	  	  <c:if test='${weather.get("sky") eq "1"}'>
	  	  <img alt="맑음" src="${pageContext.request.contextPath}/resources/image/sunny.png">
	  	  <p>맑음</p>
	  	 <p>${weather.get("tmp")}℃</p>
	  	  </c:if>
	  </div>
	  
	  <div class="weather_block"> 
	  	<c:forEach var="list" items="${readDiary}">
	  		<%-- <p class="btn"><span>${list.diary_update}</span> ${list.diary_title}</p> --%>
	  		<input type="button" class="diary_detail_btn" value="${list.diary_update} ${list.diary_title}" />
	  		<input type="text" value="${list.diary_no}" class="diary_no">
	  	
	  	</c:forEach>
	  </div>
   </div>
   
  <div>
    <h3>${login.user_name}의 일기 </h3> 	
    <div class="panel"  >
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  제목</span> 
         <p id="detail1"></p>
      </div>	
    </div>
    <div class="panel"  >
      <div  class="panel-body">
        <span class="glyphicon glyphicon-plus">  내용</span>
        <p id="detail2"></p>
      </div> 
    </div>
    <script>
    $(function(){
    	$(".diary_detail_btn").on("click",function(){
    		var diaryNo = $(this).next(".diary_no").val();
            diaryDetail(diaryNo);
    	});
    });
    
    function diaryDetail(diaryNo) {
    	console.log('go');
    	$.ajax({

    		/* url:"diary_detail.khm/"+$(this).closest("<p>").find(".diary_no").val(), */
    		url:"diary_detail.khm",
    		type:"GET",
    		dataType:"json",
    		data:{"diary_no":diaryNo}, 
    		error:function(xhr, status, msg){ alert(status+"/" +msg);} , 
			success: detailResult
    	});
	}
    
	function detailResult(json){
		console.log('List');
		console.log(json.para);
		/* $("#detail1").empty();
		$("#detail2").empty(); */
		
		$("#detail1").text(json.para.diary_title);
		$("#detail2").text(json.para.diary_content); 
		
	
	}
    
    </script>


 					 

  </div>	
<%@ include  file="../inc/footer.jsp" %>
