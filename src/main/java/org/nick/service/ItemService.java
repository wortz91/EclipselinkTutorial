package org.nick.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nick.dao.ItemDAO;
import org.nick.entities.Item;

@Path("/ItemService")
public class ItemService {
	ItemDAO itemDAO = new ItemDAO();
	
	@GET
	@Path("/getAllItems")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems() {
		return itemDAO.getAllItems();
	}
	
	@GET
	@Path("/getSingleItem")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getSingleItem() {
		return itemDAO.getSingleItem();
	}
}
