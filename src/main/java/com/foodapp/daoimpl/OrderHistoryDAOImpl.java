package com.foodapp.daoimpl;
import com.foodapp.dao.OrderHistoryDAO;
import com.foodapp.model.OrderHistory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderHistoryDAOImpl   implements OrderHistoryDAO {
    private static final String INSERT_ORDER_HISTORY = 
        "INSERT INTO order_history (userid, orderid, total, status) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ORDER_STATUS = 
        "UPDATE order_history SET status = ? WHERE order_history_id = ?";
    private static final String GET_ORDER_HISTORY_BY_ID = 
        "SELECT * FROM order_history WHERE order_history_id = ?";
    private static final String GET_ALL_ORDERS_BY_USER = 
        "SELECT * FROM order_history WHERE userid = ?";

    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root", "Chandan@8073");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrderHistory(OrderHistory orderHistory) {
        int result = -1;
        String sql = "INSERT INTO order_history (userid, orderid, total, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, orderHistory.getUserid());
            pstmt.setInt(2, orderHistory.getOrderid());
            pstmt.setInt(3, orderHistory.getTotal());
            pstmt.setInt(4, orderHistory.getStatus());

            result = pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    orderHistory.setOrder_history_id(generatedKeys.getInt(1)); // Set generated ID
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int updateOrderStatus(int orderHistoryId, int status) {
        int result = -1;
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_ORDER_STATUS)) {
            pstmt.setInt(1, status);
            pstmt.setInt(2, orderHistoryId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public OrderHistory getOrderHistoryById(int orderHistoryId) {
        OrderHistory orderHistory = null;
        try (PreparedStatement pstmt = con.prepareStatement(GET_ORDER_HISTORY_BY_ID)) {
            pstmt.setInt(1, orderHistoryId);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    orderHistory = new OrderHistory(
                        resultSet.getInt("order_history_id"),
                        resultSet.getInt("userid"),
                        resultSet.getInt("orderid"),
                        resultSet.getInt("total"),
                        resultSet.getInt("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public List<OrderHistory> getAllOrderHistoryByUserId(int userId) {
        List<OrderHistory> orderHistories = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(GET_ALL_ORDERS_BY_USER)) {
            pstmt.setInt(1, userId);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    orderHistories.add(new OrderHistory(
                        resultSet.getInt("order_history_id"),
                        resultSet.getInt("userid"),
                        resultSet.getInt("orderid"),
                        resultSet.getInt("total"),
                        resultSet.getInt("status")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistories;
    }
}

