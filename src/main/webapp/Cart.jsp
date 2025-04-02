<%@page import="com.foodapp.model.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Shopping Cart - Zwigato</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="cart.css">
</head>
<body>
    <div class="container">
        <h1>Your Shopping Cart</h1>
        
        <%
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
            if (cart != null && !cart.isEmpty()) {
        %>
        
        <table class="cart-table">
            <thead>
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    double grandTotal = 0;
                    for (Cart item : cart) {
                        double totalPrice = item.getPrice() * item.getQuantity();
                        grandTotal += totalPrice;
                %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td>₹<%= item.getPrice() %></td>
                    <td>
                        <div class="quantity-control">
                            <td>
    <form action="CartServlet" method="post" style="display: flex; align-items: center;">
        <input type="hidden" name="id" value="<%= item.getId() %>">
        <button type="submit" name="action" value="decrease">➖</button>
        <span style="margin: 0 10px;"><%= item.getQuantity() %></span>
        <button type="submit" name="action" value="increase">➕</button>
    </form>
</td>

                        </div>
                    </td>
                    <td>₹<%= totalPrice %></td>
                    <td>
                        <form action="CartServlet" method="post">
                            <input type="hidden" name="id" value="<%= item.getId() %>">
                            <input type="hidden" name="action" value="remove">
                            <button type="submit" class="remove-btn">Remove</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        <div class="cart-summary">
            <h3>Order Summary</h3>
            <div class="summary-row">
                <span>Subtotal:</span>
                <span>₹<%= grandTotal %></span>
            </div>
            <div class="summary-row">
                <span>Delivery Fee:</span>
                <span>₹30</span>
            </div>
            <div class="summary-row total-row">
                <span>Total:</span>
                <span>₹<%= grandTotal + 30 %></span>
            </div>
        </div>
        
        <div class="action-buttons">
            <a href="home.jsp" class="continue-btn">Continue Shopping</a>
            <form action="checkout.jsp" method="post">
                <button class="checkout-btn">Proceed to Checkout</button>
            </form>
        </div>
        
        <% } else { %>
        <div class="empty-cart">
            <p>Your cart is empty.</p>
            <a href="home.jsp" class="continue-btn">Browse Restaurants</a>
        </div>
        <% } %>
    </div>
</body>
</html>
