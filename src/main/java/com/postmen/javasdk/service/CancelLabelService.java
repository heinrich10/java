package com.postmen.javasdk.service;

import java.io.IOException;
import java.util.Map;

import com.postmen.javasdk.config.Config;
import com.postmen.javasdk.handler.Handler;
import com.postmen.javasdk.model.CancelLabelRequest;
import com.postmen.javasdk.model.CancelLabelResponse;
import com.postmen.javasdk.model.CancelLabelsResponse;
import com.postmen.javasdk.util.PostmenUrl;

public class CancelLabelService extends Service {
	
	public CancelLabelService(Config config) {
		super(config, "cancel-labels");
	}
	
	public CancelLabelResponse cancel(CancelLabelRequest req) throws IOException {
		PostmenUrl url = getUrl();
		CancelLabelResponse response = post(getHandler(), url, req, CancelLabelResponse.class);
		return response;
	}
	
	public CancelLabelResponse cancel(CancelLabelRequest req, Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		CancelLabelResponse response = post(new Handler(config), url, req, CancelLabelResponse.class);
		return response;
	}
	
	public CancelLabelsResponse get() throws IOException {
		PostmenUrl url = getUrl();
		CancelLabelsResponse response = get(getHandler(), url, CancelLabelsResponse.class);
		return response;
	}
	
	public CancelLabelsResponse get(Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		CancelLabelsResponse response = get(new Handler(config), url, CancelLabelsResponse.class);
		return response;
	}
	
	public CancelLabelsResponse get(Map<String, String> query) throws IOException {
		PostmenUrl url = getUrl().addQueries(query);
		CancelLabelsResponse response = get(getHandler(), url, CancelLabelsResponse.class);
		return response;
	}
	
	public CancelLabelsResponse get(Map<String, String> query, Config config) throws IOException {
		PostmenUrl url = getUrl(config).addQueries(query);
		CancelLabelsResponse response = get(getHandler(), url, CancelLabelsResponse.class);
		return response;
	}
	
	public CancelLabelResponse get(String id) throws IOException {
		PostmenUrl url = getUrl().appendPath(id);
		CancelLabelResponse response = get(getHandler(), url, CancelLabelResponse.class);
		return response;
	}
	
	public CancelLabelResponse get(String id, Config config) throws IOException {
		PostmenUrl url = getUrl(config).appendPath(id);
		CancelLabelResponse response = get(new Handler(config), url, CancelLabelResponse.class);
		return response;
	}
}
