package com.foodapp.daoimpl;

import com.foodapp.dao.Order1DAO;
import com.foodapp.model.Order1;

import java.sql.*;
import java.util.*;
public class Order1DAOImpl implements Order1DAO {
    private static final String INSERT_ORDER = "INSERT INTO order1 (user_id, restaurent_id, total_amount, status, payment) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM order1 WHERE orderid=?";
    private static final String UPDATE_PAYMENT_BY_ID = "UPDATE order1 SET payment=? WHERE orderid=?";

    private static Connection con;

    // Static block for establishing the database connection
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root", "Chandan@8073");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrder1(Order1 order1) {
        int result = -1;
        try (PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, order1.getUser_id());
            pstmt.setInt(2, order1.getRestaurent_id());
            pstmt.setInt(3, order1.getTotal_amount());
            pstmt.setBoolean(4, order1.isStatus());
            pstmt.setString(5, order1.getPayment());

            result = pstmt.executeUpdate();
            
            // Retrieve generated order ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    order1.setOrderid(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Order1 Order1getById(int id) {
        Order1 order1 = null;
        try (PreparedStatement pstmt = con.prepareStatement(GET_ORDER_BY_ID)) {
            pstmt.setInt(1, id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    order1 = new Order1(
                        resultSet.getInt("orderid"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("restaurent_id"),
                        resultSet.getInt("total_amount"),
                        resultSet.getBoolean("status"),
                        resultSet.getString("payment")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order1;
    }

    @Override
    public int updateOrder1ById(int id, String payment) {
        int result = -1;
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_PAYMENT_BY_ID)) {
            pstmt.setString(1, payment);
            pstmt.setInt(2, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

	
}
