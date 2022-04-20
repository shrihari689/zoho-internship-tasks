package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Report {

	private int id;
	private String title;
	private int userId;
	private ReportStatus status;
	private Timestamp lastUpdatedAt;
	private Message lastMessage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if((title == null) || title.isEmpty() || title.isBlank()) {
			throw new IllegalArgumentException("Title must not be blank");
		}
		this.title = title;
	}
	public ReportStatus getStatus() {
		return status;
	}
	public void setStatus(ReportStatus status) {
		this.status = status;
	}
	public static Report fromResultSet(ResultSet results) {
		Report report = new Report();
		try {
			report.setId(results.getInt("id"));
			report.setStatus(ReportStatus.valueOf(results.getString("status")));
			report.setLastUpdatedAt(results.getTimestamp("lastUpdatedAt"));
			report.setTitle(results.getString("title"));
			report.setUserId(results.getInt("userId"));
		} catch (SQLException e) {
			return null;
		}
		return report;
	}
	public Timestamp getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	public Message getLastMessage() {
		return lastMessage;
	}
	public void setLastMessage(Message lastMessage) {
		this.lastMessage = lastMessage;
	}
	
	
}
