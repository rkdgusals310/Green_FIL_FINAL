<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/login_header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<!-- HEADER -->
<!-- HEADER -->
<style>
.recommend {
	background-color: #86C5D6;
	width: 1300px;
	height: 540px;
	padding: 48px;
	margin: auto;
}

.recommend_list {
	display: flex;
	justify-content: space-around;
	text-align: center;
	font-size: 20px;
	margin-top: 30px;
	height: 330px;
	line-height: 330px;
}

.recommend_main {
	background: floralwhite;
}

#main_text{
text-align:center}

.recommend_title {
	text-align: center;
	color: white;
}
</style>
<main style="font-weight: bold">

	<div class="recommend">
		<h2 class="recommend_title">오늘의 추천 명소</h2>
		<div class="recommend_main">
			<div class="recommend_list">
				<c:forEach var="recommend" items="${title}"
					varStatus="recommendIndex">
					<p>
						<a href="${list[recommendIndex.index]}">| ${recommend } |</a>
					</p>
				</c:forEach>
			</div>
			<p id="main_text">이름을 누르면 설명링크로 연결됩니다!!</p>
		</div>
	</div>
</main>

<!-- Footer -->
<!-- Footer -->
<%@ include file="../inc/footer.jsp"%>