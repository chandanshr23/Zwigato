<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.OrderHistory" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" href="orderhistory.css">
</head>
<body>
    <div class="container">
        <h1>Your Order History</h1>
        <table class="order-table">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Total Amount</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<OrderHistory> orderHistory = (List<OrderHistory>) request.getAttribute("OrderHistory");
                    if (orderHistory != null && !orderHistory.isEmpty()) {
                        for (OrderHistory order : orderHistory) {
                %>
                <tr>
                    <td><%= order.getOrderid() %></td>
                    <td>₹<%= order.getTotal() %></td>
                    <td><%= order.getStatus() == 1 ? "Completed" : "Pending" %></td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr>
                    <td colspan="3">No orders found.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="home.jsp" class="back-btn">Back to Home</a>
    </div>
</body>
</html>
