const urlParams = new URLSearchParams(window.location.search);
const token = urlParams.get("token");

let questions = [];

function fetchQuestions() {
  return fetch(`http://localhost:8080/questions`, {
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
    })
    .then(data => {
      questions = data;

      for (let i = 0; i < questions.length; i++) {
        questions[i]['questionImg'] = `question${i + 1}.png`;
      }

      updateQuestion();
    })
    .catch(error => {
      console.error('Fetch error:', error);
    });
}

fetchQuestions();

const getEmailFromToken = (token) => {
  const [headerEncoded, payloadEncoded, signatureEncoded] = token.split(".");

  const header = atob(headerEncoded.replace(/-/g, "+").replace(/_/g, "/"));

  const payload = atob(payloadEncoded.replace(/-/g, "+").replace(/_/g, "/"));

  const headerData = JSON.parse(header);

  const payloadData = JSON.parse(payload);

  return payloadData.email;
};

function getId(email) {

  fetch(`http://localhost:8080/user/${email}`, {
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
    })
    .then(data => {
      return data.emailAddress;
    })
    .catch(error => {
      console.error('Fetch error:', error);
    });
};

// Function to save a single answer
function saveAnswer(answer) {
  return fetch('http://localhost:8080/answers', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
    body: JSON.stringify(answer),
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    });
}

// Save the answers when the user submits
function saveAllAnswers() {
  if (!Array.isArray(answers) || answers.length < 1) {
    alert('Missing answers');
    return;
  }


  Promise.all(
    answers.map(answer => saveAnswer(answer))
  )
    .then(responses => {
      console.log('Responses:', responses);
      alert('Answers saved successfully!');
      window.location.href = 'Statistics.html';
    })
    .catch(error => {
      console.error('Error saving answers:', error);
    });
}

const previousBtn = document.getElementById('previous-btn');
const nextBtn = document.getElementById('next-btn');
const answerChoice1 = document.getElementById('answer1');
const answerChoice2 = document.getElementById('answer2');

let questionIndex = 1;
let answers = [];
// need to get this from the token
let testing = getId(getEmailFromToken(token));
console.log(testing);

function getCurrentSelection() {
  if (answerChoice1.checked) {
    answers[questionIndex] = {
      user: {
        userId: testing
      },
      question: {
        questionId: questions[questionIndex - 1].question.questionId
      },
      choice: {
        choiceId: questions[questionIndex - 1].choices[0].choiceId
      }
    };
  } else if (answerChoice2.checked) {
    answers[questionIndex] = {
      user: {
        userId: testing
      },
      question: {
        questionId: questions[questionIndex - 1].question.questionId
      },
      choice: {
        choiceId: questions[questionIndex - 1].choices[1].choiceId
      }
    };
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
    saveAllAnswers();
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