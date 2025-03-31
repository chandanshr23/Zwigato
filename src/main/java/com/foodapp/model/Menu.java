package com.foodapp.model;

public class Menu {
   private int menu_id;
   private int restaurent_id;
   private String item_name;
   private String description;
   private int price;
   private boolean isAvailable;
   private String image;
public int getMenu_id() {
	return menu_id;
}
public void setMenu_id(int menu_id) {
	this.menu_id = menu_id;
}
public int getRestaurent_id() {
	return restaurent_id;
}
public void setRestaurent_id(int restaurent_id) {
	this.restaurent_id = restaurent_id;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Menu(int menu_id, int restaurent_id, String item_name, String description, int price, boolean isAvailable,String image) {
	super();
	this.menu_id = menu_id;
	this.restaurent_id = restaurent_id;
	this.item_name = item_name;
	this.description = description;
	this.price = price;
	this.isAvailable = isAvailable;
	this.image=image;
}

public Menu(int restaurent_id, String item_name, String description, int price, boolean isAvailable,String image) {
	super();
	this.restaurent_id = restaurent_id;
	this.item_name = item_name;
	this.description = description;
	this.price = price;
	this.isAvailable = isAvailable;
	this.image=image;
}
@Override
public String toString() {
	return "Menu [menu_id=" + menu_id + ", restaurent_id=" + restaurent_id + ", item_name=" + item_name
			+ ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable + ", image=" + image
			+ "]";
}
   
}
