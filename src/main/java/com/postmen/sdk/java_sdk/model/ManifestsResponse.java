package com.postmen.sdk.java_sdk.model;

import com.google.api.client.util.Key;

public class ManifestsResponse extends Response{
	@Key
	private Manifests data;

	public Manifests getData() {
		return data;
	}

	public void setData(Manifests data) {
		this.data = data;
	}
}
