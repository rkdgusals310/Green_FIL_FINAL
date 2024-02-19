<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/login_header.jsp"%>


<div class="container">


	<div class="write_notice">
		<h3>게시글</h3>
		<p>${queDetail.user_name}님의게시글입니다</p>

		<div class="panel">
			<div class="panel-body">
				<span class="glyphicon glyphicon-plus"> 제목</span>
				<p>${queDetail.board_title}</p>
			</div>
		</div>
		<div class="panel">
			<div class="panel-body">
				<span class="glyphicon glyphicon-plus"> 내용</span>
				<p>${queDetail.board_content}</p>
			</div>
		</div>

		<div class="panel">
			<div class="panel-body">


				<c:if test="${queDetail.status_no eq 2}">
					<form
						action="${pageContext.request.contextPath}/upedate_answer.hm?board_no=${queDetail.board_no}&user_email=${email_root.user_email}"
						method="POST" id="email">
						<fieldset>
							<div>
								<label for="macro_no">답변</label> 
								<select id="macro_no" name="macro_no" size="1">
									<c:forEach var="i" items="${answer}">
										<option id="m1" value="${i.macro_no}">${i.macro_content}</option>
									</c:forEach>
								</select>

							</div>

							<div>
								<input type="submit" value="확인">
								<p class="btn btn-danger">
									<a href="javascript:window.history.back();">뒤로가기</a>
								</p>
						</fieldset>
					</form>
				</c:if>
				<c:if test="${queDetail.status_no eq 1}">
					<div>
						<span class="glyphicon glyphicon-plus">답변</span>
						<p>${success.macro_content}</p>
					</div>
					<div>
						<p class="btn btn-danger">
							<a href="javascript:window.history.back();">뒤로가기</a>
						</p>
					</div>
				</c:if>


			</div>

		</div>

	</div>

</div>
<%@ include file="../inc/footer.jsp"%>
