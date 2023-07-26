function onClickGoogleSignIn(googleUser) {

  const clientId = googleUser.clientId;
  const jwt = googleUser.credential;

  fetch('/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ idToken: jwt, clientId: clientId })
  })
    .then(response => {
      if (response.ok) {
        window.location.href = 'Home.html';
      } else {
        alert('Login failed. Please try again.');
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
}