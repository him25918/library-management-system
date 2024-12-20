document.getElementById('myForm').addEventListener('submit', function (e) {
    e.preventDefault(); 
  
    const bookId = document.getElementById('bookId').value;
 
    const errorMessage = document.getElementById('error-message');
    const successMessage = document.getElementById('success-message');
    errorMessage.style.display = 'none';
    successMessage.style.display = 'none';
  
    if (!bookId) {
        errorMessage.innerText = 'Please the id correctly!';
        errorMessage.style.display = 'block'; 
        return;
    }

    const bookData = {
        bookId: bookId
    };
 
    fetch('http://localhost:8080/book-api/delete', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(bookData), 
    })
    .then(response => {
        if (response.ok) {
            successMessage.innerText = 'Book deleted successfully!';
            successMessage.style.display = 'block'; 
            document.getElementById('myForm').reset();
        } else {
            errorMessage.innerText = 'Error deleting book. Please try again.';
            errorMessage.style.display = 'block'; // Show error message
        }
    })
    .catch(error => {
        errorMessage.innerText = 'An error occurred. Please try again later.';
        errorMessage.style.display = 'block'; 
        console.error('Error:', error); 
    });
  });
  
    