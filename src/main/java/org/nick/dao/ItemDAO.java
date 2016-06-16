package org.nick.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;

import org.nick.entities.Item;

public class ItemDAO {

	@GET
	public List<Item> getAllItems() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EclipseLinkTutorial");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		Query query = em.createNamedQuery("Item.getAllItems");

		List<Item> items = query.getResultList();

		em.close();
		emf.close();

		return items;

	}

	@GET
	public List<Item> getSingleItem() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EclipseLinkTutorial");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		Query query = em.createNamedQuery("Item.getSingleItem");

		List<Item> items = query.getResultList();

		em.close();
		emf.close();

		return items;
	}

	public int addItem(Item itemToAdd) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLinkTutorial");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// create the item object
		entitymanager.persist(itemToAdd);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();

		return 1;
	}

	public int deleteItem(int id) {
		List<Item> itemList = getAllItems();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLinkTutorial");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		for (Item item : itemList) {
			if (item.getId() == id) {
				int index = itemList.indexOf(item);
				itemList.remove(index);
				
				entitymanager.persist(itemList);
				entitymanager.getTransaction().commit();
				
				entitymanager.close();
				emfactory.close();
				return 1;
			}
		}
		
		entitymanager.close();
		emfactory.close();
		return 0;
	}
}
