<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>로그인 페이지</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <!--    부트스트랩 css  -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!--    개발자 css -->
   <link rel="stylesheet" href="/css/style.css">
   <style type="text/css">
      .col2 img {width:100%; height:auto;}
   </style>
</head>
<body>
   <jsp:include page="/common/header.jsp" />
   <div class="page">
      <div class="card mt5">
         <div class="card-body">
            <div class="flex-vcenter">
               <div class="col2">
                  <img src="/images/마스코트.png">
               </div>
               <div class="col2">
                  <div class="pt5 pl5 pb5 pr5">
                     <div class="tcenter">
                        <h3 class="mb4">Welcome Back!</h3> <br>
                        ${errors}
                     </div>
                     <form id="addForm" name="addForm"
                        action="/loginProcess.do"
                        method="post">
                        <div class="form-group">
                           <input type="text" class="form-control mb3"
                           id="email" name="email"
                              placeholder="이메일을 넣기"  />
                        </div>
                        <div class="form-group">
                           <input type="password"
                           id="password" name="password"
                              class="form-control mb3"
                              placeholder="패스워드 넣기"  />
                        </div>

                        <button class="btn btn-primary w100 mb3">
                           Login</button>
                     </form>
                     <hr />
                     <div class="tcenter">
                        <a href="/hashtagpage/signup.do"> 회원가입 </a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 유효성체크 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/auth/login-validation-config.js"></script>

<jsp:include page="/common/footer.jsp" />
</body>
</html>