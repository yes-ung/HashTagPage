<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>PageHeader</title>
    <link rel="stylesheet" href="/css/header.css" />
  </head>
  <body>
  <div id="header-c">
  
  </div>
    <header>
      <div class="main-header">
        <div class="header-container ml2 mr2 pt2 pb3">
          <div class="logo">
            <a href="<c:url value='/hashtagpage.do'/>"><img src="/img/pagelogo1.png" id="mainlogo" alt="로고" /></a>
          </div>

          <div class="auth-area">
            <a href="<c:url value='/hashtagpage/signup.do'/>" class="a-rounded signup">회원가입</a>
            <a href="<c:url value='/hashtagpage/login.do'/>" class="a-rounded login pl2">로그인</a>
            <a href="<c:url value='/hashtagpage/cart.do'/>" class="a-rounded login pl2">장바구니</a>
            <a href="<c:url value='/hashtagpage/mypage.do'/>" class="a-rounded login pl2">내정보</a>
          </div>
        </div>

        <nav class="search ml2 mr2 mb4">
          <div class="main-nav">
            <button class="pc-toggle mt1" aria-label="메뉴 열기">
              <img src="/img/menu.PNG" id="menuToggle" alt="메뉴 열기" />
            </button>
            <ul>
              <li><a href="<c:url value='/hashtagpage/webtoon.do'/>" class="a-rounded">웹툰</a></li>
              <li><a href="<c:url value='/hashtagpage/webnovel.do'/>" class="a-rounded">웹소설</a></li>
              <li><a href="<c:url value='/hashtagpage/community.do'/>" class="a-rounded">커뮤니티</a></li>
            </ul>
            <div class="pc-nav">
              <div class="pdropdown-menu">
                <div class="menu-column">
                  <a href="<c:url value='/hashtagpage/webtoon.do'/>"><h3>웹툰</h3></a>
                  <a href="<c:url value='/hashtagpage/webtoon.do?genre=판타지,SF'/>">판타지 / SF </a>
                  <a href="<c:url value='/hashtagpage/webtoon.do?genre=추리,스릴러'/>">추리 스릴러</a>
                  <a href="<c:url value='/hashtagpage/webtoon.do?genre=드라마'/>">드라마</a>
                </div>
                <div class="menu-column">
                  <a href="<c:url value='/hashtagpage/webnovel.do'/>"><h3>웹소설</h3></a>
                  <a href="<c:url value='/hashtagpage/webnovel.do?genre=판타지,SF'/>">판타지 / SF </a>
                  <a href="<c:url value='/hashtagpage/webnovel.do?genre=추리,스릴러'/>">추리 스릴러</a>
                  <a href="<c:url value='/hashtagpage/webnovel.do?genre=드라마'/>">드라마</a>
                </div>
                <div class="menu-column">
                <a href="<c:url value='/hashtagpage/community.do'/>"><h3>커뮤니티</h3></a>
                <a href="<c:url value='/hashtagpage/community/list.do?genre=자유게시판'/>">자유게시판 </a>
                <a href="<c:url value='/hashtagpage/community/list.do?genre=찬반토론'/>">찬반 토론</a>
                <a href="<c:url value='/hashtagpage/community/list.do?genre=추천'/>">추천</a>
                </div>
                
              </div>
            </div>
          </div>
          <!-- 햄버거 메뉴 (모바일 전용) -->
          <div class="mobile-toggle">
            <button class="mt1" aria-label="메뉴 열기">
              <img src="/img/menu.PNG" id="menuToggle" alt="메뉴 열기" />
            </button>
          </div>
          <div class="mobile-nav">
            <div class="mdropdown-menu">
              <div class="menu-column">
                <a href="<c:url value='/hashtagpage/webtoon.do'/>"><h3>웹툰</h3></a>
                <a href="<c:url value='/hashtagpage/webtoon.do?genre=판타지,SF'/>">판타지 / SF </a>
                <a href="<c:url value='/hashtagpage/webtoon.do?genre=추리,스릴러'/>">추리 스릴러</a>
                <a href="<c:url value='/hashtagpage/webtoon.do?genre=드라마'/>">드라마</a>
              </div>
              <div class="menu-column">
                <a href="<c:url value='/hashtagpage/webnovel.do'/>"><h3>웹소설</h3></a>
                <a href="<c:url value='/hashtagpage/webnovel.do?genre=판타지,SF'/>">판타지 / SF </a>
                <a href="<c:url value='/hashtagpage/webnovel.do?genre=추리,스릴러'/>">추리 스릴러</a>
                <a href="<c:url value='/hashtagpage/webnovel.do?genre=드라마'/>">드라마</a>
              </div>
              <div class="menu-column">
                <a href="<c:url value='/hashtagpage/community.do'/>"><h3>커뮤니티</h3></a>
                <a href="<c:url value='/hashtagpage/community/list.do?genre=자유게시판'/>">자유게시판 </a>
                <a href="<c:url value='/hashtagpage/community/list.do?genre=찬반토론'/>">찬반 토론</a>
                <a href="<c:url value='/hashtagpage/community/list.do?genre=추천'/>">추천</a>
              </div>
            </div>
          </div>

          <!-- 검색창 -->
          <form id="searchForm"
                name="searchForm"
                method="get" action="<c:out value='/hashtagpage/search.do' />">
          <div class="search-bar">
            <button type="submit">🔍</button>
            <input type="text" id=search name=search placeholder="작품명 / 작가명 검색" />
            </div>
          </form>
        </nav>
      </div>
    </header>

    <!-- header 토글 JS (JSP 연동 전 테스트용) -->
    <script>
      document
        .querySelector(".mobile-toggle")
        ?.addEventListener("click", function () {
          document.querySelector(".mobile-nav")?.classList.toggle("active");
        });

      document
        .querySelector(".pc-toggle")
        ?.addEventListener("click", function () {
          document.querySelector(".pc-nav")?.classList.toggle("active");
        });
    </script>
  </body>
</html>
