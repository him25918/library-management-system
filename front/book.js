document.getElementById('myForm').addEventListener('submit', function (e) {
  e.preventDefault(); 

  const bookId = document.getElementById('bookId').value;
  const isbn = document.getElementById('isbn').value;
  const bookName = document.getElementById('bookName').value;
  const authorName = document.getElementById('authorName').value;
  const publication = document.getElementById('publication').value;
  const price = document.getElementById('price').value;
  const location = document.getElementById('location').value;

  const errorMessage = document.getElementById('error-message');
  const successMessage = document.getElementById('success-message');
  errorMessage.style.display = 'none';
  successMessage.style.display = 'none';

  if (!bookId || !bookName || !authorName || !publication || !price || price <= 0 || !isbn || !location) {
      errorMessage.innerText = 'Please fill out all fields correctly!';
      errorMessage.style.display = 'block'; // Show error message
      return;
  }

  const bookData = {
      bookId: bookId,
      isbn: isbn,
      bookName: bookName,
      authorName: authorName,
      publication: publication,
      price: price,
      isAvailable: "Yes",
      location: location 
  };

  // Send the data to the backend via a POST request
  fetch('http://localhost:8080/book-api/add', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify(bookData), // Convert book data to JSON
  })
  .then(response => {
      if (response.ok) {
          successMessage.innerText = 'Book added successfully!';
          successMessage.style.display = 'block'; // Show success message
          // Clear form inputs after successful submission
          document.getElementById('myForm').reset();
      } else {
          errorMessage.innerText = 'Error adding book. Please try again.';
          errorMessage.style.display = 'block'; // Show error message
      }
  })
  .catch(error => {
      errorMessage.innerText = 'An error occurred. Please try again later.';
      errorMessage.style.display = 'block'; // Show error message
      console.error('Error:', error); // Log error to the console for debugging
  });
});

  