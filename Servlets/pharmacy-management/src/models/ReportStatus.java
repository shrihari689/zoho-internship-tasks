package models;

public enum ReportStatus {
	OPENED("Opened"),
	REOPENED("Reopened"),
	CLOSED("Closed");
	
	private String message;
	
	private ReportStatus(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	@Override
	public String toString() {
		return this.getMessage();
	}
	
}
