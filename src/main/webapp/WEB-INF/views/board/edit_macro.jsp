
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/login_header.jsp" %>


<div class="container">
  <div class="write_notice"> <!-- 글작성 start -->
    <form action="${pageContext.request.contextPath}/edit_macro.hm?macro_no=${macroDetail.macro_no}" method="post">
      <fieldset>
        <legend>매크로 답변을 수정해주세요</legend>

        <div>
          <label for="macro_no">번호 </label><br>
          <input type="text" id="macro_no" name="macro_no" value="${macroDetail.macro_no}" readonly="readonly">
        </div>
        <div>
          <label for="macro_content">내용 </label><a> 300글자 내외로 입력가능합니다</a> <br>
          <textarea name="macro_content"  id="macro_content"  cols="60"  rows="10"   class="form-control" >${macroDetail.macro_content}</textarea>
        </div>
         <div>
          <input type="submit" value="매크로 수정하기">
         </div>
      </fieldset>
    </form>
  </div> <!-- 글작성 end -->
</div>

<%@ include  file="../inc/footer.jsp" %>
