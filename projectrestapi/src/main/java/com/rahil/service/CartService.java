package com.rahil.service;

import com.rahil.dao.CartDAO;

public class CartService {

	private CartDAO cartdao;
	
	public CartService()
	{
		cartdao = new CartDAO();
	}
	
	public void addCart(String username, int itemid,String itemname, int qty, int itemprice)
	{	
		  cartdao.addToCart(username, itemid, itemname, qty, itemprice);
	}
	
}
