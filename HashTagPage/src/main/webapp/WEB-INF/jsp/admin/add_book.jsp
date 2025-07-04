<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <!--    부트스트랩 css  -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!--    개발자 css -->
   <link rel="stylesheet" href="/css/style.css">
<style type="text/css">
.longText input{
height: 500px;
}
</style>

</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page mt3">
<!-- 업로드 시 추가(첨부파일이라는 요청) : enctype="multipart/form-data"  -->
<!-- 스프링 업로드 파일 제한 : (기본값)1M -> 10M -->
   <form id="addForm"
         name="addForm"
         method="post"
         enctype="multipart/form-data"
         >
   <div class="mb3">
            <label for="bookId" class="form-label">책 관리번호(절대 겹치면 안됨!!)</label>
            <input 
                   class="form-control"
                   id="bookId"
                   name="bookId"
                   placeholder="내용입력" />
        </div>
        <div class="mb3">
            <label for="categoryId" class="form-label">형태(소설,만화,단행본 3중 택1)</label>
            <input  
                  class="form-control"
                  id="categoryId"
                  name="categoryId"
                  placeholder="내용입력" />
        </div>
        <div class="mb3">
            <label for="typeId" class="form-label">장르(로맨스,무협 등등)</label>
            <input  
                  class="form-control"
                  id="typeId"
                  name="typeId"
                  placeholder="내용입력" />
        </div>
          <div class="mb3">
            <label for="authorId" class="form-label">책 저자이름</label>
            <input 
                   class="form-control"
                   id="authorId"
                   name="authorId"
                   placeholder="내용입력" />
        </div>
       <div class="mb3">
            <label for="publisherId" class="form-label">책 출판사</label>
            <input 
                   class="form-control"
                   id="publisherId"
                   name="publisherId"
                   placeholder="내용입력" />
        </div>
        <div class="mb3">
            <label for="bookTitle" class="form-label">책 제목</label>
            <input  
                  class="form-control"
                  id="bookTitle"
                  name="bookTitle"
                  placeholder="제목" />
        </div>
        <div class="mb3">
            <label for="bookDescription" class="form-label">책 간단소개</label>
            <input 
                   class="form-control"
                   id="bookDescription"
                   name="bookDescription"
                   placeholder="내용입력" />
        </div>
        
        <div class="mb3">
            <label for="bookPrice" class="form-label">책 가격(String이지만 숫자만 적어주세요)</label>
            <input 
                   class="form-control"
                   id="bookPrice"
                   name="bookPrice"
                   placeholder="내용입력" />
        </div>
        <div class="mb3  longText">
            <label for="novelText" class="form-label">책 내용(소설이거나 단행본일경우)</label>
            <input  
                  class="form-control"
                  id="novelText"
                  name="novelText"
                  placeholder="소설내용" />
        </div>
       
      <div class="input-group">
      <!-- type="file" : 파일대화상자가 화면에 보입니다. -->
       <label for="thumbnailImg" class="form-label">책 썸네일</label>
        <input type="file" 
               class="form-control"
                id="thumbnailFile"
                name="thumbnailFile" 
               >
        <label for="toonImg" class="form-label">책 내용(웹툰일경우)</label>
        <input type="file" 
               class="form-control"
                id="toonFile"
                name="toonFile" 
               >      
        <button class="btn btn-primary" 
                type="button"
                onclick="fn_save()"
                >저장</button>
      </div>
    </form>
</div>
<br><br><br>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<script type="text/javascript">
   function fn_save() {
	   $("#addForm").attr("action",'<c:out value="/book/add.do" />')
       .submit();
   }
</script>

<jsp:include page="/common/footer.jsp"/>
</body>
</html>
