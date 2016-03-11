package com.postmen.sdk.java_sdk.service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.http.HttpResponse;
import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.model.MapResponse;
import com.postmen.sdk.java_sdk.model.Response;
import com.postmen.sdk.java_sdk.util.PostmenUrl;

public abstract class Service {
	private Config config;
	private Handler handler;
	private final String SERVICE;
	
	public Service(Config config, String serviceName) {
		this.config = config.clone();
		this.handler = new Handler(config);
		this.SERVICE = serviceName;
	}
	
	protected Service(Handler handler, Config config, String serviceName) {
		this.handler = handler;
		this.config = config;
		this.SERVICE = serviceName;
	}
	
	public MapResponse callAsMap(String method, String path, Map<String, String> query, Object body) throws IOException {
		PostmenUrl url = getUrl().appendPath(path).addQueries(query);
		return handler.callAndParseAsMap(method, url, body);
	}
	  
	public String callAsRaw(String method, String path, Map<String, String> query, Object body) throws IOException {
		PostmenUrl url = getUrl().appendPath(path).addQueries(query);
		return handler.callAndParseAsString(method, url, body);
	}
	
	public Config getConfig() {
		return config;
	}
	
	public void reInitialize() {
		this.handler = new Handler(config);
	}
	
	protected <T extends Response> T call(Handler handler, String method, PostmenUrl url, Object body, Class<T> type) throws IOException {
		return handler.call(method, url, body, type);
	}
	
	protected <T extends Response> T delete(Handler handler, PostmenUrl endpoint, Class<T> type) throws IOException {
		return handler.call("DELETE", endpoint, null, type);
	}

	protected <T extends Response> T get(Handler handler, PostmenUrl endpoint, Class<T> type) throws IOException {
		return handler.call("GET", endpoint, null, type);
	}
	
	protected <T extends Response> T post(Handler handler, PostmenUrl endpoint, Object body, Class<T> type) throws IOException {
		return handler.call("POST", endpoint, body, type);
	}
	
	protected <T extends Response> Future<T> getAsync(Handler handler, PostmenUrl endpoint, Class<T> type) throws InterruptedException {
		return handler.executeAysnc("GET", endpoint, null, type);
	}
	
	protected <T extends Response> Future<T> postAsync(Handler handler, PostmenUrl endpoint, Object body, Class<T> type) throws InterruptedException {
		return handler.executeAysnc("POST", endpoint, body, type);
	}
	
	protected String getServiceName() {
		return SERVICE;
	}
	
	protected Handler getHandler() {
		return handler;
	}
	
	protected void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	protected PostmenUrl getUrl() {
		return new PostmenUrl(config, SERVICE);
	}
	
	protected PostmenUrl getUrl(Config config) {
		return new PostmenUrl(config, SERVICE);
	}
}
