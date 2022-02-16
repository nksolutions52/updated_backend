package com.org.dentys.controller;

import com.org.dentys.model.Order;

public class OrderHelper {
	 public static Order getOrder() {
	        Order order = new Order();
	        order.setOrderId(5769);
	        order.setDate("22/06/2021");
	        return order;

	 }
}
