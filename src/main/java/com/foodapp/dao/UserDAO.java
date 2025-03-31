package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.User;

public interface UserDAO {
   int insertUser(User user);
   List<User> getAllUser();
   User getUserById(int id);
   int deleteUserById(int id);
   int updateUserById(int id,String address);
   User getUserByEmailId(String email);
}
