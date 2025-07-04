// rating-stars.js

document.addEventListener("DOMContentLoaded", () => {
  const stars = document.querySelectorAll(".star");
  const ratingInput = document.getElementById("rating-value");

  if (!stars.length) return;

  stars.forEach((star) => {
    star.addEventListener("click", () => {
      const value = star.dataset.value;
      ratingInput.value = value;

      stars.forEach((s) => s.classList.remove("active"));
      star.classList.add("active");

      let prev = star.previousElementSibling;
      while (prev) {
        prev.classList.add("active");
        prev = prev.previousElementSibling;
      }
    });
  });
});