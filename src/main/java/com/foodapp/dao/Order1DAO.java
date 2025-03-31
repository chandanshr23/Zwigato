package com.foodapp.dao;

import com.foodapp.model.Order1;

public interface Order1DAO {
	int insertOrder1(Order1 order1);
	 Order1 Order1getById(int id);
	 int updateOrder1ById(int id,String payment_options);
	
}
