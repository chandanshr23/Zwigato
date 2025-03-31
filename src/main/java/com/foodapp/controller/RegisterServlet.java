package com.foodapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.daoimpl.*;
import com.foodapp.model.User;
import com.foodapp.dao.*;
/**
 * Servlet implementation class RegisterServlet
 * @param <UserDAO>
 */
public class RegisterServlet extends HttpServlet {
	 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String username=req.getParameter("name");
     String email=req.getParameter("email");
     String password=req.getParameter("password");
     String address=req.getParameter("address");
    
     User user=new User();
     
     user.setUsername(username);
     user.setEmail(email);
     user.setPassword(password);
     user.setAddress(address);
     
     UserDAOImpl udao=new UserDAOImpl();
     int result=udao.insertUser(user);
     if(result>0) {
    	 HttpSession session=req.getSession();
    	 session.setAttribute("user", user);
    	 resp.sendRedirect("home.jsp");
     }
     else {
    	 System.out.println("registration failed");
    	 resp.sendRedirect("register.jsp");
     }
     
	}

}
