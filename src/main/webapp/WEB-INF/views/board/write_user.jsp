<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/login_header.jsp" %>


<div class="container">
  <div class="write_notice"> <!-- 글작성 start -->

    <form action="${pageContext.request.contextPath}/write_user.hm?user_no=${login.user_no}" method="post"><!-- ${login.user_no} -->

      <fieldset>
        <legend>문의사항을 작성해주세요!</legend>

        <div>
          <label for="board_title">제목 </label><a> 30글자 내외로 입력가능합니다</a> <br>
          <input type="text" id="board_title" name="board_title" placeholder="질문 제목을 입력해주세요" >
        </div>
        <div>
          <label for="board_content">내용 </label><a> 300글자 내외로 입력가능합니다</a> <br>
          <textarea name="board_content"  id="board_content"  cols="60"  rows="10"   class="form-control" ></textarea>
        </div>
         
         <div>
          <label for="board_open">공개범위를 선택해주세요 </label><a> 필수입력입니다</a> <br>
          <select name="board_open" id="board_open">
            <option value="true">공개</option>
            <option value="false">비공개</option>
          </select>
         </div>
  
         <div>
          <input type="submit" value="글 올리기">
         </div>
      </fieldset>
    </form>
  </div> <!-- 글작성 end -->
</div>

<%@ include  file="../inc/footer.jsp" %>
