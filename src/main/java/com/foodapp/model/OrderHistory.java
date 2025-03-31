package com.foodapp.model;

public class OrderHistory {
	
private int order_history_id;
private int userid;
private int orderid;
private int total;
private int status;
public int getOrder_history_id() {
	return order_history_id;
}
public void setOrder_history_id(int order_history_id) {
	this.order_history_id = order_history_id;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public OrderHistory(int order_history_id, int userid, int orderid, int total, int status) {
	super();
	this.order_history_id = order_history_id;
	this.userid = userid;
	this.orderid = orderid;
	this.total = total;
	this.status = status;
}
public OrderHistory(int userid, int orderid, int total, int status) {
	super();
	this.userid = userid;
	this.orderid = orderid;
	this.total = total;
	this.status = status;
}
public OrderHistory() {
	super();
}
@Override
public String toString() {
	return "OrderHistory [order_history_id=" + order_history_id + ", userid=" + userid + ", orderid=" + orderid
			+ ", total=" + total + ", status=" + status + "]";
}

}
