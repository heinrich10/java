package com.postmen.sdk.java_sdk.service;

import java.io.IOException;
import java.util.Map;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.model.ManifestRequest;
import com.postmen.sdk.java_sdk.model.ManifestResponse;
import com.postmen.sdk.java_sdk.model.ManifestsResponse;
import com.postmen.sdk.java_sdk.util.PostmenUrl;

public class ManifestService extends Service {
	
	public ManifestService(Config config) {
		super(config, "manifests");
	}
	
	public ManifestResponse manifest(ManifestRequest req) throws IOException {
		PostmenUrl url = getUrl();
		ManifestResponse response = post(getHandler(), url, req, ManifestResponse.class);
		return response;
	}
	
	public ManifestResponse manifest(ManifestRequest req, Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		ManifestResponse response = post(new Handler(config), url, req, ManifestResponse.class);
		return response;
	}
	
	public ManifestsResponse get() throws IOException {
		PostmenUrl url = getUrl();
		ManifestsResponse response = get(getHandler(), url, ManifestsResponse.class);
		return response;
	}
	
	public ManifestsResponse get(Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		ManifestsResponse response = get(new Handler(config), url, ManifestsResponse.class);
		return response;
	}
	
	public ManifestsResponse get(Map<String, String> query) throws IOException {
		PostmenUrl url = getUrl().addQueries(query);
		ManifestsResponse response = get(getHandler(), url, ManifestsResponse.class);
		return response;
	}
	
	public ManifestsResponse get(Map<String, String> query, Config config) throws IOException {
		PostmenUrl url = getUrl(config).addQueries(query);
		ManifestsResponse response = get(new Handler(config), url, ManifestsResponse.class);
		return response;
	}
	
	public ManifestResponse get(String id) throws IOException {
		PostmenUrl url = getUrl().appendPath(id);
		ManifestResponse response = get(getHandler(), url, ManifestResponse.class);
		return response;
	}
	
	public ManifestResponse get(String id, Config config) throws IOException {
		PostmenUrl url = getUrl(config).appendPath(id);
		ManifestResponse response = get(new Handler(config), url, ManifestResponse.class);
		return response;
	}
}