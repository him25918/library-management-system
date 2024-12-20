window.onload = function () {
  const loader = document.getElementById('loader'); 
  const tableBody = document.getElementById('bookTable');

  loader.style.display = 'block';
  
  fetch('http://localhost:8080/book-api/all')
    .then(response => response.json())
    .then(books => {
      loader.style.display = 'none';
      
      tableBody.innerHTML = ''; 

      books.forEach(book => {
        const row = document.createElement('tr');
        row.classList.add('book-row'); 

        const idCell = document.createElement('td');
        idCell.textContent = book.bookId;
        idCell.classList.add('book-cell');
        row.appendChild(idCell);

        const isbnCell = document.createElement('td');
        isbnCell.textContent = book.isbn;
        isbnCell.classList.add('book-cell');
        row.appendChild(isbnCell);


        const nameCell = document.createElement('td');
        nameCell.textContent = book.bookName;
        nameCell.classList.add('book-cell');
        row.appendChild(nameCell);

        const authorName = document.createElement('td');
        authorName.textContent = book.authorName;
        authorName.classList.add('book-cell');
        row.appendChild(authorName);
        
        const publication = document.createElement('td');
        publication.textContent = book.publication;
        publication.classList.add('book-cell');
        row.appendChild(publication);

        const price = document.createElement('td');
        price.textContent = book.price;
        price.classList.add('book-cell');
        row.appendChild(price);

        const availability = document.createElement('td');
        availability.textContent = book.isAvailable;
        availability.classList.add('book-cell');
        row.appendChild(availability);

        const location = document.createElement('td');
        if(availability.textContent == "Yes"){
            location.textContent = book.location;
        }else{
          location.textContent = "not available";
        }
        location.classList.add('book-cell');
        row.appendChild(location);
        
        
        tableBody.appendChild(row); 
      });
    })
    .catch(error => {
      console.error('Error fetching books:', error);
      loader.style.display = 'none'; 
    });
};

  