package com.info.DAO;

import java.util.List;

import com.info.model.Cart;

public interface CartDao {

	public void addToCart(Cart cart);
	public List<Cart> getCartDetails(int uid, int from, int to);
	
}
