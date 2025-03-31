package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.daoimpl.*;
import com.foodapp.model.Restaurent;
import com.foodapp.model.User;
import com.foodapp.dao.*;
import com.foodapp.dao.RestaurentDAO;/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private HttpSession session;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserDAO udao=new UserDAOImpl();
		User user=udao.getUserByEmailId(email);
		if(user!=null) {
			System.out.println(email+" "+password);
			System.out.println(user.getEmail()+" "+user.getPassword());
			if(password.equals(user.getPassword())){
			    session=req.getSession();    
				session.setAttribute("user", user);
				
				RestaurentDAOImpl restaurentDAO=new RestaurentDAOImpl();
				List<Restaurent> restaurents=restaurentDAO.getAllRestaurent();
				req.setAttribute("restaurents", restaurents);
				
				System.out.println("redirecting to home...");
				req.getRequestDispatcher("home.jsp").forward(req,resp);
				session.setAttribute("name", user.getUsername());
				session.setAttribute("userId", user.getUser_id()); 

				
			}
			else {
				System.out.println("wrong pswd redircting to incroree");
				resp.sendRedirect("incorrectpswd.jsp");
			}
		}
		else {
			if(user==null) {
			resp.sendRedirect("register.jsp");
			}
		}
	}

}
