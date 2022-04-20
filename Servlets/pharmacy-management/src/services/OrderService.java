package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Order;
import models.OrderStatus;

public class OrderService {

	public static void updateStatus(int orderId, OrderStatus status) throws SQLException {

		Connection connection = DatabaseService.getInstance().getConnection();
		connection.setAutoCommit(false);
		
		try {
			
			PreparedStatement statement = connection.prepareStatement("UPDATE orders SET status = ? WHERE id = ?");
			statement.setString(1, status.name());
			statement.setInt(2, orderId);
			
			statement.executeUpdate();
		
		} catch (Exception e) {
			connection.rollback();
		} finally {
			connection.setAutoCommit(true);
		}
		
	}
	
	public static void cancelOrder(int orderId) throws SQLException {

		Connection connection = DatabaseService.getInstance().getConnection();
		connection.setAutoCommit(false);
		
		try {
			
			PreparedStatement statement = connection.prepareStatement("UPDATE orders SET status = ? WHERE id = ? AND createdAt > DATE_ADD(NOW(), INTERVAL -4 HOUR)");
			statement.setString(1, OrderStatus.CANCELLED.name());
			statement.setInt(2, orderId);
			
			statement.executeUpdate();
	
			Order order = findById(orderId);
			
			PreparedStatement quantityStatement = connection.prepareStatement("UPDATE medicines SET quantity = quantity + ? WHERE id = ?");
			quantityStatement.setInt(1, order.getQuantity());
			quantityStatement.setInt(2, order.getMedicineId());
			
			quantityStatement.executeUpdate();				
			
			
		} catch (Exception e) {
			connection.rollback();
		} finally {
			connection.setAutoCommit(true);
		}
		
	}
	
	public static void placeOrder(Order order) throws SQLException  {

		Connection connection = DatabaseService.getInstance().getConnection();
	
		connection.setAutoCommit(false);
		
		try {
			
			PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(code, userId, medicineId, quantity, amount, medicineName) VALUES(?, ?, ?, ?, ?, ?)");
			statement.setString(1, order.getCode());
			statement.setInt(2, order.getUserId());
			statement.setInt(3, order.getMedicineId());
			statement.setInt(4, order.getQuantity());
			statement.setDouble(5, order.getAmount());
			statement.setString(6, order.getMedicineName());
				
			statement.executeUpdate();
	
			PreparedStatement quantityStatement = connection.prepareStatement("UPDATE medicines SET quantity = quantity - ? WHERE id = ? AND quantity > 0");
			quantityStatement.setInt(1, order.getQuantity());
			quantityStatement.setInt(2, order.getMedicineId());
				
			quantityStatement.executeUpdate();
			
			connection.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			connection.rollback();
		} finally {
			connection.setAutoCommit(true);		
		}
		
	}	
	
	public static Order findById(int id) {
		Order order = null;

		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");
			statement.setInt(1, id);
			 
			ResultSet results =  statement.executeQuery();
			
			if(results.next()) {
				order = Order.fromResultSet(results);
			}
		} catch (Exception e) {}
		
		return order;
	}
	
	public static List<Order> listCancelOrders() {
		List<Order> orders = new ArrayList<Order>();

		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE status = 'PENDING' AND createdAt > DATE_ADD(NOW(), INTERVAL -4 HOUR) ORDER BY createdAt DESC;");
			 
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Order order = Order.fromResultSet(results);
				orders.add(order);
			}
		} catch (Exception e) {}
		
		return orders;
	}
	
	public static List<Order> listReturnRequestedOrders() {
		List<Order> orders = new ArrayList<Order>();

		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE status IN (?,?,?) ORDER BY updatedAt DESC;");
			statement.setString(1, OrderStatus.RETURN_REQUESTED.name()); 
			statement.setString(2, OrderStatus.RETURN_DECLINED.name()); 
			statement.setString(3, OrderStatus.RETURN_COMPLETED.name()); 
			
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Order order = Order.fromResultSet(results);
				orders.add(order);
			}
		} catch (Exception e) {}
		
		return orders;
	}
	
	public static List<Order> listReturnOrders() {
		List<Order> orders = new ArrayList<Order>();

		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE status = 'COMPLETED' AND updatedAt > DATE_ADD(NOW(), INTERVAL -30 DAY) ORDER BY updatedAt DESC;");
			 
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Order order = Order.fromResultSet(results);
				orders.add(order);
			}
		} catch (Exception e) {}
		
		return orders;
	}
	
	public static List<Order> findByStatus(OrderStatus status) {
		List<Order> orders = new ArrayList<Order>();

		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE status = ? ORDER BY id DESC");
			statement.setString(1, status.name());
			 
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Order order = Order.fromResultSet(results);
				orders.add(order);
			}
		} catch (Exception e) {}
		
		return orders;
	}
	
	public static List<Order> listByUserId(int userId, int pageNo, int perPage) {
		
		List<Order> orders = new ArrayList<Order>();

		try {
			int start = (pageNo) * perPage;
			int end = start + perPage;	
			
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE userId = ? ORDER BY updatedAt DESC LIMIT ?, ?");
			statement.setInt(1, userId);
			statement.setInt(2, start);
			statement.setInt(3, end);
			
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Order order = Order.fromResultSet(results);
				orders.add(order);
			}
		} catch (Exception e) {}
		
		return orders;
		
	}
	
	public static int todayOrdersCount() {
		int count = 0;
		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT COUNT(id) FROM orders WHERE createdAt >= CURDATE() AND createdAt < CURDATE() + INTERVAL 1 DAY");
			ResultSet results =  statement.executeQuery();
			if(results.next()) {
				count = results.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	
	public static int pendingOrdersCount() {
		int count = 0;
		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT COUNT(id) FROM orders WHERE status = 'PENDING'");
			ResultSet results =  statement.executeQuery();
			if(results.next()) {
				count = results.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	
	public static double todayRevenue() {
		double revenue = 0;
		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT SUM(amount) FROM orders WHERE (createdAt >= CURDATE() AND createdAt < CURDATE() + INTERVAL 1 DAY) AND status = 'COMPLETED'");
			ResultSet results =  statement.executeQuery();
			if(results.next()) {
				revenue = results.getDouble(1);
			}
		} catch (Exception e) {}
		return revenue;
	}

	public static int todayReturnsCount() {
		int count = 0;
		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT COUNT(id) FROM orders WHERE (createdAt >= CURDATE() AND createdAt < CURDATE() + INTERVAL 1 DAY) AND status IN (?,?,?) ");
			statement.setString(1, OrderStatus.RETURN_REQUESTED.name()); 
			statement.setString(2, OrderStatus.RETURN_DECLINED.name()); 
			statement.setString(3, OrderStatus.RETURN_COMPLETED.name()); 
			ResultSet results =  statement.executeQuery();
			if(results.next()) {
				count = results.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	
	
	
}
