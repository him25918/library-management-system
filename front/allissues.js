window.onload = function () {
    const loader = document.getElementById('loader'); 
    const tableBody = document.getElementById('bookTable');
  
    loader.style.display = 'block';
    
    fetch('http://localhost:8080/lib/all-issues')
      .then(response => response.json())
      .then(issues => {
        loader.style.display = 'none';
        
        tableBody.innerHTML = ''; 
  
        issues.forEach(book => {
          const row = document.createElement('tr');
          row.classList.add('book-row'); 
  
          const idCell = document.createElement('td');
          idCell.textContent = book.bookId;
          idCell.classList.add('book-cell');
          row.appendChild(idCell);
  
          const nameCell = document.createElement('td');
          nameCell.textContent = book.bookName;
          nameCell.classList.add('book-cell');
          row.appendChild(nameCell);
  
          const authorName = document.createElement('td');
          authorName.textContent = book.studentId;
          authorName.classList.add('book-cell');
          row.appendChild(authorName);
          
          const publication = document.createElement('td');
          publication.textContent = book.studentName;
          publication.classList.add('book-cell');
          row.appendChild(publication);
  
          const price = document.createElement('td');
          price.textContent = book.issueDate;
          price.classList.add('book-cell');
          row.appendChild(price);

          const returnDate = document.createElement('td');
          returnDate.textContent = book.issueDate;
          returnDate.classList.add('book-cell');
          row.appendChild(returnDate);
          
          tableBody.appendChild(row); 
        });
      })
      .catch(error => {
        console.error('Error fetching issues:', error);
        loader.style.display = 'none'; 
      });
  };
  
    