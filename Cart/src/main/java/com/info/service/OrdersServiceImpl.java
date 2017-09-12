package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.OrdersDao;
import com.info.model.Orders;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDao odao;
	
	public void addOrder(Orders order1) {
		
		odao.addOrder(order1);
		
	}

	public List<Orders> getAllOrders() {

		return odao.getAllOrders();
	}

	public Long getTotalOrdersRecs() {

		return odao.getTotalOrdersRecs();
	}

	public List<Orders> orderByDate(String contentStringToLook) {
		
		return odao.orderByDate(contentStringToLook);
	}

}
