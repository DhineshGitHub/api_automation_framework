package com.modals.requestModal;

public class LoginRequestModal {

	private String username;
	private String password;

	public LoginRequestModal(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestModal [username=" + username + ", password=" + password + "]";
	}

	public static class Builder {

		private String username;
		private String password;

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public LoginRequestModal build() {
			return new LoginRequestModal(username, password);
		}
	}

}
