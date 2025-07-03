package com.wrapper;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URI = "https://swift.techwithjatin.com";
	private RequestSpecification requestSpecification;

	public BaseService() {
		requestSpecification = given().baseUri(BASE_URI);
	}

	protected void setBasicPath(String basicPath) {
		requestSpecification.basePath(basicPath);
	}

	protected void setAuthorization(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}

	protected Response getRequest() {
		return requestSpecification
				.get()
				.then()
				.extract()
				.response();
	}

	protected Response postRequest(Object payload) {
		return requestSpecification
				.contentType(ContentType.JSON)
				.body(payload)
				.post()
				.then()
				.extract()
				.response();
	}
	
	protected Response putRequest(Object payload) {
		return requestSpecification
				.contentType(ContentType.JSON)
				.body(payload)
				.put()
				.then()
				.extract()
				.response();
	}

}
