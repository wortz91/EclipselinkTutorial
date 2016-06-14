package org.nick.application;

import java.math.BigDecimal;

import org.nick.dao.ItemDAO;
import org.nick.entities.Item;

public class DatabaseGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item itemToAdd = new Item();
		
		itemToAdd.setItemCategory("Dairy");
		itemToAdd.setItemCount(1);
		itemToAdd.setItemDescription("Refreshing");
		itemToAdd.setItemName("2% Milk");
		itemToAdd.setItemPrice(new BigDecimal(2.99));
		itemToAdd.setItemUnitType("Oz");
		
//		ItemDAO itemDAO = new ItemDAO();
//		itemDAO.addItem(itemToAdd);
	}

}
