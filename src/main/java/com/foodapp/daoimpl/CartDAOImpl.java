package com.foodapp.daoimpl;

import java.util.LinkedHashMap;
import java.util.Map;
import com.foodapp.model.Cart;

public class CartDAOImpl {

	private Map<Integer, Cart> items ;  
	
	public CartDAOImpl() {
	
		this.items = new LinkedHashMap<>();
	
	}	
	
	public void addItem(Cart item) {
		
		int id = item.getId();
		
		if(items.containsKey(id)) {
			Cart existingItem = items.get(id);
			existingItem.setQuantity((existingItem.getQuantity() + item.getQuantity()));
		}
		else {
			items.put(id, item);
		}
		
	}
	
	public void updateItem(int id, int quantity) {
		if(items.containsKey(id)) {
			if(quantity <=0) {
				items.remove(id);
			}
			else {
				items.get(id).setQuantity(quantity);
			}
		}
		
	}
	
	public void removeItem(int id) {
		items.remove(id);
		
	}
	
	public void clear() {
		items.clear();
	}
	
	public Map<Integer, Cart> getItems(){
		return items;
	}
	
	public int getTotalPrice() {
		return items.values().stream().mapToInt(item -> item.getPrice() * item.getQuantity()).sum();
	}
	public int getTotalItems() {
	    return items.values().stream().mapToInt(Cart::getQuantity).sum();
	}

}