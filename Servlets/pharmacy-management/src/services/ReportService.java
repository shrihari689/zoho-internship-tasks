package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Medicine;
import models.Message;
import models.Order;
import models.Report;

public class ReportService {
	
	public static List<Report> listReportByUserId(int userId, boolean includeLastMessage) {
		List<Report> reports = new ArrayList<Report>();
		
		try {
			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM reports WHERE userId = ? ORDER BY lastUpdatedAt DESC");
			statement.setInt(1, userId); 
			
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Report report = Report.fromResultSet(results);
				if(includeLastMessage) {					
					Message lastMessage = MessageService.findLastMessageFromReportId(report.getId());
					report.setLastMessage(lastMessage);
				}
				reports.add(report);
			}
		} catch (Exception e) {}
		
		return reports;
	}

	public static Report findById(int id) {
		try {

			Connection connection = DatabaseService.getInstance().getConnection();
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM reports WHERE id=?");
			statement.setInt(1, id);

			ResultSet results =  statement.executeQuery();
			
			if(results.next()) {
				Report report = Report.fromResultSet(results);
				return report;
			}
		} catch (Exception e) {}
		
		return null;
	}
	
	
}
