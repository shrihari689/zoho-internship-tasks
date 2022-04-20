package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.Utils;

public class Order {

	private int id;
	private String code;
	private int userId;
	private int medicineId;
	private String medicineName;
	private int quantity;
	private double amount;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private OrderStatus status;
	
	
	public Order() {
		setCode(Utils.generateRandomWord(5));		
	}
	
	public Order(int userId, int medicineId, String medicineName, int quantity, double amount) {
		setCode(Utils.generateRandomWord(5));
		setUserId(userId);
		setMedicineName(medicineName);
		setMedicineId(medicineId);
		setQuantity(quantity);
		setAmount(amount);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getMedicineId() {
		return medicineId;
	}


	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
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


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(String status) {
		OrderStatus orderStatus = OrderStatus.valueOf(status);
		this.status = orderStatus;
	}
	
	public static Order fromResultSet(ResultSet results) throws SQLException {
		Order order = new Order();
		order.setId(results.getInt("id"));
		order.setCode(results.getString("code"));
		order.setUserId(results.getInt("userId"));
		order.setMedicineId(results.getInt("medicineId"));
		order.setMedicineName(results.getString("medicineName"));
		order.setQuantity(results.getInt("quantity"));
		order.setAmount(results.getDouble("amount"));
		order.setCreatedAt(results.getTimestamp("createdAt"));
		order.setCreatedAt(results.getTimestamp("updatedAt"));
		order.setStatus(results.getString("status"));
		return order;
	}
	
}