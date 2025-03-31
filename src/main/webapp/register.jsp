<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Zwiggy</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="register.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="nav-content">
            <div class="logo">🍽️ Zwiggy</div>
            <div class="nav-links">
                <a href="login.jsp" class="btn-primary">Login</a>
            </div>
        </div>
    </nav>

    <!-- Registration Container -->
    <div class="auth-container">
        <div class="auth-card">
            <h2>Sign Up for Zwiggy</h2>
            <p class="auth-subtitle">Join us to discover the best food in your city</p>


            <form action="RegisterServlet" method="post" class="auth-form">
                <div class="input-group">
                    <i class="fas fa-user input-icon"></i>
                    <input type="text" name="name" placeholder="Full Name" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-envelope input-icon"></i>
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="input-group">
                    <i class="fas fa-map-marker-alt input-icon"></i>
                    <input type="text" name="address" placeholder="Address">
                </div>
                <div class="input-group">
                    <i class="fas fa-lock input-icon"></i>
                    <input type="password" name="password" placeholder="Password" required>
                    <!-- Password strength indicator (optional) -->
                    <div class="password-strength strength-medium">Medium password strength</div>
                </div>
                <button type="submit" class="btn-primary auth-btn">Sign Up</button>
            </form>

            <p class="auth-footer">Already have an account? <a href="login.jsp">Login here</a></p>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h4>About Zwiggy</h4>
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
            <p>&copy; 2024 Zwiggy. All rights reserved.</p>
        </div>
    </footer>

    <script>
        // Optional: Add password strength checker
        document.querySelector('input[name="password"]').addEventListener('input', function(e) {
            const password = e.target.value;
            const strengthIndicator = document.querySelector('.password-strength');
            
            if (password.length === 0) {
                strengthIndicator.style.display = 'none';
                return;
            }
            
            strengthIndicator.style.display = 'block';
            
            // Simple strength check
            let strength = 'weak';
            if (password.length >= 8) strength = 'medium';
            if (password.length >= 12 && /[A-Z]/.test(password) && /[0-9]/.test(password) && /[^A-Za-z0-9]/.test(password)) {
                strength = 'strong';
            }
            
            strengthIndicator.textContent = {
                weak: 'Weak password strength',
                medium: 'Medium password strength',
                strong: 'Strong password strength'
            }[strength];
            
            strengthIndicator.className = 'password-strength strength-' + strength;
        });
    </script>
</body>
</html>