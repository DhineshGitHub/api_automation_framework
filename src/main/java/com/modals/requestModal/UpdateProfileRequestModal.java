package com.modals.requestModal;

public class UpdateProfileRequestModal {

	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private long mobileNumber;

	public UpdateProfileRequestModal() {
	}

	public UpdateProfileRequestModal(String username, String email, String firstName, String lastName,
			long mobileNumber) {
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UpdateProfileRequestModal [username=" + username + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}

	public static class Builder {

		private String username;
		private String email;
		private String firstName;
		private String lastName;
		private long mobileNumber;

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder mobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public UpdateProfileRequestModal build() {
			return new UpdateProfileRequestModal(username, email, firstName, lastName, mobileNumber);
		}
	}
}
