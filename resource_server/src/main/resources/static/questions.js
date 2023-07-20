const previousBtn = document.getElementById('previous-btn');
const nextBtn = document.getElementById('next-btn');

let questionIndex = 1;

previousBtn.addEventListener('click', () => {

  if (questionIndex !== 1) {
    questionIndex--;
  }

  updateQuestion();
});

nextBtn.addEventListener('click', () => {

  if (questionIndex < 5) {
    questionIndex++;
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
  }];

function updateQuestion() {

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
