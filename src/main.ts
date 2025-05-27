let count = 0;

function updateCounter(): void {
  const el = document.getElementById("counter");
  if (el) {
    el.textContent = count.toString();
  }
  count++;
}

setInterval(updateCounter, 1000);
