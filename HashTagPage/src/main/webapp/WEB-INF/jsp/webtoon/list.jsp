<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>webtoon-series</title>
    <link rel="stylesheet" href="/css/00_style.css" />
    <link rel="stylesheet" href="/css/header.css" />
    <link rel="stylesheet" href="/css/footer.css" />
    <link rel="stylesheet" href="/css/webtoon-series-detail.css" />
  </head>
  <body>
    <div class="page">
      <jsp:include page="/common/header.jsp" />

      <main class="webtoon-series-detail mt4 mb4">
        <div class="series-flex-row">
          <div class="webtoon-series-cover w25 mr4">
            <img src="/img/bookcard27.jpg" alt="책 표지" />
            <div class="badge-container mb1">
              <span class="badge ponly">#P ONLY</span>
              <span class="badge up">UP</span>
              <span class="badge free">26화 무료</span>
            </div>
          </div>
          <div class="webtoon-series-info w75">
            <h2 class="mb1">이세계 착각 헌터</h2>
            <p class="mb1">✍ 대대원 | 🏷️ 판타지 | 📚 총 62화</p>
            <p class="mb1">⭐ 평점 4.9 (13,753명)</p>
            <div class="button-group">
            <a class="a-rounded-al mr2">첫 화 보기</a>
            <button class="btn-rounded">찜하기 ❤️</button>
            </div>
          </div>
        </div>

        <div class="book-description mt4">
          <h3 class="mb1">💬 작품 소개</h3>
          <p>
            이 책은 ...에 대한 이야기입니다. 흥미진진한 스토리와 매력적인
            캐릭터가 가득한 이 작품은, 독자들에게 깊은 인상을 남깁니다. 💫
          </p>
        </div>
        <!-- 웹툰 리스트 -->
        <section class="webtoon-episode-list mt5">
          <h3 class="mb1">📖 회차 목록</h3>
          <ul class="episodeContainer">
            <!-- 이 부분은 추후 JSP에서 forEach로 돌릴 것 -->
            <li class="episode-item mb1">
              <a href="/episode/view/1" class="episode-link">
                <div class="thumb">
                  <img src="/img/episode1.jpg" alt="1화 썸네일" />
                </div>
                <div class="episode-number">1화</div>
                <div class="episode-title">운명의 만남</div>
              </a>
              <div class="sub-info">무료</div>
            </li>

            <li class="episode-item mb1">
              <a href="/episode/view/1" class="episode-link">
                <div class="thumb">
                  <img src="/img/episode1.jpg" alt="1화 썸네일" />
                </div>
                <div class="episode-number">2화</div>
                <div class="episode-title">좀비가 나타났다</div>
              </a>
              <div class="sub-info">무료</div>
            </li>

            <li class="episode-item mb1">
              <a href="/episode/view/1" class="episode-link">
                <div class="thumb">
                  <img src="/img/episode1.jpg" alt="1화 썸네일" />
                </div>
                <div class="episode-number">3화</div>
                <div class="episode-title">생사의 갈림길</div>
              </a>
              <div class="sub-info">무료</div>
            </li>

            <!-- jsp용 : li 반복 -->
            <!-- <c:forEach var="episode" items="${episodeList}">
                    <li class="episode-item mb1">
                      <a href="/episode/view/${episode.id}" class="episode-link">
                        <div class="thumb">
                          <img src="${episode.thumbnail}" alt="${episode.title} 썸네일" />
                        </div>
                        <div class="episode-title">${episode.title}</div>
                      </a>
                      <div class="sub-info">
                  <c:choose>
                    <c:when test="${episode.isFree}">무료</c:when>
                    <c:otherwise>유료</c:otherwise>
                  </c:choose>
                      </div>
                    </li>
                  </c:forEach> -->
          </ul>

          <button id="loadMore" class="btn-rounded tcenter mt2 w98">
            더보기 ⌄
          </button>
        </section>

        <!-- 리뷰 -->
        <section class="review mt5">
          <h3 class="mb1">리뷰</h3>
          <div class="rating-info pb1 mb2">
            <div class="rating-score mb1">⭐ 4.9</div>
            <span class="rating-score-sub">(13,759명 평가)</span>
          </div>

          <div class="user-rating-stars mb2">
            <div>이 작품을 평가해 주세요!</div>
            <div class="star-rating">
              <span class="star" data-value="5">★</span>
              <span class="star" data-value="4">★</span>
              <span class="star" data-value="3">★</span>
              <span class="star" data-value="2">★</span>
              <span class="star" data-value="1">★</span>
            </div>
            <input type="hidden" id="rating-value" name="rating" value="0" />
            <textarea
              placeholder="리뷰를 10자 이상 입력해주세요."
              cols="70"
              rows="4"
            ></textarea>
            <div class="review-options">
              <!-- <label><input type="checkbox" /> 스포일러가 있습니다</label> -->
              <button class="btn-rounded">리뷰 등록</button>
            </div>
          </div>

          <!-- <div class="review-list mt3">
            <div class="review-item">
              <p class="star">⭐⭐⭐⭐</p>
              <p class="comment">1부까진 정암재밌었습니다……</p>
              <div class="meta">ehg*** · 2025.07.01 · 신고 · 차단</div>
            </div>
             반복 
          </div> -->

            <!-- 사용자 리뷰 -->
          <div class="review-list mt3">
            <c:forEach var="review" items="${reviewList}">
              <div class="review-item">
                <div class="review-top">
                  <p class="rating mb1">⭐️⭐️⭐️⭐️</p>
                  <div class="meta mb1">${review.userId} · ${review.date}</div>
                </div>

                <p class="comment mb1">${review.comment}</p>

                <div class="review-actions">
                  <button class="btn-text-danger report">🚩 신고</button>
                  <button class="btn-text-danger block">⛔ 차단</button>
                  <button class="btn-text-like like">
                    👍 좋아요 <span>0</span>
                  </button>
                </div>
              </div>
            </c:forEach>

            <!-- 반복 -->
            <c:forEach var="review" items="${reviewList}">
              <div class="review-item">
                <div class="review-top">
                  <p class="rating mb1">⭐️⭐️⭐️⭐️</p>
                  <div class="meta mb1">${review.userId} · ${review.date}</div>
                </div>

                <p class="comment mb1">${review.comment}</p>

                <div class="review-actions">
                  <button class="btn-text-danger report">🚩 신고</button>
                  <button class="btn-text-danger block">⛔ 차단</button>
                  <button class="btn-text-like like">
                    👍 좋아요 <span>0</span>
                  </button>
                </div>
              </div>
            </c:forEach>

          </div>
        </section>
      </main>

      <jsp:include page="/common/footer.jsp" />
    </div>

     <script>
      // user-rating-stars
      const stars = document.querySelectorAll(".star");
      const ratingInput = document.getElementById("rating-value");

      stars.forEach((star) => {
        star.addEventListener("click", () => {
          const value = star.dataset.value;
          ratingInput.value = value;

          stars.forEach((s) => s.classList.remove("active"));
          star.classList.add("active");

          // 왼쪽 별들에도 .active 주기
          let prev = star.previousElementSibling;
          while (prev) {
            prev.classList.add("active");
            prev = prev.previousElementSibling;
          }
        });
      });
    </script>
  </body>
</html>
