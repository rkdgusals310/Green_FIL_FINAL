
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/login_header.jsp"%>


<div class="container">
	<div class="write_notice">
			
		<!-- 글작성 start -->
		<form action="${pageContext.request.contextPath}/write_notice_end.hm?board_no=${notice_write.board_no}"
			method="post">
			<fieldset>
				<legend>공지사항의 공개기간을 지정해주세요</legend>

				<div>
					<label >제목 </label><a> 30글자 내외로 입력가능합니다</a> <br>
					<input type="text" value="${notice_write.board_title}" >
				</div>
				<div>
					<label>내용 </label><a> 300글자 내외로 입력가능합니다</a> <br>
					<textarea cols="60" rows="10" class="form-control">${notice_write.board_content}</textarea>
				</div>


				<div>
					<label for="board_start">공개일자</label> 
					<input type='date'name='board_start' id="board_start"  /> 
					<label for="board_end">종료일자</label>
					<input type='date' name='board_end' id="board_end"  />
				</div>

				<div>
					<input type="submit" value="날짜 지정 작성">
				</div>
			</fieldset>
		</form>
	</div>
	<!-- 글작성 end -->

	<%@ include file="../inc/footer.jsp"%>