<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Zwigato</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">  
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="nav-content">
            <div class="logo">Zwigato</div>
            <div class="nav-links">
                <a href="register.jsp" class="btn-primary">Sign Up</a>
            </div>
        </div>
    </nav>

    <!-- Login Container -->
    <div class="auth-container">
        <div class="auth-card">
            <h2>Login</h2>
            <p class="auth-subtitle">Welcome back! Log in to continue.</p>

            <!-- Simulating an error message for styling check -->
            <p class="error-message">Invalid email or password</p>

            <form action="LoginServlet" method="post" class="auth-form">
                <div class="input-group">
                    <i class="fas fa-envelope input-icon"></i>
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-lock input-icon"></i>
                    <input type="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit" class="btn-primary auth-btn">Login</button>
            </form>

            <p class="auth-footer">New to Zwigato? <a href="register.jsp">Create an account</a></p>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h4>About Zwigato</h4>
                <p>Discover the best restaurants in your area with Zwiggy.</p>
            </div>
            <div class="footer-section">
                <h4>Company</h4>
                <a href="#">About Us</a>
                <a href="#">Team</a>
                <a href="#">Careers</a>
                <a href="#">Blog</a>
            </div>
            <div class="footer-section">
                <h4>Contact</h4>
                <a href="#">Help & Support</a>
                <a href="#">Partner with us</a>
                <a href="#">Ride with us</a>
            </div>
            <div class="footer-section">
                <h4>Legal</h4>
                <a href="#">Terms & Conditions</a>
                <a href="#">Privacy Policy</a>
                <a href="#">Cookie Policy</a>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2024 Zwigato. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>