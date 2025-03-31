package com.foodapp.model;

public class Cart {
  private int id;
  private String name;
  private int price;
  private int quantity;
  private String imagePath;
public Cart() {
	super();
}
public Cart(int id, String name, int price, int quantity, String imagePath) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.imagePath = imagePath;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getImagePath() {
	return imagePath;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}
@Override
public String toString() {
	return "Cart [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
}
  
  
}
