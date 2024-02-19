<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/terms.css" />

	<link rel="shortcut icon" sizes="192x192" href="resources/image/logo2.png" />
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
	
	<title>feel in like</title>

</head>
<script>
	$(function(){
		$("#checkAll").on("click", function(){
			if($("#checkAll").prop("checked")){
				$("#termsOfService").prop("checked", true);
				$("#privacyPolicy").prop("checked", true);
				$("#allowPromotions").prop("checked", true);
			}else {
				$("#termsOfService").prop("checked", false);
				$("#privacyPolicy").prop("checked", false);
				$("#allowPromotions").prop("checked", false);
			}
		});
		$("input[name='agree']").on("click", function(){
			if($("input[name='agree']:checked").length==3){
				$("#checkAll").prop("checked", true);
			}else{
				$("#checkAll").prop("checked", false);
			}
		});

	});
</script>
<body>
  <div class="wrap">

    <!-- header -->
    <div>
	<p style="text-align:center">
		<a href="home.js">
		<img src="resources/image/newLogo_2.png"
			style="vertical-align: middle; margin: auto; padding: 40px; width: 370px;">
		</a>
	</p>
</div>
    <div id="header">
      <h2>이용약관</h2>
    </div>

    <div class="contents">
      <form action="signup.js" method="get" id="form__wrap">
      <fieldset>
        <div class="terms__check__all">
          <input type="checkbox" name="checkAll" id="checkAll" />
          <label for="checkAll">
            feel in like 이용약관, 개인정보 수집 및 이용, 위치정보 이용약관에 모두 동의합니다.
          </label>
        </div>
        <ul class="terms__list">
          <li class="terms__box">
            <div class="input__check">
              <input type="checkbox" name="agree" id="termsOfService" value="termsOfService" required />
              <label for="termsOfService" class="required">feel in like 이용약관 동의</label>
            </div>
            <div class="terms__content">
              <b>
                feel in like 웹을 사용하기 위해 이용약관에 동의합니다. <br>
                수집한 이용약관은 feel in like 웹 서비스 이용 동의 이외의 목적으로는 사용하지 않습니다.
              </b>
            </div>
          </li>
          <li class="terms__box">
            <div class="input__check">
              <input type="checkbox" name="agree" id="privacyPolicy" value="privacyPolicy" required />
              <label for="privacyPolicy" class="required">개인정보 수집 및 이용 동의</label>
            </div>
            <div class="terms__content">
              <b>
                feel in like 서비스 내 활동에 참여하기 위해 개인정보를 수집합니다. <br>
                수집한 개인정보는 참여자 확인 이외의 목적으로는 사용하지 않습니다.
              </b>
            </div>
          </li>
          <li class="terms__box">
            <div class="input__check">
              <input type="checkbox" name="agree" id="allowPromotions" value="allowPromotions" required />
              <label for="allowPromotions" class="required">위치정보 이용약관 동의</label>
            </div>
            <div class="terms__content">
              <b>
                feel in like 서비스 내 활동에 참여하기 위한 위치정보를 수집합니다. <br>
                수집한 위치정보는 사용자가 게시판에서 글을 작성할 때 쓰는 용도 이외에는 사용되지 않습니다.
              </b>
            </div>
          </li>
        </ul>
        <input type="submit" value="확인" class="btn next-button">
      </fieldset>
      </form>

    </div>

  </div>
</body>

</html>