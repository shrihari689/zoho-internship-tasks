package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Medicine;
 

public class MedicineService {

	public static int outOfStockCount() {
		int count = 0;
		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT COUNT(id) FROM medicines WHERE quantity = 0");
			ResultSet results =  statement.executeQuery();
			if(results.next()) {
				count = results.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	
	public static List<Medicine> searchMedicines(String query, int pageNo, int perPage) {
		
		List<Medicine> medicines = new ArrayList<Medicine>();

		try {

			int start = (pageNo) * perPage;
			int end = start + perPage;	
			
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM medicines WHERE name LIKE CONCAT( '%',?,'%') LIMIT ?, ?");
			statement.setString(1, query);
			statement.setInt(2, start);
			statement.setInt(3, end);
			
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Medicine medicine = new Medicine();
				medicine.setId(results.getInt("id"));
				medicine.setName(results.getString("name"));			
				medicine.setDescription(results.getString("description"));
				medicine.setQuantity(results.getInt("quantity"));
				medicine.setPrice(results.getDouble("price"));
				medicines.add(medicine);
			}
		} catch (Exception e) {}
		
		return medicines;
		
	}
	
	
	public static void updateMedicine(Medicine medicine) throws SQLException  {

		Connection connection = DatabaseService.getInstance().getConnection();
		
		PreparedStatement statement = connection.prepareStatement("UPDATE medicines SET name=?, description=?, quantity=?, price=? WHERE id=?");
		statement.setString(1, medicine.getName());
		statement.setString(2, medicine.getDescription());
		statement.setInt(3, medicine.getQuantity());
		statement.setDouble(4, medicine.getPrice());
		statement.setInt(5, medicine.getId());
			
		statement.executeUpdate();
	}
	
	public static void createMedicine(Medicine medicine) throws SQLException  {

		Connection connection = DatabaseService.getInstance().getConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO medicines(name, description, quantity, price) VALUES(?, ?, ?, ?)");
		statement.setString(1, medicine.getName());
		statement.setString(2, medicine.getDescription());
		statement.setInt(3, medicine.getQuantity());
		statement.setDouble(4, medicine.getPrice());
			
		statement.executeUpdate();
	}
	
	public static List<Medicine> listAllMedicines(int pageNo, int perPage) {
		
		List<Medicine> medicines = new ArrayList<Medicine>();

		try {

			int start = (pageNo) * perPage;
			int end = start + perPage;	
			
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM medicines LIMIT ?, ?");
			statement.setInt(1, start);
			statement.setInt(2, end);
			
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Medicine medicine = new Medicine();
				medicine.setId(results.getInt("id"));
				medicine.setName(results.getString("name"));			
				medicine.setDescription(results.getString("description"));
				medicine.setQuantity(results.getInt("quantity"));
				medicine.setPrice(results.getDouble("price"));
				medicines.add(medicine);
			}
		} catch (Exception e) {}
		
		return medicines;
		
	}
	
	public static Medicine findById(int id)  {
		
		try {

			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM medicines WHERE id=?");
			statement.setInt(1, id);

			ResultSet results =  statement.executeQuery();
			
			if(results.next()) {
				Medicine medicine = new Medicine();
				medicine.setId(results.getInt("id"));
				medicine.setName(results.getString("name"));			
				medicine.setDescription(results.getString("description"));
				medicine.setQuantity(results.getInt("quantity"));
				medicine.setPrice(results.getDouble("price"));
				return medicine;
			}
		} catch (Exception e) {}
		
		return null;
	}
	
}
