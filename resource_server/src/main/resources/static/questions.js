const urlParams = new URLSearchParams(window.location.search);
const token = urlParams.get("token");

let questions = [];

function fetchQuestion(questionId) {
  return fetch(`https://ec2-13-244-119-105.af-south-1.compute.amazonaws.com/questions/${questionId}`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    });
}

Promise.all([
  fetchQuestion(1),
  fetchQuestion(2),
  fetchQuestion(3),
  fetchQuestion(4),
])
  .then(responses => {
    responses.forEach((data, index) => {
      questions.push({
        ...data,
        questionImg: `question${index + 1}.png`,
      });
    });

    updateQuestion();
  })
  .catch(error => {
    console.error('Fetch error:', error);
  });

const previousBtn = document.getElementById('previous-btn');
const nextBtn = document.getElementById('next-btn');
const answerChoice1 = document.getElementById('answer1');
const answerChoice2 = document.getElementById('answer2');

let questionIndex = 1;
let answers = [];

function getCurrentSelection() {

  if (answerChoice1.checked) {
    answers[questionIndex] = 'Option 1';
  } else if (answerChoice2.checked) {
    answers[questionIndex] = 'Option 2';
  }
}

previousBtn.addEventListener('click', () => {

  getCurrentSelection();

  if (questionIndex !== 1) {
    questionIndex--;
  }

  updateQuestion();
});

nextBtn.addEventListener('click', () => {

  getCurrentSelection();

  if (questionIndex < 4) {
    questionIndex++;
  } else if (questionIndex === 4) {

    if (!Array.isArray(answers) || answers.length < 1) {
      alert('Missing answers');
      return;
    }

    for (let i = 1; i < answers.length; i++) {
      if (!answers[i]) {
        alert('Missing answers');
        return;
      }
    }

    window.location.href = 'Statistics.html';
  }

  updateQuestion();
});

function updateQuestion() {

  if (questionIndex === 4) {
    nextBtn.textContent = 'Submit';
  } else {
    nextBtn.textContent = 'Next';
  }

  const questionHeading = document.querySelector('#middle-section h1');
  questionHeading.textContent = questions[questionIndex - 1].question.questionText;

  const questionImage = document.querySelector('#middle-section img');
  questionImage.src = questions[questionIndex - 1].questionImg;
  questionImage.alt = `Question ${questionIndex} Image`;

  const questionOptions = document.querySelectorAll('.multiple-choice label');
  const options = questions[questionIndex - 1].choices;
  questionOptions.forEach((label, index) => {
    label.textContent = options[index].choiceText;
  });
}
