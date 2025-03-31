<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.User, com.foodapp.model.Restaurent" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurants - Zwiggy</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="home.css">
</head>
<body>
    <%
        User u = (User) session.getAttribute("user");
        List<Restaurent> restaurents = (List<Restaurent>) request.getAttribute("restaurents");
    %>

    <!-- Navbar -->
    <nav class="navbar">
        <div class="nav-content">
            <div class="logo">🍽️ Zwiggy</div>
            <div class="nav-links">
                <% if (u != null) { %>
                    <div class="profile-dropdown">
                        <button id="profileBtn">
                            <img src="images/ProfilePic.png" alt="Profile" class="profile-icon">
                        </button>
                        <div class="dropdown-content" id="profileDropdown">
                            <a href="profile.jsp"><i class="fas fa-user"></i> Profile</a>
                            <a href="OrderHistoryServlet"><i class="fas fa-history"></i> Order History</a>
                            <a href="LogoutServlet"><i class="fas fa-sign-out-alt"></i> Logout</a>
                        </div>
                    </div>
                <% } else { %>
                    <a href="login.jsp">Login</a>
                    <a href="register.jsp" class="btn-primary">Sign Up</a>
                <% } %>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <div class="hero">
        <h1>Discover the best food in your city</h1>
    </div>

    <!-- Search Bar -->
    <div class="search-container">
        <input type="text" placeholder="Search for restaurants, cuisines or dishes..." class="search-box">
        <button class="search-btn">Search</button>
    </div>

    <!-- Main Content -->
    <div class="container">
        <h1 class="section-title">Restaurants near you</h1>
        <div class="restaurant-list">
            <%
                if (restaurents != null && !restaurents.isEmpty()) {
                    for (Restaurent restaurent : restaurents) {
            %>
            <div class="restaurent-card" onclick="redirectToMenu(<%= restaurent.getRestaurent_id() %>)">
                <img src="<%= restaurent.getImage() != null ? restaurent.getImage() : "https://b.zmtcdn.com/data/pictures/chains/9/18350369/4be376adb66b75764946d00a7dcf9991.jpg" %>" alt="<%= restaurent.getRestaurent_name() %>" class="restaurent-image">
                <div class="restaurent-info">
                    <h3 class="restaurent-name"><%= restaurent.getRestaurent_name() %></h3>
                    <p class="restaurent-cuisine"><%= restaurent.getType() %></p>
                    <div class="restaurent-details">
                        <div class="restaurent-rating">
                            <i class="fas fa-star"></i>
                            <%= restaurent.getRestaurent_rating() %>
                        </div>
                        <div class="restaurent-price">₹200 for one</div>
                        <div class="restaurent-time">25 min</div>
                    </div>
                </div>
            </div>
            <% 
                    }
                } else { 
            %>
            <p class="no-restaurents">No restaurants available in your area</p>
            <% } %>
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
function redirectToMenu(restaurentId) {
    window.location.href = "MenuServlet?restaurent_id=" + restaurentId;
}

document.addEventListener("DOMContentLoaded", function () {
    const profileBtn = document.getElementById("profileBtn");
    const profileDropdown = document.getElementById("profileDropdown");

    if (profileBtn && profileDropdown) {
        profileBtn.addEventListener("click", function (event) {
            event.stopPropagation();
            profileDropdown.classList.toggle("show");
        });

        document.addEventListener("click", function (event) {
            if (!profileBtn.contains(event.target) && !profileDropdown.contains(event.target)) {
                profileDropdown.classList.remove("show");
            }
        });
    }

    // Search functionality can be added here
    const searchBtn = document.querySelector(".search-btn");
    if (searchBtn) {
        searchBtn.addEventListener("click", function() {
            const searchTerm = document.querySelector(".search-box").value;
            // Implement search functionality
            console.log("Searching for:", searchTerm);
        });
    }
});
</script>

</body>
</html>
