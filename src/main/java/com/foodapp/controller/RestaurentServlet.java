package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.dao.RestaurentDAO;
import com.foodapp.daoimpl.RestaurentDAOImpl;
import com.foodapp.model.Restaurent;

/**
 * Servlet implementation class RestaurentServlet
 */
public class RestaurentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurentDAOImpl restaurentDAO=new RestaurentDAOImpl();
		HttpSession session=req.getSession();
		List<Restaurent> restaurents=restaurentDAO.getAllRestaurent();
		for(Restaurent r:restaurents) {
		System.out.println(r.getRestaurent_name());
		}
		
		
		req.setAttribute("restaurents",restaurents);
		req.getRequestDispatcher("home.jsp").forward(req,resp);
		
	
	}
}
