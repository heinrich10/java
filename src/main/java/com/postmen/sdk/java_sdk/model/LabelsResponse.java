package com.postmen.sdk.java_sdk.model;

import com.google.api.client.util.Key;

public class LabelsResponse extends Response{
	
	@Key
	private Labels data;
	
	public void setData(Labels data) {
		this.data = data;
	}
	
	@Override
	public Object getData() {
		return data;
	}

}
