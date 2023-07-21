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

const questions = [
  {
    question: `You are standing near a lever that controls a trolley on a track. 
  The trolley is heading toward five people who are unaware of its approach and unable to move. 
  You have the option to pull the lever, diverting the trolley to a 
  different track where only one person is standing`,
    questionImg: 'question1.png',
    options: ['Pull the lever, saving five lives but directly causing one death?',
      'Do nothing, allowing the trolley to continue on its current track, resulting in five deaths?',],
  },
  {
    question: `There are two trains on separate tracks, each with only one person aboard. 
  One of the passengers is an innocent person, while the other is a dangerous 
  criminal. You have control over the switch, and you can divert the train 
  with the criminal to save the innocent person. However, if you do this, 
  the criminal will escape and potentially harm others`,
    questionImg: 'question2.jpg',
    options: ['Divert the train to save the innocent person, allowing the criminal to escape?',
      'Let the trains continue on their current tracks, risking the life of the innocent person to ensure the criminal is caught?',],
  },
  {
    question: `Question 3 goes here`,
    questionImg: 'question1.png',
    options: ['Divert the train to save the innocent person, allowing the criminal to escape?',
      'Let the trains continue on their current tracks, risking the life of the innocent person to ensure the criminal is caught?',],
  },
  {
    question: `Question 4 goes here`,
    questionImg: 'question2.jpg',
    options: ['Divert the train to save the innocent person, allowing the criminal to escape?',
      'Let the trains continue on their current tracks, risking the life of the innocent person to ensure the criminal is caught?',],
  }];

function updateQuestion() {

  if (questionIndex === 4) {
    nextBtn.textContent = 'Submit';
  } else {
    nextBtn.textContent = 'Next';
  }

  const questionHeading = document.querySelector('#middle-section h1');
  questionHeading.textContent = questions[questionIndex - 1].question;

  const questionImage = document.querySelector('#middle-section img');
  questionImage.src = questions[questionIndex - 1].questionImg;
  questionImage.alt = `Question ${questionIndex} Image`;

  const questionOptions = document.querySelectorAll('.multiple-choice label');
  const options = questions[questionIndex - 1].options;
  questionOptions.forEach((label, index) => {
    label.textContent = options[index];
  });
}
