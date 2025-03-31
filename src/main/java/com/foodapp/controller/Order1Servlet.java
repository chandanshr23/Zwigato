package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.daoimpl.Order1DAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.Order1;

/**
 * Servlet implementation class Order1Servlet
 */
public class Order1Servlet extends HttpServlet {

	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        List<Cart> cart = (List<Cart>) session.getAttribute("cart");

	        Integer userId = (Integer) session.getAttribute("userId");
	        String restaurentIdStr = (String) session.getAttribute("restaurentId");
	        Integer restaurentId = null;
	        if (restaurentIdStr != null) {
	            try {
	                restaurentId = Integer.parseInt(restaurentIdStr);
	            } catch (NumberFormatException e) {
	                System.out.println("ERROR: Invalid restaurentId format: " + restaurentIdStr);
	                response.sendRedirect("checkout.jsp?error=invalidRestaurantId");
	                return;
	            }
	        }

	        
	        if (restaurentId == null) {
	            System.out.println("DEBUG: restaurentId is null in session");
	        } else {
	            System.out.println("DEBUG: restaurentId = " + restaurentId);
	        }


	        if (cart == null || cart.isEmpty()) {
	            response.sendRedirect("checkout.jsp?error=emptyCart");
	            return;
	        }

	       
	       
	        String paymentMethod = request.getParameter("payment");

	        // Calculate total price
	        int totalPrice = 0;
	        for (Cart item : cart) {
	            totalPrice += item.getPrice() * item.getQuantity();
	        }

	        // Create Order object
	        Order1 order = new Order1(userId, restaurentId, totalPrice, false, paymentMethod);

	        // Save order to database
	        Order1DAOImpl orderDAO = new Order1DAOImpl();
	        int result = orderDAO.insertOrder1(order);

	        if (result > 0) {
	            session.removeAttribute("cart"); // Clear cart after placing order
	            response.sendRedirect("order1.jsp?orderId=" + order.getOrderid());
	        } else {
	            response.sendRedirect("checkout.jsp?error=orderFailed");
	        }
	    }
	}