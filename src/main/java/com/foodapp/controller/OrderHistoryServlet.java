package com.foodapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.foodapp.daoimpl.OrderHistoryDAOImpl;
import com.foodapp.model.OrderHistory;
import com.foodapp.model.User;
/**
 * Servlet implementation class OrderHistoryServlet
 */
public class OrderHistoryServlet extends HttpServlet {
	
    private OrderHistoryDAOImpl OrderHistoryDAO = new OrderHistoryDAOImpl();  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            List<OrderHistory> OrderHistoryList = OrderHistoryDAO.getAllOrderHistoryByUserId(user.getUser_id());
            request.setAttribute("OrderHistory", OrderHistoryList);
            request.getRequestDispatcher("orderhistory.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
	}


}
