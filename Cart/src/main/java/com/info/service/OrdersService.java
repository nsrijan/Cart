package com.info.service;

import java.util.List;

import com.info.model.Orders;

public interface OrdersService {
	
	 void addOrder(Orders order1);
	 List<Orders> getAllOrders();
	 Long getTotalOrdersRecs();
	 List<Orders> orderByDate(String contentStringToLook);


}
