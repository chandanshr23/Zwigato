package com.foodapp.dao;
import java.util.List;
import com.foodapp.model.Restaurent;

public interface RestaurentDAO  {
 int insertRestaurent(Restaurent restaurent);
 List<Restaurent> getAllRestaurent();
 Restaurent getRestaurentById(int id);
 int deleteRestaurentById(int id);
 int updateRestaurentById(int id,String address);
 
}
