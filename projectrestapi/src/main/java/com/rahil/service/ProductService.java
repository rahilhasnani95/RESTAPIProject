package com.rahil.service;

import java.util.List;

import com.rahil.dao.ProductDAO;
import com.rahil.entities.ProductBean;

public class ProductService {

	private ProductDAO productdao;

	public ProductService()
	{
		productdao = new ProductDAO();
	}
	
	public List<ProductBean> getprod()
	{
		return productdao.getProducts();
	}
	
	public List<ProductBean> getAllprodforadmin()
	{
		return productdao.getAllProductsforAdmin();
	}
	
	public void updateQuantityofProducts(int itemid, int quantity)
	{
		productdao.updateQuantityOfProductAdmin(itemid, quantity);
	}

	public ProductBean addNewProduct(String itemname, int itemprice, int itemquantity)
	{
		 return productdao.addNewProductAdmin(itemname, itemprice, itemquantity);
	}

	public ProductBean getoneproduct(int itemid) {
		 return productdao.getoneprod(itemid);
	}
	
}
