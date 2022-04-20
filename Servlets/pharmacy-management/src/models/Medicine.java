package models;

import utils.Utils;

public class Medicine {

	private int id;
	private String name;
	private String description;
	private int quantity;
	private double price;
	
	public Medicine() {}
	
	
	public Medicine(String name, String description, int quantity, double price) {
		setName(name);
		setDescription(description);
		setQuantity(quantity);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if((name == null) || (name.isEmpty()) || (name.isBlank())) {
			throw new IllegalArgumentException("Name of the medicine cannot be blank");
		}
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if((quantity > 1000) || (quantity < 0)) {
			throw new IllegalArgumentException("Quantity must be within 0 to 1000");
		}
		this.quantity = Utils.clamp(quantity, 0, 1000);
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if((price > 10000) || (price < 0)) {
			throw new IllegalArgumentException("Price must be within 0 to 10000");
		}
		this.price = price;
	}


	
	
	
}
