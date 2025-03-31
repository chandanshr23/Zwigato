<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Restaurent" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurants - Zwiggy</title>
    <link rel="stylesheet" href="restaurant.css">
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <div class="logo">🍽️ Zwiggy</div>
        <div class="auth-links">
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Sign Up</a>
        </div>
    </div>

    <!-- Search Bar -->
    <div class="search-container">
        <input type="text" placeholder="🔍 Search for restaurants, cuisines..." class="search-box">
        <button class="search-btn">Search</button>
    </div>

    <div class="container">
        <h1>Discover Restaurants Near You</h1>
        <div class="restaurant-list">
            <%
                List<Restaurent> restaurents = (List<Restaurent>) request.getAttribute("restaurents");
                if (restaurents != null && !restaurents.isEmpty()) {
                    for (Restaurent restaurent : restaurents) {
            %>
            <div class="restaurent-card">
                <h2><%= restaurent.getRestaurent_name() %></h2>
                <p><strong>📍 Location:</strong> <%= restaurent.getLocation() %></p>
                <p><strong>🍽️ Cuisine:</strong> <%= restaurent.getType() %></p>
                <p><strong>⭐ Rating:</strong> <%= restaurent.getRestaurent_rating() %></p>
                <p><strong>📞 Contact:</strong> <%= restaurent.getRestaurent_mob() %></p>
                <button class="order-btn" onclick="redirectToMenu(<%= restaurent.getRestaurent_id() %>)">Order Now</button>
            </div>
            <% 
                    }
                } else { 
            %>
            <p class="no-restaurants">No restaurants available</p>
            <% } %>
        </div>
    </div>
<script>
    function redirectToMenu(restaurant_id) {
    	console.log("Redirecting with restaurentId:", restaurentId);
        window.location.href = "menu.jsp?restaurantId=" + restaurantId;
    }
</script>
</body>
</html>
