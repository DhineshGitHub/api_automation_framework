package com.services;

import com.modals.requestModal.LoginRequestModal;
import com.wrapper.BaseService;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private final String BASE_PATH = "/api/auth/";
	
	public Response login(LoginRequestModal payload) {
		setBasicPath(BASE_PATH + "login");
		return postRequest(payload);
	}
}
