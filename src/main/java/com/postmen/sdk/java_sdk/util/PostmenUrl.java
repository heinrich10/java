package com.postmen.sdk.java_sdk.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.api.client.http.GenericUrl;
import com.postmen.sdk.java_sdk.config.Config;

public class PostmenUrl extends GenericUrl{
	
	public PostmenUrl(String url) {
		super(url);
	}
	
	public PostmenUrl(Config config) {
		super(config.getUrl());
		List<String> parts = this.getPathParts();
		if(parts == null) {
			parts = new ArrayList<String>();
			parts.add("");
			parts.add(config.getVersion());
			this.setPathParts(parts);
		} else {
			appendRawPath(config.getVersion());
		}
		// appendRawPath("/");
		// appendPath(config.getVersion());
	}
	
	public PostmenUrl(Config config, String path) {
		super(config.getUrl());
		appendRawPath(config.getVersion());
		appendPath(path);
	}
	
	public PostmenUrl appendPath(String path) {
		if (path != null) {
			getPathParts().add(path);
		}
		return this;
	}
	
	public PostmenUrl addQueries(Map<String, String> query) {
		if (query != null) {
			this.putAll(query);
		}
		return this;
	}

}
