package com.foodapp.daoimpl;

import java.sql.*;
import java.util.*;

import com.foodapp.dao.MenuDAO;
import com.foodapp.model.Menu;

public class MenuDAOImpl implements MenuDAO {
	static Connection con;
	private static PreparedStatement pstmt;
	private static Statement stmt; 
	private static ResultSet resultSet;
    private static final String INSERT_MENU = "INSERT INTO menu (restaurent_id, item_name, description, price, isAvailable) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ALL_REST_MENU = "SELECT * FROM menu WHERE restaurent_id=?";
    private static final String GET_MENU_BY_ID = "SELECT * FROM menu WHERE menu_id=?";
    private static final String DELETE_MENU_BY_ID = "DELETE FROM menu WHERE menu_id=?";
    private static final String UPDATE_MENU_BY_ID = "UPDATE menu SET description=? WHERE menu_id=?";


     static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root", "Chandan@8073");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertMenu(Menu menu) {
        int result = -1;
        try (PreparedStatement pstmt = con.prepareStatement(INSERT_MENU)) {
            pstmt.setInt(1, menu.getRestaurent_id());
            pstmt.setString(2, menu.getItem_name());
            pstmt.setString(3, menu.getDescription());
            pstmt.setInt(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Menu> getAllRestMenu(int id) {
         List<Menu> menuList=new ArrayList<>();
        try { 
            pstmt = con.prepareStatement(GET_ALL_REST_MENU);
            pstmt.setInt(1, id);
            
            ResultSet resultSet = pstmt.executeQuery();
            
            while(resultSet.next()) {
            List<Menu> menu = extractMenuListFromResultSet(resultSet);
            menuList.addAll(menu);;
             
            }
            } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  menuList;
    }

    @Override
    public Menu getMenuById(int id) {
        Menu menu = null;
        try {
            pstmt = con.prepareStatement(GET_MENU_BY_ID);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();
                List<Menu> menuList = extractMenuListFromResultSet(resultSet);
                menu = menuList.get(0);  // Prevent IndexOutOfBoundsException
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public int deleteMenuById(int id) {
        int result = -1;
        try {
         PreparedStatement pstmt = con.prepareStatement(DELETE_MENU_BY_ID);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateMenuById(int id, String description) {
        int result = -1;
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_MENU_BY_ID)) {
            pstmt.setString(1, description);
            pstmt.setInt(2, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

  
    List<Menu> extractMenuListFromResultSet(ResultSet resultSet) {
        List<Menu> menuList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                menuList.add(new Menu(
                        resultSet.getInt("menu_id"),
                        resultSet.getInt("restaurent_id"),
                        resultSet.getString("item_name"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getBoolean("isAvailable"),
                        resultSet.getString("image")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
}
