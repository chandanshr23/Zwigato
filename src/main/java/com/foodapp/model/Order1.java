package com.foodapp.model;

public class Order1 {

	 private int orderid;
	  private int user_id;
	  private int restaurent_id;
	  private int total_amount;
	  private boolean status;
	  private String payment;
	  
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurent_id() {
		return restaurent_id;
	}
	public void setRestaurent_id(int restaurent_id) {
		this.restaurent_id = restaurent_id;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Order1(int user_id, int restaurent_id, int total_amount, boolean status, String payment) {
		super();
		this.user_id = user_id;
		this.restaurent_id = restaurent_id;
		this.total_amount = total_amount;
		this.status = status;
		this.payment = payment;
	}
	public Order1(int orderid, int user_id, int restaurent_id, int total_amount, boolean status, String payment) {
		super();
		this.orderid = orderid;
		this.user_id = user_id;
		this.restaurent_id = restaurent_id;
		this.total_amount = total_amount;
		this.status = status;
		this.payment = payment;
	}
	public Order1() {
		super();
	}
	@Override
	public String toString() {
		return "Order1 [orderid=" + orderid + ", user_id=" + user_id + ", restaurent_id=" + restaurent_id
				+ ", total_amount=" + total_amount + ", status=" + status + ", payment=" + payment + "]";
	}
	  
}
