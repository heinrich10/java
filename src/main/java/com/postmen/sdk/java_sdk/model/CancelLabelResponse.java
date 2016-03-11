package com.postmen.sdk.java_sdk.model;

import com.google.api.client.util.Key;

public class CancelLabelResponse extends Response {
	@Key
	private CancelLabel data;

	public CancelLabel getData() {
		return data;
	}

	public void setData(CancelLabel data) {
		this.data = data;
	}
}
