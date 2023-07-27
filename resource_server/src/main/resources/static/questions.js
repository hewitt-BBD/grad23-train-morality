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

  console.log(answers);
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

  if (questionIndex < 3) {
    questionIndex++;
  } else if (questionIndex === 3) {

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

let questions = [];

for (let i = 1; i <= 4; i++) {

  fetch(`https://ec2-13-244-119-105.af-south-1.compute.amazonaws.com/questions/${i}`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      questions.push({
        ...data,
        questionImg: `question${i}.png`,
      });
    })
    .catch(error => {
      console.error('Fetch error:', error);
    });
}

function updateQuestion() {

  if (questionIndex === 3) {
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
