package com.foodapp.dao;
import java.util.ArrayList;
import java.util.List;
import com.foodapp.model.Menu;
public interface MenuDAO {
	int insertMenu(Menu menu);
	 List<Menu> getAllRestMenu(int rid);
	 Menu getMenuById(int id);
	 int deleteMenuById(int id);
	 int updateMenuById(int id,String description);
}
