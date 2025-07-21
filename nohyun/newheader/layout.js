export function setupMainHeader(status = "guest") {
  const target = document.getElementById("main-header");
  if (!target) return;

  fetch("./main-header.html")
    .then(res => res.text())
    .then(data => {
      target.innerHTML = data;

      // ⏬ HTML이 로딩된 후 실행할 로직들은 여기 안에서 호출해야 작동해!
      initHeaderInteractions(status);
    });
}

function initHeaderInteractions(status) {
  const authArea = document.querySelector(".auth-area");
  const submenuBox = document.getElementById("submenu-box");
  const menuLinks = document.querySelectorAll(".menu-link");

  const menuData = {
    webtoon: [
      "판타지/SF", "로맨스", "무협/액션", "스포츠", "공포/추리", "드라마", "퓨전", "BL/GL"
    ],
    novel: [
      "판타지/SF", "로맨스", "로맨스판타지", "무협", "공포/추리", "BL/GL"
    ],
    community: ["자유게시판", "찬반 토론", "추천"]
  };

  function renderAuthMenu() {
    if (!authArea) return;
    authArea.innerHTML = (status === "guest")
      ? `<a href="#" class="a-rounded signup">회원가입</a>
         <a href="#" class="a-rounded login pl2">로그인</a>`
      : `<a href="#" class="a-rounded cart pl2">장바구니</a>
         <a href="#" class="a-rounded mypage pl2">내정보</a>
         <a href="#" class="a-rounded logout pl2">로그아웃</a>`;
  }

  function renderSubmenu(type) {
    if (!submenuBox) return;
    submenuBox.innerHTML = "";
    menuData[type].forEach(item => {
      const link = document.createElement("a");
      link.href = "#";
      link.textContent = item;
      submenuBox.appendChild(link);
    });
  }

  renderAuthMenu();
  renderSubmenu("webtoon");

  menuLinks.forEach(link => {
    link.addEventListener("click", () => {
      document.querySelector(".menu-link.active")?.classList.remove("active");
      link.classList.add("active");
      renderSubmenu(link.dataset.type);
    });
  });
}

export function setupFooter() {
  const footerTarget = document.getElementById("footer");
  if (!footerTarget) return;

  fetch("./footer.html")
    .then(res => res.text())
    .then(data => {
      footerTarget.innerHTML = data;
    });
}