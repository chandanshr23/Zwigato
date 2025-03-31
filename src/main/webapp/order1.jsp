<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.foodapp.daoimpl.Order1DAOImpl" %>
<%@ page import="com.foodapp.model.Order1" %>

<%
    String orderIdParam = request.getParameter("orderId");
    Order1 order = null;

    if (orderIdParam != null) {
        int orderId = Integer.parseInt(orderIdParam);
        Order1DAOImpl orderDAO = new Order1DAOImpl();
        order = orderDAO.Order1getById(orderId);
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="order1.css">
</head>
<body>
    <div class="container">
        <h2>Order Confirmation</h2>

        <% if (order != null) { %>
            <p>Thank you for your order! Here are your order details:</p>
            <ul>
                <li><strong>Order ID:</strong> <%= order.getOrderid() %></li>
                <li><strong>Total Amount:</strong> ₹<%= order.getTotal_amount() %></li>
                <li><strong>Payment Method:</strong> <%= order.getPayment() %></li>
                <li><strong>Order Status:</strong> <%= order.isStatus() ? "Confirmed" : "Pending" %></li>
            </ul>
            <a href="menu.jsp">Back to Menu</a>
        <% } else { %>
            <p>Order not found. Please try again.</p>
        <% } %>
    </div>
</body>
</html>
