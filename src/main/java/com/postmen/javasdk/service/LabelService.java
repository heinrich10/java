package com.postmen.javasdk.service;

import java.io.IOException;
import java.util.Map;

import com.postmen.javasdk.config.Config;
import com.postmen.javasdk.handler.Handler;
import com.postmen.javasdk.model.LabelRequest;
import com.postmen.javasdk.model.LabelResponse;
import com.postmen.javasdk.model.LabelsResponse;
import com.postmen.javasdk.util.PostmenUrl;

public class LabelService extends Service {
	
	public LabelService(Config config) {
		super(config, "labels");
	}

	public LabelResponse create(LabelRequest req) throws IOException {
		PostmenUrl url = getUrl();
		LabelResponse labelResponse = post(getHandler(), url, req, LabelResponse.class);
		return labelResponse;
	}
	
	public LabelResponse create(LabelRequest req, Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		LabelResponse labelResponse = post(new Handler(config), url, req, LabelResponse.class);
		return labelResponse;
	}
	
	public LabelsResponse get() throws IOException {
		PostmenUrl url = getUrl();
		LabelsResponse labelsResponse = get(getHandler(), url, LabelsResponse.class);
		return labelsResponse;
	}
	
	public LabelsResponse get(Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		LabelsResponse labelsResponse = get(new Handler(config), url, LabelsResponse.class);
		return labelsResponse;
	}
	
	public LabelsResponse get(Map<String, String> map) throws IOException {
		PostmenUrl url = getUrl().addQueries(map);
		LabelsResponse labelsResponse = get(getHandler(), url, LabelsResponse.class);
		return labelsResponse;
	}
	
	public LabelsResponse get(Map<String, String> map, Config config) throws IOException {
		PostmenUrl url = getUrl(config).addQueries(map);
		LabelsResponse labelsResponse = get(new Handler(config), url, LabelsResponse.class);
		return labelsResponse;
	}
	
	public LabelResponse get(String id) throws IOException {
		PostmenUrl url = getUrl().appendPath(id);
		LabelResponse labelResponse = get(getHandler(), url, LabelResponse.class);
		return labelResponse;
	}
	
	public LabelResponse get(String id, Config config) throws IOException {
		PostmenUrl url = getUrl(config).appendPath(id);
		LabelResponse labelResponse = get(new Handler(config), url, LabelResponse.class);
		return labelResponse;
	}
	
	
}
