package com.rahil.projectrestapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rahil.entities.ProductBean;
import com.rahil.service.ProductService;

@Path("products")
public class ProductResource {

	ProductService productser = new ProductService();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ProductBean> getAllProducts()
	{
		System.out.println("prod list 1");
		List<ProductBean> products = productser.getprod();
		System.out.println("prod list 2");

		return products;
	}
	
	@GET
	@Path("product/{itemid}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ProductBean getOneProduct(@PathParam("itemid") int itemid)
	{
		 return productser.getoneproduct(itemid);
	}
	
	@POST
	@Path("product")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProductBean postProduct(ProductBean p)
	{
		ProductBean p1=  productser.addNewProduct(p.getItemname(), p.getItemprice(), p.getItemquantity());
		System.out.println(p1);
		return p1;
	}
	
	@PUT
	@Path("product")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updateProduct(ProductBean p)
	{
		if(productser.getoneproduct(p.getItemid()).getItemid() == 0)
		{
			productser.addNewProduct(p.getItemname(), p.getItemprice(), p.getItemquantity());
			System.out.println("added");
		}
		else
		{
			productser.updateQuantityofProducts(p.getItemid(), p.getItemquantity());
			System.out.println("updated");
		}
	}
	
	
}






