package models;

import utils.Utils;

public class User {
	
	private int id;
	private String name;
	private String username;
	private String password;
	private boolean isAdmin;
	
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws IllegalArgumentException {
		if(username == null || username.isEmpty() || username.isBlank()) {
			throw new IllegalArgumentException("Username cannot be blank");
		}
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) throws IllegalArgumentException {
		
		if(password == null || password.isEmpty() || password.isBlank() || password.length() < 6) {
			throw new IllegalArgumentException("Password must contain atleast 6 characters");			
		}
		
		try {
			this.password = Utils.hashSHA(password);
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to hash the password");
		}	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if((name == null) || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("Full Name cannot be blank");
		}
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getRole() {
		if(isAdmin()) return "Admin";
		return "Customer";
	}

}


