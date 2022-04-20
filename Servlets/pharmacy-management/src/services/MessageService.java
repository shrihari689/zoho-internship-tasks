package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Message;

public class MessageService {

	
	public static List<Message> findMessagesFromReportId(int reportId) {
		List<Message> messages = new ArrayList<Message>();

		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM messages WHERE reportId = ? ORDER BY id ASC;");
			statement.setInt(1, reportId);
			
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				messages.add(Message.fromResultSet(results));
			}

		} catch (SQLException e) {}
		
		return messages;
	}
	
	public static void markAllMessageAsRead(int reportId, int userId) {
		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			PreparedStatement readStatement = connection.prepareStatement("UPDATE messages SET isRead = true WHERE reportId = ? AND toUserId = ?");
			readStatement.setInt(1, reportId);
			readStatement.setInt(2, userId);
			readStatement.executeUpdate();
		} catch(Exception e) {}
		
	}
	
	public static Message findLastMessageFromReportId(int reportId) {
		Message message = null;

		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM messages WHERE reportId = ? ORDER BY id DESC LIMIT 1;");
			statement.setInt(1, reportId);
			
			ResultSet results = statement.executeQuery();
			
			if(results.next()) {
				message = Message.fromResultSet(results);
			}

		} catch (SQLException e) {}
		
		return message;
	}
	
}
