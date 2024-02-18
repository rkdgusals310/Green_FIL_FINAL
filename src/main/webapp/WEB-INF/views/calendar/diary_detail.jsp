<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/login_header.jsp"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<div class="container write_notice">
	<div>
		<div class="weather_detail">
			<c:if test='${weather.get("sky") eq "1"}'>
				<img alt="맑음"
					src="${pageContext.request.contextPath}/resources/image/sunny.png">
				<p id="tmp">${weather.get("tmp")}℃</p>
				<p id="sky">맑음</p>
			</c:if>

			<c:if test='${weather.get("sky") eq "3"}'>
				<img alt="구름많음"
					src="${pageContext.request.contextPath}/resources/image/cloud.png">

				<p id="tmp">${weather.get("tmp")}℃</p>
				<p id="sky">구름많음</p>
			</c:if>

			<c:if test='${weather.get("sky") eq "4"}'>
				<img alt="흐림"
					src="${pageContext.request.contextPath}/resources/image/blur.png">

				<p id="tmp">${weather.get("tmp")}℃</p>
				<p id="sky">흐림</p>
			</c:if>
		</div>

		<div class="weather_block">
			<c:forEach var="list" items="${readDiary}">
				<%-- <p class="btn"><span>${list.diary_update}</span> ${list.diary_title}</p> --%>
				<input type="button" class="diary_detail_btn"
					value="${list.diary_update} ${list.diary_title}" />
				<input type="hidden" value="${list.diary_no}" class="diary_no">
				<br>

			</c:forEach>
		</div>
	</div>

	<div class="diary_my">
		<h3>${login.user_name}의일기</h3>
		<div class="panel">
			<div class="panel-body">
				<span class="glyphicon glyphicon-plus"> 날씨의 일기</span>
				<p></p>
				<p id="detail3"></p>
				<p id="detail4"></p>
			</div>
		</div>
		<div class="panel">
			<div class="panel-body">
				<span class="glyphicon glyphicon-plus"> 제목</span>
				<p id="detail1"></p>
			</div>
		</div>
		<div class="panel diary_title">
			<div class="panel-body">
				<span class="glyphicon glyphicon-plus"> 내용</span>
				<p id="detail2"></p>
			</div>
		</div>
	</div>
	<p class="btn btn-color"> <a id="btn_p_color">일기 쓰기</a> </p>
	
</div>

<div class="write" id="write"> <!-- 글작성 start -->
	<div style="padding-left: 330px;">
    <form action="${pageContext.request.contextPath}/write_diary.khm?user_no=${login.user_no}&temp=${weather.get('tmp')}&weather_no=${weather.get('sky')}" method="post">
      <fieldset>
        <legend> 일기를 입력해주세요</legend>

       <%--  <div>
          <label for="weather_no">오늘의 날씨</label><br>
          <input type="number" id="weather_no" name="weather_no" value='${weather.get("sky")}' >
          
          <label for="temp">오늘의 날씨</label><br>
          <input type="number" id="temp" name="temp" value='${weather.get("tmp")}'>
        </div> --%>
        <div>
          <label for="diary_title">제목</label><br>
          <input type="text" id="diary_title" name="diary_title" >
        </div>
        <div>
          <label for="diary_content">내용 </label><a> 300글자 내외로 입력가능합니다</a> <br>
          <textarea name="diary_content"  id="diary_content"  cols="60"  rows="10"   class="form-control" ></textarea>
        </div>
        
         <div>
          <input type="submit" value="일기 저장" id="diary_save"> 
          <input type="button" value="취소" id="diary_cancel">
         </div>
      </fieldset>
    </form>
    </div>
  </div> <!-- 글작성 end -->

<script>
	$(document).ready(function(){
		$("#write").hide();
	});
    $(function(){
    	
    	$(".diary_detail_btn").on("click",function(){
    		var diaryNo = $(this).next(".diary_no").val();
            diaryDetail(diaryNo);
    	});
    	$(".btn_p_color").on("click",function(){$("#write").show();}
    	$("#diary_cancel").on("click",function(){$("#write").hide();}
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
		$("#detail3").text(json.para.diary_update);
		$("#detail4").text(json.para.weather_name);
		$("#detail2").text(json.para.diary_content); 
		
	
	}
    
    </script>

<%@ include file="../inc/footer.jsp"%>