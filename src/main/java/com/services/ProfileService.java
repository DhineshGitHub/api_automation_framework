package com.services;

import com.modals.requestModal.UpdateProfileRequestModal;
import com.wrapper.BaseService;

import io.restassured.response.Response;

public class ProfileService extends BaseService{
	
	private final String BASE_PATH = "/api/users/";
	
	public Response getProfile(String token) {
		setBasicPath(BASE_PATH + "profile");
		setAuthorization(token);
		return getRequest();
	}
	
	public Response updateProfile(String token, UpdateProfileRequestModal payload) {
		setBasicPath(BASE_PATH + "profile");
		setAuthorization(token);
		return putRequest(payload);
	}
	
}
