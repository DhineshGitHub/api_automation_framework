package com.api.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.modals.requestModal.LoginRequestModal;
import com.modals.requestModal.UpdateProfileRequestModal;
import com.modals.responseModal.LoginResponseModal;
import com.modals.responseModal.ProfileResponseModal;
import com.services.AuthService;
import com.services.ProfileService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class ProfileServiceTest {

	private ProfileService profileService;
	private LoginResponseModal loginResponseModal;

	@BeforeSuite
	public void setUp() {
		profileService = new ProfileService();
		AuthService authService = new AuthService();

		LoginRequestModal loginRequestModal = new LoginRequestModal.Builder()
				.username("kathir")
				.password("Kathir1234")
				.build();
		loginResponseModal = authService.login(loginRequestModal).as(LoginResponseModal.class);
	}

	@Test(description = "Verify the get profile api test")
	public void getProfile() {

		Response response = profileService.getProfile(loginResponseModal.getToken());

		assertThat(response.getStatusCode() == 200).as("status code must be 200").isTrue();

		ProfileResponseModal profileResponseModal = response.as(ProfileResponseModal.class);

		assertThat(profileResponseModal.getId() == loginResponseModal.getId()).as("user id should be equal").isTrue();
	}
	
	@Test(description = "verify the update profile api test")
	public void updateProfile() {
		UpdateProfileRequestModal modal = new UpdateProfileRequestModal.Builder()
				.username("hello")
				.email("hellotester@gmail.com")
				.firstName("tester")
				.lastName("test")
				.mobileNumber(1234567890L)
				.build();
		Response response = profileService.updateProfile(loginResponseModal.getToken(), modal);
		assertThat(response.getStatusCode() == 200)
		.as("status code must be 200")
		.isTrue();
	}

}
