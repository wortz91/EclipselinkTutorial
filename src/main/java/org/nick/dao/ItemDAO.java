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
	public List<Item> getItems() {
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
	public Item getItem(int itemId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EclipseLinkTutorial");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		Item item = em.find(Item.class, itemId);

		em.close();
		emf.close();

		return item;
	}

	public int addItem(Item itemToAdd) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLinkTutorial");

		EntityManager entitymanager = emfactory.createEntityManager();

		// create the item object
		try {
			entitymanager.getTransaction().begin();

			entitymanager.persist(itemToAdd);
			
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			return 0;
		} finally {
			entitymanager.close();
			emfactory.close();
		}

		return 1;
	}

	public void deleteItem(int id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLinkTutorial");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Item item = entitymanager.find(Item.class, id);

		entitymanager.remove(item);

		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

	public int updateItem(Item itemToUpdate) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLinkTutorial");

		EntityManager entitymanager = emfactory.createEntityManager();	
		
		// create the item object
		try {
			entitymanager.getTransaction().begin();
			
			Item item = entitymanager.find(Item.class, itemToUpdate.getId());
			
			
			item.setItemName(itemToUpdate.getItemName());
			
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			return 0;
		} finally {
			entitymanager.close();
			emfactory.close();
		}

		return 1;
	}
}
