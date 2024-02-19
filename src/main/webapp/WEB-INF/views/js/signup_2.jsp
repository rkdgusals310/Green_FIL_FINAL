<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/signup_header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.btn_area_s {
	margin-bottom: 10px;
	display: flex;
	justify-content: space-between;
	align-items: baseline;
}
#btnJoin{
	font-size:18px;
	font-weight:bold;
	cursor: pointer;
	outline: none;
	width: 100%;
	height: 40px;
	border: none;
	color: white;
	background-color: #2F95B1;
	border-radius: 8px;
	font-family: 'GmarketSansMedium';
}
#pwcheck{
	color: crimson;
    font-size: 10px;
    text-align: right;
}

#sign_sex {
	display: flex;
	flex-direction: row;
	align-items: baseline;
}

#sign_sex input[type=radio] {
	margin: 0px 50px
}

#sex_title {
	margin-right: 100px
}
</style>

<div>
	<p style="text-align:center">
		<a href="home.js">
		<img src="resources/image/newLogo_2.png"
			style="vertical-align: middle; margin: auto; padding: 40px; width: 370px;">
		</a>
	</p>
</div>


<!-- wrapper -->
<div id="wrapper">
	<form method="post" action="signinsert.js" name="join" id="sign2">
	<fieldset style="border: none;">
		<div id="content">
			<div class="email">
				<h3 class="join_title">
					<label for="newid">아이디</label> <strong class="required">*</strong>
				</h3>
				<span class="box int_email"> <input type="text" id="newid"
					value="${param.user_email }" name="user_email" class="field"
					placeholder="이메일을 입력해주세요">
				</span>
			</div>
	
		<c:if test="${param.code != null }">
			<div class="number">
				<div class="btn_area_s">
					<h3 class="join_title">
						<label for="signCode">인증코드</label> <strong class="required">*</strong>
					</h3>
				</div>
				<span class="box int_id"> <input type="text" id="signCode"
					name="code" class="field" value="${param.code } " readonly>
				</span>
			</div>
		</c:if>
			
			<div class="password">
				<h3 class="join_title">
					<label for="newpw">비밀번호</label> <strong class="required">*</strong>
				</h3>
				<span class="box int_pass"> <input type="password" id="newpw"
					name="user_pass" class="field" value="${param.user_pass }"
					placeholder="비밀번호는 영어와 숫자를 포함해주세요"> <span id="alertTxt">사용불가</span>
				</span> <span class="error_next_box"></span>
			</div>

			<div class="password_check">
				<h3 class="join_title">
					<label for="newpw_check">비밀번호 재확인</label>
					<p id="pwcheck"></p>
				</h3>
				<span class="box int_pass_check"> <input type="password"
					id="newpw_check" name="user_passcheck" class="field"
					value="${param.user_pass}" placeholder="비밀번호는 영어와 숫자를 포함해주세요">
				</span> <span class="error_next_box"></span>
			</div>

			<div class="name">
				<h3 class="join_title">
					<label for="newname">이름</label> <strong class="required">*</strong>
				</h3>
				<span class="box int_name"> <input type="text" id="newname"
					name="user_name" class="field" value="${param.user_name }"
					placeholder="한글을 입력해주세요">
				</span> <span class="error_next_box"></span>
			</div>

			<div class="phone">
				<h3 class="join_title">
					<label for="newphone">휴대전화</label> <strong class="required">*</strong>
				</h3>
				<span class="box int_mobile"> <input type="tel" id="newphone"
					name="user_mobile" class="field" value="${param.user_mobile }"
					pattern="^[0-9]+$" placeholder="'-' 빼고 입력해주세요">
				</span>
			</div>

			<div class="name">
				<h3 class="join_title">
					<label for="newbirth">생년월일</label> <strong class="required">*</strong>
				</h3>
				<span class="box int_name"> <input type="date" id="newbirth"
					name="user_birth" class="field" value="${param.user_birth }"
					placeholder="ex) 19940604">
				</span>
			</div>

			<div id="sign_sex">
				<div id="sex_title">
					<h3 class="join_title">
						<strong>성별</strong> <strong class="required">*</strong>
					</h3>
				</div>	
				<c:if test="${param.user_sex eq 'M' }">
					<label for="M">남자</label>
					<input type="radio" id="M" name="user_sex" value="M" checked>
					<label for="F">여자</label>
					<input type="radio" id="F" name="user_sex" value="F">
				</c:if>
				<c:if test="${param.user_sex eq 'F' }">
					<label for="M">남자</label>
					<input type="radio" id="M" name="user_sex" value="M">
					<label for="F">여자</label>
					<input type="radio" id="F" name="user_sex" value="F" checked>
				</c:if>
				<c:if test="${param.user_sex eq none }">
					<label for="M">남자</label>
					<input type="radio" id="M" name="user_sex" value="M">
					<label for="F">여자</label>
					<input type="radio" id="F" name="user_sex" value="F">
				</c:if>
			</div>

			<div class="btn_area">
				<input type="submit" id="btnJoin" value="가입하기">
			</div>
		</div>
			</fieldset>
	</form>
</div>
<script>
	$(function() {

		$("#sign2").on("submit", function(){
			alert("환영합니다!");
		});
	});
</script>
    

</body>

</html>