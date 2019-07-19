package com.rahil.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rahil.entities.CartBean;


public class ViewCartDAO {

	//DatabaseConnection db = new DatabaseConnection();
	
	public List<CartBean> getCart(String username)
	{	
		EntityManager em = null;
		List list = null;
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Query q = em.createQuery("select c from CartBean c where c.username =?1");
			q.setParameter(1, username);
			
			list = q.getResultList();
			
			return list;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			em.close();
		}
	return list;	
	}
}
