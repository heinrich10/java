package com.postmen.sdk.java_sdk.config;

import java.net.Proxy.Type;

public class ConfigBuilder {
	private String apiKey;
	private String url = "https://secure.postmen.io/";
	private String version = "v3";
	private ProxyConfig proxy = null;
	private boolean retry = true;
	private boolean rate = true;
	

	
	public ConfigBuilder() {
		
	}
	
	public ConfigBuilder(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public ConfigBuilder(String apiKey, boolean retry, boolean rate) {
		this.apiKey = apiKey;
		this.retry = retry;
		this.rate = rate;
	}
	
	public ConfigBuilder setApiKey(String apiKey) {
		this.apiKey = apiKey;
		return this;
	}
	
	public ConfigBuilder setUrl(String url){
		this.url = url;
		return this;
	}
	public ConfigBuilder setVersion(String version){
		this.version = version;
		return this;
	}
	public ConfigBuilder setProxy(ProxyConfig proxy){
		this.proxy = proxy;
		return this;
	}
	public ConfigBuilder setRetry(boolean retry){
		this.retry = retry;
		return this;
	}
	public ConfigBuilder setRate(boolean rate){
		this.rate = rate;
		return this;
	}
	
	public String getUrl() {
		return url;
	}
	public String getApiKey() {
		return apiKey;
	}
	public ProxyConfig getProxy() {
		return proxy;
	}
	public boolean getRetry() {
		return retry;
	}
	public boolean getRate() {
		return rate;
	}
	
	public Config build() {
		Config config = new Config();
		config.setApiKey(apiKey);
		config.setProxy(proxy);
		config.setRate(rate);
		config.setRetry(retry);
		config.setUrl(url);
		config.setVersion(version);
		
		return config;
	}
}
