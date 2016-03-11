package com.postmen.sdk.java_sdk.service;

import java.io.IOException;
import java.util.Map;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.model.RateRequest;
import com.postmen.sdk.java_sdk.model.RateResponse;
import com.postmen.sdk.java_sdk.model.RatesResponse;
import com.postmen.sdk.java_sdk.util.PostmenUrl;

public class RateService extends Service{
	
	public RateService(Config config) {
		super(config, "rates");
	}
	
	public RateResponse calculate(RateRequest req) throws IOException {
		PostmenUrl url = getUrl();
		RateResponse response = post(getHandler(), url, req, RateResponse.class);
		return response;
	}
	
	public RateResponse calculate(RateRequest req, Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		RateResponse response = post(new Handler(config), url, req, RateResponse.class);
		return response;
	}
	
	public RatesResponse get() throws IOException {
		PostmenUrl url = getUrl();
		RatesResponse response = get(getHandler(), url, RatesResponse.class);
		return response;
	}
	
	public RatesResponse get(Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		RatesResponse response = get(new Handler(config), url, RatesResponse.class);
		return response;
	}
	
	public RatesResponse get(Map<String, String> map) throws IOException {
		PostmenUrl url = getUrl().addQueries(map);
		RatesResponse ratesResponse = get(getHandler(), url, RatesResponse.class);
		return ratesResponse;
	}
	
	public RatesResponse get(Map<String, String> map, Config config) throws IOException {
		PostmenUrl url = getUrl(config).addQueries(map);
		RatesResponse ratesResponse = get(new Handler(config), url, RatesResponse.class);
		return ratesResponse;
	}
	
	public RateResponse get(String id) throws IOException {
		PostmenUrl url = getUrl().appendPath(id);
		RateResponse response = get(getHandler(), url, RateResponse.class);
		return response;
	}
	
	public RateResponse get(String id, Config config) throws IOException {
		PostmenUrl url = getUrl(config).appendPath(id);
		RateResponse response = get(new Handler(config), url, RateResponse.class);
		return response;
	}
}
