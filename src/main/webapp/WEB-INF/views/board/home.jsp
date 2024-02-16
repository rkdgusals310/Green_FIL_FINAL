
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/login_header.jsp"%>
<%@page import="java.sql.*"%>
<div class="container home_body">

	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#home">홈</a></li>
		<li><a data-toggle="tab" href="#menu1">공지사항</a></li>
		<c:choose>
			<c:when test="${login.grade_no eq 3}">
				<li><a data-toggle="tab" href="#menu2">내 문의내역</a></li>
			</c:when>
			<c:otherwise>
				<li><a data-toggle="tab" href="#menu2">문의 관리</a></li>
			</c:otherwise>
		</c:choose>
	</ul>

	<div class="tab-content">

		<div id="home" class="tab-pane fade in active">
			<h3 class="myhidden">HOME</h3>
			<p>feel in like 게시판입니다.</p>
			<div class="home_notice">
				<!-- 홈 - 공지사항 -->
				<!-- <h3>※공지사항※</h3> -->
				<table>
					<caption class="myhidden">※공지사항※</caption>
					<tbody>
						<tr>
							<td id="notice">※공지사항※</td>
							<td id="notice_title"><a
								href="notice_detail.hm?board_no=${readNotice.board_no}">
									${readNotice.board_title}</a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="search">
			
					<fieldset class="srch">
						<select class="search-option" name="option" id="search-option">
							<option value="All">제목+내용</option>
							<option value="Title">제목만</option>
							<option value="Writer">작성자</option>
						</select>
		                <input type="text" name="keyword" id="keyword"  title="검색어" class="search-input">
		                <input type="button" class="search-button" alt="검색" value="검색"  id="search_btn"/>
	       			 </fieldset>
       			 
			</div>
			<div id="line1"></div>
			<script>
				$(function(){
			   		$("#search_btn").on("click" , function(){
			   		    if(	$("#keyword").val() == "" ){
			   		    	alert("빈칸입니다.\n확인해주세요");
			   		    	$("#keyword").focus();
			   		    	return false;
			   		    }else{ searchUser();}  
			   		});
			   	});
				function searchUser(){
					console.log('go');
					$.ajax({
						url:"search_user.hm",
						type:"GET",
						dataType:"json",
						data:{"keyword":$("#keyword").val(),"option":$("#search-option").val()},
						error:function(xhr, status, msg){ alert(status+"/" +msg);} , 
						success:searchResult
					});
				}
				
				function searchResult(json){
					console.log('List');
					$("#boardtable tbody").empty();
					 $.each(json.para, function(idx, search_home){
						$("<tr>")
						.append(  $("<td>").html(search_home.board_no) )
						.append(  $("<td>").html(search_home.user_name) )
						.append(  $("<td>").html(search_home.board_title) )
						.append(  $("<td>").html(search_home.board_hit) )
						.append(  $("<td>").html(search_home.status_no) )
						.append(  $("<td>").html(search_home.board_date) )
						.appendTo("#boardtable tbody");
					}); 
				
				}
				
				
			</script>
			<div id="home_question_back_back">
				<div id="home_question_back">
					<!-- 홈 - 문의사항 -->
					<table class="table" id="boardtable">
					<colgroup> 
				    	<col style="width: 10%;"/> 
				        <col style="width: 10%;"/> 
				        <col style="width: 50%;"/> 
				        <col style="width: 10%;"/> 
				        <col style="width: 10%;"/> 
				        <col style="width: 10%;"/> 
				    </colgroup> 
						<thead>
							<tr id="home_question">
								<th>번호</th>
								<th>작성자</th>
								<th>제목</th>
								<th>조회수</th>
								<th>상태</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${readQue}" varStatus="status">
								<tr>
									<td><a href="detail_que.hm?board_no=${list.board_no}">${paging.listtotal-paging.pstartno-status.index}</a></td>
									<td><a href="detail_que.hm?board_no=${list.board_no}">${list.user_name}</a></td>
									<td><a href="detail_que.hm?board_no=${list.board_no}">${list.board_title}</a></td>
									<!-- 제목 클릭시 디테일 -->
									<td>${list.board_hit}</td>
									<td><c:choose>
											<c:when test="${list.status_no==2}">답변대기</c:when>
											<c:otherwise>답변완료</c:otherwise>
										</c:choose></td>
									<td>${list.board_date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<table id="paging_user">
						<tfoot>
							<tr>
								<td  class="text-center">

									<ul class="pagination">
										<c:if test="${paging.start>=paging.bottomlimit}">
											<li><a
												href="${pageContext.request.contextPath}/home.hm?pstartno=${(paging.start-2)*paging.onepagelimit}">이전</a>
											</li>
										</c:if>

										<c:forEach begin="${paging.start}" end="${paging.end}" var="i">
											<li <c:if test="${paging.current==i}" >class="active"</c:if>>

												<a
												href="${pageContext.request.contextPath}/home.hm?pstartno=${(i-1)*paging.onepagelimit}">${i}</a>
											</li>
										</c:forEach>

										<c:if test="${paging.end < paging.pagetotal}">
											<li><a
												href="${pageContext.request.contextPath}/home.hm?pstartno=${paging.end*paging.onepagelimit}">다음</a>
											</li>
										</c:if>

									</ul>
								</td>
								
								<td>
									<c:if test="${login.grade_no eq 3}">
										<div>
											<!-- 문의사항 작성 -->
											<p id="btn_w_m">
												<a href="${pageContext.request.contextPath}/write_user.hm">글작성하기</a>
											</p>
											<!--  시간 남으면 hover시 색 변화 살짝 -->
										</div>
									</c:if>
								
								</td>
								
							</tr>

						</tfoot>
					</table>
					
				</div>
				<!-- 홈 - 문의사항 -->




			</div>


		</div>

		<div id="menu1" name="menu1" class="tab-pane fade">
			<h3 class="myhidden">공지사항</h3>
			<div id="home_question_back_back">
				<div id="home_question_back">
					<!-- 홈 - 공지사항 -->
					<div id="overflow_table">
						<table class="table">
							<thead>
								<tr id="home_question">
									<th>번호</th>
									<th>제목</th>
									<th>조회수</th>
									<th>등록일</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="list" items="${noticeList}">
									<tr>
										<td><a href="notice_detail.hm?board_no=${list.board_no}">${list.board_no}</a></td>
										<td><a href="notice_detail.hm?board_no=${list.board_no}">${list.board_title}</a></td>
										<!-- 제목 클릭시 디테일 -->
										<td>${list.board_hit}</td>
										<td>${list.board_date}</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<c:if test="${login.grade_no eq 1}">
						<div>
							<p id="btn_w">
								<a href="${pageContext.request.contextPath}/write_notice.hm">글작성하기</a>
							</p>
							<!--  시간 남으면 hover시 색 변화 살짝 -->
						</div>
					</c:if>
					<c:if test="${login.grade_no eq 2}">
						<div>
							<p id="btn_w">
								<a href="${pageContext.request.contextPath}/write_notice.hm">글작성하기</a>
							</p>
							<!--  시간 남으면 hover시 색 변화 살짝 -->
						</div>
					</c:if>
				</div>
				<!-- 홈 - 공지사항 -->

			</div>

		</div>
		<c:choose>
			<c:when test="${login.grade_no eq 3}">
				<div id="menu2" class="tab-pane fade">
					<h3 class="myhidden">내 문의 내역</h3>
					<div id="home_question_back_back">

						<div id="home_question_back">
							<!-- 홈 - 공지사항 -->
							<div id="overflow_table">
								<table class="table">
									<thead>
										<tr id="home_question">
											<th>번호</th>
											<th>작성자</th>
											<th>제목</th>
											<th>조회수</th>
											<th>공개여부</th>
											<th>상태</th>
											<th>등록일</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${myQueList}">
											<tr>
												<td>${list.board_no}</td>
												<td>${list.user_name}</td>
										
												<td><a href="detail_que.hm?board_no=${list.board_no}">${list.board_title}</a></td>
												
												<!-- 제목 클릭시 디테일 -->
												<td>${list.board_hit}</td>
												
												<td>
												
												<c:if test="${list.board_open eq false}">비공개</c:if>
												<c:if test="${list.board_open eq true}">공개</c:if>
														
												</td>
												
												<!-- c:if로 true이면 공개로 false이면 비공개로 -->
												<td><c:choose>
														<c:when test="${list.status_no==2 }">
															<p>답변대기</p>
															<a
																href="${pageContext.request.contextPath}/edit_user.hm?board_no=${list.board_no}"
																class="btn btn-info">수정</a>
															<a
																href="${pageContext.request.contextPath}/delete_u.hm?board_no=${list.board_no}&user_no=${login.user_no}"
																class="btn btn-danger">삭제</a>
														</c:when>
														<c:otherwise>답변완료</c:otherwise>
													</c:choose></td>
												<!-- c:if로 사용자로 로그인하고 답변대기라면 수정 삭제 버튼 나오게-->
												<td>${list.board_date}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div>
								<p id="btn_w">
									<a href="${pageContext.request.contextPath}/write_user.hm">글작성하기</a>
								</p>
								<!--  시간 남으면 hover시 색 변화 살짝 -->
							</div>

						</div>
						<!-- 홈 - 공지사항 -->
			</c:when>
			<c:otherwise>
				<div id="menu2" class="tab-pane fade">
					<h3 class="myhidden">
						문의관리
						<h3>
							<div id="home_question_back_back">
								<div id="home_question_back">
									<!-- 홈 - 공지사항 -->
									<div id="overflow_table">
										<table class="table">
											<thead>
												<tr id="home_question">
													<th>번호</th>
													<th>작성자</th>
													<th>제목</th>
													<th>공개여부</th>
													<th>상태</th>
													<th>작성일</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="list" items="${rootQueList}">
													<tr>
														<td>${list.board_no}</td>
														<td>${list.user_name}</td>
														<td><a
															href="${pageContext.request.contextPath}/write_root_detail.hm?board_no=${list.board_no}&macro_no=${list.macro_no}">${list.board_title}</a>
														</td>
														<!-- 제목 클릭시 디테일 -->
														<td><c:if test="${list.board_open eq false}">비공개</c:if>
												<c:if test="${list.board_open eq true}">공개</c:if></td>
														<!-- c:if로 true이면 공개로 false이면 비공개로 -->
														<td><c:choose>
																<c:when test="${list.status_no==2}">
																	<p>답변대기</p>
																</c:when>
																<c:otherwise>답변완료</c:otherwise>
															</c:choose></td>
														<!-- c:if로 사용자로 로그인하고 답변대기라면 수정 삭제 버튼 나오게-->
														<td>${list.board_date}</td>
														<td> 
														<a href="${pageContext.request.contextPath}/delete_r.hm?board_no=${list.board_no}" class="btn btn-danger">삭제</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
									<!-- 홈 - 공지사항 -->
									<div>
										<p id="btn_w">
											<a href="${pageContext.request.contextPath}/macro.hm">매크로
												관리</a>
										</p>
										<!--  시간 남으면 hover시 색 변화 살짝 -->
									</div>

								</div>
							</div>
			</c:otherwise>

		</c:choose>


	</div>
</div>
<%@ include file="../inc/footer.jsp"%>
