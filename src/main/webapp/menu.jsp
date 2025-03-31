<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu - Zwiggy</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="menu.css">
</head>
<body>

    <div class="navbar">
        <div class="logo">🍕 Zwiggy</div>
        <a href="home.jsp">Back to Restaurants</a>
    </div>

    <!-- ✅ Added Extra Menu Section Below -->
    <main class="menu-container">
        <section class="menu-section">
            <h2>Restaurant Menu</h2>
            <div class="menu-items">
            <%
            	List<Menu> sessionMenuList = (List<Menu>) request.getAttribute("menuList"); // ✅ Retrieve from session
            	String restaurentId = request.getParameter("restaurent_id");
                if (restaurentId != null) {
                	session.setAttribute("restaurentId", restaurentId);
                } else {
                    System.out.println("<p>Error: restaurentId not found!</p>");
                }
            	
			    if (sessionMenuList == null) {
			        System.out.println("🚨 sessionMenuList is NULL in menu.jsp!");
			    } else {
			        System.out.println("✅ sessionMenuList size in menu.jsp: " + sessionMenuList.size());
			    }
			
			    if (sessionMenuList != null && !sessionMenuList.isEmpty()) { // ✅ Proper Null Check
			        for (Menu m : sessionMenuList) {
			%>
			            <div class="menu-item">
			            <!-- ✅ Image Section -->
                        <img src="<%= m.getImage() %>" alt="<%= m.getItem_name() %>" class="menu-img">
			            
			                <div class="item-details">
			                    <h3><%= m.getItem_name() %></h3>
			                    <p><%= m.getDescription() %></p>
			                    <p><strong>💰 Price:</strong> ₹<%= m.getPrice() %></p>
			                    <div class="item-footer">
			                        <form action="CartServlet" method="post">
			                            <input type="hidden" name="restaurentId" value="<%= session.getAttribute("restaurentId") %>">
			                            <input type="hidden" name="id" value="<%= m.getMenu_id() %>">
			                            <input type="hidden" name="quantity" value="1">
			                            <input type="hidden" name="action" value="add">
			                            <button type="submit" class="order-btn">Add to Cart</button>
			                        </form>
			                    </div>
			                </div>
			            </div>
			<%
			        }
			    } else { 
			%>
			        <p style="text-align: center; font-size: 18px; color: #777;">No menu items available.</p>
			<%
			    }
			%>
            </div>
        </section>
    </main>

    <form action="Cart.jsp" method="GET" style="display: inline;">
        <button type="submit" class="cart-fab">
            <span class="cart-icon">🛒</span>
            <span class="cart-count">
                <%= (session.getAttribute("cartCount") != null) ? session.getAttribute("cartCount") : "0" %>
            </span>
        </button>
    </form>

</body>
</html>
