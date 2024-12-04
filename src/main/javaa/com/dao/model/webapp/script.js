// Function to validate the login form
function validateLoginForm() {
    // Get the username and password input elements
    const username = document.getElementById('username');
    const password = document.getElementById('password');

    // Reset any previous validation messages
    username.classList.remove('is-invalid');
    password.classList.remove('is-invalid');

    // Check if the username is empty
    if (username.value.trim() === '') {
        username.classList.add('is-invalid'); // Add invalid class for Bootstrap styling
        return false; // Prevent form submission
    }

    // Check if the password is empty
    if (password.value.trim() === '') {
        password.classList.add('is-invalid'); // Add invalid class for Bootstrap styling
        return false; // Prevent form submission
    }

    // If both fields are valid, allow form submission
    return true;
}

// Function to handle form submission
document.getElementById('loginForm').addEventListener('submit', function(event) {
    // Prevent the default form submission
    event.preventDefault();

    // Validate the form
    if (validateLoginForm()) {
        // If validation passes, you can perform an AJAX request or submit the form
        // For demonstration, we'll just log the values to the console
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        console.log('Username:', username);
        console.log('Password:', password);

        // Here you would typically send the data to the server
        // For example, using fetch or XMLHttpRequest
        // fetch('loginServlet', {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type': 'application/json'
        //     },
        //     body: JSON.stringify({ username, password })
        // })
        // .then(response => response.json())
        // .then(data => {
        //     // Handle the response from the server
        //     if (data.success) {
        //         // Redirect to the dashboard or another page
        //         window.location.href = 'dashboard.html';
        //     } else {
        //         // Show an error message
        //         alert('Login failed: ' + data.message);
        //     }
        // })
        // .catch(error => {
        //     console.error('Error:', error);
        // });
    }
});