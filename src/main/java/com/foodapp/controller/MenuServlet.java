package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.dao.MenuDAO;
import com.foodapp.model.Menu;
/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		        System.out.println("🚀 MenuServlet called");

		       
		        String restaurentIdStr = req.getParameter("restaurent_id");
		        int restaurentId = 0;
		        System.out.println(restaurentIdStr);

		        if (restaurentIdStr != null && !restaurentIdStr.isEmpty()) {
		            try {
		                restaurentId = Integer.parseInt(restaurentIdStr);
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid restaurantId: " + restaurentIdStr);
		                resp.sendRedirect("home.jsp");
		                return;
		            }
		        } else {
		            System.out.println(" Missing restaurantId");
		            resp.sendRedirect("home.jsp");
		            return;
		        }

		       
		        MenuDAOImpl menuDAO = new MenuDAOImpl();
		        List<Menu> menuList = (List<Menu>) menuDAO.getAllRestMenu(restaurentId);

		       
		        if (menuList == null || menuList.isEmpty()) {
		            System.out.println(" No menu found for restaurant ID: " + restaurentId);
		            req.setAttribute("menuList", null);
		        } else {
		            req.setAttribute("menuList", menuList);
		            System.out.println(" Menu fetched successfully");
		        }

		        // ✅ Forward to menu.jsp
		        req.getRequestDispatcher("menu.jsp").forward(req, resp);
		    }
	  
	}

