package org.nick.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the items database table.
 * 
 */
@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Item.getAllItems", query = "SELECT i FROM Item i"),
		@NamedQuery(name = "Item.getSingleItem", query = "SELECT i FROM Item i WHERE i.id = :id"),
		@NamedQuery(name = "Item.deleteSingleItem", query = "DELETE FROM Item i WHERE i.id = :id") })

// @XmlRootElement(name = "item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String itemCategory;
	private int itemCount;
	private String itemDescription;
	private String itemName;
	private BigDecimal itemPrice;
	private String itemUnitType;

	public Item() {
		super();
	}

	public Item(int id, String itemCategory, int itemCount, String itemDescription, String itemName,
			BigDecimal itemPrice, String itemUnitType) {
		super();
		this.id = id;
		this.itemCategory = itemCategory;
		this.itemCount = itemCount;
		this.itemDescription = itemDescription;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemUnitType = itemUnitType;
	}

	public Item(String itemCategory, int itemCount, String itemDescription, String itemName, BigDecimal itemPrice,
			String itemUnitType) {
		super();
		this.itemCategory = itemCategory;
		this.itemCount = itemCount;
		this.itemDescription = itemDescription;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemUnitType = itemUnitType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemCategory() {
		return this.itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemCount() {
		return this.itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemUnitType() {
		return this.itemUnitType;
	}

	public void setItemUnitType(String itemUnitType) {
		this.itemUnitType = itemUnitType;
	}
}