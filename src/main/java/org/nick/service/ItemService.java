package org.nick.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nick.dao.ItemDAO;
import org.nick.entities.Item;

@Path("/ItemService")
public class ItemService {
	ItemDAO itemDAO = new ItemDAO();
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	@GET
	@Path("/getItems")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems() {
		return itemDAO.getItems();
	}

	@GET
	@Path("/getItem/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("id") int id) {
		return itemDAO.getItem(id);
	}

	/**
	 * 
	 {  
	"id":"6",
	"itemCategory":"MEAT",
    "itemCount":"5",
    "itemDescription":"RED",
    "itemName":"GROUND CHUCK",
    "itemPrice":"7",
    "itemUnitType":"OZ"
	}
	 * @param id
	 * @param itemCategory
	 * @param itemCount
	 * @param itemDescription
	 * @param itemName
	 * @param itemPrice
	 * @param itemUnitType
	 * @return
	 */
	@PUT
	@Path("/addItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addItem(Item itemToAdd)
/*			@FormParam("itemCategory") String itemCategory,
			@FormParam("itemCount") int itemCount, @FormParam("itemDescription") String itemDescription,
			@FormParam("itemName") String itemName, @FormParam("itemPrice") BigDecimal itemPrice,
			@FormParam("itemUnitType") String itemUnitType) 
*/	{
//		Item itemToAdd = new Item(itemCategory, itemCount, itemDescription, itemName, itemPrice, itemUnitType);

		int result = itemDAO.addItem(itemToAdd);
		
		if(result == 1){
			return SUCCESS_RESULT;
		}

		return FAILURE_RESULT;
	}

	@DELETE
	@Path("/deleteItem/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(@PathParam("id") int id) {
		itemDAO.deleteItem(id);

		return FAILURE_RESULT;
	}
	
	@POST
	@Path("/updateItem")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)	
	public String updateItem(@FormParam("id") int id, @FormParam("itemCategory") String itemCategory,
			@FormParam("itemCount") int itemCount, @FormParam("itemDescription") String itemDescription,
			@FormParam("itemName") String itemName, @FormParam("itemPrice") BigDecimal itemPrice,
			@FormParam("itemUnitType") String itemUnitType) {
		Item itemToUpdate = new Item(id, itemCategory, itemCount, itemDescription, itemName, itemPrice, itemUnitType);

		int result = itemDAO.updateItem(itemToUpdate);
		
		if(result == 1){
			return SUCCESS_RESULT;
		}
		
		return FAILURE_RESULT;
	}
}
