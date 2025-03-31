<%@page import="com.foodapp.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Menu" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    // Get cart items from session
    List<Cart> cart = (List<Cart>) session.getAttribute("cart");
    double totalPrice = 0;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - FoodApp</title>
    <link rel="stylesheet" href="checkout.css"> <!-- Link to external CSS -->
</head>
<body>

<div class="container">
    <h2>Checkout</h2>

    <% if (cart != null && !cart.isEmpty()) { %>
        <div class="cart-list">
            <% for (Cart item : cart) { 
                totalPrice += item.getPrice()*item.getQuantity();
            %>
                <div class="cart-item">
                    <span><%= item.getName() %>(x<%= item.getQuantity() %>)</span>
                    <span>₹<%= totalPrice %></span>
                </div>
            <% } %>
        </div>

        <p class="total">Total: ₹<%= totalPrice %></p>

        <form action="Order1Servlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br>

            <label for="address">Address:</label>
            <textarea id="address" name="address" required></textarea><br>

            <label for="payment">Payment Method:</label>
            <select id="payment" name="payment">
                <option value="COD">Cash on Delivery</option>
                <option value="Online">Online Payment</option>
            </select><br>

            <button type="submit" class="checkout-btn">Confirm Order</button>
        </form>

    <% } else { %>
        <p class="empty-cart">Your cart is empty. <a href="menu.jsp">Go back to menu</a></p>
    <% } %>
</div>

</body>
</html>
