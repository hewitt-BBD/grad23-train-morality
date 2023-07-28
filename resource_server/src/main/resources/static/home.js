function getUrlParameter(name) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(name);
}

const token = getUrlParameter('token');
const questionsUrl = 'Questions.html' + '?token=' + encodeURIComponent(token);
const statsUrl = 'Statistics.html' + '?token=' + encodeURIComponent(token);

function navigateToQuestions() {
  window.location.href = questionsUrl;
}

function navigateToStats() {
  window.location.href = statsUrl;
}

document.getElementById('start').addEventListener('click', navigateToQuestions);
document.getElementById('statistics').addEventListener('click', navigateToStats);