package org.great.entity;

public class User_information {
	private String user;
	private String password;
	private String phone;
	private String registration_time;
	private String login_time;
	private String status;
	
	
	public User_information() {
		super();
	}
	
	public User_information(String user) {
		super();
		this.user = user;
	}
	
	public User_information(String user, String password, String phone, String registration_time, String login_time, String status) {
		super();
		this.user = user;
		this.password = password;
		this.phone = phone;
		this.registration_time = registration_time;
		this.login_time = login_time;
		this.status = status;
	}
	

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRegistration_time() {
		return registration_time;
	}

	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}

	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User_information [user=" + user + ", password=" + password + ", phone=" + phone + ", registration_time="
				+ registration_time + ", login_time=" + login_time + ", status=" + status + "]";
	}

	
	
	
}
