package com.rahil.projectrestapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rahil.entities.CartBean;
import com.rahil.service.CartService;
import com.rahil.service.DeleteService;
import com.rahil.service.ViewCartService;

@Path("carts")
public class CartResource {

	CartService cartser = new CartService();
	ViewCartService viewcartser = new ViewCartService();
	DeleteService deleteser = new DeleteService();
	
	@POST
	@Path("cart")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void addingToCart(CartBean c)
	{
		cartser.addCart(c.getUsername(), c.getItemid(), c.getItemname(), c.getItemquantity(), c.getTotalprice());
		System.out.println("added to cart");
	}
	
	@GET
	@Path("cart/{username}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<CartBean> getMyCart(@PathParam("username") String username)
	{
		List<CartBean> mycartlist = viewcartser.getCart(username);
		return mycartlist;
	}
	
	@DELETE
	@Path("cart/{username}/{itemid}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void deletemycart(@PathParam("username") String username, @PathParam("itemid") int itemid)
	{
		deleteser.deleteItem(username, itemid);
		System.out.println("deleted from my cart item "+itemid);
	}
	
	
	
	
	
	
}
