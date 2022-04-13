package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class UserService {

	public static User findByUsernameAndPassword(String username, String password) throws SQLException  {

		Connection connection = DatabaseService.getInstance().getConnection();
			
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		
		ResultSet results =  statement.executeQuery();
		
		if(results.next()) {
			user.setId(results.getInt("id"));
			return user;
		}
		
		return null;
	}
	
	public static User findById(int id)  {
		
		try {

			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
			statement.setInt(1, id);

			ResultSet results =  statement.executeQuery();
			
			if(results.next()) {
				User user = new User();
				user.setId(results.getInt("id"));
				user.setFullName(results.getString("fullName"));			
				user.setUsername(results.getString("username"));
				return user;
			}
		} catch (Exception e) {}
		
		return null;
	}
	
	public static void createNewUser(User user) throws SQLException  {

		Connection connection = DatabaseService.getInstance().getConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO users(fullName, username, password) VALUES(?, ?, ?)");
		statement.setString(1, user.getFullName());
		statement.setString(2, user.getUsername());
		statement.setString(3, user.getPassword());
		
		statement.executeUpdate();
	}

}
