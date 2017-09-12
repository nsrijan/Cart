package com.info.DAO;

import java.util.List;

import com.info.model.Orders;

public interface OrdersDao {
	
	 void addOrder(Orders order1);
	 List<Orders> getAllOrders();
	 Long getTotalOrdersRecs();
	 List<Orders> orderByDate(String contentStringToLook);

}
