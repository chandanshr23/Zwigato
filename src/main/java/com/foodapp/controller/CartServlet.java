package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.Menu;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");

        if ("add".equals(action)) {
            addItemToCart(req, cart);
        } else if ("update".equals(action)) {
            updateCartItem(req, cart);
        } else if ("remove".equals(action)) {
            removeCartItem(req, cart);
        } else if ("clear".equals(action)) {
            cart.clear(); // Clears entire cart
        }
         else if ("increase".equals(action)) {  // Handle +
            increaseQuantity(req, cart);
        } else if ("decrease".equals(action)) {  // Handle -
            decreaseQuantity(req, cart);
        }

        // Update cart count in session
        session.setAttribute("cartCount", cart.size());

        resp.sendRedirect("Cart.jsp");
    }

    private void addItemToCart(HttpServletRequest request, List<Cart> cart) {
        String idStr = request.getParameter("id");
        String quantityStr = request.getParameter("quantity");

        if (idStr == null || quantityStr == null) {
            System.out.println("Error: Missing item ID or quantity.");
            return;
        }

        int id = Integer.parseInt(idStr);
        int quantity = Integer.parseInt(quantityStr);

        MenuDAOImpl menuDAO = new MenuDAOImpl();
        Menu menuItem = menuDAO.getMenuById(id);

        if (menuItem == null) {
            System.out.println("Error: No menu item found for ID: " + id);
            return;
        }

        for (Cart item : cart) {
            if (item.getId() == id) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        Cart newItem = new Cart(menuItem.getMenu_id(), menuItem.getItem_name(), menuItem.getPrice(), quantity, quantityStr);
        cart.add(newItem);
    }

    private void updateCartItem(HttpServletRequest request, List<Cart> cart) {
        String idStr = request.getParameter("id");
        String quantityStr = request.getParameter("quantity");

        if (idStr == null || quantityStr == null) {
            return;
        }

        int id = Integer.parseInt(idStr);
        int quantity = Integer.parseInt(quantityStr);

        for (Cart item : cart) {
            if (item.getId() == id) {
                item.setQuantity(quantity);
                return;
            }
        }
    }
    private void increaseQuantity(HttpServletRequest request, List<Cart> cart) {
        int id = Integer.parseInt(request.getParameter("id"));

        for (Cart item : cart) {
            if (item.getId() == id) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
    }

    private void decreaseQuantity(HttpServletRequest request, List<Cart> cart) {
        int id = Integer.parseInt(request.getParameter("id"));

        for (Cart item : cart) {
            if (item.getId() == id) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    cart.remove(item); // Remove item if quantity becomes 0
                }
                return;
            }
        }
    }


    private void removeCartItem(HttpServletRequest request, List<Cart> cart) {
        String idStr = request.getParameter("id");

        if (idStr == null) {
            return;
        }

        int id = Integer.parseInt(idStr);
        cart.removeIf(item -> item.getId() == id);
    }
}
