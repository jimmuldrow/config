package com.citi.cards.fraudtransactions.restfulwebservices;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LisaResponse {
	@JsonProperty("Response")
	private Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
