package com.api.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.modals.requestModal.LoginRequestModal;
import com.modals.responseModal.LoginResponseModal;
import com.modals.responseModal.ProfileResponseModal;
import com.services.AuthService;
import com.services.ProfileService;

import io.restassured.response.Response;

public class ProfileServiceTest {
	
	private ProfileService profileService;
	private AuthService authService;
	
	@BeforeTest
	public void setUp() {
		profileService = new ProfileService();
		authService = new AuthService();
	}
	
	@Test(description = "Verify the get profile api test")
	public void getProfile() {
		LoginRequestModal loginRequestModal = new LoginRequestModal
				.Builder()
				.username("kathir")
				.password("Kathir1234")
				.build();
		LoginResponseModal loginResponseModal = authService.login(loginRequestModal).as(LoginResponseModal.class);
		
		Response response = profileService.getProfile(loginResponseModal.getToken());
		
		assertThat(response.getStatusCode() == 200)
		.as("status code must be 200")
		.isTrue();
		
		ProfileResponseModal profileResponseModal = response.as(ProfileResponseModal.class);
		
		assertThat(profileResponseModal.getId() == loginResponseModal.getId())
		.as("user id should be equal")
		.isTrue();
	}
	
}
