
const correctUsername = "admin";
const correctPassword = "admin@123";

function login() {
    const username = document.getElementById("user").value;
    const password = document.getElementById("pass").value;
    const errorMessage = document.getElementById("error-message");
    errorMessage.textContent = "";
    if (username === correctUsername && password === correctPassword) {
        window.location.href = "/main.html";
        alert("Login successful!");
    } else {
        errorMessage.textContent = "Invalid username or password.";
    }
}
