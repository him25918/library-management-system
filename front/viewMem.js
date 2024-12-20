window.onload = function () {
  const loader = document.getElementById('loader'); 
  const tableBody = document.getElementById('memTable');

  loader.style.display = 'block';

  fetch('http://localhost:8080/std-api/all')
      .then(response => response.json())
      .then(students => {
    
          loader.style.display = 'none';

          tableBody.innerHTML = ''; 

          students.forEach(student => {
              const row = document.createElement('tr');
              row.classList.add('member-row'); 


              const idCell = document.createElement('td');
              idCell.textContent = student.studentId;
              idCell.classList.add('member-cell');
              row.appendChild(idCell);

              const nameCell = document.createElement('td');
              nameCell.textContent = student.studentName;
              nameCell.classList.add('member-cell');
              row.appendChild(nameCell);

              const cityCell = document.createElement('td');
              cityCell.textContent = student.city;
              cityCell.classList.add('member-cell');
              row.appendChild(cityCell);

              const phoneCell = document.createElement('td');
              phoneCell.textContent = student.phone;
              phoneCell.classList.add('member-cell');
              row.appendChild(phoneCell);

              const emailCell = document.createElement('td');
              emailCell.textContent = student.email;
              emailCell.classList.add('member-cell');
              row.appendChild(emailCell);


              tableBody.appendChild(row);
          });
      })
      .catch(error => {
          console.error('Error fetching members:', error);
          loader.style.display = 'none';
      });
};
  