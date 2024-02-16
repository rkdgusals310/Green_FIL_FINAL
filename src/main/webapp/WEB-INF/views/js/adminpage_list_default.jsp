<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../inc/login_header.jsp"%>

<style>
.main {
	font-family: 'GmarketSansLight';
	margin: auto;
	padding: 125px;
}

#btnfont a {
	color: white !important;
	font-weight: bold;
}

.tables {
	overflow: auto;
	border: 1px solid #eee;
	margin: 10px;
}

#adminPlus, #adminPlus_next {
	font-family: 'GmarketSansLight';
	background-color: aliceblue;
	position: absolute;
	width: 800px;
	height: 300px;
	top: 420px;
	left: 530px;
	padding: 40px;
	text-align: center;
}

#adminPlus h3, #adminPlus_next h3 {
	text-align: left;
	margin-left: 20px;
	font-weight: bold;
}

#adminPlus p, #adminPlus_next p {
	text-align: left;
	margin-left: 40px;
	font-size: 20px
}

#adminPlus input[type="text"], #adminPlus_next input[type="text"] {
	background-color: aliceblue;
	outline: none;
	border: none;
	border-bottom: 2px solid black;
	text-align: center;
	margin: 10px;
	font-weight: bold;
	font-size: 25px;
}

#adminPlus_next input[type="text"]{
	margin-top: 49px;
}


#plusbtns input[type="button"] {
	border: none;
	width: 190px;
	height: 50px;
	font-size: 20px;
	font-weight: bold;
	margin: 10px 20px;
}

#opnPlus {
	background-color: #00A3FFBD;
	color: white;
	font-weight: bold;
}
</style>

<script>
	$(function() {
		readAll(); 
		
		$("#adminPlus").hide();
		$("#adminPlus_next").hide();
		$("#opnPlus").on("click", function() {
			$("#adminPlus").toggle();

		});
		$("#btnok1").on("click", function(){
			$("#adminPlus_next").show();
		});
		$(".btncancel, #btnok2").on("click", function(){
			$("#adminPlus").hide();
			$("#adminPlus_next").hide();
		})
		
	});//end
	
	 function readAll(){
		
		$.ajax({
			url : "ex_adminpage_list.js",
			type : "GET",
			dataType:"json",
			error:function(xhr,status,msg){
				alert(status+"/"+msg);
			},
			success: function(json){
					console.log(json.result);
					console.log("23123123");
			 	 	$(".adminList tbody").empty();
		 			$.each(json.result, function(idx,user){
					$("<tr>")
					.append($("<td>").html(user.user_no))
					.append($("<td>").html(user.user_name))
					.append($("<td>").html(user.user_email))
					.append($("<td>").html(user.grade_name))
					.append($("<td>").html(user.user_date))
					.appendTo(".adminList tbody");
				});  
			}
		});
	}  
	
 	function admin_plus(){
		$.ajax({
			url:"ex_admin_plus.js",
			type:"POST",
			dataType:"json",
			data:{"user_email":$("#user_email").val()},
			error:function(xhr, status, msg){
				alert(status+"/"+msg);
				console.log(status+"/"+msg);
			},
			success:function(json){
				alert(json);
				//readAll();
				console.log(json);
				$("#user_email").val(''); 
			}
			
			
		});	//aend
	};//fend  
	
</script>
<div class="main">
	<div>
		<h4>관리자를 관리해보세요</h4>
		<p>
			<strong>※ 관리자로 추가한 이메일로 메일이 보내져요!</strong>
		</p>

	</div>
	<div class="tables">
		<table class="table table-bordered adminList">
			<caption>〈〈현재관리자 LIST〉〉</caption>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">이메일</th>
					<th scope="col">권한</th>
					<th scope="col">등록일</th>
					<th scope="col">변경</th>
				</tr>
			</thead>
			<tbody>
				 <c:forEach var="admin" items="${admin_list }" varStatus="status">
					<tr>
						<td>${admin.user_no }</td>
						<td>${admin.user_name }</td>
						<td>${admin.user_email }</td>
						<td>${admin.grade_name }</td>
						<td>${admin.user_date }</td>
						<td id="btnfont"><a
							href="admin_delete.js?user_no=${admin.user_no }" class="btn"
							style="background-color: #FFC633BD;">해제하기</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<c:if test="${login.grade_no eq 1 }">
			<div id="btnfont" class="text-right">
				<input type="button" value="추가하기" id="opnPlus" class="btn">
			</div>
		</c:if>
	</div>

	 <div class="tables">
		<table class="table table-bordered">
			<caption>〈〈현재회원 LIST〉〉</caption>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">이메일</th>
					<th scope="col">생년월일</th>
					<th scope="col">휴대폰번호</th>
					<th scope="col">등록일</th>
					<th scope="col">변경</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${list }" varStatus="status">
					<tr>
						<td>${user.user_no }</td>
						<td>${user.user_name }</td>
						<td>${user.user_email }</td>
						<td>${user.user_birth }</td>
						<td>${user.user_mobile }</td>
						<td>${user.user_date }</td>
						<td id="btnfont"><a
							href="kill_user.js?user_no=${user.user_no }" class="btn"
							style="background-color: #FF6666ED;">삭제하기</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> 
</div>

<div id="adminPlus">
	<div>
		<h3>관리자 권한 주기 </h3>
		<p>관리자 추가 인증할 이메일을 입력해주세요</p>
		<input type="text" name="user_email" value="" id="user_email">
	</div>
	<div id="plusbtns">
		<input type="button" value="취소" class="btncancel"> 
		<input type="button" value="확인" id="btnok1"> 
	</div>
</div>
<div id="adminPlus_next">
	<div>
		<h3>관리자 권한 주기 </h3>
		<input type="text" value="" placeholder="인증코드">
	</div>
	<div id="plusbtns">
		<input type="button" value="취소" class="btncancel"> 
		<input type="button" value="확인" id="btnok2"> 
	</div>
	<script>
	
		$(function(){
			$("#btnok2").on("click", function(){
				admin_plus();
			});
		});
	
	</script>
</div>
<%@ include file="../inc/footer.jsp"%>