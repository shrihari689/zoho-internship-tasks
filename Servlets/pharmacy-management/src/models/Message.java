package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Message {
	private int id;
	private String message;
	private boolean isRead;
	private boolean isAction;
	private int reportId;
	private int fromUserId;
	private int toUserId;
	private Timestamp sentAt;
	
	public Message() {}
	
	public Message(String message, boolean isRead, boolean isAction, int reportId, int fromUserId, int toUserId) {
		setMessage(message);
		setRead(isRead);
		setAction(isAction);
		setReportId(reportId);
		setFromUserId(fromUserId);
		setToUserId(toUserId);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		if((message == null) || message.isEmpty() || message.isBlank()) {
			throw new IllegalArgumentException("Message cannot be blank");
		}
		this.message = message;
	}
	public boolean isAction() {
		return isAction;
	}
	public void setAction(boolean isAction) {
		this.isAction = isAction;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getSentAtString() {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM YYYY hh:mm a");
		return format.format(this.getSentAt());
	}
	public Timestamp getSentAt() {
		return sentAt;
	}
	public void setSentAt(Timestamp sentAt) {
		this.sentAt = sentAt;
	}
	public static Message fromResultSet(ResultSet results) {
		Message message = null;
		try {
			message = new Message();
			message.setId(results.getInt("id"));
			message.setFromUserId(results.getInt("fromUserId"));
			message.setToUserId(results.getInt("toUserId"));
			message.setAction(results.getBoolean("isAction"));
			message.setRead(results.getBoolean("isRead"));
			message.setMessage(results.getString("message"));
			message.setReportId(results.getInt("reportId"));
			message.setSentAt(results.getTimestamp("sentAt"));
		} catch (SQLException e) {
			
		}
		
		return message;
	}
	public int getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}
	public int getToUserId() {
		return toUserId;
	}
	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}
 
	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
}
