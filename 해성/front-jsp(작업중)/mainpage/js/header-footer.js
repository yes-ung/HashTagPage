// header-footer.js

document.addEventListener("DOMContentLoaded", () => {
  fetch("/header.html")
    .then((res) => res.text())
    .then((data) => {
      document.getElementById("header").innerHTML = data;
      if (typeof setHeaderToggleEvent === "function") {
        setHeaderToggleEvent();
      }
    });

  fetch("/footer.html")
    .then((res) => res.text())
    .then((data) => {
      document.getElementById("footer").innerHTML = data;
    });
});