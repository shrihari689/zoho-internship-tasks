package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Offer;

public class OfferService {

	
	public static void updateOffer(Offer offer) throws SQLException {
		
		Connection connection = DatabaseService.getInstance().getConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO offers VALUES (DEFAULT, ?, ?, ?, ?);");
		statement.setString(1, offer.getName());
		statement.setTimestamp(2, offer.getStartTime());
		statement.setTimestamp(3, offer.getEndTime());
		statement.setDouble(4, offer.getDiscount());
			
		statement.executeUpdate();
		
	}
	
	
	public static void deleteOffer() throws SQLException {
		
		Offer offer = currentOffer();
		
		if(offer != null) {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("DELETE FROM offers WHERE id=?");
			statement.setInt(1, offer.getId());
			
			statement.executeUpdate();
		}		
		
	}
	
	public static Offer currentOffer() throws SQLException {
		Offer offer = null;

		Connection connection = DatabaseService.getInstance().getConnection();
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM offers WHERE startTime <= NOW() AND endTime >= NOW();");
			
		ResultSet results = statement.executeQuery();
			
		if(results.next()) {
			offer = new Offer(results.getString("name"), results.getDouble("discount"), results.getTimestamp("startTime"), results.getTimestamp("endTime"));
			offer.setId(results.getInt("id"));
		}
		
		return offer;
	}
	
	
}
