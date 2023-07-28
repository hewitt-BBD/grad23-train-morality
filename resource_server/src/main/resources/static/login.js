function onClickGoogleSignIn(googleUser) {

  const clientId = googleUser.clientId;
  const jwt = googleUser.credential;

  const [headerEncoded, payloadEncoded, signatureEncoded] = jwt.split(".");
  const header = atob(headerEncoded.replace(/-/g, "+").replace(/_/g, "/"));
  const payload = atob(payloadEncoded.replace(/-/g, "+").replace(/_/g, "/"));
  const headerData = JSON.parse(header);
  const payloadData = JSON.parse(payload);

  console.log('Payload data', payloadData);

  fetch('/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ idToken: jwt, clientId: clientId })
  })
    .then(response => {
      if (response.ok) {

        fetch(`/user/email/${payloadData.email}`, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${jwt}`,
          },
        })
          .then(response => {
            if (!response.ok) {
              console.log('Doesnt exist');

              fetch('/user', {
                method: 'POST',
                headers: {
                  'Content-Type': 'application/json',
                  'Authorization': `Bearer ${jwt}`,
                },
                body: JSON.stringify({ emailAddress: payloadData.email, username: payloadData.name }),
              })
                .then(response => {

                  if (!response.ok) {

                    throw new Error('Network response was not ok');
                  }

                  return response.json();
                })
                .then(data => {

                  console.log('User added successfully:', data);

                  window.location.href = `Home.html?token=${encodeURIComponent(jwt)}`;
                })
                .catch(error => {

                  console.error('Error creating user:', error);
                });
            }
            return response.json();
          })
          .then(data => {

            window.location.href = `Home.html?token=${encodeURIComponent(jwt)}`;
          })
          .catch(error => {
            console.error('Fetch error:', error);
          });
      } else {
        alert('Login failed. Please try again.');
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
}