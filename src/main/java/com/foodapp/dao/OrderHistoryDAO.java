package com.foodapp.dao;

import com.foodapp.model.OrderHistory;
import java.util.List;

public interface OrderHistoryDAO {

    int insertOrderHistory(OrderHistory orderHistory);
    int updateOrderStatus(int orderHistoryId, int status);
    OrderHistory getOrderHistoryById(int orderHistoryId);
    List<OrderHistory> getAllOrderHistoryByUserId(int userId);
}
