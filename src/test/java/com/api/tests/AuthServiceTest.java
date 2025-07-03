package com.api.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.*;

import com.modals.requestModal.LoginRequestModal;
import com.modals.responseModal.LoginResponseModal;
import com.services.AuthService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class AuthServiceTest {

	private AuthService authService;

	@BeforeTest
	public void setUp() {
		authService = new AuthService();
	}

	@Test(description = "Verify Login API test case")
	public void login() {
		LoginRequestModal loginRequestModal = new LoginRequestModal.Builder().username("kathir").password("Kathir1234")
				.build();
		Response response = authService.login(loginRequestModal);
		assertThat(response.getStatusCode())
		.as("status code must be 200")
		.isEqualTo(200);

		LoginResponseModal loginResponseModal = response.as(LoginResponseModal.class);

		assertThat(loginResponseModal.getToken())
		.as("token must not be null")
		.isNotNull();
		
		assertThat(loginResponseModal.getUsername())
		.as("username match with given request username")
		.isEqualTo(loginRequestModal.getUsername());
	}

}
