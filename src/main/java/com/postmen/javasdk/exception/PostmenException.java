package com.postmen.javasdk.exception;

import java.io.IOException;

import com.postmen.javasdk.model.Response;

public class PostmenException extends IOException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -671762530914847990L;
	
	private Response response;
	
	public PostmenException(Response response) {
		super(response.getMeta().getMessage());
		this.response = response;
	}
	
	public Response getResponse() {
		return response;
	}

}
