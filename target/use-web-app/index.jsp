<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Voting System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Welcome to the Online Voting System</h1>

        <div class="row mt-4">
            <div class="col-12 col-md-6">
                <h2>Login</h2>
                <form action="login.jsp" method="post" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" required />
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required />
                    </div>
                    <div class="mb-3">
                        <button type="submit" class="btn btn-primary w-100">Login</button>
                    </div>
                </form>
            </div>

            <div class="col-12 col-md-6">
                <h2>Register</h2>
                <form action="registerUser .jsp" method="post" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label for="newUsername" class="form-label">Username</label>
                        <input type="text" class="form-control" id="newUsername" name="newUsername" required />
                    </div>
                    <div class="mb-3">
                        <label for="newPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" id="newPassword" name="newPassword" required />
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required />
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required />
                    </div>
                    <div class="mb-3">
                        <button type="submit" class="btn btn-success w-100">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="script.js"></script>
</body>
</html>