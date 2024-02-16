	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/login_header.jsp"%>


<div class="container">
	<div class="write_notice">
		<!-- 글작성 start -->

		<form action="${pageContext.request.contextPath}/write_notice.hm?user_no=${login.user_no}" method="post">
			<fieldset>
				<legend>문의사항을 입력해주세요!</legend>

				<div>
					<label for="board_title">제목 </label><a> 30글자 내외로 입력가능합니다</a> <br>
					<input type="text" id="board_title" name="board_title"
						placeholder="질문 제목을 입력해주세요">
				</div>
				<div>
					<label for="board_content">내용 </label><a> 300글자 내외로 입력가능합니다</a> <br>
					<textarea name="board_content" id="board_content" cols="60"
						rows="10" class="form-control"></textarea>
				</div>


				<div>
					<input type="submit" value="공지글 작성">
				</div>
			</fieldset>
		</form>
	</div>
	<!-- 글작성 end -->


	<div>
		<%-- <div id="board_day">
			<form
				action="${pageContext.request.contextPath}/write_notice_end.hm?board_no=${noticeWrite_1.board_no}"
				method="post">
				<fieldset>
					<label for="board_start">공개일자</label> <input type='date'
						name='board_start' id="board_start" /> <label for="board_end">종료일자</label>
					<input type='date' name='board_end' id="board_end" />
					<div>
						<input type="submit" value="날짜 지정하기">
					</div>
				</fieldset>
			</form>

		</div> --%>
	</div>

	<%@ include file="../inc/footer.jsp"%>