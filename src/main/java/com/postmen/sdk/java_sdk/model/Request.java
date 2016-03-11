package com.postmen.sdk.java_sdk.model;

import com.google.api.client.util.Key;

public abstract class Request {
	@Key
	private Boolean async;

	public Boolean getAsync() {
		return async;
	}

	public void setAsync(Boolean async) {
		this.async = async;
	}
}
