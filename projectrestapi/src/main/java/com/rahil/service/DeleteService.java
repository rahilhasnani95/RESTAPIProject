package com.rahil.service;

import com.rahil.dao.DeleteDAO;

public class DeleteService {

	private DeleteDAO deletedao;
	
	public DeleteService()
	{
		deletedao = new DeleteDAO();
	}
	
	public void deleteItem(String username, int itemid)
	{
		deletedao.deleteItem(username, itemid);
	}
	
	
}
