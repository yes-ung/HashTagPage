<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>cart</title>
    <link rel="stylesheet" href="/css/00_style.css" />
    <link rel="stylesheet" href="/css/cart.css">
</head>
<body>
<div class="page">
  <jsp:include page="/common/header.jsp" />

  <!-- 장바구니 본문 -->
    <main class="cart-container flex-center pl1 pr1">
      <h2 class="cart-title mt2">장바구니<span>|</span>
      <a class="a-float-text ml2">찜목록</a> </h2>

  <!-- 모바일 : 장바구니 요약 -->
      <aside class="m-cart-summary mt2 mr1 ml1">
        <ul class="summary-info">
          <li>총 상품 금액<div class="price">15,000원</div></li>
          <li>할인 금액 <div class="price">0원</div></li>
          <li class="total">합계 <div class="price">15,000원</div></li>
        </ul>
      </aside>

  <!-- 모바일 전용 하단 고정 구매 버튼 -->
      <div class="mobile-bottom-bar">
        <button class="mobile-bottom-purchs">구매하기</button>
      </div>

  <!-- 모바일, PC 상단 바 -->
      <div class="cart-toolbar">
        <label><input type="checkbox" id="selectAll" class="mr1"> 전체 선택</label>
          <div class="del-button">
            <a class="a-float-text">선택삭제</a>
          </div>
      </div>


  <!-- 장바구니 컨테이너 : 모바일->PC 반응형 -->
    <div class="pc-cart-wrapper">
      <section class="cart-items">
      <!-- 장바구니 항목들 -->
        <ul class="item-list">
          <li class="cart-item">
            <input type="checkbox" class="item-checkbox">
              <img src="/img/episode2.jpg" alt="썸네일">
                <div class="item-number">1화</div>
                <div class="item-info">
                <a class="title a-float-text">내일은 온다</a>
                <p class="author">작가</p>
                </div>
                <div class="price">₩500</div>
          </li>
      <!-- 다른 항목들도 같은 형식으로 반복 -->


        </ul>
      </section>
      <!-- PC : 장바구니 요약(모바일 장바구니와 동일) -->
      <aside class="pc-cart-summary mt4 mb4 mr2 ml2">
        <ul class="summary-info">
          <li>총 상품 금액<div class="price">15,000원</div></li>
          <li>할인 금액 <div class="price">0원</div></li>
          <li class="total">합계 <div class="price">15,000원</div></li>
        <div class="pc-cart-bar mt2">
          <button class="pc-cart-purchsbar">구매하기</button>
        </div>
      </aside>
    </div>
 
    </main>

  <jsp:include page="/common/footer.jsp" />
</div>


<script>
   window.addEventListener("scroll", function () {
    const scrollBar = document.querySelector(".mobile-bottom-bar");

    if (window.scrollY > 50) {
      scrollBar.classList.add("scroll");
    } else {
      scrollBar.classList.remove("scroll");
    }
  });
</script>

<script>
  // 전체 선택 체크박스
  const selectAllCheckbox = document.getElementById("selectAll");

  // 개별 체크박스들
  const itemCheckboxes = document.querySelectorAll(".item-checkbox");

  // 전체 선택 클릭 시 → 모두 체크 or 해제
  selectAllCheckbox.addEventListener("change", function () {
    const isChecked = selectAllCheckbox.checked;
    itemCheckboxes.forEach((checkbox) => {
      checkbox.checked = isChecked;
    });
  });

  // 개별 체크박스 중 하나라도 변경되면 → 전체 선택 상태 재판단
  itemCheckboxes.forEach((checkbox) => {
    checkbox.addEventListener("change", function () {
      const allChecked = [...itemCheckboxes].every(cb => cb.checked);
      selectAllCheckbox.checked = allChecked;
    });
  });
</script>

</body>
</html>