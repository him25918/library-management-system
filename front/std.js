document.getElementById('stdForm').addEventListener('submit', function (e) { 
  e.preventDefault(); // Prevent form from submitting the default way

  // Collect form data
  const studentId = document.getElementById('studentId').value;
  const studentName = document.getElementById('studentName').value;
  const city = document.getElementById('city').value;
  const phone = document.getElementById('phone').value;
  const email = document.getElementById('email').value;

  const message = document.getElementById('message');

  // Clear previous messages
  message.style.display = 'none';
  message.classList.remove('success', 'error');

  // Validate form data
  if (!studentId || !studentName || !city || !phone || !email) {
      message.innerText = 'Please fill out all fields correctly!';
      message.classList.add('error');
      message.style.display = 'block';
      return;
  }

  // Send the data to the backend via a POST request
  fetch('http://localhost:8080/std-api/add', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify({
          studentId: studentId,
          studentName: studentName,
          city: city,
          phone: phone,
          email: email
      }),
  })
  .then(response => {
      if (response.ok) {
          message.innerText = 'Student added successfully!';
          message.classList.add('success');
          message.style.display = 'block';
          document.getElementById('stdForm').reset(); // Clear form after success
      } else {
          message.innerText = 'Error adding student!';
          message.classList.add('error');
          message.style.display = 'block';
      }
  })
  .catch(error => {
      message.innerText = 'An error occurred. Please try again.';
      message.classList.add('error');
      message.style.display = 'block';
      console.error('Error:', error);
  });
});
