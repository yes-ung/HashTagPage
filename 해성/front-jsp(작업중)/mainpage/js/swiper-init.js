// swiper-init.js

document.addEventListener("DOMContentLoaded", () => {
  // 상단 이벤트 배너 슬라이드
  if (document.querySelector(".topSwiper")) {
    new Swiper(".topSwiper", {
      loop: true,
      pagination: {
        el: ".swiper-pagination",
      },
      autoplay: {
        delay: 3000,
      },
    });
  }

  // 카드 슬라이더들 공통 처리
  document.querySelectorAll(".cardSwiper").forEach((el) => {
    const id = el.dataset.swiperId; // ex: freeWebtoon
    new Swiper(el, {
      slidesPerView: 3,
      spaceBetween: 10,
      navigation: {
        nextEl: `.${id}-next`,
        prevEl: `.${id}-prev`,
      },
    });
  });

  // 📚 웹툰 순위 슬라이드 (슬라이드 하나에 2개 카드 묶임)
  if (document.querySelector(".rank-swiper")) {
    new Swiper(".rank-swiper", {
      slidesPerView: "auto", // ← 이거 중요! 슬라이드 너비만큼 자동 계산
      spaceBetween: 20,
      navigation: {
        nextEl: ".rank-next",
        prevEl: ".rank-prev",
      },
    });
  }
});