package models;

public enum OrderStatus {
	COMPLETED("Completed"),		
	PENDING("Pending"),		
	CANCELLED("Cancelled"),		
	RETURN_REQUESTED("Return Requested"),
	RETURN_COMPLETED("Return Completed"),
	RETURN_DECLINED("Return Declined");
	
	private String message;

	OrderStatus(String message) {
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
        return this.message;
    }

};

