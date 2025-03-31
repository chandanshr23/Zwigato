package com.foodapp.model;

public class Restaurent {
	
private int restaurent_id;
private String restaurent_name;
private String location;
private int restaurent_mob;private float restaurent_rating;
private String type;
private String image;

public int getRestaurent_id() {
	return restaurent_id;
}
public void setRestaurent_id(int restaurent_id) {
	this.restaurent_id = restaurent_id;
}
public String getRestaurent_name() {
	return restaurent_name;
}
public void setRestaurent_name(String restaurent_name) {
	this.restaurent_name = restaurent_name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getRestaurent_mob() {
	return restaurent_mob;
}
public void setRestaurent_mob(int restaurent_mob) {
	this.restaurent_mob = restaurent_mob;
}
public float getRestaurent_rating() {
	return restaurent_rating;
}
public void setRestaurent_rating(float restaurent_rating) {
	this.restaurent_rating = restaurent_rating;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Restaurent(int restaurent_id, String restaurent_name, String location, int restaurent_mob,float restaurent_rating, String type,String image) {
	super();
	this.restaurent_id = restaurent_id;
	this.restaurent_name = restaurent_name;
	this.location = location;
	this.restaurent_mob = restaurent_mob;
	this.restaurent_rating = restaurent_rating;
	this.type = type;
	this.image=image;
}

public Restaurent(String restaurent_name, String location, int restaurent_mob, float restaurent_rating, String type,String image) {
	super();
	this.restaurent_name = restaurent_name;
	this.location = location;
	this.restaurent_mob = restaurent_mob;
	this.restaurent_rating = restaurent_rating;
	this.type = type;
	this.image=image;
}
@Override
public String toString() {
	return "Restaurent [restaurent_id=" + restaurent_id + ", restaurent_name=" + restaurent_name + ", location="
			+ location + ", restaurent_mob=" + restaurent_mob + ", restaurent_rating=" + restaurent_rating + ", type="
			+ type + ", image=" + image + "]";
}
  
}
