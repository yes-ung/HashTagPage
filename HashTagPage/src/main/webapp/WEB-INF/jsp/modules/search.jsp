<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>검색 결과 | #PAGE</title>
  <link rel="stylesheet" href="/css/00_style.css" />
  <link rel="stylesheet" href="/css/search.css">
</head>
<body>
  <div class="page">
  
  <header class="mt5 pl2 pr2">
    <div class="search-logo">
         <a href="<c:url value='/hashtagpage.do'/>"><img src="/img/pagelogo1.png" id="mainlogo" alt="로고" /></a>
    </div>

    <div class="auth-area">
            <a href="<c:url value='/hashtagpage/cart.do'/>" class="a-rounded-al login pl2">장바구니</a>
            <a href="<c:url value='/hashtagpage/liked.do'/>" class="a-rounded-al login pl2">찜목록</a>
          </div>
        </div>
  </header>

  <main class="search-page">
    <!-- 검색 바 -->
    <div class="search-header">
      <div class="nowtag mr2"><p class="">🔥 #Page 인기 태그:</p>
        <a href="#" class="float-text">#헌터</a>
        <a href="#" class="float-text">#착각물</a>
        <a href="#" class="float-text">#망함</a>
        <a href="#" class="float-text">#조별과제</a>
        <a href="#" class="float-text">#좀비</a>
      </div>
      <a href="#"><img src="/img/hashtagp.png" alt="썸네일"></a>
         <form id="searchForm"
                name="searchForm"
                method="get" action="<c:out value='/hashtagpage/search.do' />">
          <div class="search-bar">
            <button type="submit">🔍</button>
            <input type="text" id=search name=search placeholder="#을 눌러 검색하세요!" class="search-input" />
            </div>
          </form>
        <p class="p-font mr4">👉 궁금한 태그를 눌러보세요!</p>     
      <button class="btn-text-like">#hashTagPage</button>
      <button class="btn-text-like">#엘롯기</button>
      <button class="btn-text-like">#먼치킨</button>
      <button class="btn-text-like">#마법은어떻게쓰나요</button>
      <button class="btn-text-like">#현생챙겨</button>
      <!-- <button class="search-button btn-rounded">검색</button> -->
    </div>

    <!-- 검색 결과 요약 -->
    <section class="search-summary">
      <p><strong>“백작”</strong>에 대한 검색결과 <span class="result-count">총 284건</span></p>
      <div class="search-tabs">
        <button class="active">전체<span>(21건)</span></button>
        <button>NOVEL<span>(1건)</span></button>
        <button>COMIX<span>(20건)</span></button>
      </div>
    </section>

    <!-- 검색 결과 리스트 -->
    <section class="search-results">
      <ul class="result-list">
        <li class="result-card">
          <img src="/img/episode2.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title highlight">백작가의 망나니가 되었다</p>
            <p class="meta">웹툰 · <span>유려한</span> · <span>청어람</span></p>
            <p class="desc">이세계의 재혼으로 갑작스레 동생이 생긴 장강 그룹의 후계자...</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>
        <!-- 추가 결과 반복 -->
        
        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>

        <li class="result-card">
          <img src="/img/episode1.jpg" alt="썸네일">
          <div class="result-info">
            <p class="title">백작가의 독공 천재</p>
            <p class="meta">웹소설 · <span>탐구생</span> · <span>카카오</span></p>
            <p class="desc">무공을 잃은 낙오자에서 독공으로 각성한 천재의 성장기!</p>
          </div>
        </li>



      </ul>
    </section>
  </main>
<jsp:include page="/common/footer.jsp" />
</div>

<script>
  const tabButtons = document.querySelectorAll('.search-tabs button');

  tabButtons.forEach((btn) => {
    btn.addEventListener('click', function () {
      // 1. 모든 버튼에서 active 제거
      tabButtons.forEach((b) => b.classList.remove('active'));

      // 2. 클릭한 버튼에 active 추가
      this.classList.add('active');
    });
  });
</script>

</body>
</html>